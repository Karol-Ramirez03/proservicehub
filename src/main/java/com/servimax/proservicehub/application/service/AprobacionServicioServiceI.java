package com.servimax.proservicehub.application.service;

import java.util.List;
import java.util.Optional;

import com.servimax.proservicehub.domain.entity.AprobacionServicio;
import com.servimax.proservicehub.domain.entity.Personas;

public interface AprobacionServicioServiceI {
    List<AprobacionServicio> findAll();
    Optional<AprobacionServicio> findById(Long id);
    AprobacionServicio save(AprobacionServicio aprobacionServicio);
    Optional<AprobacionServicio> update(Long id, AprobacionServicio aprobacionServicio);
    Optional<AprobacionServicio> delete(Long id);
    List<AprobacionServicio> findByPersonasId(Personas personasId);
    List<AprobacionServicio> findByEstadoId(long estadoId);
    void insertAprobacionServicio(Long idTrabajo,String hallazgoap,String solucionap);

}
//mccm
