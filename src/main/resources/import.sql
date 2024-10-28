INSERT INTO module (name,base_path) VALUES ("AprobacionServicio","/api/aprobacionservicio"); 
INSERT INTO module (name,base_path) VALUES ("Ciudad","/api/ciudad"); 
INSERT INTO module (name,base_path) VALUES ("Compra","/api/compra"); 
INSERT INTO module (name,base_path) VALUES ("DetalleCompra","/api/detallecompra"); 
INSERT INTO module (name,base_path) VALUES ("Detalle0rdenServicio","/api/detalleordenservicio"); 
INSERT INTO module (name,base_path) VALUES ("DetalleOrden","/api/detalleorden"); 
INSERT INTO module (name,base_path) VALUES ("Direccion","/api/direccion"); 
INSERT INTO module (name,base_path) VALUES ("Emailpersona","/api/emailpersona"); 
INSERT INTO module (name,base_path) VALUES ("Empresa","/api/empresa"); 
INSERT INTO module (name,base_path) VALUES ("EmpresaServicio","/api/empresaServicio"); 
INSERT INTO module (name,base_path) VALUES ("Estadoaprobacion","/api/estadoaprobacion"); 
INSERT INTO module (name,base_path) VALUES ("Estadocompra","/api/estadocompra"); 
INSERT INTO module (name,base_path) VALUES ("EstadoOrden","/api/estadoorden"); 
INSERT INTO module (name,base_path) VALUES ("EstadoOrdenServicio","/api/estadoordenservicio"); 
INSERT INTO module (name,base_path) VALUES ("Insumo","/api/insumo"); 
INSERT INTO module (name,base_path) VALUES ("Login","/api/login"); 
INSERT INTO module (name,base_path) VALUES ("Ordenservicio","/api/ordenservicio"); 
INSERT INTO module (name,base_path) VALUES ("Ordentrabajo","/api/ordentrabajo"); 
INSERT INTO module (name,base_path) VALUES ("Pais","/api/pais"); 
INSERT INTO module (name,base_path) VALUES ("PersonaInsumo","/api/personainsumo"); 
INSERT INTO module (name,base_path) VALUES ("Personas","/api/personas"); 
INSERT INTO module (name,base_path) VALUES ("Region","/api/region"); 
INSERT INTO module (name,base_path) VALUES ("Rol","/api/rol"); 
INSERT INTO module (name,base_path) VALUES ("Servicio","/api/servicio"); 
INSERT INTO module (name,base_path) VALUES ("Servicioinsumo","/api/servicioinsumo"); 
INSERT INTO module (name,base_path) VALUES ("Sucursal","/api/sucursal"); 
INSERT INTO module (name,base_path) VALUES ("Telpersona","/api/telpersona"); 
INSERT INTO module (name,base_path) VALUES ("Telsucursal","/api/telsucursal"); 
INSERT INTO module (name,base_path) VALUES ("Tipocompra","/api/tipocompra"); 
INSERT INTO module (name,base_path) VALUES ("TipoEmail","/api/tipoEmail"); 
INSERT INTO module (name,base_path) VALUES ("TipoEmpresa","/api/tipoEmpresa"); 
INSERT INTO module (name,base_path) VALUES ("Tipopersona","/api/tipopersona"); 
INSERT INTO module (name,base_path) VALUES ('AUTH', '/auth'); 
INSERT INTO module (name,base_path) VALUES ("Tipotelefono","/api/tipotelefono");

INSERT INTO rol (nombre) VALUES ("Admin")
INSERT INTO rol (nombre) VALUES ("Cliente")
INSERT INTO rol (nombre) VALUES ("Jefe_recursos_humanos")
INSERT INTO rol (nombre) VALUES ("Jefe_bodega")
INSERT INTO rol (nombre) VALUES ("Jefe_inventario")
INSERT INTO rol (nombre) VALUES ("Jefe_marketing")
INSERT INTO rol (nombre) VALUES ("Jefe_sistemas")
INSERT INTO rol (nombre) VALUES ("Gerente")
INSERT INTO rol (nombre) VALUES ("Profesional")
INSERT INTO rol (nombre) VALUES ("Auxiliar_bodega")
INSERT INTO rol (nombre) VALUES ("Proveedor")
INSERT INTO rol (nombre) VALUES ("Jefe_compra")


INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_ALL_APROBACIONES", '', 'GET', false, 1); 
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_ONE_APROBACION", '/[0-9]*', 'GET', false, 1); 
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("CREATE_ONE_APROBACION", '', 'POST', false, 1); 
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("UPDATE_ONE_APROBACION", '/[0-9]*', 'PUT', false, 1); 
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("DELETE_ONE_APROBACION", '/[0-9]*', 'DELETE', false, 1); 
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_APROBACION_PERSONAS", '/persona/[0-9]*', 'GET', false, 1);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_APROBACION_ESTADO", '/aprobacion/[0-9]*', 'GET', false, 1);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_APROBACION_ESTADO_PERSONA", '/aprobacionPer/[0-9]*/[0-9]*', 'GET', false, 1);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("ADD_APROBACION_SERVICIO", '/agregar', 'POST', false, 1);

INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_ALL_CIUDADES", '', 'GET', false, 2);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_ONE_CIUDAD", '/[0-9]*', 'GET', false, 2);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("CREATE_ONE_CIUDAD", '', 'POST', false, 2);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("UPDATE_ONE_CIUDAD", '/[0-9]*', 'PUT', false, 2);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("DELETE_ONE_CIUDAD", '/[0-9]*', 'DELETE', false, 2);

INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_ALL_COMPRAS", '', 'GET', false, 3);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_ONE_COMPRA", '/[0-9]*', 'GET', false, 3);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("CREATE_ONE_COMPRA", '', 'POST', false, 3);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("UPDATE_ONE_COMPRA", '/[0-9]*', 'PUT', false, 3);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("DELETE_ONE_COMPRA", '/[0-9]*', 'DELETE', false, 3);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_COMPRA_PERSONAS", '/persona/[0-9]*', 'GET', false, 3);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_NOMBRE_ESTADO_COMPRA", '/[0-9]*/estado/nombre', 'GET', false, 3);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("ADD_NEW_COMPRA", '/agregar', 'POST', false, 3);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_COMPRA_TIPO", 'tipocompra/[0-9]*', 'GET', false, 3);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("UPDATE_ESTADO_COMPRA", 'actualizarestadocompra/[0-9]*', 'POST', false, 3);

INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_ALL_DETALLE_COMPRAS", '', 'GET', false, 4);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_ONE_DETALLE_COMPRA", '/[0-9]*', 'GET', false, 4);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("CREATE_ONE_DETALLE_COMPRA", '', 'POST', false, 4);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("UPDATE_ONE_DETALLE_COMPRA", '/[0-9]*', 'PUT', false, 4);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("DELETE_ONE_DETALLE_COMPRA", '/[0-9]*', 'DELETE', false, 4);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_DETALLE_COMPRA_PERSONA", 'compra/[0-9]*', 'GET', false, 4);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_DETALLE_COMPRA_MAS_VENDIDO", '/top3', 'GET', false, 4);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_DETALLE_COMPRA_MENOS_VENDIDO", '/top3menos', 'GET', false, 4);

INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_ALL_DETALLE_ORDENES_SERVICIO", '', 'GET', false, 5);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_ONE_DETALLE_ORDEN_SERVICIO", '/[0-9]*', 'GET', false, 5);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("CREATE_ONE_DETALLE_ORDEN_SERVICIO", '', 'POST', false, 5);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("UPDATE_ONE_DETALLE_ORDEN_SERVICIO", '/[0-9]*', 'PUT', false, 5);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("DELETE_ONE_DETALLE_ORDEN_SERVICIO", '/[0-9]*', 'DELETE', false, 5);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_DETALLE_ORDEN_SERVICIO_ESTADO", '/estado/[0-9]*', 'GET', false, 5);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_DETALLE_ORDEN_SERVICIO_EMPLEADO", '/empleado/[0-9]*', 'GET', false, 5);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_DETALLE_ORDEN_SERVICIO_MAS_ORDENADO", '/mas', 'GET', false, 5);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_DETALLE_ORDEN_SERVICIO_MENOS_ORDENADO", '/menos', 'GET', false, 5);

INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_ALL_DETALLE_ORDENES_TRABAJO", '', 'GET', false, 6);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_ONE_DETALLE_ORDEN_TRABAJO", '/[0-9]*', 'GET', false, 6);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("CREATE_ONE_DETALLE_ORDEN_TRABAJO", '', 'POST', false, 6);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("UPDATE_ONE_DETALLE_ORDEN_TRABAJO", '/[0-9]*', 'PUT', false, 6);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("DELETE_ONE_DETALLE_ORDEN_TRABAJO", '/[0-9]*', 'DELETE', false, 6);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_DETALLE_ORDENES_TRABAJO_EMPLEADO", '/empleadoId/[0-9]*', 'GET', false, 6);

INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_ALL_DIRECCIONES", '', 'GET', false, 7);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_ONE_DIRECCION", '/[0-9]*', 'GET', false, 7);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("CREATE_ONE_DIRECCION", '', 'POST', false, 7);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("UPDATE_ONE_DIRECCION", '/[0-9]*', 'PUT', false, 7);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("DELETE_ONE_DIRECCION", '/[0-9]*', 'DELETE', false, 7);

INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_ALL_EMAIL_PERSONAS", '', 'GET', false, 8);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_ONE_EMAIL_PERSONA", '/[0-9]*', 'GET', false, 8);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("CREATE_ONE_EMAIL_PERSONA", '', 'POST', false, 8);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("UPDATE_ONE_EMAIL_PERSONA", '/[0-9]*', 'PUT', false, 8);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("DELETE_ONE_EMAIL_PERSONA", '/[0-9]*', 'DELETE', false, 8);

INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_ALL_EMPRESAS", '', 'GET', false, 9);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_ONE_EMPRESA", '/[0-9]*', 'GET', false, 9);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("CREATE_ONE_EMPRESA", '', 'POST', false, 9);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("UPDATE_ONE_EMPRESA", '/[0-9]*', 'PUT', false, 9);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("DELETE_ONE_EMPRESA", '/[0-9]*', 'DELETE', false, 9);

INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_ALL_EMPRESA_SERVICIO", '', 'GET', false, 10);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_ONE_EMPRESA_SERVICIO", '/[0-9]*/[0-9]*', 'GET', false, 10);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("CREATE_ONE_EMPRESA_SERVICIO", '', 'POST', false, 10);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("UPDATE_ONE_EMPRESA_SERVICIO", '/[0-9]*/[0-9]*', 'PUT', false, 10);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("DELETE_ONE_EMPRESA_SERVICIO", '/[0-9]*/[0-9]*', 'DELETE', false, 10);

INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_ALL_ESTADO_APROBACION", '', 'GET', false, 11);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_ONE_ESTADO_APROBACION", '/[0-9]*', 'GET', false, 11);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("CREATE_ONE_ESTADO_APROBACION", '', 'POST', false, 11);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("UPDATE_ONE_ESTADO_APROBACION", '/[0-9]*', 'PUT', false, 11);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("DELETE_ONE_ESTADO_APROBACION", '/[0-9]*', 'DELETE', false, 11);

INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_ALL_ESTADO_COMPRA", '', 'GET', false, 12);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_ONE_ESTADO_COMPRA", '/[0-9]*', 'GET', false, 12);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("CREATE_ONE_ESTADO_COMPRA", '', 'POST', false, 12);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("UPDATE_ONE_ESTADO_COMPRA", '/[0-9]*', 'PUT', false, 12);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("DELETE_ONE_ESTADO_COMPRA", '/[0-9]*', 'DELETE', false, 12);

INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_ALL_ESTADO_ORDEN", '', 'GET', false, 13);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_ONE_ESTADO_ORDEN", '/[0-9]*', 'GET', false, 13);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("CREATE_ONE_ESTADO_ORDEN", '', 'POST', false, 13);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("UPDATE_ONE_ESTADO_ORDEN", '/[0-9]*', 'PUT', false, 13);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("DELETE_ONE_ESTADO_ORDEN", '/[0-9]*', 'DELETE', false, 13);

INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_ALL_ESTADO_ORDEN_SERVICIO", '', 'GET', false, 14);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_ONE_ESTADO_ORDEN_SERVICIO", '/[0-9]*', 'GET', false, 14);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("CREATE_ONE_ESTADO_ORDEN_SERVICIO", '', 'POST', false, 14);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("UPDATE_ONE_ESTADO_ORDEN_SERVICIO", '/[0-9]*', 'PUT', false, 14);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("DELETE_ONE_ESTADO_ORDEN_SERVICIO", '/[0-9]*', 'DELETE', false, 14);

INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_ALL_INSUMO", '', 'GET', false, 15);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_ONE_INSUMO", '/[0-9]*', 'GET', false, 15);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("CREATE_ONE_INSUMO", '', 'POST', false, 15);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("UPDATE_ONE_INSUMO", '/[0-9]*', 'PUT', false, 15);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("DELETE_ONE_INSUMO", '/[0-9]*', 'DELETE', false, 15);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("INSUMO_VALIDAR_STOCK", '/validar-stock', 'POST', false, 15);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("INSUMO_ACTUALIZAR_STOCK", '/actualizar-stock', 'POST', false, 15);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("INSUMO_ACTUALIZAR_STOCK_PROVEEDOR", '/actualizar-stock-proveedor', 'POST', false, 15);

INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_ALL_LOGIN", '', 'GET', false, 16);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_ONE_LOGIN", '/[0-9]*', 'GET', false, 16);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("CREATE_ONE_LOGIN", '', 'POST', false, 16);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("UPDATE_ONE_LOGIN", '/[0-9]*', 'PUT', false, 16);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("DELETE_ONE_LOGIN", '/[0-9]*', 'DELETE', false, 16);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_LOGIN_USUARIO", '/usuario/[0-9]*', 'GET', false, 16);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_LOGIN_ROL", '/rol/[0-9]*', 'GET', false, 16);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("REGISTER_ONE_LOGIN", '/post', 'POST', true, 16);

INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_ALL_ORDEN_SERVICIO", '', 'GET', false, 17);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_ONE_ORDEN_SERVICIO", '/[0-9]*', 'GET', false, 17);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("CREATE_ONE_ORDEN_SERVICIO", '', 'POST', false, 17);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("UPDATE_ONE_ORDEN_SERVICIO", '/[0-9]*', 'PUT', false, 17);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("DELETE_ONE_ORDEN_SERVICIO", '/[0-9]*', 'DELETE', false, 17);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_ORDEN_SERVICIO_PERSONA", '/persona/[0-9]*', 'GET', false, 17);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("ADD_NEW_ORDEN_SERVICIO", '/agregar', 'POST', false, 17);

INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_ALL_ORDEN_TRABAJO", '', 'GET', false, 18);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_ONE_ORDEN_TRABAJO", '/[0-9]*', 'GET', false, 18);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("CREATE_ONE_ORDEN_TRABAJO", '', 'POST', false, 18);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("UPDATE_ONE_ORDEN_TRABAJO", '/[0-9]*', 'PUT', false, 18);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("DELETE_ONE_ORDEN_TRABAJO", '/[0-9]*', 'DELETE', false, 18);

INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_ALL_PAIS", '', 'GET', false, 19);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_ONE_PAIS", '/[0-9]*', 'GET', false, 19);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("CREATE_ONE_PAIS", '', 'POST', false, 19);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("UPDATE_ONE_PAIS", '/[0-9]*', 'PUT', false, 19);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("DELETE_ONE_PAIS", '/[0-9]*', 'DELETE', false, 19);

INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_ALL_PERSONA_INSUMO", '', 'GET', false, 20);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_ONE_PERSONA_INSUMO", '/[0-9]*/[0-9]*', 'GET', false, 20);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("CREATE_ONE_PERSONA_INSUMO", '', 'POST', false, 20);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("UPDATE_ONE_PERSONA_INSUMO", '/[0-9]*/[0-9]*', 'PUT', false, 20);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("DELETE_ONE_PERSONA_INSUMO", '/[0-9]*/[0-9]*', 'DELETE', false, 20);

INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_ALL_PERSONAS", '', 'GET', false, 21);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_ONE_PERSONAS", '/[0-9]*', 'GET', false, 21);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("CREATE_ONE_PERSONAS", '', 'POST', true, 21);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("UPDATE_ONE_PERSONAS", '/[0-9]*', 'PUT', false, 21);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("DELETE_ONE_PERSONAS", '/[0-9]*', 'DELETE', false, 21);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_PERSONAS_TELEFONO", '/personas/[0-9]*', 'GET', false, 21);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_PERSONAS_INVERSION", '/inversion', 'GET', false, 21);
 
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_ALL_REGION", '', 'GET', false, 22);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_ONE_REGION", '/[0-9]*', 'GET', false, 22);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("CREATE_ONE_REGION", '', 'POST', false, 22);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("UPDATE_ONE_REGION", '/[0-9]*', 'PUT', false, 22);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("DELETE_ONE_REGION", '/[0-9]*', 'DELETE', false, 22);

INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_ALL_ROL", '', 'GET', false, 23);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_ONE_ROL", '/[0-9]*', 'GET', false, 23);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("CREATE_ONE_ROL", '', 'POST', false, 23);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("UPDATE_ONE_ROINVERSIONL", '/[0-9]*', 'PUT', false, 23);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("DELETE_ONE_ROL", '/[0-9]*', 'DELETE', false, 23);

INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_ALL_SERVICIO", '', 'GET', false, 24);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_ONE_SERVICIO", '/[0-9]*', 'GET', false, 24);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("CREATE_ONE_SERVICIO", '', 'POST', false, 24);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("UPDATE_ONE_SERVICIO", '/[0-9]*', 'PUT', false, 24);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("DELETE_ONE_SERVICIO", '/[0-9]*', 'DELETE', false, 24);

INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_ALL_SERVICIO_INSUMO", '', 'GET', false, 25);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_ONE_SERVICIO_INSUMO", '/[0-9]*/[0-9]*', 'GET', false, 25);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("CREATE_ONE_SERVICIO_INSUMO", '', 'POST', false, 25);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("UPDATE_ONE_SERVICIO_INSUMO", '/[0-9]*/[0-9]*', 'PUT', false, 25);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("DELETE_ONE_SERVICIO_INSUMO", '/[0-9]*/[0-9]*', 'DELETE', false, 25);

INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_ALL_SUCURSAL", '', 'GET', false, 26);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_ONE_SUCURSAL", '/[0-9]*', 'GET', false, 26);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("CREATE_ONE_SUCURSAL", '', 'POST', false, 26);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("UPDATE_ONE_SUCURSAL", '/[0-9]*', 'PUT', false, 26);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("DELETE_ONE_SUCURSAL", '/[0-9]*', 'DELETE', false, 26);

INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_ALL_TEL_PERSONA", '', 'GET', false, 27);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_ONE_TEL_PERSONA", '/[0-9]*', 'GET', false, 27);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("CREATE_ONE_TEL_PERSONA", '', 'POST', false, 27);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("UPDATE_ONE_TEL_PERSONA", '/[0-9]*', 'PUT', false, 27);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("DELETE_ONE_TEL_PERSONA", '/[0-9]*', 'DELETE', false, 27);

INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_ALL_TEL_SUCURSAL", '', 'GET', false, 28);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_ONE_TEL_SUCURSAL", '/[0-9]*', 'GET', false, 28);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("CREATE_ONE_TEL_SUCURSAL", '', 'POST', false, 28);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("UPDATE_ONE_TEL_SUCURSAL", '/[0-9]*', 'PUT', false, 28);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("DELETE_ONE_TEL_SUCURSAL", '/[0-9]*', 'DELETE', false, 28);

INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_ALL_TIPO_COMPRA", '', 'GET', false, 29);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_ONE_TIPO_COMPRA", '/[0-9]*', 'GET', false, 29);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("CREATE_ONE_TIPO_COMPRA", '', 'POST', false, 29);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("UPDATE_ONE_TIPO_COMPRA", '/[0-9]*', 'PUT', false, 29);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("DELETE_ONE_TIPO_COMPRA", '/[0-9]*', 'DELETE', false, 29);

INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_ALL_TIPO_EMAIL", '', 'GET', false, 30);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_ONE_TIPO_EMAIL", '/[0-9]*', 'GET', false, 30);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("CREATE_ONE_TIPO_EMAIL", '', 'POST', false, 30);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("UPDATE_ONE_TIPO_EMAIL", '/[0-9]*', 'PUT', false, 30);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("DELETE_ONE_TIPO_EMAIL", '/[0-9]*', 'DELETE', false, 30);

INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_ALL_TIPO_EMPRESA", '', 'GET', false, 31);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_ONE_TIPO_EMPRESA", '/[0-9]*', 'GET', false, 31);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("CREATE_ONE_TIPO_EMPRESA", '', 'POST', false, 31);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("UPDATE_ONE_TIPO_EMPRESA", '/[0-9]*', 'PUT', false, 31);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("DELETE_ONE_TIPO_EMPRESA", '/[0-9]*', 'DELETE', false, 31);

INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_ALL_TIPO_PERSONA", '', 'GET', false, 32);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_ONE_TIPO_PERSONA", '/[0-9]*', 'GET', false, 32);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("CREATE_ONE_TIPO_PERSONA", '', 'POST', false, 32);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("UPDATE_ONE_TIPO_PERSONA", '/[0-9]*', 'PUT', false, 32);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("DELETE_ONE_TIPO_PERSONA", '/[0-9]*', 'DELETE', false, 32);

INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ('AUTHENTICATE','/authenticate', 'POST', true, 33);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ('VALIDATE-TOKEN','/validate-token', 'GET', true,33);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ('READ_MY_PROFILE','/profile','GET', false, 33);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ('LOGOUT','/logout', 'POST', true, 33);

INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_INSUMO_PERSONA", 'insumos/[0-9]*', 'GET', false, 20);

INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_ALL_TIPO_TELEFONO", '', 'GET', false, 34);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_ONE_TIPO_TELEFONO", '/[0-9]*', 'GET', false, 34);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("CREATE_ONE_TIPO_TELEFONO", '', 'POST', false, 34);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("UPDATE_ONE_TIPO_TELEFONO", '/[0-9]*', 'PUT', false, 34);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("DELETE_ONE_TIPO_TELEFONO", '/[0-9]*', 'DELETE', false, 34);

INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ('REFRESCAR_TOKEN','/refresh-token', 'POST', true, 33);

 -- rol admin

INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 1);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 2);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 3);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 4);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 5);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 6);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 7);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 8);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 9);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 10);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 11);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 12);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 13);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 14);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 15);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 16);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 17);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 18);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 19);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 20);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 21);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 22);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 23);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 24);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 25);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 26);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 27);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 28);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 29);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 30);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 31);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 32);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 33);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 34);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 35);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 36);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 37);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 38);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 39);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 40);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 41);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 42);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 43);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 44);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 45);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 46);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 47);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 48);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 49);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 50);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 51);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 52);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 53);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 54);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 55);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 56);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 57);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 58);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 59);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 60);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 61);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 62);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 63);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 64);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 65);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 66);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 67);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 68);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 69);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 70);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 71);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 72);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 73);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 74);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 75);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 76);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 77);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 78);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 79);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 80);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 81);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 82);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 83);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 84);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 85);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 86);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 87);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 88);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 89);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 90);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 91);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 92);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 93);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 94);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 95);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 96);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 97);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 98);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 99);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 100);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 101);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 102);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 103);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 104);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 105);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 106);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 107);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 108);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 109);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 110);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 111);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 112);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 113);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 114);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 115);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 116);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 117);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 118);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 119);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 120);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 121);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 122);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 123);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 124);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 125);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 126);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 127);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 128);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 129);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 130);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 131);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 132);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 133);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 134);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 135);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 136);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 137);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 138);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 139);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 140);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 141);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 142);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 143);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 144);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 145);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 146);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 147);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 148);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 149);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 150);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 151);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 152);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 153);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 154);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 155);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 156);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 157);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 158);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 159);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 160);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 161);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 162);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 163);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 164);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 165);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 166);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 167);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 168);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 169);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 170);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 171);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 172);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 173);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 174);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 175);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 176);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 177);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 178);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 179);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 180);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 181);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 182);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 183);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 184);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 185);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 186);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 187);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 188);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 189);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 190);
INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 191);

-- rol cliente

INSERT INTO granted_permission (role_id, operation_id) VALUES (2, 4);
INSERT INTO granted_permission (role_id, operation_id) VALUES (2, 6);
INSERT INTO granted_permission (role_id, operation_id) VALUES (2, 20);
INSERT INTO granted_permission (role_id, operation_id) VALUES (2, 21);
INSERT INTO granted_permission (role_id, operation_id) VALUES (2, 22);
INSERT INTO granted_permission (role_id, operation_id) VALUES (2, 30);
INSERT INTO granted_permission (role_id, operation_id) VALUES (2, 34);
INSERT INTO granted_permission (role_id, operation_id) VALUES (2, 88);
INSERT INTO granted_permission (role_id, operation_id) VALUES (2, 107);
INSERT INTO granted_permission (role_id, operation_id) VALUES (2, 109);
INSERT INTO granted_permission (role_id, operation_id) VALUES (2, 110);
INSERT INTO granted_permission (role_id, operation_id) VALUES (2, 143);
INSERT INTO granted_permission (role_id, operation_id) VALUES (2, 144);

-- rol jefe recursos humanos

INSERT INTO granted_permission (role_id, operation_id) VALUES (3, 38);
INSERT INTO granted_permission (role_id, operation_id) VALUES (3, 42);
INSERT INTO granted_permission (role_id, operation_id) VALUES (3, 98);
INSERT INTO granted_permission (role_id, operation_id) VALUES (3, 128);

-- rol jefe bodega

INSERT INTO granted_permission (role_id, operation_id) VALUES (4, 88);
INSERT INTO granted_permission (role_id, operation_id) VALUES (4, 90);
INSERT INTO granted_permission (role_id, operation_id) VALUES (4, 91);
INSERT INTO granted_permission (role_id, operation_id) VALUES (4, 102);

-- rol jefe inventario

INSERT INTO granted_permission (role_id, operation_id) VALUES (5, 88);
INSERT INTO granted_permission (role_id, operation_id) VALUES (5, 90);
INSERT INTO granted_permission (role_id, operation_id) VALUES (5, 91);
INSERT INTO granted_permission (role_id, operation_id) VALUES (5, 102);

-- rol marketing

INSERT INTO granted_permission (role_id, operation_id) VALUES (6, 31);
INSERT INTO granted_permission (role_id, operation_id) VALUES (6, 32);
INSERT INTO granted_permission (role_id, operation_id) VALUES (6, 40);
INSERT INTO granted_permission (role_id, operation_id) VALUES (6, 41);
INSERT INTO granted_permission (role_id, operation_id) VALUES (6, 131);
INSERT INTO granted_permission (role_id, operation_id) VALUES (6, 132)

-- rol jefe sistemas 

INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 1);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 2);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 3);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 4);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 5);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 6);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 7);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 8);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 9);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 10);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 11);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 12);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 13);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 14);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 15);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 16);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 17);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 18);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 19);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 20);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 21);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 22);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 23);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 24);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 25);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 26);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 27);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 28);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 29);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 30);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 31);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 32);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 33);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 34);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 35);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 36);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 37);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 38);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 39);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 40);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 41);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 42);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 43);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 44);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 45);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 46);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 47);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 48);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 49);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 50);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 51);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 52);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 53);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 54);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 55);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 56);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 57);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 58);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 59);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 60);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 61);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 62);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 63);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 64);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 65);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 66);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 67);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 68);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 69);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 70);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 71);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 72);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 73);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 74);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 75);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 76);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 77);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 78);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 79);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 80);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 81);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 82);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 83);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 84);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 85);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 86);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 87);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 88);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 89);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 90);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 91);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 92);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 93);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 94);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 95);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 96);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 97);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 98);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 99);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 100);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 101);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 102);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 103);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 104);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 105);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 106);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 107);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 108);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 109);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 110);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 111);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 112);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 113);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 114);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 115);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 116);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 117);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 118);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 119);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 120);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 121);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 122);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 123);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 124);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 125);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 126);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 127);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 128);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 129);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 130);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 131);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 132);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 133);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 134);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 135);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 136);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 137);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 138);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 139);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 140);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 141);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 142);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 143);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 144);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 145);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 146);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 147);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 148);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 149);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 150);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 151);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 152);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 153);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 154);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 155);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 156);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 157);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 158);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 159);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 160);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 161);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 162);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 163);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 164);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 165);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 166);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 167);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 168);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 169);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 170);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 171);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 172);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 173);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 174);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 175);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 176);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 177);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 178);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 179);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 180);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 181);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 182);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 183);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 184);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 185);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 186);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 187);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 188);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 189);
INSERT INTO granted_permission (role_id, operation_id) VALUES (7, 190);

-- rol gerente

INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 1);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 2);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 3);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 4);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 5);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 6);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 7);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 8);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 9);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 10);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 11);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 12);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 13);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 14);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 15);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 16);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 17);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 18);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 19);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 20);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 21);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 22);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 23);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 24);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 25);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 26);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 27);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 28);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 29);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 30);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 31);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 32);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 33);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 34);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 35);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 36);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 37);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 38);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 39);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 40);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 41);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 42);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 43);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 44);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 45);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 46);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 47);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 48);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 49);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 50);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 51);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 52);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 53);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 54);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 55);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 56);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 57);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 58);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 59);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 60);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 61);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 62);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 63);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 64);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 65);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 66);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 67);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 68);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 69);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 70);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 71);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 72);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 73);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 74);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 75);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 76);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 77);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 78);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 79);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 80);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 81);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 82);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 83);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 84);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 85);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 86);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 87);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 88);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 89);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 90);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 91);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 92);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 93);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 94);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 95);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 96);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 97);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 98);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 99);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 100);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 101);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 102);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 103);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 104);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 105);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 106);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 107);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 108);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 109);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 110);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 111);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 112);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 113);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 114);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 115);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 116);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 117);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 118);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 119);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 120);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 121);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 122);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 123);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 124);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 125);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 126);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 127);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 128);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 129);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 130);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 131);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 132);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 133);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 134);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 135);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 136);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 137);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 138);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 139);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 140);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 141);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 142);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 143);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 144);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 145);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 146);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 147);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 148);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 149);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 150);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 151);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 152);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 153);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 154);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 155);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 156);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 157);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 158);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 159);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 160);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 161);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 162);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 163);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 164);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 165);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 166);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 167);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 168);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 169);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 170);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 171);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 172);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 173);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 174);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 175);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 176);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 177);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 178);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 179);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 180);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 181);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 182);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 183);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 184);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 185);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 186);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 187);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 188);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 189);
INSERT INTO granted_permission (role_id, operation_id) VALUES (8, 190);

-- rol profesional

INSERT INTO granted_permission (role_id, operation_id) VALUES (9, 8);
INSERT INTO granted_permission (role_id, operation_id) VALUES (9, 9);
INSERT INTO granted_permission (role_id, operation_id) VALUES (9, 39);
INSERT INTO granted_permission (role_id, operation_id) VALUES (9, 47);

-- rol axiliar bodega

INSERT INTO granted_permission (role_id, operation_id) VALUES (10, 21);
INSERT INTO granted_permission (role_id, operation_id) VALUES (10, 22);
INSERT INTO granted_permission (role_id, operation_id) VALUES (10, 23);
INSERT INTO granted_permission (role_id, operation_id) VALUES (10, 24);
INSERT INTO granted_permission (role_id, operation_id) VALUES (10, 30);
INSERT INTO granted_permission (role_id, operation_id) VALUES (10, 89);
INSERT INTO granted_permission (role_id, operation_id) VALUES (10, 93);
INSERT INTO granted_permission (role_id, operation_id) VALUES (10, 94);

