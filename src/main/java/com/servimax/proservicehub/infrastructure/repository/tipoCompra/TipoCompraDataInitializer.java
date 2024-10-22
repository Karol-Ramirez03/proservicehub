package com.servimax.proservicehub.infrastructure.repository.tipoCompra;

import java.util.List;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.servimax.proservicehub.domain.entity.TipoCompra;

@Component
public class TipoCompraDataInitializer implements CommandLineRunner{

    @Autowired
    private TipoCompraRepositoryI tipoCompraRepositoryI;

    @Override
    public void run(String... args) throws Exception {
    List<String> tipos = Arrays.asList(
        "Compra Proveedor",
        "Venta Cliente"
    );

    for (String nombreTipo : tipos) {
        if (!tipoCompraRepositoryI.findByNombre(nombreTipo).isPresent()) {
            tipoCompraRepositoryI.save(new TipoCompra(nombreTipo));
        }
    }
}
}
