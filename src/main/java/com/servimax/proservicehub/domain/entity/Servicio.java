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
@Table(name = "servicio")
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column 
    private String nombre;
    private Boolean requiere_insumo;
    private String  tiempo_ejecucion;

    @OneToMany(mappedBy = "servicio")
    private List<EmpresaServicio> empresa_servicio;

    @OneToMany(mappedBy="servicio")
    private List<ServicioInsumo> servicioInsumo;

    @OneToMany(mappedBy="servicio")
    private List<DetalleOrdenServicio> detalle_orden_servicio;

    @OneToMany(mappedBy="servicio")
    private List<DetalleOrdenTrabajo> detalle_orden_trabajo;

    @OneToMany(mappedBy = "servicio")
    private List<AprobacionServicio> aprovacionServicio;

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