-- rol proveedor

INSERT INTO granted_permission (role_id, operation_id) VALUES (11, 20);
INSERT INTO granted_permission (role_id, operation_id) VALUES (11, 21);
INSERT INTO granted_permission (role_id, operation_id) VALUES (11, 24);
INSERT INTO granted_permission (role_id, operation_id) VALUES (11, 30);
INSERT INTO granted_permission (role_id, operation_id) VALUES (11, 95);
INSERT INTO granted_permission (role_id, operation_id) VALUES (11, 192);

-- rol jefe compra

INSERT INTO granted_permission (role_id, operation_id) VALUES (12, 88);
INSERT INTO granted_permission (role_id, operation_id) VALUES (12, 98);
INSERT INTO granted_permission (role_id, operation_id) VALUES (12, 102);
INSERT INTO granted_permission (role_id, operation_id) VALUES (12, 123);
INSERT INTO granted_permission (role_id, operation_id) VALUES (12, 128);
INSERT INTO granted_permission (role_id, operation_id) VALUES (12, 192);



INSERT INTO pais (nombre) VALUES ("Colombia");
INSERT INTO pais (nombre) VALUES ("Estados Unidos");
INSERT INTO pais (nombre) VALUES ("Mexico");

INSERT INTO  region (nombre,pais_id) VALUES ("Santander",1);
INSERT INTO  region (nombre,pais_id) VALUES ("Cundinamarca",1);
INSERT INTO  region (nombre,pais_id) VALUES ("Cesar",1);
INSERT INTO  region (nombre,pais_id) VALUES ("Norte de santander",1);

INSERT INTO ciudad (nombre,region_id) VALUES ("Bucaramanga",1);
INSERT INTO ciudad (nombre,region_id) VALUES ("Piedecuesta",1);
INSERT INTO ciudad (nombre,region_id) VALUES ("Cucuta",1);
INSERT INTO ciudad (nombre,region_id) VALUES ("Giron",1);

INSERT INTO tipo_empresa (descripcion) VALUES ("Publica");
INSERT INTO tipo_empresa (descripcion) VALUES ("Privada");

INSERT INTO empresa (id,nombre,tipo_empresa_id) VALUES (1289,"Electricos SA",2);
INSERT INTO empresa (id,nombre,tipo_empresa_id) VALUES (1267,"Plomeria a tu servicio",1);
INSERT INTO empresa (id,nombre,tipo_empresa_id) VALUES (1223,"Bellas artes",1);

INSERT INTO direccion (barrio,calle,carrera,descripcion,ciudad_id) VALUES ("Las mercedes","34","56b","Apt 203",1);
INSERT INTO direccion (barrio,calle,carrera,descripcion,ciudad_id) VALUES ("Altamira","52","3","local 19",2);
INSERT INTO direccion (barrio,calle,carrera,descripcion,ciudad_id) VALUES ("La Napolitana","16","6w","Edificio miraflores",3);

INSERT INTO sucursal (nit,nombre,direccion_id,empresa_id) VALUES (12423,"Tu servicio express",1,1289);
INSERT INTO sucursal (nit,nombre,direccion_id,empresa_id) VALUES (124235,"Destapa-Todo",2,1267);
INSERT INTO sucursal (nit,nombre,direccion_id,empresa_id) VALUES (12456,"Artina",3,1223);

INSERT INTO tipo_persona  (id,nombre) VALUES (1,"Admin")
INSERT INTO tipo_persona  (id,nombre) VALUES (2,"Cliente")
INSERT INTO tipo_persona  (nombre) VALUES ("Empleado")
INSERT INTO tipo_persona  (id,nombre) VALUES (7,"Jefe_sistemas")
INSERT INTO tipo_persona  (id,nombre) VALUES (8,"Gerente")
INSERT INTO tipo_persona  (id,nombre) VALUES (9,"Profesional")
INSERT INTO tipo_persona  (id,nombre) VALUES (11,"Proveedor")

INSERT INTO persona (nro_Doc,nombre, fecha_registro ,apellido,sucursal_id,tipo_persona_id) VALUES (1005539417,"Mauricio","2024-10-9","Diaz",1,1);
INSERT INTO persona (nro_Doc,nombre, fecha_registro ,apellido,sucursal_id,tipo_persona_id) VALUES (10255,"Karol","2024-10-9","Ramirez",2,8);
INSERT INTO persona (nro_Doc,nombre, fecha_registro ,apellido,sucursal_id,tipo_persona_id) VALUES (10266,"Laura","2024-10-9","Torres",3,7);
