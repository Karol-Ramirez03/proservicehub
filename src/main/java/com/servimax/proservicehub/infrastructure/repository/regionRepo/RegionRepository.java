package com.servimax.proservicehub.infrastructure.repository.regionRepo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.servimax.proservicehub.domain.entity.Region;

@Repository
public interface RegionRepository extends CrudRepository<Region,Long>{

    //aja
}
