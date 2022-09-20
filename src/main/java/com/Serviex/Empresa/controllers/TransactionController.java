package com.Serviex.Empresa.controllers;

import com.Serviex.Empresa.entities.Employee;
import com.Serviex.Empresa.entities.Enterprice;
import com.Serviex.Empresa.entities.Transaction;
import com.Serviex.Empresa.entities.TransactionView;
import com.Serviex.Empresa.services.TransactionService;
import com.Serviex.Empresa.services.EnterpriceService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.List;

@RestController
public class TransactionController {
    private Transaction transaction;
    private EnterpriceService enterpriceService;
    private TransactionService service;

    TransactionController(TransactionService service, EnterpriceService enterpriceService) {
        this.enterpriceService =enterpriceService;
        this.service = service;
    }

    @GetMapping("/transaction")
    public ModelAndView getTransaction(Model model, @AuthenticationPrincipal OidcUser principal) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("transaction");

        List<Transaction> transactions= this.service.getTransactions();
        model.addAttribute("transactions", transactions);
        float total=0;
        for (int i=0; i< transactions.stream().count(); i++)
        {
            total =total +transactions.get(i).getAmount();
        }
        model.addAttribute("total", total);
        return modelAndView;
    }
    @GetMapping("/newTransaction")
    public ModelAndView  newTransaction(Model model, @AuthenticationPrincipal OidcUser principal) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("newTransaction");
        TransactionView transaction=  new TransactionView();
        List<Enterprice> enterprices= this.enterpriceService.getEnterprices();
        model.addAttribute("enterprice", enterprices);

        model.addAttribute("transaction", transaction);
        return modelAndView;
    }
    @GetMapping("/Transaction/{id}")
    public Transaction getTransaction(@PathVariable("id") long id) {
        return this.service.getTransaction(id);
    }
    @PostMapping("/addTransaction")
    public ModelAndView  createTransaction(TransactionView transaction, BindingResult result, Model model) {
        Transaction transaction1 = new Transaction();
        transaction1.setConcept(transaction.getConcept());
        transaction1.setAmount(transaction.getAmount());
        if(transaction.getIdEnterprice()> 0){
            Enterprice e = this.enterpriceService.getEnterprice(transaction.getIdEnterprice());
            transaction1.setEnterprice(e);
        }

        this.service.createTransaction(transaction1);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("transaction");


        List<Transaction> transactions= this.service.getTransactions();
        model.addAttribute("transactions", transactions);
        float total=0;
        for (int i=0; i< transactions.stream().count(); i++)
        {
            total =total +transactions.get(i).getAmount();
        }
        model.addAttribute("total", total);
        return modelAndView;
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
