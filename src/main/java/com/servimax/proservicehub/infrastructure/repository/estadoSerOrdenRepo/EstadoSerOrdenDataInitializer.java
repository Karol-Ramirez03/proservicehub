package com.servimax.proservicehub.infrastructure.repository.estadoSerOrdenRepo;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.servimax.proservicehub.domain.entity.EstadoOrdenServicio;

@Component
public class EstadoSerOrdenDataInitializer implements CommandLineRunner{

    @Autowired
    private EstadoSerOrdenRepository estadoSerOrdenRepository;

    @Override
    public void run(String... args) throws Exception {
        List<String> tipos = Arrays.asList(
        "Ejecutado",
        "Pendiente asignacion",
        "Cancelado",
        "Rechazado"
    );

     for (String nombreTipo : tipos) {
        if (!estadoSerOrdenRepository.findByNombre(nombreTipo).isPresent()) {
            estadoSerOrdenRepository.save(new EstadoOrdenServicio(nombreTipo));
        }
    }
}
}
