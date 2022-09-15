package com.Serviex.Empresa.controllers;
import com.Serviex.Empresa.services.EmployeeService;
import com.Serviex.Empresa.services.EnterpriceService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    EmployeeService service;
    LoginController(EmployeeService service)
    {
        this.service = service;
    }
    @GetMapping("/")
    public String home(Model model, @AuthenticationPrincipal OidcUser principal) {
        if(principal != null){
            String email= (String) principal.getClaims().get("email");
            var e= service.getEmployeeByEmail(email);
            System.out.println("set concept:"+ e.getName());
        }
        return "index";
    }
}
