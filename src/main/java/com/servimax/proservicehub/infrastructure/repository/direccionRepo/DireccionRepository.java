package com.servimax.proservicehub.infrastructure.repository.direccionRepo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.servimax.proservicehub.domain.entity.Direccion;

@Repository
public interface DireccionRepository extends CrudRepository<Direccion,Long> {

}
