package com.servimax.proservicehub.infrastructure.repository.tipoCompra;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.servimax.proservicehub.domain.entity.TipoCompra;

@Repository
public interface TipoCompraRepositoryI extends CrudRepository<TipoCompra,Long>{
    Optional<TipoCompra> findByNombre(String nombre);
}
