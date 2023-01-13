
package com.axyus.tpagenda;

import com.axyus.jdbc.pool.PoolManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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

    public static void main(String[] args) {
        TpAgenda tpAgenda = new TpAgenda();
        tpAgenda.connect();
    }
}
