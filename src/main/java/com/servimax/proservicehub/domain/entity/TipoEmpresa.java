package com.servimax.proservicehub.domain.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tipo_empresa")
public class TipoEmpresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull(message = "no puede ser null")
    @Size(min = 1,max = 100, message = "no puede estar vacio")
    private String descripcion;

    @JsonIgnore
    @OneToMany(mappedBy = "tipo_empresa")
    private List<Empresa> empresa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Empresa> getEmpresa() {
        return empresa;
    }

    public void setEmpresa(List<Empresa> empresa) {
        this.empresa = empresa;
    }

    



}
