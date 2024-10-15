package com.servimax.proservicehub.infrastructure.repository.estadoCompra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.servimax.proservicehub.domain.entity.EstadoCompra;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private EstadoCompraRepositoryI estadoCompraRepositoryI;

    @Override
    public void run(String... args) throws Exception {
        // Verifica ya existe antes de insertarlo
        if (!estadoCompraRepositoryI.findByNombre("Ejecutado").isPresent()) {
            estadoCompraRepositoryI.save(new EstadoCompra("Ejecutado"));
        }
    }
}
