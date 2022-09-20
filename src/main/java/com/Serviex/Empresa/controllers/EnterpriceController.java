package com.Serviex.Empresa.controllers;

import com.Serviex.Empresa.entities.Employee;
import com.Serviex.Empresa.entities.Enterprice;
import com.Serviex.Empresa.entities.Transaction;
import com.Serviex.Empresa.services.EnterpriceService;
import com.Serviex.Empresa.services.TransactionService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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

    @GetMapping("/enterprice")
    public ModelAndView getEnterprice(Model model, @AuthenticationPrincipal OidcUser principal) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("enterprice");

        List<Enterprice> enterprices= this.service.getEnterprices();
        model.addAttribute("enterprices", enterprices);
        return modelAndView;
    }
    @GetMapping("/newEnterprice")
    public ModelAndView  newEnterprice(Model model, @AuthenticationPrincipal OidcUser principal) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("newEnterprice");
        Enterprice enterprice=  new Enterprice();
        model.addAttribute("enterprice", enterprice);
        return modelAndView;
    }

    @GetMapping("/Enterprice/{id}")
    public Enterprice getEnterprice(@PathVariable("id") long id) {
        return this.service.getEnterprice(id);
    }
    @PostMapping("/addEnterprice")
    public ModelAndView  createEnterprice(Enterprice employee, BindingResult result, Model model) {
        this.service.createEnterprice(employee);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("enterprice");

        List<Enterprice> enterprices= this.service.getEnterprices();
        model.addAttribute("enterprice", enterprices);
        return modelAndView;
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
