package com.servimax.proservicehub.infrastructure.repository.estadoAprobacion;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servimax.proservicehub.application.service.EstadoAprobacionServiceI;
import com.servimax.proservicehub.domain.entity.EstadoAprobacion;

@Service
public class EstadoAporbacionImplementation implements EstadoAprobacionServiceI{

    @Autowired
    private EstadoAprobacionRepositoryI estadoAprobacionRepositoryI;

    @Override
    public List<EstadoAprobacion> findAll() {
        return ((List<EstadoAprobacion>) estadoAprobacionRepositoryI.findAll());
    }

    @Override
    public Optional<EstadoAprobacion> findById(Long id) {
        return estadoAprobacionRepositoryI.findById(id);
    }

    @Override
    public EstadoAprobacion save(EstadoAprobacion estadoAprobacion) {
        return estadoAprobacionRepositoryI.save(estadoAprobacion);
    }

    @Override
    public Optional<EstadoAprobacion> update(Long id, EstadoAprobacion estadoAprobacion) {
        Optional<EstadoAprobacion> OEstado = estadoAprobacionRepositoryI.findById(id);
        if (OEstado.isPresent()) {
            EstadoAprobacion estado2 = OEstado.orElseThrow();
            estado2.setNombre(estadoAprobacion.getNombre());
            return Optional.of(estadoAprobacionRepositoryI.save(estado2));
        }
        return Optional.empty();
    }

    @Override
    public Optional<EstadoAprobacion> delete(Long id) {
        Optional<EstadoAprobacion> OEstado = estadoAprobacionRepositoryI.findById(id);
        OEstado.ifPresent( estados -> {
            estadoAprobacionRepositoryI.delete(estados);
        });
        return OEstado;
    }

}
