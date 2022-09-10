package com.Serviex.Empresa.controllers;

import com.Serviex.Empresa.entities.Employee;

import com.Serviex.Empresa.entities.Enterprice;
import com.Serviex.Empresa.entities.Transaction;
import com.Serviex.Empresa.services.EmployeeService;
import com.Serviex.Empresa.services.EnterpriceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    EmployeeService service;
    private EnterpriceService serviceEnterprice;
    EmployeeController(EmployeeService service, EnterpriceService serviceEnterprice)
    {
        this.serviceEnterprice=serviceEnterprice;
        this.service = service;
    }
    @GetMapping("/Employee")
    public List<Employee> getEmployees() {

        return this.service.getEmployees();
    }
    @GetMapping("/Employee/{id}")
    public Employee getEmployee(@PathVariable("id") long id){
        return this.service.getEmployee(id);

    }
    @PostMapping("/Employee")
    public Employee createEmployee(@RequestBody Employee employee) {
        return  this.service.createEmployee(employee);
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
