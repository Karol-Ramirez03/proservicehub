package com.servimax.proservicehub.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "estado_compra")
public class EstadoCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "No puede estar vacio")
    @Column
    private String nombre;

    @JsonIgnore
    @OneToMany(mappedBy = "estado_compra")
    private List<Compra> compra;

    public EstadoCompra() {
    }

    public EstadoCompra(@NotNull(message = "No puede estar vacio") String nombre) {
        this.nombre = nombre;
    }

    public EstadoCompra(Long id, String nombre, List<Compra> compra) {
        this.id = id;
        this.nombre = nombre;
        this.compra = compra;
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

    public List<Compra> getCompra() {
        return compra;
    }

    public void setCompra(List<Compra> compra) {
        this.compra = compra;
    }

    

}
