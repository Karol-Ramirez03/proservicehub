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
@Table(name = "ciudad")
public class Ciudad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "No puedes ser vacio este campo")
    @Size(min = 1, max = 100, message = "debe tener entre 1 y 100 caracteres")
    @Column
    private String nombre;

    @ManyToOne
    @NotNull(message = "No puedes ser vacio este campo")
    private Region region;

    @JsonIgnore
    @OneToMany(mappedBy = "ciudad")
    private List<Direccion> direccion;

    public Ciudad() {
    }

    public Ciudad(String nombre, Region region) {
        this.nombre = nombre;
        this.region = region;
    }

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

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    
    
}
