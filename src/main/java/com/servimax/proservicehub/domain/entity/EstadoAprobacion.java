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
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "estado_aprobacion")
public class EstadoAprobacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull(message = "no puede estar vacio")
    private String nombre;

    @JsonIgnore
    @OneToMany(mappedBy = "estado_aprobacion")
    private List<AprobacionServicio> aprobacionServicio;

    public EstadoAprobacion() {
    }

    public EstadoAprobacion(String nombre) {
        this.nombre = nombre;
    }

    public EstadoAprobacion(Long id, String nombre, List<AprobacionServicio> aprobacionServicio) {
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

    public List<AprobacionServicio> getAprobacionServicio() {
        return aprobacionServicio;
    }

    public void setAprobacionServicio(List<AprobacionServicio> aprobacionServicio) {
        this.aprobacionServicio = aprobacionServicio;
    }
    
}

