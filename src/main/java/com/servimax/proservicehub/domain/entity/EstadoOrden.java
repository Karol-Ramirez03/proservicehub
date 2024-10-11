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
@Table(name = "estado_orden")
public class EstadoOrden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column
    private String nombre;

    @OneToMany(mappedBy = "estado_orden")
    private List<DetalleOrdenTrabajo> detalleOrdenTrabajo;

    
    public EstadoOrden(Long id, String nombre, List<DetalleOrdenTrabajo> detalleOrdenTrabajo) {
        this.id = id;
        this.nombre = nombre;
        this.detalleOrdenTrabajo = detalleOrdenTrabajo;
    }

    public EstadoOrden() {
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
    
}