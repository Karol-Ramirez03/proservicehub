package com.servimax.proservicehub.domain.dto;

public class OrdenServicioDTO {

    private Long idCliente;
    private Long idServicio;
    
    public OrdenServicioDTO() {
    }

    public OrdenServicioDTO(Long idCliente, Long idServicio) {
        this.idCliente = idCliente;
        this.idServicio = idServicio;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Long getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Long idServicio) {
        this.idServicio = idServicio;
    }

    
}
