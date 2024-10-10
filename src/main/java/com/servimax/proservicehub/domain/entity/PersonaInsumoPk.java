package com.servimax.proservicehub.domain.entity;

import java.io.Serializable;
import jakarta.persistence.Embeddable;

@Embeddable
public class PersonaInsumoPk implements Serializable{

    private Long idPersona;
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
