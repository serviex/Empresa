package com.Serviex.Empresa.entities;

import java.time.LocalDate;
import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "enterprice")
public class Enterprice {
    //ATRIBUTOS
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "enterprice_id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "document")
    private String document;
    @Column(name = "phone")
    private String phone;
    @Column(name = "address")
    private String address;
    @Column(name = "createAt")
    private LocalDate createAt;
    @Column(name = "updateAt")
    private LocalDate updateAt;

    @OneToMany(mappedBy = "enterprice", cascade = CascadeType.ALL)

    private List<Employee> employees;

    //MÉTODOS
    public Enterprice() {
    }
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

    public List<Employee> getEmployees() {
        return employees;
    }

    public void addEmployee(Employee employee){
        this.employees.add(employee);
        employee.setEnterprice(this);
    }

    public void removeEmployee(Employee employee){
        this.employees.remove(employee);
        employee.setEnterprice(null);
    }
}
