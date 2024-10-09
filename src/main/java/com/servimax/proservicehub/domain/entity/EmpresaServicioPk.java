package com.servimax.proservicehub.domain.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class EmpresaServicioPk implements Serializable{

    @Column(name = "id_empresa")
    private Long idEmpresa;
    @Column(name = "id_servicio")
    private Long idServicio;

    
    public EmpresaServicioPk() {
    }


    public EmpresaServicioPk(Long idEmpresa, Long idServicio) {
        this.idEmpresa = idEmpresa;
        this.idServicio = idServicio;
    }


    public Long getIdEmpresa() {
        return idEmpresa;
    }


    public void setIdEmpresa(Long idEmpresa) {
        this.idEmpresa = idEmpresa;
    }


    public Long getIdServicio() {
        return idServicio;
    }


    public void setIdServicio(Long idServicio) {
        this.idServicio = idServicio;
    }

    

}
