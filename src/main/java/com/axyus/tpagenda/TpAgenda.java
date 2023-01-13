package com.axyus.tpagenda;

import com.axyus.jdbc.JdbcUtils;
import com.axyus.jdbc.RowMapper;
import com.axyus.jdbc.pool.PoolManager;
import com.axyus.tpagenda.exceptions.FichierConfigurationIntrouvableException;
import com.axyus.tpagenda.utils.Utils;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TpAgenda {

    public static void main(String[] args) throws SQLException {

        Utils utils = new Utils();
        try {
            utils.initialize();
            // obtenir connexion et faire des operation sur la base
            try (Connection connection = PoolManager.getInstance().getConnection()) {
                
                String test = (String) JdbcUtils.queryObject(connection, "SELECT lst_name FROM customers WHERE customer_id=1", new RowMapper.ColToStringRowMapper());
                Logger.getLogger(TpAgenda.class.getName()).log(Level.INFO, test);
                
        
}

        } catch (IOException ex) {
            Logger.getLogger(TpAgenda.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FichierConfigurationIntrouvableException ex) {
            Logger.getLogger(TpAgenda.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
