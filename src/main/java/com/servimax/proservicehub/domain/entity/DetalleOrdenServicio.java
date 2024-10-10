package com.servimax.proservicehub.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "detalle_orden_servicio")
public class DetalleOrdenServicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Double valor_servicio;

    @ManyToOne
    @JoinColumn(name="id_orden_servicio")
    private OrdenServicio ordenServicio;

    @ManyToOne
    @JoinColumn(name="id_servicio")
    private Servicio servicio;

    public DetalleOrdenServicio() {
    }

    public DetalleOrdenServicio(Double valor_servicio, OrdenServicio ordenServicio, Servicio servicio) {
        this.valor_servicio = valor_servicio;
        this.ordenServicio = ordenServicio;
        this.servicio = servicio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValor_servicio() {
        return valor_servicio;
    }

    public void setValor_servicio(Double valor_servicio) {
        this.valor_servicio = valor_servicio;
    }

    public OrdenServicio getOrden_servicio() {
        return ordenServicio;
    }

    public void setOrden_servicio(OrdenServicio orden_servicio) {
        this.ordenServicio = orden_servicio;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    

}
