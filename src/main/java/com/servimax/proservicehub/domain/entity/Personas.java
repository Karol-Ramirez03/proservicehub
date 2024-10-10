package com.servimax.proservicehub.domain.entity;

import java.security.Timestamp;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "persona")
public class Personas {

    @Id
    private Long Nro_Doc;

    @Column
    private String nombre;
    private String apellido;
    private Timestamp fechaRegistro;

    @OneToMany(mappedBy = "personas")
    private List<TelPersona> telPersona;

    @OneToMany(mappedBy = "personas")
    private List<EmailPersona> emailPersona;

    @OneToMany(mappedBy = "personas")
    private List<PersonaInsumo> personaInsumo;

    @ManyToOne
    private Sucursal sucursal;

    @ManyToOne
    private TipoPersona tipoPersona;

    public Long getNro_Doc() {
        return Nro_Doc;
    }
    public void setNro_Doc(Long nro_Doc) {
        Nro_Doc = nro_Doc;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public Timestamp getFechaRegistro() {
        return fechaRegistro;
    }
    public void setFechaRegistro(Timestamp fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }





    




}
