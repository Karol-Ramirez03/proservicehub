package com.servimax.proservicehub.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "detalle_orden_servicio")
public class DetalleOrdenServicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "no puede estar vacio")
    @Column
    private Double valor_servicio;

    @NotNull(message = "no puede estar vacio")
    @ManyToOne
    @JoinColumn(name="id_orden_servicio")
    private OrdenServicio id_orden_servicio;

    @NotNull(message = "no puede estar vacio")
    @ManyToOne
    @JoinColumn(name="id_servicio")
    private Servicio servicio;

    public DetalleOrdenServicio() {
    }

    public DetalleOrdenServicio(Double valor_servicio, OrdenServicio id_orden_servicio, Servicio servicio) {
        this.valor_servicio = valor_servicio;
        this.id_orden_servicio = id_orden_servicio;
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
        return id_orden_servicio;
    }

    public void setOrden_servicio(OrdenServicio orden_servicio) {
        this.id_orden_servicio = orden_servicio;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public OrdenServicio getOrdenServicio() {
        return id_orden_servicio;
    }

    public void setOrdenServicio(OrdenServicio ordenServicio) {
        this.id_orden_servicio = ordenServicio;
    }



    

}
