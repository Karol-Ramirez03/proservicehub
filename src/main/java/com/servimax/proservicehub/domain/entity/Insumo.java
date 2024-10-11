package com.servimax.proservicehub.domain.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "insumo")
public class Insumo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length=20,nullable=false)
    private String codigo_interno;

    @Column(length=40,nullable=false)
    private String nombre;
    private Double precio_unitario;
    private int stock;
    private int stock_minimo;
    private int stock_maximo;

    @OneToMany(mappedBy="insumo")
    private List<ServicioInsumo> servicioInsumo;

    @OneToMany(mappedBy = "insumo")
    private List<PersonaInsumo> personaInsumos;

    public Insumo() {
    }

    public Insumo( String codigo_interno, String nombre) {
        
        this.codigo_interno = codigo_interno;
        this.nombre = nombre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCodigo_interno() {
        return codigo_interno;
    }

    public void setCodigo_interno(String codigo_interno) {
        this.codigo_interno = codigo_interno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(Double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getStock_minimo() {
        return stock_minimo;
    }

    public void setStock_minimo(int stock_minimo) {
        this.stock_minimo = stock_minimo;
    }

    public int getStock_maximo() {
        return stock_maximo;
    }

    public void setStock_maximo(int stock_maximo) {
        this.stock_maximo = stock_maximo;
    }

    public List<ServicioInsumo> getServicioInsumo() {
        return servicioInsumo;
    }

    public void setServicioInsumo(List<ServicioInsumo> servicioInsumo) {
        this.servicioInsumo = servicioInsumo;
    }

    

}