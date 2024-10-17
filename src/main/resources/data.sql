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
