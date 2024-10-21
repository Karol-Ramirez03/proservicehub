package com.servimax.proservicehub.domain.entity;

import java.sql.Timestamp;
import java.util.List;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "persona")
public class Personas {

    @Id
    private Long Nro_Doc;

    @Column
    private String nombre;
    private String apellido;

    @Column(nullable = false,updatable = false)
    private Timestamp fechaRegistro;

    @JsonIgnore
    @OneToMany(mappedBy = "personas")
    private List<TelPersona> telPersona;

    @JsonIgnore
    @OneToMany(mappedBy = "personas")
    private List<EmailPersona> emailPersona;

    @JsonIgnore
    @OneToMany(mappedBy = "personas")
    private List<PersonaInsumo> personaInsumo;

    @JsonIgnore
    @OneToMany(mappedBy = "personas")
    private List<OrdenServicio> ordenServicioCliente;

    @JsonIgnore
    @OneToMany(mappedBy = "persona")
    private List<OrdenServicio> ordenServicioEmpleado;

    @JsonIgnore
    @OneToMany(mappedBy = "personas")
    private List<OrdenTrabajo> ordenTrabajoEmpleado;

    @JsonIgnore
    @OneToMany(mappedBy = "personas")
    private List<AprobacionServicio> aprovacionServicio;

    @JsonIgnore
    @OneToMany(mappedBy = "personas")
    private List<Compra> compra;

    @JsonIgnore
    @OneToMany(mappedBy = "personas")
    private List<Login> login;

    @ManyToOne
    private Sucursal sucursal;

    @ManyToOne
    private TipoPersona tipoPersona;

    @PrePersist
    protected void onCreate() {
        this.fechaRegistro = new Timestamp(new Date().getTime());
    }

    public Personas(Long nro_Doc, String nombre, String apellido, Timestamp fechaRegistro, List<TelPersona> telPersona,
            List<EmailPersona> emailPersona, List<PersonaInsumo> personaInsumo,
            List<OrdenServicio> ordenServicioCliente, List<OrdenServicio> ordenServicioEmpleado,
            List<OrdenTrabajo> ordenTrabajoEmpleado, List<AprobacionServicio> aprovacionServicio, List<Compra> compra,
            List<Login> login, Sucursal sucursal, TipoPersona tipoPersona) {
        Nro_Doc = nro_Doc;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaRegistro = fechaRegistro;
        this.telPersona = telPersona;
        this.emailPersona = emailPersona;
        this.personaInsumo = personaInsumo;
        this.ordenServicioCliente = ordenServicioCliente;
        this.ordenServicioEmpleado = ordenServicioEmpleado;
        this.ordenTrabajoEmpleado = ordenTrabajoEmpleado;
        this.aprovacionServicio = aprovacionServicio;
        this.compra = compra;
        this.login = login;
        this.sucursal = sucursal;
        this.tipoPersona = tipoPersona;
    }


    public Personas() {
    }
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
    public List<TelPersona> getTelPersona() {
        return telPersona;
    }
    public void setTelPersona(List<TelPersona> telPersona) {
        this.telPersona = telPersona;
    }
    public List<EmailPersona> getEmailPersona() {
        return emailPersona;
    }
    public void setEmailPersona(List<EmailPersona> emailPersona) {
        this.emailPersona = emailPersona;
    }
    public List<PersonaInsumo> getPersonaInsumo() {
        return personaInsumo;
    }
    public void setPersonaInsumo(List<PersonaInsumo> personaInsumo) {
        this.personaInsumo = personaInsumo;
    }
    public List<OrdenServicio> getOrdenServicioCliente() {
        return ordenServicioCliente;
    }
    public void setOrdenServicioCliente(List<OrdenServicio> ordenServicioCliente) {
        this.ordenServicioCliente = ordenServicioCliente;
    }
    public List<OrdenServicio> getOrdenServicioEmpleado() {
        return ordenServicioEmpleado;
    }
    public void setOrdenServicioEmpleado(List<OrdenServicio> ordenServicioEmpleado) {
        this.ordenServicioEmpleado = ordenServicioEmpleado;
    }
    public List<OrdenTrabajo> getOrdenTrabajoEmpleado() {
        return ordenTrabajoEmpleado;
    }
    public void setOrdenTrabajoEmpleado(List<OrdenTrabajo> ordenTrabajoEmpleado) {
        this.ordenTrabajoEmpleado = ordenTrabajoEmpleado;
    }
    public List<AprobacionServicio> getAprovacionServicio() {
        return aprovacionServicio;
    }
    public void setAprovacionServicio(List<AprobacionServicio> aprovacionServicio) {
        this.aprovacionServicio = aprovacionServicio;
    }
    public Sucursal getSucursal() {
        return sucursal;
    }
    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }
    public TipoPersona getTipoPersona() {
        return tipoPersona;
    }
    public void setTipoPersona(TipoPersona tipoPersona) {
        this.tipoPersona = tipoPersona;
    }
    public List<Compra> getCompra() {
        return compra;
    }
    public void setCompra(List<Compra> compra) {
        this.compra = compra;
    }
    public List<Login> getLogin() {
        return login;
    }
    public void setLogin(List<Login> login) {
        this.login = login;
    }

    
}
