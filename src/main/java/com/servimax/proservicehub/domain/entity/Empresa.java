package com.servimax.proservicehub.domain.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "empresa")
public class Empresa {

    @Id
    private Long id;

    @Column
    @NotNull(message = "no puede estar vacio")
    @Size(min = 1,max = 100, message = "no puede estar vacio")
    private String nombre;
    
    @ManyToOne
    @NotNull(message = "no puede estar vacio")
    private TipoEmpresa tipo_empresa;

    @JsonIgnore
    @OneToMany(mappedBy = "empresa")
    private List<Sucursal> sucursal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoEmpresa getTipo_empresa() {
        return tipo_empresa;
    }

    public void setTipo_empresa(TipoEmpresa tipo_empresa) {
        this.tipo_empresa = tipo_empresa;
    }

    
}
