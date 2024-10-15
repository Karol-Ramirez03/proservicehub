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
@Table(name = "aprovacion_servicio")
public class AprobacionServicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="id_orden_trabajo")
    private OrdenTrabajo orden_trabajo;

    @ManyToOne
    @JoinColumn(name="id_cliente")
    private Personas personas;

    @ManyToOne
    @JoinColumn(name="id_servicio")
    private Servicio servicio;

    @Column
    private String hallazgo;

    @Column
    private String solucion;
    
    @ManyToOne
    private EstadoAprovacion estado_aprovacion;

    public AprobacionServicio() {
    }

    public AprobacionServicio(Long id, OrdenTrabajo orden_trabajo, Personas personas, Servicio servicio,
            String hallazgo, String solucion, EstadoAprovacion estado_aprovacion) {
        this.id = id;
        this.orden_trabajo = orden_trabajo;
        this.personas = personas;
        this.servicio = servicio;
        this.hallazgo = hallazgo;
        this.solucion = solucion;
        this.estado_aprovacion = estado_aprovacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrdenTrabajo getOrden_trabajo() {
        return orden_trabajo;
    }

    public void setOrden_trabajo(OrdenTrabajo orden_trabajo) {
        this.orden_trabajo = orden_trabajo;
    }

    public Personas getPersonas() {
        return personas;
    }

    public void setPersonas(Personas personas) {
        this.personas = personas;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public String getHallazgo() {
        return hallazgo;
    }

    public void setHallazgo(String hallazgo) {
        this.hallazgo = hallazgo;
    }

    public String getSolucion() {
        return solucion;
    }

    public void setSolucion(String solucion) {
        this.solucion = solucion;
    }

    public EstadoAprovacion getEstado_aprovacion() {
        return estado_aprovacion;
    }

    public void setEstado_aprovacion(EstadoAprovacion estado_aprovacion) {
        this.estado_aprovacion = estado_aprovacion;
    }

    
}
