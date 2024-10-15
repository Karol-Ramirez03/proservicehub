package com.servimax.proservicehub.domain.entity;

import java.io.Serializable;
import java.util.Objects;

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

    @Override
    public boolean equals(Object obj) {
        if (this==obj) return true;
        if (obj==null || getClass() != obj.getClass()) return false;
        ServicioInsumoPk that = (ServicioInsumoPk) obj;
        return Objects.equals(idInsumo,that.idServicio) && Objects.equals(idServicio,that.idInsumo); 
    }

    @Override
    public int hashCode() {
        return Objects.hash(idInsumo,idServicio);
    }

    

    
    
}


