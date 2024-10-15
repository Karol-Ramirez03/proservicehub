package com.servimax.proservicehub.infrastructure.repository.telPersonaRepo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servimax.proservicehub.application.service.TelPersonaServiceI;
import com.servimax.proservicehub.domain.entity.TelPersona;

@Service
public class TelPersonaImplementacion implements  TelPersonaServiceI{
    @Autowired
    private TelPersonaRepositoryI telPersonaRepositoryI;

    @Override
    public List<TelPersona> findAll() {
        return ((List<TelPersona>) telPersonaRepositoryI.findAll());
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<TelPersona> findById(Long id) {
        return telPersonaRepositoryI.findById(id);
    }

    @Override
    public TelPersona save(TelPersona TelPersona) {
        return telPersonaRepositoryI.save(TelPersona);
    }

    @Override
    public Optional<TelPersona> update(Long id, TelPersona TelPersona) {
        Optional<TelPersona> OTelPersona = telPersonaRepositoryI.findById(id);
        if (OTelPersona.isPresent()) {
            TelPersona  TelPersonaAdic = OTelPersona.orElseThrow();
            TelPersonaAdic.setNumero(TelPersona.getNumero());
            TelPersonaAdic.setTipoTelefono(TelPersona.getTipoTelefono());
            TelPersonaAdic.setPersonas(TelPersona.getPersonas());
            return Optional.of(telPersonaRepositoryI.save(TelPersonaAdic));
        }
        return Optional.empty();
    }

    @Override
    public Optional<TelPersona> delete(Long id) {
        Optional<TelPersona> OTelPersona = telPersonaRepositoryI.findById(id);
        OTelPersona.ifPresent( ser -> {
            telPersonaRepositoryI.delete(ser);
        });
        return OTelPersona;
    }

}
