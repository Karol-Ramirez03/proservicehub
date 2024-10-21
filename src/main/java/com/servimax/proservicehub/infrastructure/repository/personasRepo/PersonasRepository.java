package com.servimax.proservicehub.infrastructure.repository.personasRepo;

import org.hibernate.mapping.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.servimax.proservicehub.domain.entity.Personas;

@Repository
public interface PersonasRepository extends CrudRepository<Personas,Long>{
    
    @Query("SELECT p.nombre, p.apellido, d.insumo, SUM(d.cantidad) as totalCompras, tp.numero FROM Personas p LEFT JOIN p.telPersona tp JOIN p.compra c JOIN c.detalleCompra d WHERE p.Nro_Doc = ?1 GROUP BY p.nombre, p.apellido, d.insumo, tp.numero ORDER BY totalCompras DESC LIMIT 1")
    List<Object[]> findByEstadoEmpleado(@Param("idcliente")Long idcliente);

    @Query("SELECT p.nombre, p.apellido, SUM(i.precio_unitario * dc.cantidad) AS total_invertido, tp.numero FROM Personas p LEFT JOIN p.telPersona tp JOIN p.compra c JOIN c.detalleCompra dc JOIN dc.insumo i GROUP BY p.Nro_Doc, p.nombre, p.apellido, tp.numero ORDER BY total_invertido DESC LIMIT 3")
    List<Object[]> findByTop3PersonasMasInversiones();
}
