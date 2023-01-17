package com.axyus.tpagenda.bll;

import com.axyus.jdbc.JdbcUtils;
import com.axyus.jdbc.PStmtBinder;
import com.axyus.jdbc.RowMapper;
import com.axyus.jdbc.pool.PoolManager;
import com.axyus.tpagenda.bo.Address;
import com.axyus.tpagenda.bo.Customer;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class AgendaManager {

    @Autowired
    private JdbcUtils jdbcUtils;

    //Get all customers
    public List<Customer> getAllCustomers() throws SQLException {

        try (Connection connection = PoolManager.getInstance().getConnection()) {
            final StringBuilder sql = new StringBuilder();
            final PStmtBinder.SimplePStmtBinderBuilder binder = new PStmtBinder.SimplePStmtBinderBuilder();
            sql.append("SELECT * \n ");
            sql.append("    FROM \n");
            sql.append("        customers");
            List<Customer> allCustomers = (List<Customer>) jdbcUtils.queryObjects(connection, sql.toString(), new RowMapper.ClassRowMapper(Customer.class));
            for (int i = 0; i < allCustomers.size(); i++) {
                System.out.println(allCustomers.get(i));
            }
        }
        return null;
    }

    //Get all Addresses
    public List<Address> getAllAddresses() throws SQLException {
        try (Connection connection = PoolManager.getInstance().getConnection()) {
            final StringBuilder sql = new StringBuilder();
            final PStmtBinder.SimplePStmtBinderBuilder binder = new PStmtBinder.SimplePStmtBinderBuilder();
            sql.append("SELECT * \n ");
            sql.append("    FROM \n");
            sql.append("        addresses");
            List<Address> allAddresses = (List<Address>) jdbcUtils.queryObjects(connection, sql.toString(), new RowMapper.ClassRowMapper(Address.class));
            for (int i = 0; i < allAddresses.size(); i++) {
                System.out.println(allAddresses.get(i));
            }
        }
        return null;
    }

    //Create Customer
    public void createCustomer(Customer customer) throws SQLException {
        try (Connection connection = PoolManager.getInstance().getConnection()) {
            final StringBuilder sql = new StringBuilder();
            final PStmtBinder.SimplePStmtBinderBuilder binder = new PStmtBinder.SimplePStmtBinderBuilder();
            sql.append(" INSERT INTO \n");
            sql.append("    customers \n");
            sql.append("        (lst_name, first_name, username, email, phone_number, address_id) \n");
            sql.append("            VALUES(?,?,?,?,?,?)");
            binder.add(customer.getLastName());
            binder.add(customer.getFirstName());
            binder.add(customer.getUsername());
            binder.add(customer.getEmail());
            binder.add(customer.getPhoneNumber());
            binder.add(customer.getAddressId());
            jdbcUtils.executeUpdate(connection, sql.toString(), binder.toPStmtBinder());
            connection.commit();
        }
    }

    //Create Address
    public void createAddress(Address address) throws SQLException {
        try (Connection connection = PoolManager.getInstance().getConnection()) {
            final StringBuilder sql = new StringBuilder();
            final PStmtBinder.SimplePStmtBinderBuilder binder = new PStmtBinder.SimplePStmtBinderBuilder();
            sql.append(" INSERT INTO \n");
            sql.append("    addresses \n");
            sql.append("        (street_number, street_name, city, postal_code, country) \n");
            sql.append("            VALUES(?,?,?,?,?)");
            binder.add(address.getStreetNumber());
            binder.add(address.getStreetName());
            binder.add(address.getCity());
            binder.add(address.getPostalCode());
            binder.add(address.getCountry());
            jdbcUtils.executeUpdate(connection, sql.toString(), binder.toPStmtBinder());
            connection.commit();
        }
    }

    //Update Customer username
    public void updateUsername(int id, String username) throws SQLException {
        try (Connection connection = PoolManager.getInstance().getConnection()) {
            final StringBuilder sql = new StringBuilder();
            final PStmtBinder.SimplePStmtBinderBuilder binder = new PStmtBinder.SimplePStmtBinderBuilder();
            sql.append(" UPDATE \n");
            sql.append("    customers \n");
            sql.append("        SET username = ? \n");
            binder.add(username);
            sql.append("            WHERE \n");
            sql.append("                customer_id=?");
            binder.add(id);
            jdbcUtils.executeUpdate(connection, sql.toString(), binder.toPStmtBinder());
            connection.commit();
        }
    }

    //delete customer by id
    public void deleteById(int id) throws SQLException {
        try (Connection connection = PoolManager.getInstance().getConnection()) {
            final StringBuilder sql = new StringBuilder();
            final PStmtBinder.SimplePStmtBinderBuilder binder = new PStmtBinder.SimplePStmtBinderBuilder();
            sql.append(" DELETE FROM \n");
            sql.append("    customers \n");
            sql.append("        WHERE \n");
            sql.append("            customer_id=? \n");
            binder.add(id);
            jdbcUtils.executeUpdate(connection, sql.toString(), binder.toPStmtBinder());
            connection.commit();
        }
    }

    //get customer by id
    public void findById(int id) throws SQLException {
        try (Connection connection = PoolManager.getInstance().getConnection()) {
            final StringBuilder sql = new StringBuilder();
            final PStmtBinder.SimplePStmtBinderBuilder binder = new PStmtBinder.SimplePStmtBinderBuilder();
            sql.append(" SELECT * FROM \n");
            sql.append("    customers \n");
            sql.append("        WHERE \n");
            sql.append("            customer_id=? \n");
            binder.add(id);
            Customer customer = (Customer) jdbcUtils.queryObject(connection, sql.toString(), new RowMapper.ClassRowMapper(Customer.class), binder.toPStmtBinder());
            System.out.println(customer);
            connection.commit();
        }
    }

}
