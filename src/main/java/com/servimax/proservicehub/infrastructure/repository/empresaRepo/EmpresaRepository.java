package com.servimax.proservicehub.infrastructure.repository.empresaRepo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.servimax.proservicehub.domain.entity.Empresa;

@Repository 
public interface EmpresaRepository extends CrudRepository<Empresa,Long> {

}
