package com.servimax.proservicehub.infrastructure.repository.tipoPersonaRepo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servimax.proservicehub.application.service.TipoPersonaServiceI;
import com.servimax.proservicehub.domain.entity.TipoPersona;

import org.springframework.transaction.annotation.Transactional;

@Service
public class TipoPersonaImplementacion implements TipoPersonaServiceI {

    @Autowired
    private TipoPersonaRepositoryI tipoPersonaRepositoryI;

    @Override
    public List<TipoPersona> findAll() {
        return ((List<TipoPersona>) tipoPersonaRepositoryI.findAll());
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<TipoPersona> findById(Long id) {
        return tipoPersonaRepositoryI.findById(id);
    }

    @Override
    public TipoPersona save(TipoPersona tipoPersona) {
        return tipoPersonaRepositoryI.save(tipoPersona);
    }

    @Override
    public Optional<TipoPersona> update(Long id, TipoPersona TipoPersona) {
        Optional<TipoPersona> tipoEmpresaId = tipoPersonaRepositoryI.findById(id);
        if (tipoEmpresaId.isPresent()) {
            TipoPersona  tipoPersonaCopia = tipoEmpresaId.orElseThrow();
            tipoPersonaCopia.setNombre(TipoPersona.getNombre());
            return Optional.of(tipoPersonaRepositoryI.save(tipoPersonaCopia));
        }
        return Optional.empty();
    }

    @Override
    public Optional<TipoPersona> delete(Long id) {
        Optional<TipoPersona> tipoEmpresaId = tipoPersonaRepositoryI.findById(id);
        tipoEmpresaId.ifPresent( te -> {
            tipoPersonaRepositoryI.delete(te);
        });
        return tipoEmpresaId;
    }

}
