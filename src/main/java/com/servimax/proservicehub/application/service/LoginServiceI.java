package com.servimax.proservicehub.application.service;

import java.util.List;
import java.util.Optional;

import com.servimax.proservicehub.domain.entity.Login;
import com.servimax.proservicehub.domain.entity.Rol;

public interface LoginServiceI {
    List<Login> findAll();
    Optional<Login> findById(Long id);
    Login save(Login login);
    Optional<Login> update(Long id, Login login);
    Optional<Login> delete(Long id);
    List<Login> findByRolId(Long rolId); 
}
