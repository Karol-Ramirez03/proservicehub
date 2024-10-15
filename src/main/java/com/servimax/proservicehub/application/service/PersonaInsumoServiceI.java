package com.servimax.proservicehub.application.service;

import java.util.List;
import java.util.Optional;

import com.servimax.proservicehub.domain.entity.PersonaInsumo;

public interface PersonaInsumoServiceI {
    List<PersonaInsumo> findAll();
    Optional<PersonaInsumo> findById(Long idPersona, Long idInsumo);
    PersonaInsumo save(PersonaInsumo personaInsumo);
    Optional<PersonaInsumo> update(Long idPersona, Long idInsumo, PersonaInsumo personaInsumo);
    Optional<PersonaInsumo> delete(Long idPersona, Long idInsumo);
}
