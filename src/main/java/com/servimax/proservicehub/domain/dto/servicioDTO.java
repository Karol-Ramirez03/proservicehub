package com.servimax.proservicehub.domain.dto;

import com.servimax.proservicehub.domain.entity.Servicio;

public class servicioDTO {

    private Servicio servicio;
    private Long cantidad;

    
    public servicioDTO(Servicio servicio, Long cantidad) {
        this.servicio = servicio;
        this.cantidad = cantidad;
    }
    public Servicio getServicio() {
        return servicio;
    }
    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
    public Long getCantidad() {
        return cantidad;
    }
    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    

}
