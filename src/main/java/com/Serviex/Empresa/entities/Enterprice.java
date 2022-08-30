package com.Serviex.Empresa.entities;

import java.time.LocalDate;


public class Enterprice {

    //ATRIBUTOS
    private Long id;

    private String name;

    private String document;

    private String phone;
    private String address;
    private LocalDate createAt;
    private LocalDate updateAt;
    //MÉTODOS
    public Enterprice(Long id, String name, String document,String phone,String address, LocalDate createAt,
                      LocalDate updateAt) {
        setId(id);
        setDocument(document);
        setPhone(phone);
        setAddress(address);
        setCreateAt(createAt);
        setUpdateAt(updateAt);
        setName(name);
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
