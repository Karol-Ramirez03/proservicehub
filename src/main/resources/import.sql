-- INSERT INTO module (name,base_path) VALUES ("persona","/api/personas");
-- INSERT INTO module (name,base_path) VALUES ("compra","/api/compra");
-- INSERT INTO module (name,base_path) VALUES ("Ciudad","/api/ciudad");
-- INSERT INTO module (name,base_path) VALUES ("DetalleCompra","/api/detalleCompra");
-- INSERT INTO module (name,base_path) VALUES ("Direccion","/api/direccion");
-- INSERT INTO module (name, base_path) VALUES ('AUTH', '/auth');


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
