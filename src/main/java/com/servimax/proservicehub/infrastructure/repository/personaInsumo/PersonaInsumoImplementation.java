package com.servimax.proservicehub.infrastructure.repository.personaInsumo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servimax.proservicehub.application.service.PersonaInsumoServiceI;
import com.servimax.proservicehub.domain.entity.PersonaInsumo;
import com.servimax.proservicehub.domain.entity.PersonaInsumoPk;

@Service
public class PersonaInsumoImplementation implements PersonaInsumoServiceI{

    @Autowired
    private PersonaInsumoRepositoryI personaInsumoRepositoryI;

    @Override
    public List<PersonaInsumo> findAll() {
        return ((List<PersonaInsumo>) personaInsumoRepositoryI.findAll());
    }

    @Override
    public Optional<PersonaInsumo> findById(Long idPersona, Long idInsumo) {
        PersonaInsumoPk key=new PersonaInsumoPk(idPersona,idInsumo);
        return personaInsumoRepositoryI.findById(key);
    }

    @Override
    public PersonaInsumo save(PersonaInsumo personaInsumo) {
        return personaInsumoRepositoryI.save(personaInsumo);
    }

    @Override
    public Optional<PersonaInsumo> update(Long idPersona, Long idInsumo, PersonaInsumo personaInsumo) {
        PersonaInsumoPk key=new PersonaInsumoPk(idPersona,idInsumo);
        Optional<PersonaInsumo> OPersonaInsumo= personaInsumoRepositoryI.findById(key);
        if(OPersonaInsumo.isPresent()){
            PersonaInsumo personaInsumo2= OPersonaInsumo.orElseThrow();
            personaInsumo2.setServicio(personaInsumo.getServicio());
            return Optional.of(personaInsumoRepositoryI.save(personaInsumo2));
        }
        return Optional.empty();
    }

    @Override
    public Optional<PersonaInsumo> delete(Long idPersona, Long idInsumo) {
        PersonaInsumoPk key=new PersonaInsumoPk(idPersona,idInsumo);
        personaInsumoRepositoryI.deleteById(key);
        return null;
    }

    public List<PersonaInsumo> getInsumosByPersonaId(Long idPersona) {
        return personaInsumoRepositoryI.findByIdIdPersona(idPersona);
    }

}
