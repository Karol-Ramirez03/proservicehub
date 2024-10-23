INSERT INTO module (name,base_path) VALUES ("AprobacionServicio","/api/aprobacionservicio");
INSERT INTO module (name,base_path) VALUES ("Ciudad","/api/ciudad");
INSERT INTO module (name,base_path) VALUES ("Compra","/api/compra");
INSERT INTO module (name,base_path) VALUES ("DetalleCompra","/api/detalleCompra");
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
INSERT INTO module (name,base_path) VALUES ("Tipotelefono","/api/tipotelefono");
INSERT INTO module (name,base_path) VALUES ('AUTH', '/auth');


-- INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_ALL_PERSONAS", '', 'GET', false, 1);
-- INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("READ_ONE_PERSONAS", '', 'GET', false, 1);
-- INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("CREATE_ONE_PERSONAS", '', 'POST', true, 1);
-- INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("UPDATE_ONE_PERSONAS", '/[0-9]*', 'PUT', false, 1);
-- INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ("DISABLE_ONE_PERSONAS", '/[0-9]*/disable', 'PUT', false, 1);

-- INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ('AUTHENTICATE','/authenticate', 'POST', true, 6);
-- INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ('VALIDATE-TOKEN','/validate-token', 'GET', true,6);
-- INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ('READ_MY_PROFILE','/profile','GET', false, 6);

-- INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 1);
-- INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 2);
-- INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 3);
-- INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 4);
-- INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 5);

-- INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 6);
-- INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 7);
-- INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 8);

-- INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 2);
-- INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 3);
-- INSERT INTO granted_permission (role_id, operation_id) VALUES (1, 4);
