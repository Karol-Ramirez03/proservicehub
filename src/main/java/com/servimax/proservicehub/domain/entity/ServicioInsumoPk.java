package com.servimax.proservicehub.domain.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
@Embeddable
public class ServicioInsumoPk implements Serializable{

    private Long idInsumo;
    private Long idServicio;

    public ServicioInsumoPk() {
    }

    public ServicioInsumoPk(Long idInsumo, Long idServicio) {
        this.idInsumo = idInsumo;
        this.idServicio = idServicio;
    }

    public Long getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(Long idInsumo) {
        this.idInsumo = idInsumo;
    }

    public Long getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Long idServicio) {
        this.idServicio = idServicio;
    }
    
}


