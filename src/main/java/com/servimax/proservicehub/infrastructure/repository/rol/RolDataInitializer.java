package com.servimax.proservicehub.infrastructure.repository.rol;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.Arrays;

import com.servimax.proservicehub.domain.entity.Permiso;
import com.servimax.proservicehub.domain.entity.Rol;
import com.servimax.proservicehub.infrastructure.repository.permisosRepo.PermisoRepository;
import com.servimax.proservicehub.infrastructure.repository.permisosRepo.RolPermisoService;


@Component
public class RolDataInitializer implements CommandLineRunner{

    @Autowired
    private RolRepositoryI rolRepositoryI;

    @Autowired
    private PermisoRepository permisoRepository;

    @Autowired
    private RolPermisoService rolPermisoService;
    
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

     List<String> permisos = Arrays.asList(
        "READ_ALL_APROBACIONES",
        "READ_ONE_APROBACION",
        "CREATE_ONE_APROBACION",
        "UPDATE_ONE_APROBACION",
        "DISABLE_ONE_APROBACION",

        "READ_ALL_CIUDADES",
        "READ_ONE_CIUDAD",
        "CREATE_ONE_CIUDAD",
        "UPDATE_ONE_CIUDAD",
        "DISABLE_ONE_CIUDAD",

        "READ_ALL_COMPRAS",
        "READ_ONE_COMPRA",
        "CREATE_ONE_COMPRA",
        "UPDATE_ONE_COMPRA",
        "DISABLE_ONE_COMPRA",

        "READ_ALL_DETALLE_COMPRAS",
        "READ_ONE_DETALLE_COMPRA",
        "CREATE_ONE_DETALLE_COMPRA",
        "UPDATE_ONE_DETALLE_COMPRA",
        "DISABLE_ONE_DETALLE_COMPRA",

        "READ_ALL_ORDENES_SERVICIO",
        "READ_ONE_ORDEN_SERVICIO",
        "CREATE_ONE_ORDEN_SERVICIO",
        "UPDATE_ONE_ORDEN_SERVICIO",
        "DISABLE_ONE_ORDEN_SERVICIO",

        "READ_ALL_ORDENES_TRABAJO",
        "READ_ONE_ORDEN_TRABAJO",
        "CREATE_ONE_ORDEN_TRABAJO",
        "UPDATE_ONE_ORDEN_TRABAJO",
        "DISABLE_ONE_ORDEN_TRABAJO",

        "READ_ALL_DIRECCIONES",
        "READ_ONE_DIRECCION",
        "CREATE_ONE_DIRECCION",
        "UPDATE_ONE_DIRECCION",
        "DISABLE_ONE_DIRECCION",

        "READ_ALL_EMAIL_PERSONAS",
        "READ_ONE_EMAIL_PERSONA",
        "CREATE_ONE_EMAIL_PERSONA",
        "UPDATE_ONE_EMAIL_PERSONA",
        "DISABLE_ONE_EMAIL_PERSONA",

        "READ_ALL_EMPRESAS",
        "READ_ONE_EMPRESA",
        "CREATE_ONE_EMPRESA",
        "UPDATE_ONE_EMPRESA",
        "DISABLE_ONE_EMPRESA",

        "READ_ALL_EMPRESA_SERVICIO",
        "READ_ONE_EMPRESA_SERVICIO",
        "CREATE_ONE_EMPRESA_SERVICIO",
        "UPDATE_ONE_EMPRESA_SERVICIO",
        "DISABLE_ONE_EMPRESA_SERVICIO",

        "READ_ALL_ESTADO_APROBACION",
        "READ_ONE_ESTADO_APROBACION",
        "CREATE_ONE_ESTADO_APROBACION",
        "UPDATE_ONE_ESTADO_APROBACION",
        "DISABLE_ONE_ESTADO_APROBACION",

        "READ_ALL_ESTADO_COMPRA",
        "READ_ONE_ESTADO_COMPRA",
        "CREATE_ONE_ESTADO_COMPRA",
        "UPDATE_ONE_ESTADO_COMPRA",
        "DISABLE_ONE_ESTADO_COMPRA",

        "READ_ALL_ESTADO_ORDEN",
        "READ_ONE_ESTADO_ORDEN",
        "CREATE_ONE_ESTADO_ORDEN",
        "UPDATE_ONE_ESTADO_ORDEN",
        "DISABLE_ONE_ESTADO_ORDEN",

        "READ_ALL_ESTADO_ORDEN_SERVICIO",
        "READ_ONE_ESTADO_ORDEN_SERVICIO",
        "CREATE_ONE_ESTADO_ORDEN_SERVICIO",
        "UPDATE_ONE_ESTADO_ORDEN_SERVICIO",
        "DISABLE_ONE_ESTADO_ORDEN_SERVICIO",

        "READ_ALL_INSUMO",
        "READ_ONE_INSUMO",
        "CREATE_ONE_INSUMO",
        "UPDATE_ONE_INSUMO",
        "DISABLE_ONE_INSUMO",

        "READ_ALL_ORDEN_SERVICIO",
        "READ_ONE_ORDEN_SERVICIO",
        "CREATE_ONE_ORDEN_SERVICIO",
        "UPDATE_ONE_ORDEN_SERVICIO",
        "DISABLE_ONE_ORDEN_SERVICIO",

        "READ_ALL_ORDEN_TRABAJO",
        "READ_ONE_ORDEN_TRABAJO",
        "CREATE_ONE_ORDEN_TRABAJO",
        "UPDATE_ONE_ORDEN_TRABAJO",
        "DISABLE_ONE_ORDEN_TRABAJO",

        "READ_ALL_PAIS",
        "READ_ONE_PAIS",
        "CREATE_ONE_PAIS",
        "UPDATE_ONE_PAIS",
        "DISABLE_ONE_PAIS",

        "READ_ALL_PERSONA_INSUMO",
        "READ_ONE_PERSONA_INSUMO",
        "CREATE_ONE_PERSONA_INSUMO",
        "UPDATE_ONE_PERSONA_INSUMO",
        "DISABLE_ONE_PERSONA_INSUMO",

        "READ_ALL_REGION",
        "READ_ONE_REGION",
        "CREATE_ONE_REGION",
        "UPDATE_ONE_REGION",
        "DISABLE_ONE_REGION",

        "READ_ALL_PERSONAS",
        "READ_ONE_PERSONAS",
        "CREATE_ONE_PERSONAS",
        "UPDATE_ONE_PERSONAS",
        "DISABLE_ONE_PERSONAS",

        "READ_ALL_SERVICIO",
        "READ_ONE_SERVICIO",
        "CREATE_ONE_SERVICIO",
        "UPDATE_ONE_SERVICIO",
        "DISABLE_ONE_SERVICIO",

        "READ_ALL_SERVICIO_INSUMO",
        "READ_ONE_SERVICIO_INSUMO",
        "CREATE_ONE_SERVICIO_INSUMO",
        "UPDATE_ONE_SERVICIO_INSUMO",
        "DISABLE_ONE_SERVICIO_INSUMO",

        "READ_ALL_SUCURSAL",
        "READ_ONE_SUCURSAL",
        "CREATE_ONE_SUCURSAL",
        "UPDATE_ONE_SUCURSAL",
        "DISABLE_ONE_SUCURSAL",

        "READ_ALL_TEL_PERSONA",
        "READ_ONE_TEL_PERSONA",
        "CREATE_ONE_TEL_PERSONA",
        "UPDATE_ONE_TEL_PERSONA",
        "DISABLE_ONE_TEL_PERSONA",

        "READ_ALL_TEL_SUCURSAL",
        "READ_ONE_TEL_SUCURSAL",
        "CREATE_ONE_TEL_SUCURSAL",
        "UPDATE_ONE_TEL_SUCURSAL",
        "DISABLE_ONE_TEL_SUCURSAL",

        "READ_ALL_TIPO_EMAIL",
        "READ_ONE_TIPO_EMAIL",
        "CREATE_ONE_TIPO_EMAIL",
        "UPDATE_ONE_TIPO_EMAIL",
        "DISABLE_ONE_TIPO_EMAIL",

        "READ_ALL_TIPO_EMPRESA",
        "READ_ONE_TIPO_EMPRESA",
        "CREATE_ONE_TIPO_EMPRESA",
        "UPDATE_ONE_TIPO_EMPRESA",
        "DISABLE_ONE_TIPO_EMPRESA",

        "READ_ALL_TIPO_PERSONA",
        "READ_ONE_TIPO_PERSONA",
        "CREATE_ONE_TIPO_PERSONA",
        "UPDATE_ONE_TIPO_PERSONA",
        "DISABLE_ONE_TIPO_PERSONA",

        "READ_ALL_TIPO_TELEFONO",
        "READ_ONE_TIPO_TELEFONO",
        "CREATE_ONE_TIPO_TELEFONO",
        "UPDATE_ONE_TIPO_TELEFONO",
        "DISABLE_ONE_TIPO_TELEFONO"
        );

        for (String nombrePermiso : permisos) {
            if (!permisoRepository.findByNombre(nombrePermiso).isPresent()) {
                permisoRepository.save(new Permiso(nombrePermiso));
            }
        }


        rolPermisoService.asignarPermisoARol("Admin", "READ_ALL_APROBACIONES");
        rolPermisoService.asignarPermisoARol("Jefe_sistemas", "UPDATE_ONE_TIPO_TELEFONO");

        
        rolPermisoService.asignarPermisoARol("Cliente", "READ_ALL_APROBACIONES");
}

}