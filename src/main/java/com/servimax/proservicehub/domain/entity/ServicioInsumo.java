package com.servimax.proservicehub.domain.entity;


import org.springframework.beans.factory.annotation.Autowired;

import com.servimax.proservicehub.infrastructure.repository.insumoRepo.InsumoRepository;
import com.servimax.proservicehub.infrastructure.repository.servicio.ServicioRepositoryI;

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
    private int cantidad;

    
    @ManyToOne
    @MapsId("idInsumo")
    @JoinColumn(name="id_insumo", updatable = false)
    private Insumo insumo;
    
    @ManyToOne
    @MapsId("idServicio")
    @JoinColumn(name="id_servicio", updatable = false)
    private Servicio servicio;

    public ServicioInsumo() {
    }

    public ServicioInsumo(ServicioInsumoPk id, @NotNull(message = "No puede estar vacio") int cantidad) {
        this.id = id;
        this.cantidad = cantidad;
    }

    public ServicioInsumo(@NotNull(message = "No puede estar vacio") int cantidad,
            @NotNull(message = "No puede estar vacio") Insumo insumo,
            @NotNull(message = "No puede estar vacio") Servicio servicio) {
        this.cantidad = cantidad;
        this.insumo = insumo;
        this.servicio = servicio;
    }

    public ServicioInsumo(ServicioInsumoPk id, int cantidad, Insumo insumo, Servicio servicio) {
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
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
