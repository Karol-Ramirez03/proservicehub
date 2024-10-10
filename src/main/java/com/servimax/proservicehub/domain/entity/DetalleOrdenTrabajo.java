package com.servimax.proservicehub.domain.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "detalle_orden_trabajo")
public class DetalleOrdenTrabajo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Date fecha;

    @ManyToOne
    @JoinColumn(name="id_orden_trabajo")
    private OrdenTrabajo orden_trabajo;

    @ManyToOne
    @JoinColumn(name="id_estado")
    private EstadoOrden estado_orden;
   
    @ManyToOne
    @JoinColumn(name="id_servicio")
    private Servicio servicio;

    public DetalleOrdenTrabajo() {
    }

    public DetalleOrdenTrabajo(Long id, Date fecha, OrdenTrabajo orden_trabajo, EstadoOrden estado_orden,
            Servicio servicio) {
        this.id = id;
        this.fecha = fecha;
        this.orden_trabajo = orden_trabajo;
        this.estado_orden = estado_orden;
        this.servicio = servicio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public OrdenTrabajo getOrden_trabajo() {
        return orden_trabajo;
    }

    public void setOrden_trabajo(OrdenTrabajo orden_trabajo) {
        this.orden_trabajo = orden_trabajo;
    }

    public EstadoOrden getEstado_orden() {
        return estado_orden;
    }

    public void setEstado_orden(EstadoOrden estado_orden) {
        this.estado_orden = estado_orden;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    




}
