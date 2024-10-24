package com.servimax.proservicehub.domain.dto;

import java.io.Serializable;

import com.servimax.proservicehub.domain.entity.Personas;
import com.servimax.proservicehub.domain.entity.Rol;

public class RegisterUser implements Serializable {
    private Long id;
    private String username;
    private Personas idPersonas;
    private Rol role;
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
    
    public Rol getRole() {
        return role;
    }
    public void setRole(Rol role) {
        this.role = role;
    }
    public String getJwt() {
        return jwt;
    }
    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
    public Personas getIdPersonas() {
        return idPersonas;
    }
    public void setIdPersonas(Personas idPersonas) {
        this.idPersonas = idPersonas;
    }
    

}