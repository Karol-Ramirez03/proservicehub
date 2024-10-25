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
@Table(name = "estado_orden_servicio")
public class EstadoOrdenServicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    @NotBlank(message = "no puede estar vacio")
    private String nombre;

    @JsonIgnore
    @OneToMany(mappedBy = "estado_orden_servicio")
    private List<OrdenServicio> ordenServicio;

    public EstadoOrdenServicio() {
    }

    public EstadoOrdenServicio(String nombre) {
        this.nombre = nombre;
    }

    public EstadoOrdenServicio(long id, String nombre) {
        this.id = id;
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

    public List<OrdenServicio> getOrdenServicio() {
        return ordenServicio;
    }

    public void setOrdenServicio(List<OrdenServicio> ordenServicio) {
        this.ordenServicio = ordenServicio;
    }

    
}
