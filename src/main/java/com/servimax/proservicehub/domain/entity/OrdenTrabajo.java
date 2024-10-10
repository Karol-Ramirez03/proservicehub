package com.servimax.proservicehub.domain.entity;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "orden_trabajo")
public class OrdenTrabajo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String numero_orden_trabajo;

    @Column
    private Date fecha_asignacion;
    
    @Column
    private Time hora_asignacion;

    @OneToMany(mappedBy = "orden_trabajo")
    private List<DetalleOrdenTrabajo> detalleOrdenTrabajo;

    @ManyToOne
    @JoinColumn(name="id_empleado")
    private Personas personas;

    @ManyToOne
    @JoinColumn(name="numero_orden_servicio")
    private OrdenServicio ordenServicio;

    @OneToMany(mappedBy = "orden_trabajo")
    private List<AprobacionServicio> aprobacionServicios;

    public OrdenTrabajo() {
    }

    public OrdenTrabajo(Long id, String numero_orden_trabajo, Date fecha_asignacion, Time hora_asignacion,
            List<DetalleOrdenTrabajo> detalleOrdenTrabajo, Personas personas, OrdenServicio ordenServicio) {
        this.id = id;
        this.numero_orden_trabajo = numero_orden_trabajo;
        this.fecha_asignacion = fecha_asignacion;
        this.hora_asignacion = hora_asignacion;
        this.detalleOrdenTrabajo = detalleOrdenTrabajo;
        this.personas = personas;
        this.ordenServicio = ordenServicio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero_orden_trabajo() {
        return numero_orden_trabajo;
    }

    public void setNumero_orden_trabajo(String numero_orden_trabajo) {
        this.numero_orden_trabajo = numero_orden_trabajo;
    }

    public Date getFecha_asignacion() {
        return fecha_asignacion;
    }

    public void setFecha_asignacion(Date fecha_asignacion) {
        this.fecha_asignacion = fecha_asignacion;
    }

    public Time getHora_asignacion() {
        return hora_asignacion;
    }

    public void setHora_asignacion(Time hora_asignacion) {
        this.hora_asignacion = hora_asignacion;
    }

    public List<DetalleOrdenTrabajo> getDetalleOrdenTrabajo() {
        return detalleOrdenTrabajo;
    }

    public void setDetalleOrdenTrabajo(List<DetalleOrdenTrabajo> detalleOrdenTrabajo) {
        this.detalleOrdenTrabajo = detalleOrdenTrabajo;
    }

    public Personas getPersonas() {
        return personas;
    }

    public void setPersonas(Personas personas) {
        this.personas = personas;
    }

    public OrdenServicio getOrdenServicio() {
        return ordenServicio;
    }

    public void setOrdenServicio(OrdenServicio ordenServicio) {
        this.ordenServicio = ordenServicio;
    }

    public List<AprobacionServicio> getAprobacionServicios() {
        return aprobacionServicios;
    }

    public void setAprobacionServicios(List<AprobacionServicio> aprobacionServicios) {
        this.aprobacionServicios = aprobacionServicios;
    }


}
