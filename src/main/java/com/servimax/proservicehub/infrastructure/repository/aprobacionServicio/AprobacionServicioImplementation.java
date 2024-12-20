package com.servimax.proservicehub.infrastructure.repository.aprobacionServicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servimax.proservicehub.application.service.AprobacionServicioServiceI;
import com.servimax.proservicehub.domain.entity.AprobacionServicio;
import com.servimax.proservicehub.domain.entity.EstadoAprobacion;
import com.servimax.proservicehub.domain.entity.Personas;



@Service
public class AprobacionServicioImplementation implements AprobacionServicioServiceI{

    @Autowired
    private AprobacionServicioRepositoryI aprobacionServicioRepositoryI;

    @Override
    public List<AprobacionServicio> findAll() {
        return ((List<AprobacionServicio>) aprobacionServicioRepositoryI.findAll());
    }

    @Override
    public Optional<AprobacionServicio> findById(Long id) {
        return aprobacionServicioRepositoryI.findById(id);
    }

    @Override
    public AprobacionServicio save(AprobacionServicio aprobacionServicio) {
        return aprobacionServicioRepositoryI.save(aprobacionServicio);
    }

    @Override
    public Optional<AprobacionServicio> update(Long id, AprobacionServicio aprobacionServicio) {
        Optional<AprobacionServicio> OAprobacionservicio= aprobacionServicioRepositoryI.findById(id);
        if (OAprobacionservicio.isPresent()) {
            AprobacionServicio aprobacionServicio2 = OAprobacionservicio.orElseThrow();
            aprobacionServicio2.setEstado_aprovacion(aprobacionServicio.getEstado_aprovacion());
            aprobacionServicio2.setHallazgo(aprobacionServicio.getHallazgo());
            aprobacionServicio2.setPersonas(aprobacionServicio.getPersonas());
            aprobacionServicio2.setOrden_trabajo(aprobacionServicio.getOrden_trabajo());
            return Optional.of(aprobacionServicioRepositoryI.save(aprobacionServicio2));
            
        }
        return Optional.empty();
    }

    @Override
    public Optional<AprobacionServicio> delete(Long id) {
        Optional<AprobacionServicio> OAprobacionservicio= aprobacionServicioRepositoryI.findById(id);
        OAprobacionservicio.ifPresent( aprobSer-> {
            aprobacionServicioRepositoryI.delete(aprobSer);
        });
        return OAprobacionservicio;
    }

    @Override
    public List<AprobacionServicio> findByPersonasId(Personas personasId) {
        return aprobacionServicioRepositoryI.findByPersonaId(personasId);
    }

    @Override
    public List<AprobacionServicio> findByEstadoId(long estadoId) {
        return aprobacionServicioRepositoryI.findByEstadoAprobacionId(estadoId);
    }

    @Override
    public List<AprobacionServicio> findByEstadoPersona(EstadoAprobacion estado_aprobacion,Long estadoId) {
        return aprobacionServicioRepositoryI.findByEstadoAprobacionAndEmpleado(estado_aprobacion, estadoId);
    }

    @Override
    @Transactional
    public void insertAprobacionServicio(Long idTrabajo, String hallazgoap, String solucionap) {
        try {
            aprobacionServicioRepositoryI.insertAprobacionServicio(idTrabajo, hallazgoap, solucionap);
        } catch (Exception e) {
            // Manejar excepciones de forma adecuada
            throw new RuntimeException("Error al insertar la aprobación de servicio", e);
        }
    }
}
