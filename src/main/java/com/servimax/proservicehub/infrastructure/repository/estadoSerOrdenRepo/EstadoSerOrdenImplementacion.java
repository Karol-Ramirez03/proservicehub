package com.servimax.proservicehub.infrastructure.repository.estadoSerOrdenRepo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servimax.proservicehub.application.service.EstadoSerOrdenServiceI;
import com.servimax.proservicehub.domain.entity.EstadoOrdenServicio;

@Service
public class EstadoSerOrdenImplementacion implements EstadoSerOrdenServiceI{

    @Autowired
    private EstadoSerOrdenRepository estadoOrdenServicioRepository;

    @Override
    public List<EstadoOrdenServicio> findAll() {
        return ((List<EstadoOrdenServicio>) estadoOrdenServicioRepository.findAll());
    }

    @Override
    public Optional<EstadoOrdenServicio> findById(Long id) {
        return estadoOrdenServicioRepository.findById(id);
    }

    @Override
    public EstadoOrdenServicio save(EstadoOrdenServicio estadoOrdenServicio) {
        return estadoOrdenServicioRepository.save(estadoOrdenServicio);
    }

    @Override
    public Optional<EstadoOrdenServicio> update(Long id, EstadoOrdenServicio estadoOrdenServicio) {
        return estadoOrdenServicioRepository.findById(id)
            .map(existingEstadoOrden -> {
                existingEstadoOrden.setNombre(estadoOrdenServicio.getNombre());
                return estadoOrdenServicioRepository.save(existingEstadoOrden);
            });
    }

    @Override
    public Optional<EstadoOrdenServicio> delete(Long id) {
        return estadoOrdenServicioRepository.findById(id)
            .map(estadoOrden -> {
                estadoOrdenServicioRepository.delete(estadoOrden);
                return estadoOrden;
            });
    }

}
