package com.Serviex.Empresa.controllers;

import com.Serviex.Empresa.entities.Enterprice;
import com.Serviex.Empresa.entities.Transaction;
import com.Serviex.Empresa.services.EnterpriceService;
import com.Serviex.Empresa.services.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class EnterpriceController {
    private EnterpriceService service;
    private TransactionService serviceTransaction;
    EnterpriceController(EnterpriceService service,TransactionService serviceTransaction) {

        this.service = service;
        this.serviceTransaction =serviceTransaction;
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
    @PostMapping("/Enterprice/{id}/movements")
    public Enterprice createTransaction(@RequestBody Transaction transaction, @PathVariable("id") long id) {
        Transaction tra= this.serviceTransaction.createTransaction(transaction);
        return this.service.createTransaction(tra, id);
    }
    @DeleteMapping("/Enterprice/{id}")
    public Boolean deleteEnterprice(@PathVariable("id") long id){
        return this.service.deleteEnterprice(id);
    }

    @DeleteMapping("/Enterprice/{id}/movements/{idMovement}")
    public Boolean deleteTransaction(@PathVariable("id") long id,@PathVariable("idMovement") long idMovement){
        Transaction tra= this.serviceTransaction.getTransaction(idMovement);
        return this.service.deleteTransaction(id, tra);
    }
}
