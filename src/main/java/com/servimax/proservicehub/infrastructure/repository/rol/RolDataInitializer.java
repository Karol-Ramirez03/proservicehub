package com.servimax.proservicehub.infrastructure.repository.rol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.servimax.proservicehub.domain.entity.Rol;


@Component
public class RolDataInitializer implements CommandLineRunner{

    @Autowired
    private RolRepositoryI rolRepositoryI;

    @Override
    public void run(String... args) throws Exception {
        // Verifica ya existe antes de insertarlo
        if (!rolRepositoryI.findByNombre("Admin").isPresent()) {
            rolRepositoryI.save(new Rol("Admin"));
        }
        if (!rolRepositoryI.findByNombre("Cliente").isPresent()) {
            rolRepositoryI.save(new Rol("Cliente"));
        }
        if (!rolRepositoryI.findByNombre("Jefe_recursos_humanos").isPresent()) {
            rolRepositoryI.save(new Rol("Jefe_recursos_humanos"));
        }
        if (!rolRepositoryI.findByNombre("Jefe_bodega").isPresent()) {
            rolRepositoryI.save(new Rol("Jefe_bodega"));
        }
        if (!rolRepositoryI.findByNombre("Jefe_inventario").isPresent()) {
            rolRepositoryI.save(new Rol("Jefe_inventario"));
        }
        if (!rolRepositoryI.findByNombre("Jefe_marketing").isPresent()) {
            rolRepositoryI.save(new Rol("Jefe_marketing"));
        }
        if (!rolRepositoryI.findByNombre("Jefe_sistemas").isPresent()) {
            rolRepositoryI.save(new Rol("Jefe_sistemas"));
        }
        if (!rolRepositoryI.findByNombre("Gerente").isPresent()) {
            rolRepositoryI.save(new Rol("Gerente"));
        }
        if (!rolRepositoryI.findByNombre("Profesional").isPresent()) {
            rolRepositoryI.save(new Rol("Profesional"));
        }
        if (!rolRepositoryI.findByNombre("Auxiliar_bodega").isPresent()) {
            rolRepositoryI.save(new Rol("Auxiliar_bodega"));
        }
        if (!rolRepositoryI.findByNombre("Proveedor").isPresent()) {
            rolRepositoryI.save(new Rol("Proveedor"));
        }
        if (!rolRepositoryI.findByNombre("Jefe_compra").isPresent()) {
            rolRepositoryI.save(new Rol("Jefe_compra"));
        }

    }
}