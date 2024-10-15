package com.servimax.proservicehub.infrastructure.repository.ordentrabajoRepo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servimax.proservicehub.application.service.OrdenTrabajoServiceI;
import com.servimax.proservicehub.domain.entity.OrdenTrabajo;

@Service
public class OrdenTrabajoImplementacion implements OrdenTrabajoServiceI{

    @Autowired
    private OrdenTrabajoRepository ordenTrabajoRepositoryI;

    @Override
    public List<OrdenTrabajo> findAll() {
        return ((List<OrdenTrabajo>) ordenTrabajoRepositoryI.findAll());
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<OrdenTrabajo> findById(Long id) {
        return ordenTrabajoRepositoryI.findById(id);
    }

    @Override
    public OrdenTrabajo save(OrdenTrabajo ordenTrabajo) {
        return ordenTrabajoRepositoryI.save(ordenTrabajo);
    }

    @Override
    public Optional<OrdenTrabajo> update(Long id, OrdenTrabajo ordenTrabajo) {
        Optional<OrdenTrabajo> OrdenTrabajo= ordenTrabajoRepositoryI.findById(id);
        if(OrdenTrabajo.isPresent()){
            OrdenTrabajo ordenTrabajo2= OrdenTrabajo.orElseThrow();
            ordenTrabajo2.setNumero_orden_trabajo(ordenTrabajo.getNumero_orden_trabajo());
            ordenTrabajo2.setFecha_asignacion(ordenTrabajo.getFecha_asignacion());
            ordenTrabajo2.setHora_asignacion(ordenTrabajo.getHora_asignacion());
            return Optional.of(ordenTrabajoRepositoryI.save(ordenTrabajo2));
        }
        return Optional.empty();
    }

    @Override
    public Optional<OrdenTrabajo> delete(Long id) {
        Optional<OrdenTrabajo> OrdenTrabajo= ordenTrabajoRepositoryI.findById(id);
        OrdenTrabajo.ifPresent( orTra->{
            ordenTrabajoRepositoryI.delete(orTra);
        });
        return OrdenTrabajo;
    }
}
