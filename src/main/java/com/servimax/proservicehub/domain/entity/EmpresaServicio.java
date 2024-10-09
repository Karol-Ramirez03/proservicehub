package com.servimax.proservicehub.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "empresa_servicio")
public class EmpresaServicio {

    @EmbeddedId
    EmpresaServicioPk id;

    @Column
    private Double valorServicio;

    @ManyToOne
    // @MapsId("idEmpresa")
    @JoinColumn(name = "id_empresa", insertable = false, updatable = false)
    private Empresa empresa;

    @ManyToOne
    // @MapsId("idServicio")
    @JoinColumn(name = "id_servicio", insertable = false, updatable = false)
    private Servicio servicio;


    public Double getValorServicio() {
        return valorServicio;
    }

    public void setValorServicio(Double valorServicio) {
        this.valorServicio = valorServicio;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public EmpresaServicioPk getId() {
        return id;
    }

    public void setId(EmpresaServicioPk id) {
        this.id = id;
    }
 

}
