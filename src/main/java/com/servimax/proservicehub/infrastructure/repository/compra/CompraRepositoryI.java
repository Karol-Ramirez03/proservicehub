package com.servimax.proservicehub.infrastructure.repository.compra;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.servimax.proservicehub.domain.entity.Compra;
import com.servimax.proservicehub.domain.entity.Personas;
import com.servimax.proservicehub.domain.entity.TipoCompra;

@Repository
public interface CompraRepositoryI extends CrudRepository<Compra,Long>{

    @Query("SELECT c FROM Compra c WHERE c.personas = ?1")
    List<Compra> findByPersonaId(@Param("personaId") Personas personaId);

    @Procedure(name="addComprayDetalle")
    void addComprayDetalle(@Param("idCliente")Long idCliente,@Param("idProducto")Long idProducto,@Param("cantidad")int cantidad,@Param("tipo_compra")int tipo);

    @Query("SELECT c FROM Compra c WHERE c.tipo_compra = ?1")
    List<Compra> findByTipoCompraId(@Param("tipoCompraId") TipoCompra tipoCompraId);

    @Procedure(name="actualizarEstadocompra")
    void actualizarEstadocompra(@Param("compraId")int compraId);

}
