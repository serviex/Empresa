package com.Serviex.Empresa.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

public class TransactionView {

    private String concept;

    private Float amount;

    private Long idEnterprice;

    private List<Enterprice> entreprice;
    public TransactionView(){

    }
    public TransactionView(Long idEnterprice, String concept,Float amount) {
        setIdEnterprice(idEnterprice);
        setConcept(concept);
        setAmount(amount);

    }
    public Long getIdEnterprice() {
        return this.idEnterprice;
    }

    public void setIdEnterprice(Long id) {
        this.idEnterprice = id;
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public List<Enterprice> getEntreprice() {
        return entreprice;
    }

    public void setEnterprice(List<Enterprice> entreprice) {
        this.entreprice = entreprice;
    }
}
