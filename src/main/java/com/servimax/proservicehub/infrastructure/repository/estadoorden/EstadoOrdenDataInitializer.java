package com.servimax.proservicehub.infrastructure.repository.estadoorden;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.servimax.proservicehub.domain.entity.EstadoOrden;

@Component
public class EstadoOrdenDataInitializer implements CommandLineRunner{
     @Autowired
    private EstadoOrdenRepositoryI estadoOrdenRepositoryI;

    @Override
    public void run(String... args) throws Exception {
        List<String> tipos = Arrays.asList(
        "Ejecutado",
        "Pendiente asignacion",
        "Cancelado",
        "Rechazado"
    );

     for (String nombreTipo : tipos) {
        if (!estadoOrdenRepositoryI.findByNombre(nombreTipo).isPresent()) {
            estadoOrdenRepositoryI.save(new EstadoOrden(nombreTipo));
        }
    }
}
}
