package com.Serviex.Empresa.controllers;
import com.Serviex.Empresa.entities.Enterprice;
import com.Serviex.Empresa.entities.Transaction;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
public class TransactionController {
    private Transaction transaction;

    TransactionController() {
        this.transaction =
                new Transaction((long)1,"compra pan",(float)1000,
                LocalDate.of(2022,8,24),
                LocalDate.of(2022,8,24));
    }
    @GetMapping("/Transaction")
    public Transaction getTransaction() {
        return transaction;
    }
    @PostMapping("/Transaction")
    public Transaction createTransaction(@RequestBody Transaction transaction) {
        this.transaction =transaction;
        return this.transaction;
    }
    @PutMapping("/Transaction/{id}")
    public Transaction setTransaction(@RequestBody Transaction transaction, @PathVariable Long id) {
        if(this.transaction.getId()== id)
        {
            this.transaction =transaction;
            return transaction;
        }
        return transaction;
    }
}
