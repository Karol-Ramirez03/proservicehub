package com.servimax.proservicehub.domain.dto;

import java.io.Serializable;

public class RegisterUsuario implements Serializable{

    private Long id;
    private String username;
    private String role;
    private String jwt;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public String getJwt() {
        return jwt;
    }
    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    
}
