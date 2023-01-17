
package com.axyus.tpagenda.ihm;

import com.axyus.tpagenda.bll.AgendaManager;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AgendaController {
    
    @Autowired
    AgendaManager agendaManager;
    
    @GetMapping("/index")
    public String index(){
        return "index";
    }
    
    @GetMapping("/all-customers")
    public String allcustomers (Model model) throws SQLException{
        model.addAttribute("all-customers", agendaManager.getAllCustomers());
        return "all-customers";
    }
    
}
