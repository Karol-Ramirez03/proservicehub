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
@Table(name = "estado_orden")
public class EstadoOrden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "No puedes ser vacio")
    @Column
    private String nombre;

    @JsonIgnore
    @OneToMany(mappedBy = "estado_orden")
    private List<DetalleOrdenTrabajo> detalleOrdenTrabajo;

    
    public EstadoOrden(Long id, String nombre, List<DetalleOrdenTrabajo> detalleOrdenTrabajo) {
        this.id = id;
        this.nombre = nombre;
        this.detalleOrdenTrabajo = detalleOrdenTrabajo;
    }

    public EstadoOrden() {
    }

    public EstadoOrden(@NotBlank(message = "No puedes ser vacio nombre") String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public List<DetalleOrdenTrabajo> getDetalleOrdenTrabajo() {
        return detalleOrdenTrabajo;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDetalleOrdenTrabajo(List<DetalleOrdenTrabajo> detalleOrdenTrabajo) {
        this.detalleOrdenTrabajo = detalleOrdenTrabajo;
    }
    
}
