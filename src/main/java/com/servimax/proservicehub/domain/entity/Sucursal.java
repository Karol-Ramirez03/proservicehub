package com.servimax.proservicehub.domain.entity;



import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "sucursal")
public class Sucursal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull(message = "No puedes ser vacio este campo")
    @Size(min = 1, max = 100, message = "debe tener entre 1 y 100 caracteres")
    private String nombre;

    @Column
    @NotNull(message = "No puedes ser vacio este campo")
    @Size(min = 1, max = 100, message = "debe tener entre 1 y 100 caracteres")
    private String nit;

    @Column
    private Timestamp fecha_creacion;

    @ManyToOne
    @NotNull(message = "No puedes ser vacio este campo")
    private Direccion direccion;

    @ManyToOne
    @NotNull(message = "No puedes ser vacio este campo")
    private Empresa empresa;

    @JsonIgnore
    @OneToMany(mappedBy = "sucursal")
    private List<EmpresaServicio> empresa_servicio;

    @JsonIgnore
    @OneToMany(mappedBy = "sucursal")
    private List<Personas> personas;

    @JsonIgnore
    @OneToMany(mappedBy = "sucursal")
    private List<TelSucursal> sucursales;

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

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public Timestamp getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Timestamp fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }


    
}
