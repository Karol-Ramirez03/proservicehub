package com.servimax.proservicehub.infrastructure.repository.insumoRepo;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.servimax.proservicehub.domain.entity.Insumo;

@Component
public class InsumoDataInitializer implements CommandLineRunner{
    
    @Autowired
    private InsumoRepository insumoRepository;

    @Override
    public void run(String... args) throws Exception {
        // Crear una lista de insumos
        List<Insumo> insumos = Arrays.asList(
            new Insumo("C001", "Cinta Aislante", 2000.0, 25, 20, 100),
            new Insumo("C002", "Tijeras", 1500.0, 15, 10, 50),
            new Insumo("C003", "Pegamento", 800.0, 30, 5, 60),
            new Insumo("C004", "Cartulina", 1200.0, 40, 15, 80),
            new Insumo("C005", "Resistol", 900.0, 50, 10, 70),
            new Insumo("C006", "Marcadores", 500.0, 60, 30, 150),
            new Insumo("C007", "Regla", 400.0, 70, 20, 120),
            new Insumo("C008", "Goma de borrar", 300.0, 80, 25, 200),
            new Insumo("EOO1", "Cable Eléctrico", 500.0, 100, 20, 200),
            new Insumo("EOO2", "Toma Corriente", 1500.0, 50, 10, 100),
            new Insumo("EOO3", "Interruptor", 800.0, 75, 15, 150),
            new Insumo("EOO4", "Foco LED", 200.0, 200, 50, 300),
            new Insumo("EOO5", "Regleta de Enchufes", 1200.0, 30, 5, 60),
            new Insumo("EOO6", "Conector RJ45", 100.0, 150, 40, 200),
            new Insumo("EOO7", "Lámpara de Mesa", 1800.0, 20, 5, 40),
            new Insumo("EOO8", "Transformador", 2500.0, 10, 2, 20),
            new Insumo("EOO9", "Batería Recargable", 1200.0, 40, 10, 80),
            new Insumo("EOO10", "Herramienta Multitool", 3000.0, 15, 5, 30)
        );

        for (Insumo insumo : insumos) {
            // Verificar si ya existe un insumo con el mismo nombre
            if (!insumoRepository.findByNombre(insumo.getNombre()).isPresent()) {
                insumoRepository.save(insumo); // Guardar solo si no existe
            }
        }
    }
}