package com.servimax.proservicehub.domain.entity;

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
@Table(name = "direccion")
public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; 

    @Column
    @NotNull(message = "No puedes ser vacio este campo")
    @Size(min = 1, max = 100, message = "debe tener entre 1 y 100 caracteres")
    private String calle;
    
    @Column
    @NotNull(message = "no puede estar vacio")
    private String carrera;

    @Column
    @NotNull(message = "no puede estar vacio")
    private String descripcion;

    @Column
    @NotNull(message = "no puede estar vacio")
    private String barrio;

    @ManyToOne
    @NotNull(message = "no puede estar vacio")
    private Ciudad ciudad;

    @JsonIgnore
    @OneToMany(mappedBy = "direccion")
    private List<Sucursal> sucursal; 

    

    public Direccion() {
    }
    
    public Direccion(long id,
            @NotNull(message = "No puedes ser vacio este campo") @Size(min = 1, max = 100, message = "debe tener entre 1 y 100 caracteres") String calle,
            @NotNull(message = "no puede estar vacio") String carrera,
            @NotNull(message = "no puede estar vacio") String descripcion,
            @NotNull(message = "no puede estar vacio") String barrio,
            @NotNull(message = "no puede estar vacio") Ciudad ciudad, List<Sucursal> sucursal) {
        this.id = id;
        this.calle = calle;
        this.carrera = carrera;
        this.descripcion = descripcion;
        this.barrio = barrio;
        this.ciudad = ciudad;
        this.sucursal = sucursal;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getCalle() {
        return calle;
    }
    public void setCalle(String calle) {
        this.calle = calle;
    }
    public String getCarrera() {
        return carrera;
    }
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getBarrio() {
        return barrio;
    }
    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }
    public Ciudad getCiudad() {
        return ciudad;
    }
    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }
    public List<Sucursal> getSucursal() {
        return sucursal;
    }
    public void setSucursal(List<Sucursal> sucursal) {
        this.sucursal = sucursal;
    }
    





    
}
