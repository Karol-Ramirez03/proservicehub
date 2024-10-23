package com.servimax.proservicehub.domain.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "region")
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotBlank(message = "No puede estar vacio")
    private String nombre;
    
    @ManyToOne
    @NotNull(message = "No puede estar vacio")
    private Pais pais;

    @JsonIgnore
    @OneToMany(mappedBy = "region")
    private List<Ciudad> ciudad;

    public Region() {
    }

    public Region(String nombre, Pais pais) {
        this.nombre = nombre;
        this.pais = pais;
    }

    public Region(String nombre) {
        this.nombre = nombre;
    }

    public Region(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    
}
