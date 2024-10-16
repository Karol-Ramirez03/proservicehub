package com.servimax.proservicehub.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="compra")
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "No puede estar vacio")
    @Column
    private Timestamp fecha_compra;
    private Double total;

    @ManyToOne
    private EstadoCompra estado_compra;

    @JsonIgnore
    @OneToMany(mappedBy = "compra")
    private List<DetalleCompra> detalleCompra;

    @ManyToOne
    @JoinColumn(name = "cliente")
    private Personas personas;

    public Compra() {
    }

    

    public Compra(Long id, @NotNull(message = "No puede estar vacio") Timestamp fecha_compra, Double total,
            @NotNull(message = "No puede estar vacio") EstadoCompra estado_compra,
            @NotNull(message = "No puede estar vacio") List<DetalleCompra> detalleCompra, Personas personas) {
        this.id = id;
        this.fecha_compra = fecha_compra;
        this.total = total;
        this.estado_compra = estado_compra;
        this.detalleCompra = detalleCompra;
        this.personas = personas;
    }



    public Compra(Long id, Timestamp fecha_compra, EstadoCompra estado_compra, List<DetalleCompra> detalleCompra,Double total) {
        this.id = id;
        this.fecha_compra = fecha_compra;
        this.estado_compra = estado_compra;
        this.detalleCompra = detalleCompra;
        this.total=total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getFecha_compra() {
        return fecha_compra;
    }

    public void setFecha_compra(Timestamp fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    public EstadoCompra getEstado_compra() {
        return estado_compra;
    }

    public void setEstado_compra(EstadoCompra estado_compra) {
        this.estado_compra = estado_compra;
    }

    public List<DetalleCompra> getDetalleCompra() {
        return detalleCompra;
    }

    public void setDetalleCompra(List<DetalleCompra> detalleCompra) {
        this.detalleCompra = detalleCompra;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Personas getPersonas() {
        return personas;
    }

    public void setPersonas(Personas personas) {
        this.personas = personas;
    }

    
}
