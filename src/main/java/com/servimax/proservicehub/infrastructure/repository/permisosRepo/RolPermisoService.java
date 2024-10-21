package com.servimax.proservicehub.infrastructure.repository.permisosRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servimax.proservicehub.domain.entity.Permiso;
import com.servimax.proservicehub.domain.entity.Rol;
import com.servimax.proservicehub.infrastructure.repository.rol.RolRepositoryI;
import java.util.Optional;
@Service
public class RolPermisoService {

    @Autowired
    private RolRepositoryI rolRepository;

    @Autowired
    private PermisoRepository permisoRepository;

    public void asignarPermisoARol(String nombreRol, String nombrePermiso) {
        // Buscar el rol en la base de datos
        Optional<Rol> rolOptional = rolRepository.findByNombre(nombreRol);
        Optional<Permiso> permisoOptional = permisoRepository.findByNombre(nombrePermiso);

        if (rolOptional.isPresent() && permisoOptional.isPresent()) {
            Rol rol = rolOptional.get();
            Permiso permiso = permisoOptional.get();

            if (!rol.getPermisos().contains(permiso)) {
                rol.getPermisos().add(permiso);
                rolRepository.save(rol);
            }
        }
    }
}
