![](/home/camper/Documentos/mauricio/proservicehub/src/main/resources/img/image.webp)





# PrestService



La empresa PrestService, con presencia en varias sucursales a nivel nacional, está buscando desarrollar un sistema integral que centralice y optimice la gestión de todas sus operaciones clave. Este sistema debe permitir la administración eficiente de todos los aspectos relacionados con la empresa, tales como la gestión de sucursales, servicios ofrecidos, personal, inventario de insumos, órdenes de trabajo y procesos de control de calidad. El sistema también debe facilitar la coordinación entre las distintas sucursales, garantizando la visibilidad y el control en tiempo real de los recursos disponibles, así como el seguimiento del estado de cada orden de trabajo o solicitud de servicio. Además, uno de los componentes fundamentales será un sistema de aprobación, que garantizará que todos los servicios prestados cumplan con los estándares de calidad establecidos antes de ser aprobados y finalizados. De esta manera, PrestService busca mejorar la eficiencia operativa, reducir costos, incrementar la satisfacción del cliente y garantizar la uniformidad y calidad de los servicios en todas sus sucursales.



**Requisitos del sistema:**



- **Gestión de Empresa y Sucursales:**
- El sistema debe permitir la creación y gestión de múltiples sucursales. Cada sucursal contará con información como su nombre, NIT, fecha de creación, y estará asociada a una ciudad, región y país.
- La empresa principal y cada sucursal estarán categorizadas por un tipo de empresa, lo que permitirá diferenciar su estructura.



- **Gestión de Personal:**
- El sistema gestionará la información del personal, que incluirá nombres, apellidos, número de documento, fecha de registro, tipo de persona (empleado, contratista, etc.) y la sucursal a la que pertenece.
- Se almacenará el contacto del personal, como números de teléfono (con el tipo de teléfono) y correos electrónicos (con tipo de email).



- **Gestión de Insumos:**
- El sistema deberá administrar un catálogo de insumos, que incluirá un código interno, nombre y clasificación del insumo.
- Para cada servicio que requiera insumos, se debe registrar el insumo utilizado, el valor unitario del insumo, el stock disponible, el stock mínimo y el stock máximo permitido, permitiendo un control preciso de los inventarios.



- **Gestión de Servicios e Insumos:**
- Los servicios ofrecidos tendrán un nombre, el tiempo de ejecución, y se especificará si requieren insumos (T/F).
- Se mantendrá un registro de los insumos necesarios para cada servicio, especificando el valor unitario de cada insumo.



- **Gestión de Órdenes de Servicio y Trabajo:**
- El sistema permitirá la creación de **Órdenes de Servicio**, que incluirán el número de la orden, la fecha de creación, el cliente asociado, el empleado responsable y el estado de la orden (pendiente, en proceso, finalizada, etc.).
- Además, se gestionarán **Órdenes de Trabajo**, que incluirán detalles como la fecha y hora de asignación de la orden a un empleado específico, vinculado a la orden de servicio correspondiente y a los servicios asignados en dicha orden.
- Los detalles de la orden de trabajo especificarán los servicios asignados y su estado.



- **Gestión de Estados de Servicio y Trabajo:**
- El sistema permitirá gestionar los distintos estados tanto de las órdenes de trabajo como de los servicios asociados a estas órdenes. Los estados de servicio ayudarán a controlar el progreso de cada orden (por ejemplo: asignado, en proceso, completado).



- **Aprobación de Servicios:**
- Para garantizar la calidad de los servicios prestados, el sistema manejará un proceso de **Aprobación de Servicios**, donde se verifique la correcta ejecución de los servicios mediante la observación de hallazgos y soluciones implementadas.
- Cada aprobación de servicio estará asociada a una orden de servicio, a un cliente, y tendrá un estado de aprobación (aprobado, rechazado, en espera, etc.).



