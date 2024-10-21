package com.servimax.proservicehub.infrastructure.repository.aprobacionServicio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.servimax.proservicehub.domain.entity.AprobacionServicio;
import com.servimax.proservicehub.domain.entity.EstadoAprobacion;
import com.servimax.proservicehub.domain.entity.Personas;

@Repository
public interface AprobacionServicioRepositoryI extends CrudRepository<AprobacionServicio,Long>{

    @Query("SELECT as FROM AprobacionServicio as WHERE as.personas = ?1")
    List<AprobacionServicio> findByPersonaId(@Param("personaId") Personas personaId);
    @Query("SELECT a FROM AprobacionServicio a WHERE a.estado_aprobacion.id = ?1")
    List<AprobacionServicio> findByEstadoAprobacionId(@Param("estadoId") Long estadoId);

    @Query("SELECT a FROM AprobacionServicio a WHERE a.estado_aprobacion = ?1 AND a.orden_trabajo.personas.id = ?2")
    List<AprobacionServicio> findByEstadoAprobacionAndEmpleado(@Param("estadoAprobacion") EstadoAprobacion estadoAprobacion, @Param("idEmpleado") Long idEmpleado);


    @Procedure(name="insertaprobacionservicio")
    void insertAprobacionServicio(@Param("id_trabajo") Long idTrabajo, @Param("hallazgoap") String hallazgoap, @Param("solucionap") String solucionap);
}
