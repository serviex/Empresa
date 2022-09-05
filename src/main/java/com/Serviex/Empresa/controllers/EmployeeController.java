package com.Serviex.Empresa.controllers;

import com.Serviex.Empresa.entities.Employee;

import com.Serviex.Empresa.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    EmployeeService service;
    EmployeeController(EmployeeService service) {
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
    @DeleteMapping("/Employee/{id}")
    public Boolean deleteEmployee(@PathVariable("id") long id){
        return this.service.deleteEmployee(id);
    }
}
