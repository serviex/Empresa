package com.Serviex.Empresa.services;

import com.Serviex.Empresa.entities.Employee;
import com.Serviex.Empresa.entities.Enterprice;
import com.Serviex.Empresa.entities.Role;
import com.Serviex.Empresa.entities.Transaction;
import com.Serviex.Empresa.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployees(){
        return this.employeeRepository.findAll();
    }

    public Employee getEmployee(Long id){
        Optional<Employee> employee = this.employeeRepository.findById(id);
        return employee.orElse(null);
    }
    public Employee createEmployee(Map<String, Object> emp){
        var e = this.employeeRepository.findByEmail(emp.get("email").toString());
        Employee employee = new Employee();
        if(e!= null && e.stream().count()> 0){
            employee = e.stream().findFirst().get();
        }
        else{
            employee.setEmail(emp.get("email").toString());
            employee.setRole(Role.ADMINISTRADOR);
            employee.setName(emp.get("name").toString());
            employee.setCreateAt(LocalDate.now());
            employee = this.employeeRepository.save(employee);
        }
        return employee;
    }
    public Employee createEmployee(Employee employee){
        employee.setCreateAt(LocalDate.now());
        return this.employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee employee){
        Optional<Employee> dbData = this.employeeRepository.findById(id);

        if(dbData.isPresent()){
            Employee e = dbData.get();
            e.setName(employee.getName());
            e.setEmail(employee.getEmail());
            e.setRole(employee.getRole());
            e.setUpdateAt(LocalDate.now());
            this.employeeRepository.save(e);
            return e;
        }

        return null;
    }
    public Employee createEnterprice(Enterprice enterprice, long id){
        Employee employee = this.getEmployee(id);
        employee.setCreateAt(LocalDate.now());
        employee.setEnterprice(enterprice);
        return this.employeeRepository.save(employee);
    }

    public Boolean deleteEmployee(Long id){
        try{
            this.employeeRepository.deleteById(id);
            return true;
        }catch (Exception e) {
            return false;
        }
    }
}
