package com.Serviex.Empresa.entities;

import java.time.LocalDate;

public class Employee {
    private Long id;
    private String email;
    private String name;
    private Role role;
    private Enterprice enterprice;
    private LocalDate createAt;
    private LocalDate updateAt;
    private String authOId;

    //MÉTODOS
    public Employee(Long id, String email, String name, Role role,
                LocalDate createAt, LocalDate updateAt,
                Enterprice enterprice, String authOId) {
        setId(id);
        setEmail(email);
        setName(name);
        setRole(role);
        setEnterprice(enterprice);
        setCreateAt(createAt);
        setUpdateAt(updateAt);
        setAuthOId(authOId);
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

    public String getAuthOId() {
        return authOId;
    }

    public void setAuthOId(String authOId) {
        this.authOId = authOId;
    }

    public Enterprice getEnterprice() {
        return enterprice;
    }

    public void setEnterprice(Enterprice enterprice) {
        this.enterprice = enterprice;
    }
}
