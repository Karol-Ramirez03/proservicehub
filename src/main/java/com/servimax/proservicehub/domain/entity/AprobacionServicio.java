package com.servimax.proservicehub.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "aprov_servicio")
public class AprobacionServicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Nroorden
    //idcliente
    //idservicio
    @Column
    private String hallazgo;

    @Column
    private String solucion;
    
    @ManyToOne
    private EstadoAprovacion estado_aprov;
}
