package com.Serviex.Empresa.entities;

import java.time.LocalDate;

public class Transaction {

    //ATRIBUTOS
    private Long id;
    private String concept;
    private Float amount;
    private LocalDate createAt;
    private LocalDate updateAt;
    private Employee user;
    //MÉTODOS
    public Transaction(Long id, String concept,Float amount, LocalDate createAt,
                      LocalDate updateAt, Employee user) {
        setId(id);
        setConcept(concept);
        setAmount(amount);
        setCreateAt(createAt);
        setUpdateAt(updateAt);
        setUser(user);
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDate getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDate createAt) {
        this.createAt = createAt;
    }

    public LocalDate getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDate updateAt) {
        this.updateAt = updateAt;
    }

    public Employee getUser() {
        return user;
    }

    public void setUser(Employee user) {
        this.user = user;
    }


}
