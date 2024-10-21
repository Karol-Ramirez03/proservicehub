package com.servimax.proservicehub.infrastructure.repository.insumoRepo;

import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.servimax.proservicehub.domain.entity.Insumo;

import jakarta.transaction.Transactional;


@Repository
public interface InsumoRepository extends CrudRepository<Insumo,Long>{
     Optional<Insumo> findByNombre(String nombre);

     @Transactional
     @Modifying
     @Query(value = "CALL validar_stock(:insumoId, :cantidadSolicitada, @estado)", nativeQuery = true)
     void validarStock(@Param("insumoId") int insumoId, @Param("cantidadSolicitada") int cantidadSolicitada);

     @Query(value = "SELECT @estado", nativeQuery = true)
     Integer obtenerEstado();

     @Procedure(name="actualizarStock")
     void actualizarStock(@Param("insumoId")int insumoId,@Param("cantidad")int cantidad);

}
