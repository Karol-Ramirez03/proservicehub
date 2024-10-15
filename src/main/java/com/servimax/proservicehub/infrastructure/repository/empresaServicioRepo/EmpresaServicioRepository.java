package com.servimax.proservicehub.infrastructure.repository.empresaServicioRepo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.servimax.proservicehub.domain.entity.EmpresaServicio;
import com.servimax.proservicehub.domain.entity.EmpresaServicioPk;

@Repository
public interface EmpresaServicioRepository extends CrudRepository<EmpresaServicio, EmpresaServicioPk>{

}
