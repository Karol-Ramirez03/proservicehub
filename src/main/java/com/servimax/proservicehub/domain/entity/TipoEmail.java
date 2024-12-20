package com.servimax.proservicehub.domain.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "tipo_email")
public class TipoEmail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; 

    @Column
    @NotBlank(message = "no puede ser null")
    private String nombre;

    @JsonIgnore
    @OneToMany(mappedBy = "tipoEmail")
    private List<EmailPersona> emailPersona;

    public TipoEmail() {
    }

    public TipoEmail(String nombre) {
        this.nombre = nombre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<EmailPersona> getEmailPersona() {
        return emailPersona;
    }

    public void setEmailPersona(List<EmailPersona> emailPersona) {
        this.emailPersona = emailPersona;
    }


    
}
