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
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "servicio")
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull(message = "No puedes ser vacio")
    @Column(length = 50,nullable = false)
    private String nombre;

    @NotNull(message = "No puedes ser vacio")
    private Boolean requiere_insumo;

    @NotNull(message = "No puedes ser vacio")
    private String  tiempo_ejecucion;

    @JsonIgnore
    @OneToMany(mappedBy = "servicio")
    private List<EmpresaServicio> empresa_servicio;

    @JsonIgnore
    @OneToMany(mappedBy="servicio")
    private List<ServicioInsumo> servicioInsumo;

    @JsonIgnore
    @OneToMany(mappedBy="servicio")
    private List<DetalleOrdenServicio> detalle_orden_servicio;

    @JsonIgnore
    @OneToMany(mappedBy="servicio")
    private List<DetalleOrdenTrabajo> detalle_orden_trabajo;

    @JsonIgnore
    @OneToMany(mappedBy = "servicio")
    private List<AprobacionServicio> aprovacionServicio;

    public Servicio() {
    }
    
    public Servicio(Long id) {
        this.id = id;
    }

    public Servicio(@NotNull(message = "No puedes ser vacio nombre") String nombre,
            @NotNull(message = "No puedes ser vacio requiere insumo") Boolean requiere_insumo,
            @NotNull(message = "No puedes ser vacio tiempo ejecucion") String tiempo_ejecucion) {
        this.nombre = nombre;
        this.requiere_insumo = requiere_insumo;
        this.tiempo_ejecucion = tiempo_ejecucion;
    }

    public Servicio(Long id, @NotNull(message = "No puedes ser vacio nombre") String nombre,
            @NotNull(message = "No puedes ser vacio requiere insumo") Boolean requiere_insumo,
            @NotNull(message = "No puedes ser vacio tiempo ejecucion") String tiempo_ejecucion,
            List<EmpresaServicio> empresa_servicio, List<ServicioInsumo> servicioInsumo,
            List<DetalleOrdenServicio> detalle_orden_servicio, List<DetalleOrdenTrabajo> detalle_orden_trabajo,
            List<AprobacionServicio> aprovacionServicio) {
        this.id = id;
        this.nombre = nombre;
        this.requiere_insumo = requiere_insumo;
        this.tiempo_ejecucion = tiempo_ejecucion;
        this.empresa_servicio = empresa_servicio;
        this.servicioInsumo = servicioInsumo;
        this.detalle_orden_servicio = detalle_orden_servicio;
        this.detalle_orden_trabajo = detalle_orden_trabajo;
        this.aprovacionServicio = aprovacionServicio;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Boolean getRequiere_insumo() {
        return requiere_insumo;
    }
    public void setRequiere_insumo(Boolean requiere_insumo) {
        this.requiere_insumo = requiere_insumo;
    }
    public String getTiempo_ejecucion() {
        return tiempo_ejecucion;
    }
    public void setTiempo_ejecucion(String tiempo_ejecucion) {
        this.tiempo_ejecucion = tiempo_ejecucion;
    }
    public List<EmpresaServicio> getEmpresa_servicio() {
        return empresa_servicio;
    }
    public void setEmpresa_servicio(List<EmpresaServicio> empresa_servicio) {
        this.empresa_servicio = empresa_servicio;
    }
    public List<ServicioInsumo> getServicioInsumo() {
        return servicioInsumo;
    }
    public void setServicioInsumo(List<ServicioInsumo> servicioInsumo) {
        this.servicioInsumo = servicioInsumo;
    }
    public List<DetalleOrdenServicio> getDetalle_orden_servicio() {
        return detalle_orden_servicio;
    }
    public void setDetalle_orden_servicio(List<DetalleOrdenServicio> detalle_orden_servicio) {
        this.detalle_orden_servicio = detalle_orden_servicio;
    }
    public List<DetalleOrdenTrabajo> getDetalle_orden_trabajo() {
        return detalle_orden_trabajo;
    }
    public void setDetalle_orden_trabajo(List<DetalleOrdenTrabajo> detalle_orden_trabajo) {
        this.detalle_orden_trabajo = detalle_orden_trabajo;
    }
    public List<AprobacionServicio> getAprovacionServicio() {
        return aprovacionServicio;
    }
    public void setAprovacionServicio(List<AprobacionServicio> aprovacionServicio) {
        this.aprovacionServicio = aprovacionServicio;
    } 

    

}
