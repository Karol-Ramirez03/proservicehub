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
        Optional<Rol> ORol = rolRepositoryI.findById(id);
        if (ORol.isPresent()) {
            Rol rol2 = ORol.orElseThrow();
            rol2.setNombre(rol.getNombre());
            return Optional.of(rolRepositoryI.save(rol2));
            
        }
        return Optional.empty();
    }

    @Override
    public Optional<Rol> delete(Long id) {
        Optional<Rol> ORol = rolRepositoryI.findById(id);
        ORol.ifPresent( rols -> {
            rolRepositoryI.delete(rols);
        });
        return ORol;
    }

    public boolean validarPermiso(String nombreRol, String nombrePermiso) {
        Optional<Rol> rolOptional = rolRepositoryI.findByNombre(nombreRol);

        if (rolOptional.isPresent()) {
            Rol rol = rolOptional.get();
            // Verifica si el rol tiene el permiso especificado
            return rol.getPermisos().stream().anyMatch(p -> p.getNombre().equals(nombrePermiso));
        }
        return false;
    }

}
