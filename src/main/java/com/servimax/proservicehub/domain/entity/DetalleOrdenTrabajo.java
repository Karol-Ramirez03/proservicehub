package com.servimax.proservicehub.domain.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "detalle_o_t")
public class DetalleOrdenTrabajo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Date fecha;

    @ManyToOne
    private OrdenTrabajo orden_trabajo;

    @ManyToOne
    private EstadoOrden estado_orden;
   


    //idservicioasig






}
