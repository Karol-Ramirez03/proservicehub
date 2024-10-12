package com.servimax.proservicehub.domain.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "telefono_persona")
public class TelPersona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; 

    @Column
    @NotNull(message = "no puede ser null")
    @Size(min = 1,max = 100, message = "no puede estar vacio")
    private Long numero;

    @ManyToOne
    @NotNull(message = "no puede ser null")
    private TipoTelefono tipoTelefono;

    @ManyToOne
    private Personas personas;

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
