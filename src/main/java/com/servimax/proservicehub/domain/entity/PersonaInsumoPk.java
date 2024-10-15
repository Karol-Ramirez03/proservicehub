package com.servimax.proservicehub.domain.entity;

import java.io.Serializable;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;

@Embeddable
public class PersonaInsumoPk implements Serializable{

    @NotNull(message = "No puede estar vacio")
    private Long idPersona;

    @NotNull(message = "No puede estar vacio")
    private Long idInsumo;

    public PersonaInsumoPk() {
    }

    public PersonaInsumoPk(Long idPersona, Long idInsumo) {
        this.idPersona = idPersona;
        this.idInsumo = idInsumo;
    }

    public Long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    public Long getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(Long idInsumo) {
        this.idInsumo = idInsumo;
    }

    

    

}
