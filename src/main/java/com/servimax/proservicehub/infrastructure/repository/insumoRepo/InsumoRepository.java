package com.servimax.proservicehub.infrastructure.repository.insumoRepo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.servimax.proservicehub.domain.entity.Insumo;


@Repository
public interface InsumoRepository extends CrudRepository<Insumo,Long>{

}
