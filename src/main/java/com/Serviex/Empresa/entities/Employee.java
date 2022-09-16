package com.Serviex.Empresa.entities;

import com.Serviex.Empresa.entities.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
@Entity
@Data
@Table(name = "employee")
@JsonIgnoreProperties({"enterprice"})
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id")
    private Long id;
    @Column(name = "email", unique = true)
    private String email;
    @Column(name = "name")
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(name="role")
    private Role role;

    @Column(name = "image")
    private String image;

    @Column(name = "auth0Id")
    private String auth0Id;
    @ManyToOne(fetch = FetchType.LAZY,
            targetEntity = Enterprice.class)
    @JoinColumn(name = "enterprice_id")
    private Enterprice enterprice;
    @Column(name = "createAt")
    private LocalDate createAt;
    @Column(name = "updateAt")
    private LocalDate updateAt;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)

    private List<Transaction> transactions;
    //MÉTODOS
    public Employee(){

    }
    public Employee(Long id, String email, String name, Role role,
                LocalDate createAt, LocalDate updateAt) {
        setId(id);
        setEmail(email);
        setName(name);
        setRole(role);
        setCreateAt(createAt);
        setUpdateAt(updateAt);

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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


    public Enterprice getEnterprice() {
        return enterprice;
    }

    public void setEnterprice(Enterprice enterprice) {
        this.enterprice = enterprice;
    }
    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void addTransaction(Transaction transaction){
        if (transactions == null)
            transactions = new ArrayList<>();
        this.transactions.add(transaction);
        transaction.setUser(this);
    }

    public void removeTransaction(Transaction transaction){
        this.transactions.remove(transaction);
        transaction.setUser(null);
    }
}
