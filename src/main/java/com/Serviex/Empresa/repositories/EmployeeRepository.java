package com.Serviex.Empresa.repositories;

import com.Serviex.Empresa.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>  {
}
