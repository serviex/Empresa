package com.Serviex.Empresa.controllers;

import com.Serviex.Empresa.entities.Enterprice;
import com.Serviex.Empresa.services.EnterpriceService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class EnterpriceController {
    private EnterpriceService service;

    EnterpriceController(EnterpriceService service) {
        this.service = service;
    }
    @GetMapping("/Enterprice")
    public List<Enterprice> getEnterprices() {
        return this.service.getEnterprices();
    }
    @GetMapping("/Enterprice/{id}")
    public Enterprice getEnterprice(@PathVariable("id") long id) {
        return this.service.getEnterprice(id);
    }
    @PostMapping("/Enterprice")
    public Enterprice createEnterprice(@RequestBody Enterprice enterprice) {
        return this.service.createEnterprice(enterprice);
    }
    @PutMapping("/Enterprice/{id}")
    public Enterprice setEnterprice(@RequestBody Enterprice enterprice, @PathVariable("id") long id) {
        return this.service.updateEnterprice(id, enterprice);
    }

    @DeleteMapping("/Enterprice/{id}")
    public Boolean deleteEnterprice(@PathVariable("id") long id){
        return this.service.deleteEnterprice(id);
    }
}
