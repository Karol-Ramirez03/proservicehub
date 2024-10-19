INSERT INTO pais(nombre) VALUES ('Argentina');


DELIMITER $$
DROP TRIGGER IF EXISTS actualizar_estado_servicio$$
CREATE TRIGGER actualizar_estado_servicio
BEFORE UPDATE ON orden_servicio
FOR EACH ROW
BEGIN
    DECLARE nueva_order_id INT;
    DECLARE id_empleado_asignado INT;
    DECLARE numeroSiguiente INT;
    DECLARE id_servicio_Asignado INT;

    IF NEW.id_empleado IS NOT NULL THEN
            SET NEW.estado_orden_servicio_id = 3;
            SET id_empleado_asignado = NEW.id_empleado;
            
            SELECT numero_orden_trabajo + 1 INTO numeroSiguiente
            FROM orden_Trabajo
            ORDER BY numero_orden_trabajo DESC
            LIMIT 1;

            SELECT id_servicio INTO id_servicio_Asignado
            FROM detalle_orden_servicio
            WHERE id_orden_servicio = NEW.numero_orden
            LIMIT 1;

            INSERT INTO orden_trabajo (numero_orden_trabajo, fecha_asignacion, hora_asignacion, id_empleado, numero_orden_servicio)
            VALUES (numeroSiguiente, NOW(), NOW(),id_empleado_asignado, NEW.numero_orden);

            SET nueva_order_id = LAST_INSERT_ID(); 


            INSERT INTO detalle_orden_trabajo (fecha, id_orden_trabajo, id_estado, id_servicio)
            VALUES(NULL, nueva_order_id, 1,id_servicio_Asignado);
            END IF;
END$$
DELIMITER ;


DROP PROCEDURE IF EXISTS addOrdenServicio;
DELIMITER $$
CREATE PROCEDURE addOrdenServicio(IN idCliente INT,IN idServicio INT)
BEGIN
	DECLARE nueva_orden_id INT;
    
    INSERT INTO orden_servicio(estado_orden_servicio_id,fecha_orden,id_empleado,id_cliente) VALUES(2,NOW(),null,idCliente);
    
    SET nueva_orden_id = LAST_INSERT_ID();
    
    INSERT INTO detalle_orden_servicio(valor_servicio,id_orden_servicio,id_servicio) VALUES(0,nueva_orden_id,idServicio);
    
END $$
DELIMITER ;


DELIMITER $$
DROP PROCEDURE IF EXISTS insertaprobacionservicio$$
CREATE PROCEDURE insertaprobacionservicio(
    IN id_trabajo INT,
    IN hallazgoap VARCHAR(200),
    IN solucionap VARCHAR(200)
)
BEGIN
    DECLARE id_cliente_aprob INT;
    DECLARE id_servicio_aprob INT;
    DECLARE id_orden_servicio_aprob INT;

    SELECT id_servicio INTO id_servicio_aprob
    FROM detalle_orden_trabajo
    WHERE id_orden_trabajo = id_trabajo
    LIMIT 1;

    SELECT numero_orden_servicio INTO id_orden_servicio_aprob
    FROM orden_trabajo
    WHERE id = id_trabajo;

    SELECT id_cliente INTO id_cliente_aprob
    FROM orden_servicio
    WHERE numero_orden = id_orden_servicio_aprob;

    INSERT INTO aprovacion_servicio(estado_aprobacion_id, id_cliente, id_orden_trabajo,id_servicio,hallazgo,solucion)
    VALUES (1,id_cliente_aprob,id_trabajo,id_servicio_aprob,hallazgoap,solucionap);


END$$
DELIMITER ;


SELECT * FROM orden_Trabajo;
SELECT * FROM aprovacion_servicio;

CALL insert_aprobacion_servicio(1,"cambiar de tuberias", "tuberias viejas");