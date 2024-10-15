package com.servimax.proservicehub.infrastructure.repository.rol;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servimax.proservicehub.application.service.RolServiceI;
import com.servimax.proservicehub.domain.entity.Rol;

@Service
public class RolImplementation implements RolServiceI{

    @Autowired
    private RolRepositoryI rolRepositoryI;

    @Override
    public List<Rol> findAll() {
        return ((List<Rol>) rolRepositoryI.findAll());
    }

    @Override
    public Optional<Rol> findById(Long id) 
    {
        return rolRepositoryI.findById(id);
    }

    @Override
    public Rol save(Rol rol) {
        return rolRepositoryI.save(rol);
    }

    @Override
    public Optional<Rol> update(Long id, Rol rol) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Optional<Rol> delete(Long id) {
        Optional<Rol> ORol = rolRepositoryI.findById(id);
        ORol.ifPresent( rols -> {
            rolRepositoryI.delete(rols);
        });
        return ORol;
    }

}
