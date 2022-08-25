package com.Serviex.Empresa;

import com.Serviex.Empresa.entities.Enterprice;
import java.time.LocalDate;

import com.Serviex.Empresa.entities.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class EmpresaApplication {

	public static void main(String[] args) {
		//SpringApplication.run(EmpresaApplication.class, args);
        User user= new User((long)1,"eje@email.com","1234");
        User[] users=new User[]{ user };
        Enterprice enterprice= new Enterprice((long)1, "5555","3222","calle falsa",
                LocalDate.of(2022,8,24),
                LocalDate.of(2022,8,24),users);
        System.out.println("id:"+ enterprice.getId().toString());
        System.out.println("document:"+ enterprice.getDocument());
        System.out.println("phone:"+ enterprice.getPhone());
        System.out.println("address:"+ enterprice.getAddress());
        System.out.println("updateAt:"+ enterprice.getUpdateAt());
        System.out.println("createAt:"+ enterprice.getCreateAt());
        System.out.println("user:"+ enterprice.getUser()[0].getEmail().toString());
	}

}
