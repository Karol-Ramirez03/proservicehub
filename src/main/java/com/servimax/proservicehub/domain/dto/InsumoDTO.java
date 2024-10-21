package com.servimax.proservicehub.domain.dto;

import com.servimax.proservicehub.domain.entity.Insumo;

public class InsumoDTO {

    private Long cantidad;
    private Insumo insumo;
    
    public InsumoDTO(Long cantidad, Insumo insumo) {
        this.cantidad = cantidad;
        this.insumo = insumo;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public Insumo getInsumo() {
        return insumo;
    }

    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }

    

}
