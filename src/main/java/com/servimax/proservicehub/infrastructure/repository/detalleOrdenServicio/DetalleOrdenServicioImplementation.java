package com.servimax.proservicehub.infrastructure.repository.detalleOrdenServicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servimax.proservicehub.application.service.DetalleOrdenServicioServiceI;
import com.servimax.proservicehub.domain.entity.DetalleOrdenServicio;

@Service
public class DetalleOrdenServicioImplementation implements DetalleOrdenServicioServiceI{

    @Autowired
    private DetalleOrdenServicioRepositoryI detalleOrdenServicioRepositoryI;

    @Override
    public List<DetalleOrdenServicio> findAll() {
        return ((List<DetalleOrdenServicio>) detalleOrdenServicioRepositoryI.findAll());
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<DetalleOrdenServicio> findById(Long id) {
        return detalleOrdenServicioRepositoryI.findById(id);
    }

    @Override
    public DetalleOrdenServicio save(DetalleOrdenServicio detalleOrdenServicio) {
        return detalleOrdenServicioRepositoryI.save(detalleOrdenServicio);
    }

    @Override
    public Optional<DetalleOrdenServicio> update(Long id, DetalleOrdenServicio detalleOrdenServicio) {
        Optional<DetalleOrdenServicio> ODetalleOrdenServicio= detalleOrdenServicioRepositoryI.findById(id);
        if(ODetalleOrdenServicio.isPresent()){
            DetalleOrdenServicio detalleOrdenServicio2= ODetalleOrdenServicio.orElseThrow();
            detalleOrdenServicio2.setValor_servicio(detalleOrdenServicio.getValor_servicio());
            detalleOrdenServicio2.setServicio(detalleOrdenServicio.getServicio());
            detalleOrdenServicio2.setOrdenServicio(detalleOrdenServicio.getOrden_servicio());
            return Optional.of(detalleOrdenServicioRepositoryI.save(detalleOrdenServicio2));
        }
        return Optional.empty();
    }

    @Override
    public Optional<DetalleOrdenServicio> delete(Long id) {
        Optional<DetalleOrdenServicio> OOrdenServicio= detalleOrdenServicioRepositoryI.findById(id);
        OOrdenServicio.ifPresent( detOrdeServi->{
            detalleOrdenServicioRepositoryI.delete(detOrdeServi);
        });
        return OOrdenServicio;
    }
    
    @Override
    public List<DetalleOrdenServicio> findByEstadoId(long estadoId) {
        return detalleOrdenServicioRepositoryI.findByEstadoOrdenServicioId(estadoId);
    }

    @Override
    public List<DetalleOrdenServicio> findByIdEmpleado(long estadoId) {
        return detalleOrdenServicioRepositoryI.findByIdEmpleado(estadoId);

    }

}
