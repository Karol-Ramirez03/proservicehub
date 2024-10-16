package com.servimax.proservicehub.infrastructure.repository.compra;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.servimax.proservicehub.domain.entity.Compra;

@Repository
public interface CompraRepositoryI extends CrudRepository<Compra,Long>{
}
