package com.servimax.proservicehub.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "aprovacion_servicio")
public class AprobacionServicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="id_orden_trabajo")
    private OrdenTrabajo orden_trabajo;

    @ManyToOne
    @JoinColumn(name="id_cliente")
    private Personas personas;

    @ManyToOne
    @JoinColumn(name="id_servicio")
    private Servicio servicio;

    @Column
    private String hallazgo;

    @Column
    private String solucion;
    
    @ManyToOne
    private EstadoAprovacion estado_aprovacion;
}
