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
@Table(name = "tipo_telefono")
public class TipoTelefono {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; 

    @Column
    private String nombre;

    @OneToMany(mappedBy = "tipoTelefono")
    private List<TelPersona> telPersona;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<TelPersona> getTelPersona() {
        return telPersona;
    }

    public void setTelPersona(List<TelPersona> telPersona) {
        this.telPersona = telPersona;
    }


    
}
