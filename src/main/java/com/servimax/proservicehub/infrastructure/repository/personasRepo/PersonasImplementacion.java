package com.servimax.proservicehub.infrastructure.repository.personasRepo;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servimax.proservicehub.application.service.PersonasServiceI;
import com.servimax.proservicehub.domain.entity.Personas;

@Service
public class PersonasImplementacion implements PersonasServiceI{

    @Autowired
    private PersonasRepository personaRepository;

    @Override
    public List<Personas> findAll() {
        return ((List<Personas>) personaRepository.findAll());
    }

    @Override
    public Optional<Personas> findById(Long nroDoc) {
        return personaRepository.findById(nroDoc);
    }

    @Override
    public Personas save(Personas persona) {
        return personaRepository.save(persona);
    }

    @Override
    public Optional<Personas> update(Long nroDoc, Personas persona) {
        return personaRepository.findById(nroDoc).map(existingPersona -> {
            existingPersona.setNombre(persona.getNombre());
            existingPersona.setApellido(persona.getApellido());
            existingPersona.setFechaRegistro(persona.getFechaRegistro());
            return personaRepository.save(existingPersona);
        });
    }

    @Override
    public Optional<Personas> delete(Long nroDoc) {
        return personaRepository.findById(nroDoc).map(persona -> {
            personaRepository.delete(persona);
            return persona;
        });
    }

   
}
