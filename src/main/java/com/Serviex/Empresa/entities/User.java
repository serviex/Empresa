package com.Serviex.Empresa.entities;

public class User {
    private Long id;

    private String email;

    private String authOId;

    public User(Long id,String email,String authOId){
        setEmail(email);
        setId(id);
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

    public String getAuthOId() {
        return authOId;
    }

    public void setAuthOId(String authOId) {
        this.authOId = authOId;
    }

}
