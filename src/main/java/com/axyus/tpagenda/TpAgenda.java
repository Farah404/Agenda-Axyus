package com.axyus.tpagenda;
import com.axyus.tpagenda.bll.AgendaManager;
import com.axyus.tpagenda.bo.Address;
import com.axyus.tpagenda.bo.Customer;
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
            
            //get and find
            agendaManager.getAllCustomers();
            agendaManager.getAllAddresses();
            agendaManager.findAddressById(1);
            agendaManager.findCustomerbyAddressId(1);
            
            //add new address
            Address address = new Address(6,"Boulevard des rêves", "Wonderland", "26500", "Neverland");
            int idAddress1 = agendaManager.insertAddress(address);
            
            //add new customer
            Customer customer = new Customer("Reynolds", "Dan", "ImagineDragons", "imagine@fragons.com", 06323232, 3);
            int idCustomer1 = agendaManager.insertCustomer(customer);
            
            //delete
            agendaManager.deleteAddress(idAddress1);
            agendaManager.deleteCustomer(idCustomer1);
            
            //update
            agendaManager.updateUsername(1, "farahaha");
            
        } catch (IOException ex) {
            Logger.getLogger(TpAgenda.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
