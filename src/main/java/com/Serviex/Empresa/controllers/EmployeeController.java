package com.Serviex.Empresa.controllers;

import com.Serviex.Empresa.entities.Employee;
import com.Serviex.Empresa.entities.Enterprice;
import com.Serviex.Empresa.entities.Role;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;

import java.time.LocalDate;

public class EmployeeController {
    private Employee employee;


    EmployeeController() {
        this.employee = new Employee((long)1,"eje@email.com",
                "Tafif", Role.OPERATIVO,
                LocalDate.of(2022,8,24),
                LocalDate.of(2022,8,24));
    }
    @GetMapping("/Employee")
    public Employee getEnterprice() {
        return employee;
    }
    @PostMapping("/Enterprice")
    public Employee createEmployee(@RequestBody Employee employee) {
        this.employee =employee;
        return this.employee;
    }
    @PutMapping("/Enterprice/{id}")
    public Employee setEmployee(@RequestBody Employee employee, @PathVariable Long id) {
        if(this.employee.getId()== id)
        {
            this.employee =employee;
            return employee;
        }
        return employee;
    }
}
