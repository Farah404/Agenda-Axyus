package com.axyus.tpagenda;

import com.axyus.jdbc.pool.PoolManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TpAgenda {

    private final String url = "jdbc:postgresql://jaccard:5432/NA_DEMAQT_PORTAIL_BO_DEV";
    private final String user = "NA_DEMAQT_PORTAIL_BO_DEV";
    private final String password = "NA_DEMAQT_PORTAIL_BO_DEV";

// obtenir connexion et faire des operation sur la base
    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }

    public void getCustomers() {
        String SQL = "SELECT * FROM customers";
        try (Connection conn = connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(SQL)) {
            // display customer information
            displayCustomer(rs);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void getAddresses(){
        String SQL = "SELECT * FROM addresses";
         try (Connection conn = connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(SQL)) {
            // display address information
            displayAddresses(rs);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void findCustomerByID(int customerId) {
        String SQL = " SELECT * FROM customers WHERE customer_id = ?";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setInt(1, customerId);
            ResultSet rs = pstmt.executeQuery();
            displayCustomer(rs);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void displayCustomer(ResultSet rs) throws SQLException {
        while (rs.next()) {
            System.out.println(rs.getString("customer_id") + "\t"
                    + rs.getString("lst_name") + "\t"
                    + rs.getString("first_name") + "\t"
                    + rs.getString("username") + "\t"
                    + rs.getString("email") + "\t"
                    + rs.getString("phone_number")
            );

        }
    }
    
    private void displayAddresses (ResultSet rs) throws SQLException {
        while (rs.next()) {
            System.out.println(rs.getString("address_id") + "\t"
                    + rs.getString("street_number") + "\t"
                    + rs.getString("street_name") + "\t"
                    + rs.getString("city") + "\t"
                    + rs.getString("postal_code") + "\t"
                    + rs.getString("country")
            );

        }
    }

    public static void main(String[] args) {
        TpAgenda tpAgenda = new TpAgenda();
//      tpAgenda.connect();
        tpAgenda.getCustomers();
        tpAgenda.getAddresses();
//        tpAgenda.findCustomerByID(2);

    }
}
