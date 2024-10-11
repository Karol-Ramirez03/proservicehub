package com.servimax.proservicehub.infrastructure.repository.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servimax.proservicehub.application.service.ServicioServiceI;
import com.servimax.proservicehub.domain.entity.Servicio;

@Service
public class ServicioImplementation implements ServicioServiceI{

    @Autowired
    private ServicioRepositoryI servicioRepositoryI;

    @Override
    public List<Servicio> findAll() {
        return ((List<Servicio>) servicioRepositoryI.findAll());
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Servicio> findById(Long id) {
        return servicioRepositoryI.findById(id);
    }

    @Override
    public Servicio save(Servicio servicio) {
        return servicioRepositoryI.save(servicio);
    }

    @Override
    public Optional<Servicio> update(Integer id, Servicio servicio) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Optional<Servicio> delete(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
