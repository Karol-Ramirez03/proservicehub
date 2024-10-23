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
@Table(name = "aprovacion_servicio")
public class AprobacionServicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @NotNull(message = "no puede estar vacio")
    @JoinColumn(name="id_orden_trabajo")
    private OrdenTrabajo orden_trabajo;

    @ManyToOne
    @NotNull(message = "no puede estar vacio")
    @JoinColumn(name="id_cliente")
    private Personas personas;

    @ManyToOne
    @NotNull(message = "no puede estar vacio")
    @JoinColumn(name="id_servicio")
    private Servicio servicio;

    @Column
    @NotNull(message = "no puede estar vacio")
    private String hallazgo;

    @Column
    @NotNull(message = "no puede estar vacio")
    private String solucion;

    @Column
    @NotNull(message = "no puede estar vacio")
    private String motivoRechazo;
    
    @ManyToOne
    @NotNull(message = "no puede estar vacio")
    private EstadoAprobacion estado_aprobacion;

    public AprobacionServicio() {
    }

    public AprobacionServicio(Long id, OrdenTrabajo orden_trabajo, Personas personas, Servicio servicio,
            String hallazgo, String solucion, EstadoAprobacion estado_aprovacion) {
        this.id = id;
        this.orden_trabajo = orden_trabajo;
        this.personas = personas;
        this.servicio = servicio;
        this.hallazgo = hallazgo;
        this.solucion = solucion;
        this.estado_aprobacion = estado_aprovacion;
    }

    public AprobacionServicio(Long id, OrdenTrabajo orden_trabajo, Personas personas, Servicio servicio,
            String hallazgo, String solucion, String motivoRechazo, EstadoAprobacion estado_aprobacion) {
        this.id = id;
        this.orden_trabajo = orden_trabajo;
        this.personas = personas;
        this.servicio = servicio;
        this.hallazgo = hallazgo;
        this.solucion = solucion;
        this.motivoRechazo = motivoRechazo;
        this.estado_aprobacion = estado_aprobacion;
    }

    public String getMotivoRechazo() {
        return motivoRechazo;
    }

    public void setMotivoRechazo(String motivoRechazo) {
        this.motivoRechazo = motivoRechazo;
    }

    public EstadoAprobacion getEstado_aprobacion() {
        return estado_aprobacion;
    }

    public void setEstado_aprobacion(EstadoAprobacion estado_aprobacion) {
        this.estado_aprobacion = estado_aprobacion;
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

    public EstadoAprobacion getEstado_aprovacion() {
        return estado_aprobacion;
    }

    public void setEstado_aprovacion(EstadoAprobacion estado_aprovacion) {
        this.estado_aprobacion = estado_aprovacion;
    }

    
}
