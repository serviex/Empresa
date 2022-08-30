package com.Serviex.Empresa.controllers;

import com.Serviex.Empresa.entities.Enterprice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class EnterpriceController {
    private Enterprice enterprice;

    public  EnterpriceController(){
        this.enterprice = new Enterprice((long)1, "Competencia de Lagobo",
                "6666","2333","carrera falsa",
                LocalDate.of(2022,8,24),
                LocalDate.of(2022,8,24));
    }
    @GetMapping("/Enterprice")
    public Enterprice getEnterprice() {
        return enterprice;
    }
}
