package com.servimax.proservicehub.domain.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "estado_aprovacion")
public class EstadoAprovacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;

    @OneToMany(mappedBy = "estado_aprovacion")
    private List<AprobacionServicio> aprobacionServicio;

    public EstadoAprovacion() {
    }

    public EstadoAprovacion(Long id, String nombre, List<AprobacionServicio> aprobacionServicio) {
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

    // public List<AprobacionServicio> getAprobacionServicio() {
    //     return aprobacionServicio;
    // }

    // public void setAprobacionServicio(List<AprobacionServicio> aprobacionServicio) {
    //     this.aprobacionServicio = aprobacionServicio;
    // }
    
}

