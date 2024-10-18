package com.servimax.proservicehub.infrastructure.repository.login;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.servimax.proservicehub.domain.entity.Login;

@Repository
public interface LoginRepositoryI extends CrudRepository<Login,Long>{
    Optional<Login> findByUsuario(String nombre);
    List<Login> findByRolId(Long rolId); 
}
