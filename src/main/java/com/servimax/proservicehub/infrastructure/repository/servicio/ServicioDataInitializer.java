package com.servimax.proservicehub.infrastructure.repository.servicio;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.servimax.proservicehub.domain.entity.Servicio;
import com.servimax.proservicehub.domain.entity.ServicioInsumo;
import com.servimax.proservicehub.domain.entity.ServicioInsumoPk;
import com.servimax.proservicehub.infrastructure.repository.insumoRepo.InsumoRepository;
import com.servimax.proservicehub.infrastructure.repository.servicioInsumo.ServicioInsumoRepositoryI;

@Component
public class ServicioDataInitializer implements CommandLineRunner{

    @Autowired
    private ServicioRepositoryI servicioRepositoryI;

    @Autowired
    private ServicioInsumoRepositoryI servicioInsumoRepositoryI;

    @Autowired
    private InsumoRepository insumoRepository;

    @Override
    public void run(String... args) throws Exception {
        // Crear una lista de insumos
        List<Servicio> servicios = Arrays.asList(
            new Servicio("Reparacion electrica", true, "4 Horas"),
            new Servicio("Estudio de consumo", false, "2.5 horas"),
            new Servicio("Pancarta", true, "7 Horas"),
            new Servicio("Cambio transformador", true, "2 Dias")
        );

        for (Servicio servicio : servicios) {
            // Verificar si ya existe un insumo con el mismo nombre
            if (!servicioRepositoryI.findByNombre(servicio.getNombre()).isPresent()) {
                servicioRepositoryI.save(servicio); // Guardar solo si no existe
            }
        }

        List<ServicioInsumo> serInsumos=Arrays.asList(
            new ServicioInsumo(new ServicioInsumoPk(18L,1L),2),
            new ServicioInsumo(new ServicioInsumoPk(14L,1L),7),
            new ServicioInsumo(new ServicioInsumoPk(4L,3L),2),
            new ServicioInsumo(new ServicioInsumoPk(6L,3L),5),
            new ServicioInsumo(new ServicioInsumoPk(16L,4L),1)
        );

        if (servicioRepositoryI.count() != 0 && insumoRepository.count() !=0) {
        for (ServicioInsumo serInsumo: serInsumos){
            servicioInsumoRepositoryI.save(serInsumo);
        }
    }


    }
}
