package com.axyus.tpagenda.bll;

import com.axyus.jdbc.pool.PoolManager;
import com.axyus.tpagenda.bo.Address;
import com.axyus.tpagenda.bo.Customer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class AgendaManager {

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
                customers.add(customer);
            }
            System.out.println("-----------------------");
            System.out.println("----All Customers----");
            for (int i = 0; i < customers.size(); i++) {
                
                System.out.println(customers.get(i));
            }

        }
    }

    public void getAllAddresses() throws SQLException {
        try (Connection connection = PoolManager.getInstance().getConnection()) {
            List<Address> addresses = new ArrayList<>();
            String SQL = "SELECT * FROM addresses";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                Address address = new Address();
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

}
