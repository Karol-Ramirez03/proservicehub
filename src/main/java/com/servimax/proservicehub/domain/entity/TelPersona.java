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
@Table(name = "telefono_persona")
public class TelPersona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    @Column
    @NotNull(message = "no puede ser null")
    private Long numero;

    @ManyToOne
    @NotNull(message = "no puede ser null")
    private TipoTelefono tipoTelefono;

    @ManyToOne
    @NotNull(message = "no puede ser null")
    private Personas personas;

    public TelPersona() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public TipoTelefono getTipoTelefono() {
        return tipoTelefono;
    }

    public void setTipoTelefono(TipoTelefono tipoTelefono) {
        this.tipoTelefono = tipoTelefono;
    }

    public Personas getPersonas() {
        return personas;
    }

    public void setPersonas(Personas personas) {
        this.personas = personas;
    }


    
}
