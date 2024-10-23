package com.servimax.proservicehub.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="login")
public class Login {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "no puede estar vacio")
    @Column(unique=true)
    private String usuario;

    @NotBlank(message = "no puede estar vacio")
    @Column(unique=true)
    private String contraseña;

    @ManyToOne
    @NotNull(message = "no puede estar vacio")
    @JoinColumn(name="id_rol")
    private Rol rol;

    @ManyToOne
    @NotNull(message = "no puede estar vacio")
    @JoinColumn(name="id_persona")
    private Personas personas;

    public Login() {
    }

    
    public Login(Long id, @NotBlank String usuario) {
        this.id = id;
        this.usuario = usuario;
    }


    public Login(@NotBlank String usuario, @NotBlank String contraseña) {
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public Login(Long id, String usuario, String contraseña, Rol rol, Personas personas) {
        this.id = id;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.rol = rol;
        this.personas = personas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Personas getPersonas() {
        return personas;
    }

    public void setPersonas(Personas personas) {
        this.personas = personas;
    }

    


}
