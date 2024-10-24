package com.servimax.proservicehub.domain.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "persona_insumo")
public class PersonaInsumo {

    @EmbeddedId
    PersonaInsumoPk id;

    @NotNull(message = "No puede estar vacio")
    @ManyToOne
    @JoinColumn(name="servicio_id")
    private Servicio servicio;

    @NotNull(message = "No puede estar vacio")
    @ManyToOne
    @MapsId("idPersona")
    @JoinColumn(name = "id_persona", insertable = false, updatable = false)
    private Personas personas;

    @NotNull(message = "No puede estar vacio")
    @ManyToOne
    @MapsId("idInsumo")
    @JoinColumn(name = "id_Insumo", insertable = false, updatable = false)
    private Insumo insumo;

    public PersonaInsumo() {
    }

    public PersonaInsumo(PersonaInsumoPk id, @NotNull(message = "No puede estar vacio") Servicio servicio,
            @NotNull(message = "No puede estar vacio") Personas personas,
            @NotNull(message = "No puede estar vacio") Insumo insumo) {
        this.id = id;
        this.servicio = servicio;
        this.personas = personas;
        this.insumo = insumo;
    }

    public PersonaInsumoPk getId() {
        return id;
    }

    public void setId(PersonaInsumoPk id) {
        this.id = id;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Personas getPersonas() {
        return personas;
    }

    public void setPersonas(Personas personas) {
        this.personas = personas;
    }

    public Insumo getInsumo() {
        return insumo;
    }

    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }


    
}
