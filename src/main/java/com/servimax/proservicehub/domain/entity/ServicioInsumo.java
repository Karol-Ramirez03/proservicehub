package com.servimax.proservicehub.domain.entity;


import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="servicio_insumo")
public class ServicioInsumo {

    @EmbeddedId
    private ServicioInsumoPk id;

    @NotNull(message = "No puede estar vacio")
    @Column
    private Double cantidad;

    @NotNull(message = "No puede estar vacio")
    @ManyToOne
    @MapsId("idInsumo")
    @JoinColumn(name="id_insumo", insertable = false, updatable = false)
    private Insumo insumo;
  
    @NotNull(message = "No puede estar vacio")
    @ManyToOne
    @MapsId("idServicio")
    @JoinColumn(name="id_servicio", insertable = false, updatable = false)
    private Servicio servicio;

    public ServicioInsumo() {
    }

    public ServicioInsumo(ServicioInsumoPk id, Double cantidad, Insumo insumo, Servicio servicio) {
        this.id = id;
        this.cantidad = cantidad;
        this.insumo = insumo;
        this.servicio = servicio;
    }

    public ServicioInsumoPk getId() {
        return id;
    }

    public void setId(ServicioInsumoPk id) {
        this.id = id;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Insumo getInsumo() {
        return insumo;
    }

    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    
    
}
