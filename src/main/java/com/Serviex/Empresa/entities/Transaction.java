package com.Serviex.Empresa.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDate;
import javax.persistence.*;
import java.util.List;
@Entity
@Data
@Table(name = "transaction")
@JsonIgnoreProperties({"employee","entreprice"})
public class Transaction {

    //ATRIBUTOS
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "transaction_id")
    private Long id;
    @Column(name = "concept")
    private String concept;
    @Column(name = "amount")
    private Float amount;
    @Column(name = "createAt")
    private LocalDate createAt;
    @Column(name = "updateAt")
    private LocalDate updateAt;
    @ManyToOne(fetch = FetchType.LAZY,
            targetEntity = Employee.class)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY,
            targetEntity = Enterprice.class)
    @JoinColumn(name = "entreprice_id")
    private Enterprice entreprice;
    //MÉTODOS
    public Transaction(){

    }
    public Transaction(Long id, String concept,Float amount, LocalDate createAt,
                      LocalDate updateAt) {
        setId(id);
        setConcept(concept);
        setAmount(amount);
        setCreateAt(createAt);
        setUpdateAt(updateAt);
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
        return employee;
    }

    public void setUser(Employee user) {
        this.employee = user;
    }

    public Enterprice getEntreprice() {
        return entreprice;
    }

    public void setEnterprice(Enterprice entreprice) {
        this.entreprice = entreprice;
    }
}
