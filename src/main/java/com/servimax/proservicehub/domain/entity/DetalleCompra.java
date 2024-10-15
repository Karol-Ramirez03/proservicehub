package com.servimax.proservicehub.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="detalle_compra")
public class DetalleCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull(message = "No puede estar vacio")
    @Column
    private int cantidad;
    private Double precio_unitario;

    @ManyToOne
    private Insumo insumo;

    @ManyToOne
    private Compra compra;

    public DetalleCompra() {
    }

    public DetalleCompra(Long id, int cantidad, Double precio_unitario, Insumo insumo) {
        this.id = id;
        this.cantidad = cantidad;
        this.precio_unitario = precio_unitario;
        this.insumo = insumo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(Double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public Insumo getInsumo() {
        return insumo;
    }

    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    

}
