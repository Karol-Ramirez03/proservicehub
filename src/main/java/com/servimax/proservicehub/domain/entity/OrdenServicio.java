package com.servimax.proservicehub.domain.entity;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "orden_servicio")
public class OrdenServicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numero_orden;

    @Column
    private Date fecha_orden;

    @ManyToOne
    @NotNull(message = "no puede estar vacio")
    @JoinColumn(name="id_cliente")
    private Personas personas;

    @ManyToOne
    @JoinColumn(name="id_empleado")
    private Personas persona;

    @ManyToOne
    @NotNull(message = "no puede estar vacio")
    private EstadoOrdenServicio estado_orden_servicio;

    @JsonIgnore
    @OneToMany(mappedBy = "ordenServicio")
    private List<OrdenTrabajo> ordenTrabajo;

    @PrePersist
    protected void onCreate() {
        this.fecha_orden = new Timestamp(new Date().getTime());
    }

    public OrdenServicio() {
    }

    public OrdenServicio(Date fecha_orden) {
        this.fecha_orden = fecha_orden;
    }

    public Long getNumero_orden() {
        return numero_orden;
    }

    public void setNumero_orden(Long numero_orden) {
        this.numero_orden = numero_orden;
    }

    public Date getFecha_orden() {
        return fecha_orden;
    }

    public void setFecha_orden(Date fecha_orden) {
        this.fecha_orden = fecha_orden;
    }

    public EstadoOrdenServicio getEstado_orden_servicio() {
        return estado_orden_servicio;
    }

    public void setEstado_orden_servicio(EstadoOrdenServicio estado_orden_servicio) {
        this.estado_orden_servicio = estado_orden_servicio;
    }

    public Personas getPersonas() {
        return personas;
    }

    public void setPersonas(Personas personas) {
        this.personas = personas;
    }

    public Personas getPersona() {
        return persona;
    }

    public void setPersona(Personas persona) {
        this.persona = persona;
    }

    public List<OrdenTrabajo> getOrdenTrabajo() {
        return ordenTrabajo;
    }

    public void setOrdenTrabajo(List<OrdenTrabajo> ordenTrabajo) {
        this.ordenTrabajo = ordenTrabajo;
    }


    
}
