package com.Serviex.Empresa.services;

import com.Serviex.Empresa.entities.Employee;
import com.Serviex.Empresa.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
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

    public Boolean deleteEmployee(Long id){
        try{
            this.employeeRepository.deleteById(id);
            return true;
        }catch (Exception e) {
            return false;
        }
    }
}
