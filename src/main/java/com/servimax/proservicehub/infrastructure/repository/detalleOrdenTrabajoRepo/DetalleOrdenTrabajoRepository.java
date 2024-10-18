package com.servimax.proservicehub.infrastructure.repository.detalleOrdenTrabajoRepo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.servimax.proservicehub.domain.entity.DetalleOrdenTrabajo;

public interface DetalleOrdenTrabajoRepository extends CrudRepository<DetalleOrdenTrabajo,Long>{
    @Query("SELECT d FROM DetalleOrdenTrabajo d INNER JOIN d.orden_trabajo o WHERE o.personas.id = ?1")
    List<DetalleOrdenTrabajo> findDetallesByEmpleadoId(@Param("empleadoId") Long empleadoId);

}
