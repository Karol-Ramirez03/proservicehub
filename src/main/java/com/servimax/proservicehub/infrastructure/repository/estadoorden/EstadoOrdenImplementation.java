package com.servimax.proservicehub.infrastructure.repository.estadoorden;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servimax.proservicehub.application.service.EstadoOrdenServiceI;
import com.servimax.proservicehub.domain.entity.EstadoOrden;

@Service
public class EstadoOrdenImplementation implements EstadoOrdenServiceI{

    @Autowired
    private EstadoOrdenRepositoryI estadoOrdenRepositoryI;

    @Override
    public List<EstadoOrden> findAll() {
        return((List<EstadoOrden>) estadoOrdenRepositoryI.findAll());
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<EstadoOrden> findById(Long id) {
        return estadoOrdenRepositoryI.findById(id);
    }

    @Override
    public EstadoOrden save(EstadoOrden estadoOrden) {
        return estadoOrdenRepositoryI.save(estadoOrden);
    }

    @Override
    public Optional<EstadoOrden> update(Long id, EstadoOrden estadoOrden) {
        Optional<EstadoOrden> OEstadoOrden= estadoOrdenRepositoryI.findById(id);
        if(OEstadoOrden.isPresent()){
            EstadoOrden estadoOrden2=OEstadoOrden.orElseThrow();
            estadoOrden2.setNombre(estadoOrden.getNombre());
            return Optional.of(estadoOrdenRepositoryI.save(estadoOrden2));
        }
        return Optional.empty();
    }

    @Override
    public Optional<EstadoOrden> delete(Long id) {
        Optional<EstadoOrden> OEstadoOrden= estadoOrdenRepositoryI.findById(id);
        OEstadoOrden.ifPresent( estaOrde->{
            estadoOrdenRepositoryI.delete(estaOrde);
        });
        return OEstadoOrden;
    }

}
