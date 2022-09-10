package com.Serviex.Empresa.controllers;

import com.Serviex.Empresa.entities.Transaction;
import com.Serviex.Empresa.services.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class TransactionController {
    private Transaction transaction;

    private TransactionService service;

    TransactionController(TransactionService service) {
        this.service = service;
    }
    @GetMapping("/Transaction")
    public List<Transaction> getTransaction() {
        return this.service.getTransactions();
    }
    @GetMapping("/Transaction/{id}")
    public Transaction getTransaction(@PathVariable("id") long id) {
        return this.service.getTransaction(id);
    }
    @PostMapping("/Transaction")
    public Transaction createTransaction(@RequestBody Transaction transaction) {
        return this.service.createTransaction(transaction);
    }
    @PutMapping("/Transaction/{id}")
    public Transaction setEnterprice(@RequestBody Transaction transaction, @PathVariable("id") long id) {
        return this.service.updateTransaction(id, transaction);
    }

    @DeleteMapping("/Transaction/{id}")
    public Boolean deleteTransaction(@PathVariable("id") long id){
        return this.service.deleteTransaction(id);
    }

}
