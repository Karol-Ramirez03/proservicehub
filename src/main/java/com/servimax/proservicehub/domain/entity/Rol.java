package com.servimax.proservicehub.domain.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.servimax.proservicehub.domain.entity.segurity.GrantedPermission;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

//tabla 1
@Entity
@Table(name="rol")
public class Rol {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;

    @JsonIgnore
    @OneToMany(mappedBy = "rol")
    private List<Login> login;
    
    @JsonIgnore
    @OneToMany(mappedBy = "role", fetch = FetchType.EAGER)
    private List<GrantedPermission> permissions;
    
    public Rol() {
    }

    public Rol(String nombre) {
        this.nombre = nombre;
    }

    public Rol(Long id, String nombre, List<Login> login) {
        this.id = id;
        this.nombre = nombre;
        this.login = login;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Login> getLogin() {
        return login;
    }

    public void setLogin(List<Login> login) {
        this.login = login;
    }

    public List<GrantedPermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<GrantedPermission> permissions) {
        this.permissions = permissions;
    }

    

}
