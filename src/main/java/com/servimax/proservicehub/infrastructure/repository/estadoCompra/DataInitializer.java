package com.servimax.proservicehub.infrastructure.repository.estadoCompra;

import java.util.Arrays;
import java.util.List;

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
        List<String> tipos = Arrays.asList(
        "Ejecutado",
        "Pendiente",
        "Cancelado",
        "Rechazado"
    );

    for (String nombreTipo : tipos) {
        if (!estadoCompraRepositoryI.findByNombre(nombreTipo).isPresent()) {
            estadoCompraRepositoryI.save(new EstadoCompra(nombreTipo));
        }
    }
}
}
