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

    final StringBuilder sql = new StringBuilder();
    final PStmtBinder.SimplePStmtBinderBuilder binder = new PStmtBinder.SimplePStmtBinderBuilder();

    //Get all customers
    public List<Customer> getAllCustomers() throws SQLException {
        try (Connection connection = PoolManager.getInstance().getConnection()) {
            sql.append(" SELECT * FROM \n ");
            sql.append("    customers");
            List<Customer> allCustomers = (List<Customer>) jdbcUtils.queryObjects(connection, sql.toString(), new RowMapper.ColToStringRowMapper("first_name"));
            for (int i = 0; i < allCustomers.size(); i++) {
                System.out.println(allCustomers.get(i));
            }
        }
        return null;
    }

    //Get all Addresses
    public List<Address> getAllAddresses() throws SQLException {
        try (Connection connection = PoolManager.getInstance().getConnection()) {
            sql.append(" SELECT * FROM \n ");
            sql.append("    addresses");
            List<Address> allAddresses = (List<Address>) jdbcUtils.queryObjects(connection, sql.toString(), new RowMapper.ColToStringRowMapper("city"));
            for (int i = 0; i < allAddresses.size(); i++) {
                System.out.println(allAddresses.get(i));
            }
        }
        return null;
    }

    //Create Customer
    public void createCustomer() throws SQLException {
        try (Connection connection = PoolManager.getInstance().getConnection()) {
            sql.append(" INSERT INTO \n");
            sql.append("    customers \n");
            sql.append("        lst_name, first_name, username, email, phone_number, address_id \n");
            sql.append("            VALUES(?,?,?,?,?,?)");
            jdbcUtils.executeUpdate(connection, sql.toString(), binder.toPStmtBinder());
        }
    }

    //Create Address
    public void createAddress() throws SQLException {
        try (Connection connection = PoolManager.getInstance().getConnection()) {
            sql.append(" INSERT INTO \n");
            sql.append("    addresses \n");
            sql.append("        street_number, street_name, city, postal_code, country \n");
            sql.append("            VALUES(?,?,?,?,?)");
            jdbcUtils.executeUpdate(connection, sql.toString(), binder.toPStmtBinder());
        }
    }

    //Update Customer username
    public void updateUsername() throws SQLException {
        try (Connection connection = PoolManager.getInstance().getConnection()) {
            sql.append(" UPDATE \n");
            sql.append("    customers \n");
            sql.append("        SET username = ? \n");
            sql.append("            WHERE \n");
            sql.append("                id=?");
            jdbcUtils.executeUpdate(connection, sql.toString(), binder.toPStmtBinder());
        }
    }

    //delete customer by id
    public void deleteById(int id) throws SQLException {
        try (Connection connection = PoolManager.getInstance().getConnection()) {
            sql.append(" DELETE FROM \n");
            sql.append("    customers \n");
            sql.append("        WHERE \n");
            sql.append("            customer_id=? \n");
            jdbcUtils.executeUpdate(connection, sql.toString(), binder.toPStmtBinder());
        }
    }

    //get customer by id
    public void findById(int id) throws SQLException {
        try (Connection connection = PoolManager.getInstance().getConnection()) {
            sql.append(" SELECT FROM \n");
            sql.append("    customers \n");
            sql.append("        WHERE \n");
            sql.append("            id=? \n");
            jdbcUtils.executeUpdate(connection, sql.toString(), binder.toPStmtBinder());
        }
    }

}
