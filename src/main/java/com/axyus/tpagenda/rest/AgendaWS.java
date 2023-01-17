
package com.axyus.tpagenda.rest;

import com.axyus.tpagenda.bll.AgendaManager;
import com.axyus.tpagenda.bo.Customer;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class AgendaWS {
    
    @Autowired
    private AgendaManager agendaManager;
    
    @GetMapping
    public List<Customer> getAllcustomers() throws SQLException{
        return agendaManager.getAllCustomers();
    }
    
    
}
