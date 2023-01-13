package com.axyus.tpagenda;
import com.axyus.tpagenda.bll.AgendaManager;
import com.axyus.tpagenda.utils.Utils;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TpAgenda {

    public static void main(String[] args) throws SQLException {

        Utils utils = new Utils();
        AgendaManager agendaManager = new AgendaManager();
        try {
            utils.initialize();
            agendaManager.getAllCustomers();
            agendaManager.getAllAddresses();
        } catch (IOException ex) {
            Logger.getLogger(TpAgenda.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
