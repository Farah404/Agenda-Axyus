package com.axyus.tpagenda.bll;

import com.axyus.jdbc.pool.PoolManager;
import com.axyus.tpagenda.bo.Address;
import com.axyus.tpagenda.bo.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AgendaManager {

    //Get all customers
    public void getAllCustomers() throws SQLException {
        try (Connection connection = PoolManager.getInstance().getConnection()) {
//            String test = (String) JdbcUtils.queryObject(connection, "SELECT lst_name FROM customers WHERE customer_id=1", new RowMapper.ColToStringRowMapper());
//            Logger.getLogger(TpAgenda.class.getName()).log(Level.INFO, test);
            List<Customer> customers = new ArrayList<Customer>();
            String SQL = "SELECT * FROM customers";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setCustomerId(rs.getInt("customer_id"));
                customer.setEmail(rs.getString("email"));
                customer.setFirstName(rs.getString("first_name"));
                customer.setLastName(rs.getString("lst_name"));
                customer.setUsername(rs.getString("username"));
                customer.setPhoneNumber(rs.getInt("phone_number"));
                customer.setAddressId(rs.getInt("address_id"));
                customers.add(customer);
            }
            System.out.println("-----------------------");
            System.out.println("----All Customers----");
            for (int i = 0; i < customers.size(); i++) {

                System.out.println(customers.get(i));
            }

        }
    }

    //Get all Addresses
    public void getAllAddresses() throws SQLException {
        try (Connection connection = PoolManager.getInstance().getConnection()) {
            List<Address> addresses = new ArrayList<>();
            String SQL = "SELECT * FROM addresses";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                Address address = new Address(6, "Boulevard des r\u00eaves", "Wonderland", "26500", "Neverland");
                address.setAddressId(rs.getInt("address_id"));
                address.setCity(rs.getString("city"));
                address.setCountry(rs.getString("country"));
                address.setPostalCode(rs.getString("postal_code"));
                address.setStreetName(rs.getString("street_name"));
                address.setStreetNumber(rs.getInt("street_number"));
                addresses.add(address);
            }
            System.out.println("-----------------------");
            System.out.println("---All Addresses----");
            for (int i = 0; i < addresses.size(); i++) {
                System.out.println(addresses.get(i));
            }
        }
    }

    //find Address by id
    public void findAddressById(int addressId) throws SQLException {
        try (Connection connection = PoolManager.getInstance().getConnection()) {
            String SQL = "SELECT * " + "FROM addresses " + "WHERE address_id=?";
            PreparedStatement pstmt = connection.prepareStatement(SQL);
            pstmt.setInt(1, addressId);
            ResultSet rs = pstmt.executeQuery();
            displayAddress(rs);
        }
    }

    private void displayAddress(ResultSet rs) throws SQLException {
        while (rs.next()) {
            System.out.println("-----------------------");
            System.out.println(rs.getString("address_id") + "\t"
                    + rs.getString("street_number") + "\t"
                    + rs.getString("street_name") + "\t"
                    + rs.getString("city") + "\t"
                    + rs.getString("postal_code") + "\t"
                    + rs.getString("country")
            );
        }
    }

    //find Customer by address id
    public void findCustomerbyAddressId(int addressId) throws SQLException {
        try (Connection connection = PoolManager.getInstance().getConnection()) {
            String SQL = "SELECT * " + "FROM customers " + "WHERE address_id=?";
            PreparedStatement pstmt = connection.prepareStatement(SQL);
            pstmt.setInt(1, addressId);
            ResultSet rs = pstmt.executeQuery();
            displayCustomer(rs);
        }
    }

    private void displayCustomer(ResultSet rs) throws SQLException {
        while (rs.next()) {
            System.out.println("-----------------------");
            System.out.println(rs.getString("lst_name") + "\t"
                    + rs.getString("first_name") + "\t"
                    + rs.getString("username") + "\t"
                    + rs.getString("email") + "\t"
                    + rs.getString("phone_number") + "\t"
                    + rs.getInt("address_id"));
        }
    }

    //Insert address
    public int insertAddress(Address address) throws SQLException {
        String SQL = "INSERT INTO addresses (street_number, street_name, city, postal_code, country)" + "VALUES(?,?,?,?,?)";
        int id = 0;
        try (Connection connection = PoolManager.getInstance().getConnection()) {
            PreparedStatement pstmt = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, address.getStreetNumber());
            pstmt.setString(2, address.getStreetName());
            pstmt.setString(3, address.getCity());
            pstmt.setString(4, address.getPostalCode());
            pstmt.setString(5, address.getCountry());
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        id = rs.getInt(1);
                    }
                }
            }

        }
        return id;
    }

//Insert customer
    public int insertCustomer(Customer customer) throws SQLException {
        String SQL = "INSERT INTO customers (lst_name, first_name, username, email, phone_number, address_id)" + "VALUES(?,?,?,?,?,?)";
        int id = 0;
        try (Connection connection = PoolManager.getInstance().getConnection()) {
            PreparedStatement pstmt = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, customer.getLastName());
            pstmt.setString(2, customer.getFirstName());
            pstmt.setString(3, customer.getUsername());
            pstmt.setString(4, customer.getEmail());
            pstmt.setInt(5, customer.getPhoneNumber());
            pstmt.setInt(6, customer.getAddressId());
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        id = rs.getInt(1);
                    }
                }
            }

        }
        return id;
    }

    //delete address
    public int deleteAddress(int id) throws SQLException {
        String SQL = "DELETE FROM addresses WHERE address_id = ?";
        int affectedrows = 0;
        try (Connection connection = PoolManager.getInstance().getConnection()) {
            PreparedStatement pstmt = connection.prepareStatement(SQL);
            pstmt.setInt(1, id);
            affectedrows = pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return affectedrows;

    }

    //delete customer
    public int deleteCustomer(int id) throws SQLException {
        String SQL = "DELETE FROM customers WHERE customer_id = ?";
        int affectedrows = 0;
        try (Connection connection = PoolManager.getInstance().getConnection()) {
            PreparedStatement pstmt = connection.prepareStatement(SQL);
            pstmt.setInt(1, id);
            affectedrows = pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return affectedrows;

    }

    //Update username
    public int updateUsername(int id, String username) throws SQLException {
        String SQL = "UPDATE customers " + "SET username= ? " + "WHERE customer_id=?";
        int affectedrows = 0;
        try (Connection connection = PoolManager.getInstance().getConnection()) {
            PreparedStatement pstmt = connection.prepareStatement(SQL);
            pstmt.setString(1, username);
            pstmt.setInt(2, id);
            affectedrows = pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return affectedrows;

    }

}
