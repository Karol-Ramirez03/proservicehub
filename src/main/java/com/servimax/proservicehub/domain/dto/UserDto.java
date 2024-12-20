package com.servimax.proservicehub.domain.dto;

import jakarta.validation.constraints.Size;
import java.io.Serializable;

import com.servimax.proservicehub.domain.entity.Personas;
import com.servimax.proservicehub.domain.entity.Rol;
//usada para el registro de buevos usuarios
public class UserDto implements Serializable {

    @Size(min = 4)
    private String name;
    private String username;
    @Size(min = 8)
    private String password;
    @Size(min = 8)
    private String repeatedPassword;

    private Personas idPersonas;
    private Rol role;

    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getRepeatedPassword() {
        return repeatedPassword;
    }
    public void setRepeatedPassword(String repeatedPassword) {
        this.repeatedPassword = repeatedPassword;
    }
    public Personas getIdPersonas() {
        return idPersonas;
    }
    public void setIdPersonas(Personas idPersonas) {
        this.idPersonas = idPersonas;
    }
    public Rol getRole() {
        return role;
    }
    public void setRole(Rol role) {
        this.role = role;
    }
    
}
