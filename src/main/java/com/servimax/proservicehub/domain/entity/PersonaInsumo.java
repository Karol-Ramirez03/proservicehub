package com.servimax.proservicehub.domain.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "persona_insumo")
public class PersonaInsumo {

    @EmbeddedId
    PersonaInsumoPk id;

    @ManyToOne
    private Servicio servicio;

    @ManyToOne
    @MapsId("idPersona")
    @JoinColumn(name = "id_persona", insertable = false, updatable = false)
    private Personas personas;

    @ManyToOne
    @MapsId("idInsumo")
    @JoinColumn(name = "id_Insumo", insertable = false, updatable = false)
    private Insumo insumo;

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
