package com.servimax.proservicehub.infrastructure.repository.ordenServicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servimax.proservicehub.application.service.OrdenServicioServiceI;
import com.servimax.proservicehub.domain.entity.OrdenServicio;
import com.servimax.proservicehub.domain.entity.Personas;

@Service
@Transactional
public class OrdenServicioImplementation implements OrdenServicioServiceI{

    @Autowired
    private OrdenServicioRepositoryI ordenServicioRepositoryI;

    @Override
    public List<OrdenServicio> findAll() {
        return ((List<OrdenServicio>) ordenServicioRepositoryI.findAll());
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<OrdenServicio> findById(Long id) {
        return ordenServicioRepositoryI.findById(id);
    }

    @Override
    public OrdenServicio save(OrdenServicio ordenServicio) {
        return ordenServicioRepositoryI.save(ordenServicio);
    }

    @Override
    public Optional<OrdenServicio> update(Long id, OrdenServicio ordenServicio) {
        Optional<OrdenServicio> OOrdenServicio= ordenServicioRepositoryI.findById(id);
        if(OOrdenServicio.isPresent()){
            OrdenServicio ordenServicio2= OOrdenServicio.orElseThrow();
            ordenServicio2.setFecha_orden(ordenServicio.getFecha_orden());
            ordenServicio2.setPersona(ordenServicio.getPersona());
            ordenServicio2.setPersonas(ordenServicio.getPersonas());
            ordenServicio2.setEstado_orden_servicio(ordenServicio.getEstado_orden_servicio());
            return Optional.of(ordenServicioRepositoryI.save(ordenServicio2));
        }
        return Optional.empty();
    }

    @Override
    public Optional<OrdenServicio> delete(Long id) {
        Optional<OrdenServicio> OOrdenServicio= ordenServicioRepositoryI.findById(id);
        OOrdenServicio.ifPresent( ordeServi->{
            ordenServicioRepositoryI.delete(ordeServi);
        });
        return OOrdenServicio;
    }

    @Override
    public List<OrdenServicio> findByPersonasId(Personas personasId) {
        return ordenServicioRepositoryI.findByPersonaId(personasId);
    }

    @Override
    public void addOrdenServicio(Long idCliente,Long idservicio) {
        ordenServicioRepositoryI.addOrdenServicio(idCliente,idservicio);
    }


}
