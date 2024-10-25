package com.servimax.proservicehub.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "email_persona")
public class EmailPersona {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; 

    @Column
    @NotNull(message = "no puede estar vacio")
    private String email;

    @ManyToOne
    @NotNull(message = "no puede estar vacio")
    private Personas personas;

    @ManyToOne
    @NotNull(message = "no puede estar vacio")
    private TipoEmail tipoEmail;
    

    public EmailPersona() {
    }

    public EmailPersona(long id, String email, Personas personas, TipoEmail tipoEmail) {
        this.id = id;
        this.email = email;
        this.personas = personas;
        this.tipoEmail = tipoEmail;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Personas getPersonas() {
        return personas;
    }

    public void setPersonas(Personas personas) {
        this.personas = personas;
    }

    public TipoEmail getTipoEmail() {
        return tipoEmail;
    }

    public void setTipoEmail(TipoEmail tipoEmail) {
        this.tipoEmail = tipoEmail;
    }




}
