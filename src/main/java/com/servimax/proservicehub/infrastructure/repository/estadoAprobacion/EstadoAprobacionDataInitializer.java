package com.servimax.proservicehub.infrastructure.repository.estadoAprobacion;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.servimax.proservicehub.domain.entity.EstadoAprobacion;

@Component
public class EstadoAprobacionDataInitializer implements CommandLineRunner{
    @Autowired
    private EstadoAprobacionRepositoryI estadoAprobacionRepositoryI;

    @Override
    public void run(String... args) throws Exception {
        List<String> tipos = Arrays.asList(
        "Ejecutado",
        "No aprobado",
        "Aprobado",
        "Pendiente"
    );

    for (String nombreTipo : tipos) {
        if (!estadoAprobacionRepositoryI.findByNombre(nombreTipo).isPresent()) {
            estadoAprobacionRepositoryI.save(new EstadoAprobacion(nombreTipo));
        }
    }
}
}
