package com.servimax.proservicehub.domain.entity;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "orden_trabajo")
public class OrdenTrabajo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nroordent;

    @Column
    private Date fechaa;
    
    @Column
    private Time horaa;

    @OneToMany(mappedBy = "orden_trabajo")
    private List<DetalleOrdenTrabajo> detalleOrdenTrabajo;

    
    //falta id empleado-nroorden

    
    


}
