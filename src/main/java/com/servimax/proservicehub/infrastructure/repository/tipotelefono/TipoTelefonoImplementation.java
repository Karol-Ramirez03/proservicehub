package com.servimax.proservicehub.infrastructure.repository.tipotelefono;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servimax.proservicehub.application.service.TipoTelefonoServiceI;
import com.servimax.proservicehub.domain.entity.TipoTelefono;

@Service
public class TipoTelefonoImplementation implements TipoTelefonoServiceI{

    @Autowired
    private TipotelefonoRepositoryI tipoTelefonoRepositoryI;

    @Override
    public List<TipoTelefono> findAll() {
        return ((List<TipoTelefono>) tipoTelefonoRepositoryI.findAll());
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<TipoTelefono> findById(Long id) {
        return tipoTelefonoRepositoryI.findById(id);
    }

    @Override
    public TipoTelefono save(TipoTelefono tipoTelefono) {
        return tipoTelefonoRepositoryI.save(tipoTelefono);
    }

    @Override
    public Optional<TipoTelefono> update(Long id, TipoTelefono tipoTelefono) {
        Optional<TipoTelefono> OTipoTelefono = tipoTelefonoRepositoryI.findById(id);
        if (OTipoTelefono.isPresent()) {
            TipoTelefono  TipoTelefonoAdic = OTipoTelefono.orElseThrow();
            TipoTelefonoAdic.setNombre(tipoTelefono.getNombre());
            return Optional.of(tipoTelefonoRepositoryI.save(TipoTelefonoAdic));
        }
        return Optional.empty();
    }

    @Override
    public Optional<TipoTelefono> delete(Long id) {
        Optional<TipoTelefono> OTipoTelefono = tipoTelefonoRepositoryI.findById(id);
        OTipoTelefono.ifPresent( tipTel -> {
            tipoTelefonoRepositoryI.delete(tipTel);
        });
        return OTipoTelefono;
    }

}
