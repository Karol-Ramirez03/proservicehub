package com.servimax.proservicehub.domain.entity;

import java.io.Serializable;
import jakarta.persistence.Embeddable;

@Embeddable
public class EmpresaServicioPk implements Serializable{

    private Long idSucursal;
    private Long idServicio;

    
    public EmpresaServicioPk() {
    }


    public EmpresaServicioPk(Long idSucursal, Long idServicio) {
        this.idSucursal = idSucursal;
        this.idServicio = idServicio;
    }


    public Long getIdServicio() {
        return idServicio;
    }


    public void setIdServicio(Long idServicio) {
        this.idServicio = idServicio;
    }


    public Long getIdSucursal() {
        return idSucursal;
    }


    public void setIdSucursal(Long idSucursal) {
        this.idSucursal = idSucursal;
    }

    

}
