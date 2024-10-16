package com.servimax.proservicehub.infrastructure.repository.rol;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.Arrays;

import com.servimax.proservicehub.domain.entity.Rol;


@Component
public class RolDataInitializer implements CommandLineRunner{

    @Autowired
    private RolRepositoryI rolRepositoryI;

    @Override
    public void run(String... args) throws Exception {
    List<String> roles = Arrays.asList(
        "Admin",
        "Cliente",
        "Jefe_recursos_humanos",
        "Jefe_bodega",
        "Jefe_inventario",
        "Jefe_marketing",
        "Jefe_sistemas",
        "Gerente",
        "Profesional",
        "Auxiliar_bodega",
        "Proveedor",
        "Jefe_compra"
    );

    for (String nombreRol : roles) {
        if (!rolRepositoryI.findByNombre(nombreRol).isPresent()) {
            rolRepositoryI.save(new Rol(nombreRol));
        }
    }
}

}