package com.servimax.proservicehub.infrastructure.repository.tipoEmpresa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servimax.proservicehub.application.service.TipoEmpresaServiceI;
import com.servimax.proservicehub.domain.entity.TipoEmpresa;

@Service
public class TipoEmpresaImplementacion implements TipoEmpresaServiceI{

   @Autowired
    private TipoEmpresaRepositoryI tipoEmpresaRepositoryI;

    @Override
    public List<TipoEmpresa> findAll() {
        return ((List<TipoEmpresa>) tipoEmpresaRepositoryI.findAll());
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<TipoEmpresa> findById(Long id) {
        return tipoEmpresaRepositoryI.findById(id);
    }

    @Override
    public TipoEmpresa save(TipoEmpresa TipoEmpresa) {
        return tipoEmpresaRepositoryI.save(TipoEmpresa);
    }

    @Override
    public Optional<TipoEmpresa> update(Long id, TipoEmpresa TipoEmpresa) {
       Optional<TipoEmpresa> tipoEmpresa = tipoEmpresaRepositoryI.findById(id);
        if (tipoEmpresa.isPresent()) {
            TipoEmpresa  TipoEmpresaAdic = tipoEmpresa.orElseThrow();
            TipoEmpresaAdic.setDescripcion(TipoEmpresa.getDescripcion());
            return Optional.of(tipoEmpresaRepositoryI.save(TipoEmpresaAdic));
        }
        return Optional.empty();
    }

    @Override
    public Optional<TipoEmpresa> delete(Long id) {
        Optional<TipoEmpresa> OTipoEmpresa = tipoEmpresaRepositoryI.findById(id);
        OTipoEmpresa.ifPresent( ser -> {
            tipoEmpresaRepositoryI.delete(ser);
        });
        return OTipoEmpresa;
    }


}
