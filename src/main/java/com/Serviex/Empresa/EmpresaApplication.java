package com.Serviex.Empresa;

import com.Serviex.Empresa.entities.Employee;
import com.Serviex.Empresa.entities.Enterprice;
import java.time.LocalDate;

import com.Serviex.Empresa.entities.Role;
import com.Serviex.Empresa.entities.Transaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmpresaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpresaApplication.class, args);
        /*Enterprice enterprice_alt= new Enterprice((long)1, "Competencia de Lagobo",
                "6666","2333","carrera falsa",
                LocalDate.of(2022,8,24),
                LocalDate.of(2022,8,24));
        Enterprice enterprice= new Enterprice((long)1, "empaladito", "5555","3222","calle falsa",
                LocalDate.of(2022,8,24),
                LocalDate.of(2022,8,24));
        System.out.println("id:"+ enterprice.getId().toString());
        System.out.println("name:"+ enterprice.getName());
        enterprice.setName("Lagobo");
        System.out.println("set name:"+ enterprice.getName());
        System.out.println("document:"+ enterprice.getDocument());
        enterprice.setDocument("12345");
        System.out.println("document:"+ enterprice.getDocument());
        System.out.println("phone:"+ enterprice.getPhone());
        enterprice.setPhone("6666");
        System.out.println("set phone:"+ enterprice.getPhone());
        System.out.println("address:"+ enterprice.getAddress());
        enterprice.setAddress("Carrera false 123");
        System.out.println("set address:"+ enterprice.getAddress());
        System.out.println("updateAt:"+ enterprice.getUpdateAt());
        System.out.println("createAt:"+ enterprice.getCreateAt());
        Employee user= new Employee((long)1,"eje@email.com",
                "Tafif",Role.operativo,
                LocalDate.of(2022,8,24),
                LocalDate.of(2022,8,24),
                enterprice,
                "22222");
        System.out.println("id:"+ user.getId().toString());
        System.out.println("Email:" + user.getEmail());
        user.setEmail("cambio@gmail.com");
        System.out.println("Set email:" + user.getEmail());
        System.out.println("Name:" + user.getName());
        user.setName("David");
        System.out.println("Set name:" + user.getName());
        System.out.println("Role:" + user.getRole());
        user.setRole(Role.administrador);
        System.out.println("Set role" + user.getRole());
        System.out.println(user.getCreateAt());
        System.out.println(user.getUpdateAt());
        System.out.println(user.getAuthOId());
        System.out.println(user.getName() + " trabajaba en " + user.getEnterprice().getName());
        user.setEnterprice(enterprice_alt);
        System.out.println("Pero ahora trabaja en " + user.getEnterprice().getName());
        Transaction transaction= new Transaction((long)1,"compra pan",(float)1000,
            LocalDate.of(2022,8,24),
            LocalDate.of(2022,8,24),user);
        System.out.println("id:"+ transaction.getId().toString());
        System.out.println("concept:"+ transaction.getConcept());
        transaction.setConcept("compra pizza");
        System.out.println("set concept:"+ transaction.getConcept());
        System.out.println("amount:"+ transaction.getAmount());
        transaction.setAmount((float)-1000);
        System.out.println("set amount:"+ transaction.getAmount());
        System.out.println("updateAt:"+ transaction.getUpdateAt());
        System.out.println("createAt:"+ transaction.getCreateAt());
        System.out.println("user:"+ transaction.getUser().getEmail().toString());*/
	}

}
