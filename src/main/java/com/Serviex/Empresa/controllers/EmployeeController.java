package com.Serviex.Empresa.controllers;

import com.Serviex.Empresa.entities.Employee;

import com.Serviex.Empresa.entities.Enterprice;
import com.Serviex.Empresa.entities.Transaction;
import com.Serviex.Empresa.services.EmployeeService;
import com.Serviex.Empresa.services.EnterpriceService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import java.util.List;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class EmployeeController {
    EmployeeService service;
    private EnterpriceService serviceEnterprice;
    EmployeeController(EmployeeService service, EnterpriceService serviceEnterprice)
    {
        this.serviceEnterprice=serviceEnterprice;
        this.service = service;
    }

    @GetMapping("/employee")
    public ModelAndView  getEmployees(Model model, @AuthenticationPrincipal OidcUser principal) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("employee");

        List<Employee> employees= this.service.getEmployees();
        model.addAttribute("employees", employees);
        return modelAndView;
    }
    @GetMapping("/newEmployee")
    public ModelAndView  newEmployees(Model model, @AuthenticationPrincipal OidcUser principal) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("newEmployee");
        Employee employees=  new Employee();
        model.addAttribute("employee", employees);
        return modelAndView;
    }

    @GetMapping("/Employee/{id}")
    public Employee getEmployee(@PathVariable("id") long id){
        return this.service.getEmployee(id);

    }

    @PostMapping("/addEmployee")
    public ModelAndView  createEmployee(Employee employee, BindingResult result, Model model) {
        this.service.createEmployee(employee);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("employee");

        List<Employee> employees= this.service.getEmployees();
        model.addAttribute("employees", employees);
        return modelAndView;
    }
    @PutMapping("/Employee/{id}")
    public Employee updateEmployee(@RequestBody Employee employee, @PathVariable Long id) {
        return this.service.updateEmployee(id,employee);
    }
    @PostMapping("/Employee/{id}/enterprice")
    public Employee createTransaction(@RequestBody Enterprice enterprice, @PathVariable("id") long id) {
        Enterprice emp=this.serviceEnterprice.createEnterprice(enterprice);
        return this.service.createEnterprice(emp, id);
    }
    @DeleteMapping("/Employee/{id}")
    public Boolean deleteEmployee(@PathVariable("id") long id){
        return this.service.deleteEmployee(id);
    }
}
