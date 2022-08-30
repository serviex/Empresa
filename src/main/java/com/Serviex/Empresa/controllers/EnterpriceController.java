package com.Serviex.Empresa.controllers;

import com.Serviex.Empresa.entities.Enterprice;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
public class EnterpriceController {
    private Enterprice enterprice;

    EnterpriceController() {
        this.enterprice = new Enterprice((long)1, "Competencia de Lagobo",
                "6666","2333","carrera falsa",
                LocalDate.of(2022,8,24),
                LocalDate.of(2022,8,24));
    }
    @GetMapping("/Enterprice")
    public Enterprice getEnterprice() {
        return enterprice;
    }
    @PostMapping("/Enterprice")
    public Enterprice createEnterprice(@RequestBody Enterprice enterprice) {
        this.enterprice =enterprice;
        return this.enterprice;
    }
    @PutMapping("/Enterprice/{id}")
    public Enterprice setEnterprice(@RequestBody Enterprice enterprice, @PathVariable Long id) {
        this.enterprice =enterprice;
        return enterprice;
    }
}
