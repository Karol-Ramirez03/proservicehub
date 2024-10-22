package com.servimax.proservicehub.domain.dto;

import java.io.Serializable;

import com.servimax.proservicehub.domain.entity.Personas;
import com.servimax.proservicehub.domain.entity.Rol;

public class RegisterUser implements Serializable{

    private Long id;
    private String username;
    private String password;
    private Rol role;
    private Personas persona;
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

    public String getJwt() {
        return jwt;
    }
    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Rol getRole() {
        return role;
    }
    public void setRole(Rol role) {
        this.role = role;
    }
    public Personas getPersona() {
        return persona;
    }
    public void setPersona(Personas persona) {
        this.persona = persona;
    }

    

}