- **Integración de Detalles de Órdenes y Aprobaciones:**
- Cada **Detalle de Orden de Trabajo** reflejará el servicio prestado, el estado de la orden y los servicios específicos asignados.
- Los **Estados de Aprobación** estarán vinculados a la calidad del servicio prestado, permitiendo un control completo del proceso de verificación y aprobación.



Este sistema permitirá a **PrestService** gestionar de manera eficiente los servicios prestados, insumos utilizados, personal asignado, órdenes de trabajo y la calidad del servicio mediante un proceso de aprobación formal. Además, ofrecerá una trazabilidad completa desde la solicitud del servicio hasta su finalización y aprobación, mejorando el control de la empresa y la satisfacción del cliente.



# **Historias de Usuario**

​		**Como**: Administrador

​		**Quiero**: Que el sistema tenga una página de login.

​		**Para**: Que los usuarios no autorizados no puedan ingresar a visualizar la información.



​		**Como**: Jefe de Bodega

​		**Quiero**: Tener una interfaz de registro.

​		**Para**: Poder registrar los insumos que la compañía utiliza para ejecutar los servicios.



​		**Como**: Cliente

​		**Quiero**: Tener una interfaz de registro

​		**Para**: Poder darme de alta en la aplicación y solicitar los servicios especializados.



​		**Como**: Administrador/Gerente

​		**Quiero**: Que el personal de seguimiento de servicios pueda verificar los servicios que no han sido asignados.



​		**Como**: Administrador/Gerente

​		**Quiero**: Que el personal de recursos humanos pueda generar órdenes de trabajo, servicios y responsables de cada 	

​		servicio.



​		**Como**: Jefe de Inventario

​		**Quiero**: Que los auxiliares de bodega puedan llevar el control de los pedidos, compras de los insumos usados en 

​		cada servicio.



​		**Como**: Jefe de Recursos Humanos

​		**Quiero**: Poder registrar a todos los empleados que pertenecen a una sucursal específica.



​		**Como**: Jefe de Marketing

​		**Quiero**: Poder visualizar los datos del cliente para poder crear campañas de fidelización.



​		**Como**: Jefe de Bodega

​		**Quiero**: Ver la información de todos los proveedores.



​		**Como**: Jefe de Compras

​		**Quiero**: Visualizar los insumos y proveedores a los que se les han comprado cada insumo.



​		**Como**: Gerente

​		**Quiero**: Que todos los profesionales que prestan los servicios puedan registrarse.



​		**Como**: Profesional de Servicios

​		**Quiero**: Poder visualizar las órdenes y servicios que me han asignado.



​		**Como**: Gerente

​		**Quiero**: Que el área encargada pueda llevar el control y seguimiento de todas las órdenes de trabajo.



​		**Como**: Gerente

​		**Quiero**: Que mis proveedores puedan ver los pedidos que se encuentran en solicitud.



​		**Como**: Gerente

​		**Quiero**: Que los clientes puedan comprar insumos sin necesidad de solicitar un servicio. El cliente debe estar 	

​		registrado.



​		**Como**: Gerente

​		**Quiero**: Que el personal de bodega pueda verificar los pedidos realizados por los clientes y efectuar el despacho.



​		**Como**: Cliente

​		**Deseo**: Poder cancelar la orden de pedido que no ha sido enviada o despachada y poder escribir el motivo de 	

​		cancelación.



​		**Como**: Profesional

​		**Quiero**: Poder solicitar al cliente la aprobación de una reparación a partir de unos hallazgos encontrados.



​		**Como**: Profesional

​		**Deseo**: Poder visualizar las solicitudes de aprobación realizadas por los clientes dueños de la solicitud. El profesional 

​		debe estar logueado.



​		**Como**: Jefe de Sistemas

​		**Quiero**: Que los usuarios responsables puedan alimentar todas las tablas de la base de datos.



​		**Como**: Jefe de Sistemas

​		**Quiero**: Que los datos sean validados antes de ser insertados en la base de datos.
