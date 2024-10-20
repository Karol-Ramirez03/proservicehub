import { initDynamicPanel } from "./prueba";
import { initDynamicTable } from "./prueba";

// initDynamicPanel({
//     buttonText: '+ Registrar Insumo',
//     panelTitle: 'Agregar Nuevo Insumo',
//     submitButtonText: 'Registrar Insumo',
//     apiUrl: 'http://localhost:8080/api/insumo',
//     fields: [
//         { label: 'Código Interno', id: 'codigoInterno', type: 'text', apiKey: 'codigo_interno' },
//         { label: 'Nombre', id: 'nombre', type: 'text', apiKey: 'nombre' },
//         { label: 'Precio', id: 'productPrice', type: 'number', apiKey: 'precio_unitario' },
//         { label: 'Stock', id: 'stock', type: 'number', apiKey: 'stock' },
//         { label: 'Stock Mínimo', id: 'stockMinimo', type: 'number', apiKey: 'stock_minimo' },
//         { label: 'Stock Máximo', id: 'stockMaximo', type: 'number', apiKey: 'stock_maximo' }
//     ]
////falta servicioinsumo-personainsumo-detallecompras
// });

// initDynamicPanel({
//     buttonText: '+ Registrar Producto',
//     panelTitle: 'Agregar Nuevo Producto',
//     submitButtonText: 'Registrar Producto',
//     apiUrl: 'http://localhost:8080/api/producto',
//     fields: [
//         { label: 'ID Producto', id: 'idProducto', type: 'text', apiKey: 'id_producto' },
//         { label: 'Descripción', id: 'descripcion', type: 'text', apiKey: 'descripcion' },
//         { label: 'Precio', id: 'precioProducto', type: 'number', apiKey: 'precio' }
//     ]
// });

// initDynamicPanel({
//     buttonText: '+ Registrar Rol',
//     panelTitle: 'Agregar Nuevo Rol',
//     submitButtonText: 'Registrar Rol',
//     apiUrl: 'http://localhost:8080/api/rol',
//     fields: [
//         { label: 'Id', id: 'id', type: 'number', apiKey: 'id' },
//         { label: 'Nombre', id: 'nombre', type: 'text', apiKey: 'nombre' }
//     ]
// });

// initDynamicPanel({
//     buttonText: '+ Registrar Personas',
//     panelTitle: 'Agregar Nuevo Personas',
//     submitButtonText: 'Registrar Personas',
//     apiUrl: 'http://localhost:8080/api/personas',
//     fields: [
//         { label: 'Numero Documento', id: 'numerodocumento', type: 'number', apiKey: ' Nro_Doc' },
//         { label: 'Nombre', id: 'nombre', type: 'text', apiKey: 'nombre' },
//         { label: 'Apellido', id: 'apellido', type: 'text', apiKey: 'apellido' },
//         { label: 'Fecha Registro', id: 'fechaRegistro', type: 'date', apiKey: 'fechaRegistro' },
//             { label: 'Sucursal', id: 'sucursal', type: 'select', apiKey: 'sucursal', 
//               options: [
//                 { value: 'sucursal1', label: 'Sucursal 1' },
//                 { value: 'sucursal2', label: 'Sucursal 2' }
//               ],
//               required: true, validationMessage: 'Debe seleccionar una sucursal'
//             },
//             { label: 'Tipo de Persona', id: 'tipoPersona', type: 'select', apiKey: 'tipoPersona', 
//               options: [
//                 { value: 'natural', label: 'Natural' },
//                 { value: 'juridico', label: 'Juridico' }
//               ],
//               required: true, validationMessage: 'Debe seleccionar un tipo de persona'
//             }

//     ]
// });

// initDynamicPanel({
//     buttonText: '+ Registrar Ciudad',
//     panelTitle: 'Agregar Nueva Ciudad',
//     submitButtonText: 'Registrar Ciudad',
//     apiUrl: 'http://localhost:8080/api/ciudad',
//     fields: [
//         { label: 'Id', id: 'id', type: 'number', apiKey: ' id' },
//         { label: 'Nombre', id: 'nombre', type: 'text', apiKey: 'nombre' },
//         { label: 'Region', id: 'region', type: 'text', apiKey: 'region' }
//     ]
// });

// initDynamicPanel({
//     buttonText: '+ Registrar Compra',
//     panelTitle: 'Agregar Nueva Compra',
//     submitButtonText: 'Registrar Compra',
//     apiUrl: 'http://localhost:8080/api/compra',
//     fields: [
//         { label: 'Id', id: 'id', type: 'number', apiKey: ' id' },
//         { label: 'Fecha Compra', id: 'fechacompra', type: 'date', apiKey: 'fecha_compra' },
//         { label: 'Total', id: 'total', type: 'number', apiKey: 'total', required: true, validationMessage: 'No puede estar vacio' },
//         { label: 'Estado Compra', id: 'estadoCompra', type: 'select', apiKey: 'estado_compra', 
//            options: [
//                { value: 'ejecutado', label: 'Ejecutado' },
//                { value: 'pendiente', label: 'Pendiente' },
//                { value: 'cancelado', label: 'Cancelado' },
//                { value: 'rechazado', label: 'Rechazado' }
//             ]
//         },
//         { label: 'Cliente', id: 'personas', type: 'select', apiKey: 'personas', 
//           options: [
            
//             { value: 'persona1', label: 'Persona 1' },
//             { value: 'persona2', label: 'Persona 2' }
//           ],
//           required: true, validationMessage: 'Debe seleccionar un cliente'
//         }
        
        
//     ]
// });

// initDynamicPanel({
//         buttonText: '+ Registrar Detalle compra',
//         panelTitle: 'Agregar Nueva Detalle compra',
//         submitButtonText: 'Registrar Detalle compra',
//         apiUrl: 'http://localhost:8080/api/detalle_compra',
//         fields: [
//             { label: 'Cantidad', id: 'cantidad', type: 'number', apiKey: 'cantidad', required: true, validationMessage: 'La cantidad no puede estar vacía' },
//             { label: 'Precio Unitario', id: 'precio_unitario', type: 'number', apiKey: 'precio_unitario', required: true, validationMessage: 'El precio unitario no puede estar vacío' },
//             { label: 'Insumo', id: 'insumo', type: 'select', apiKey: 'insumo', 
//                 options: [ 
//                   // Aquí se agregarían las opciones de insumos disponibbles o se pueden hacer dinamicas
//                   { value: 'insumo1', label: 'Insumo 1' },
//                   { value: 'insumo2', label: 'Insumo 2' }
//                 ]
//               },
//               { label: 'Compra', id: 'compra', type: 'select', apiKey: 'compra', 
//                 options: [
//                   // Opciones de compra pero no se como mostrar la op
//                   { value: 'compra1', label: 'Compra 1' },
//                   { value: 'compra2', label: 'Compra 2' }
//                 ]
//               }
//         ]
//     });
    
// initDynamicPanel({
//         buttonText: '+ Registrar Detalle Orden Servicio',
//         panelTitle: 'Agregar Nuevo Detalle Orden Servicio',
//         submitButtonText: 'Registrar Detalle Orden Servicio',
//         apiUrl: 'http://localhost:8080/api/detalle_orden_servicio',
//         fields: [
//           { label: 'Id', id: 'id', type: 'number', apiKey: 'id', required: true, validationMessage: 'El ID no puede estar vacío' },
//           { label: 'Valor del Servicio', id: 'valor_servicio', type: 'number', apiKey: 'valor_servicio', required: true, validationMessage: 'El valor del servicio no puede estar vacío' },
//           { label: 'Orden de Servicio', id: 'id_orden_servicio', type: 'select', apiKey: 'id_orden_servicio', 
//             options: [
//               { value: 'orden1', label: 'Orden 1' },
//               { value: 'orden2', label: 'Orden 2' }
//             ],
//             required: true, validationMessage: 'Debe seleccionar una orden de servicio'
//           },
//           { label: 'Servicio', id: 'servicio', type: 'select', apiKey: 'servicio', 
//             options: [
//               { value: 'reparacion electrica', label: 'Reparacion electrica' },
//               { value: 'estudio de consumo', label: 'Estudio de consumo' },
//               { value: 'pancarta', label: 'Pancarta' },
//               { value: 'cambio transformador', label: 'Cambio transformador' }
//             ],
//             required: true, validationMessage: 'Debe seleccionar un servicio'
//           }
          
//         ]
// });

// initDynamicPanel({
//         buttonText: '+ Registrar Detalle Orden Trabajo',
//         panelTitle: 'Agregar Nuevo Detalle Orden Trabajo',
//         submitButtonText: 'Registrar Detalle Orden Trabajo',
//         apiUrl: 'http://localhost:8080/api/detalle_orden_trabajo',
//         fields: [
//           { label: 'Id', id: 'id', type: 'number', apiKey: 'id', required: true, validationMessage: 'El ID no puede estar vacío' },
//           { label: 'Fecha', id: 'fecha', type: 'date', apiKey: 'fecha', required: true, validationMessage: 'La fecha no puede estar vacía' },
//           { label: 'Orden de Trabajo', id: 'orden_trabajo', type: 'select', apiKey: 'orden_trabajo', 
//             options: [
//               { value: 'ordenTrabajo1', label: 'Orden de Trabajo 1' },
//               { value: 'ordenTrabajo2', label: 'Orden de Trabajo 2' }
//             ],
//             required: true, validationMessage: 'Debe seleccionar una orden de trabajo'
//           },
//           { label: 'Estado de Orden', id: 'estado_orden', type: 'select', apiKey: 'estado_orden', 
//             options: [
//               { value: 'ejecutado', label: 'Ejecutado' },
//               { value: 'pendiente asignacion', label: 'Pendiente asignacion' },
//               { value: 'en proceso', label: 'En proceso' },
//               { value: 'Cancelado', label: 'Cancelado' },
//               { value: 'rechazado', label: 'Rechazado' }
//             ],
//             required: true, validationMessage: 'Debe seleccionar un estado de orden'
//           },
//           { label: 'Servicio', id: 'servicio', type: 'select', apiKey: 'servicio', 
//             options: [
//               { value: 'reparacion electrica', label: 'Reparacion electrica' },
//               { value: 'estudio de consumo', label: 'Estudio de consumo' },
//               { value: 'pancarta', label: 'Pancarta' },
//               { value: 'cambio transformador', label: 'Cambio transformador' }
//             ],
//             required: true, validationMessage: 'Debe seleccionar un servicio'
//           }
          

//         ]
// });

// initDynamicPanel({
//         buttonText: '+ Registrar Direccion  ',
//         panelTitle: 'Agregar Nuevo Direccion  ',
//         submitButtonText: 'Registrar Direccion  ',
//         apiUrl: 'http://localhost:8080/api/direccion',
//         fields: [          
//             { label: 'Calle', id: 'calle', type: 'text', apiKey: 'calle', required: true, validationMessage: 'La calle no puede estar vacía y debe tener entre 1 y 100 caracteres' },
//             { label: 'Carrera', id: 'carrera', type: 'text', apiKey: 'carrera', validationMessage: 'Este campo es opcional' },
//             { label: 'Descripción', id: 'descripcion', type: 'text', apiKey: 'descripcion', validationMessage: 'Este campo es opcional' },
//             { label: 'Barrio', id: 'barrio', type: 'text', apiKey: 'barrio', validationMessage: 'Este campo es opcional' },
//             { label: 'Ciudad', id: 'ciudad', type: 'select', apiKey: 'ciudad', validationMessage: 'Este campo es opcional' }

//         ]
// });

// initDynamicPanel({
//         buttonText: '+ Registrar Email Persona  ',
//         panelTitle: 'Agregar Nuevo Email Persona ',
//         submitButtonText: 'Registrar Email Persona ',
//         apiUrl: 'http://localhost:8080/api/email_persona',
//         fields: [          
//           { label: 'Id', id: 'id', type: 'number', apiKey: 'id', required: true, validationMessage: 'El ID no puede estar vacío' },
//           { label: 'Email', id: 'email', type: 'email', apiKey: 'email', required: true, validationMessage: 'El email no puede estar vacío y debe ser válido' },
//           { label: 'Persona', id: 'personas', type: 'select', apiKey: 'personas' },
//           { label: 'Tipo de Email', id: 'tipoEmail', type: 'select', apiKey: 'tipoEmail', 
//             options: [
//               { value: 'profesional', label: 'Profesional' },
//               { value: 'personal', label: 'Personal' },
//               { value: 'educativo', label: 'Educativo' }
//             ]
//           }
// ///el tema de q muestre los selects
//         ]
// });

// initDynamicPanel({
//         buttonText: '+ Registrar Empresa  ',
//         panelTitle: 'Agregar Nueva Empresa ',
//         submitButtonText: 'Registrar Empresa ',
//         apiUrl: 'http://localhost:8080/api/empresa',
//         fields: [          
//           { label: 'Id', id: 'id', type: 'number', apiKey: 'id', required: true, validationMessage: 'El ID no puede estar vacío' },
//           { label: 'Nombre', id: 'nombre', type: 'text', apiKey: 'nombre', required: true, validationMessage: 'El nombre no puede estar vacío y debe tener entre 1 y 100 caracteres' },
//           { label: 'Tipo de Empresa', id: 'tipo_empresa', type: 'select', apiKey: 'tipo_empresa', 
//             options: [
//               { value: 'publica', label: 'Publica' },
//               { value: 'privada', label: 'Privada' },
//               { value: 'guvernamental', label: 'Guvernamental' },
//               { value: 'Internacional', label: 'Internacional' }
//             ],
//             required: true, validationMessage: 'El tipo de empresa no puede estar vacío'
//           }
     
//         ]
// });



































































/////////////////////////////////////////////////////////////////////////////////////
// initDynamicTable({
//     apiUrl: 'http://localhost:8080/api/insumo',
//     fields: [
//         { label: 'ID', id: 'id', type: 'text', apiKey: 'id' },
//         { label: 'Nombre', id: 'nombre', type: 'text', apiKey: 'nombre' },
//         { label: 'Código Interno', id: 'codigo', type: 'text', apiKey: 'codigo_interno' },
//         { label: 'Precio', id: 'precio', type: 'number', apiKey: 'precio_unitario' },
//         { label: 'Stock', id: 'stock', type: 'number', apiKey: 'stock' },
//         { label: 'Min Stock', id: 'stockMinimo', type: 'number', apiKey: 'stock_minimo' },
//         { label: 'Max Stock', id: 'stockMaximo', type: 'number', apiKey: 'stock_maximo' }
//     ]
// });

// initDynamicTable({
//     apiUrl: 'http://localhost:8080/api/producto',
//     fields: [
//         { label: 'ID Producto', id: 'idProducto', type: 'text', apiKey: 'id_producto' },
//         { label: 'Descripción', id: 'descripcion', type: 'text', apiKey: 'descripcion' },
//         { label: 'Precio', id: 'precioProducto', type: 'number', apiKey: 'precio' }
//     ]
// });

// initDynamicTable({
//     apiUrl: 'http://localhost:8080/api/rol',
//     fields: [
//         { label: 'Id', id: 'id', type: 'number', apiKey: 'id' },
//         { label: 'Nombre', id: 'nombre', type: 'text', apiKey: 'nombre' }
//     ]
// });

// initDynamicTable({
//     apiUrl: 'http://localhost:8080/api/personas',
//     fields: [
//       { label: 'Numero Documento', id: 'numerodocumento', type: 'number', apiKey: ' Nro_Doc' },
//       { label: 'Nombre', id: 'nombre', type: 'text', apiKey: 'nombre' },
//       { label: 'Apellido', id: 'apellido', type: 'text', apiKey: 'apellido' },
//       { label: 'Fecha Registro', id: 'fechaRegistro', type: 'date', apiKey: 'fechaRegistro' },
//       { label: 'Sucursal', id: 'sucursal', type: 'select', apiKey: 'sucursal', 
//             options: [
//               { value: 'sucursal1', label: 'Sucursal 1' },
//               { value: 'sucursal2', label: 'Sucursal 2' }
//             ],
//             required: true, validationMessage: 'Debe seleccionar una sucursal'
//           },
//       { label: 'Tipo de Persona', id: 'tipoPersona', type: 'select', apiKey: 'tipoPersona', 
//             options: [
//               { value: 'natural', label: 'Natural' },
//               { value: 'juridico', label: 'Juridico' }
//             ],
//             required: true, validationMessage: 'Debe seleccionar un tipo de persona'
//           }
//     ]
// });

// initDynamicTable({
//     apiUrl: 'http://localhost:8080/api/ciudad',
//     fields: [
//         { label: 'Id', id: 'id', type: 'number', apiKey: ' id' },
//         { label: 'Nombre', id: 'nombre', type: 'text', apiKey: 'nombre' },
//         { label: 'Region', id: 'region', type: 'text', apiKey: 'region' }
//     ]
// });

// initDynamicTable({
//     apiUrl: 'http://localhost:8080/api/compra',
//     fields: [
//       { label: 'Id', id: 'id', type: 'number', apiKey: ' id' },
//       { label: 'Fecha Compra', id: 'fechacompra', type: 'date', apiKey: 'fecha_compra' },
//       { label: 'Total', id: 'total', type: 'number', apiKey: 'total', required: true, validationMessage: 'No puede estar vacio' },
//       { label: 'Estado Compra', id: 'estadoCompra', type: 'select', apiKey: 'estado_compra', 
//          options: [
//              { value: 'ejecutado', label: 'Ejecutado' },
//              { value: 'pendiente', label: 'Pendiente' },
//              { value: 'cancelado', label: 'Cancelado' },
//              { value: 'rechazado', label: 'Rechazado' }
//           ]
//       },
//       { label: 'Cliente', id: 'personas', type: 'select', apiKey: 'personas', 
//         options: [
          
//           { value: 'persona1', label: 'Persona 1' },
//           { value: 'persona2', label: 'Persona 2' }
//         ],
//         required: true, validationMessage: 'Debe seleccionar un cliente'
//       }
      
//     ]
// });

// initDynamicTable({
//     apiUrl: 'http://localhost:8080/api/detalle_compra',
//     fields: [
//         { label: 'Cantidad', id: 'cantidad', type: 'number', apiKey: 'cantidad', required: true, validationMessage: 'La cantidad no puede estar vacía' },
//         { label: 'Precio Unitario', id: 'precio_unitario', type: 'number', apiKey: 'precio_unitario', required: true, validationMessage: 'El precio unitario no puede estar vacío' },
//         { label: 'Insumo', id: 'insumo', type: 'select', apiKey: 'insumo', 
//             options: [ 
//               // Aquí se agregarían las opciones de insumos disponibbles o se pueden hacer dinamicas
//               { value: 'insumo1', label: 'Insumo 1' },
//               { value: 'insumo2', label: 'Insumo 2' }
//             ]
//           },
//           { label: 'Compra', id: 'compra', type: 'select', apiKey: 'compra', 
//             options: [
//               // Opciones de compra pero no se como mostrar la op
//               { value: 'compra1', label: 'Compra 1' },
//               { value: 'compra2', label: 'Compra 2' }
//             ]
//           }    ]
// });

// initDynamicTable({
//     apiUrl: 'http://localhost:8080/api/detalle_orden_servicio',
//     fields: [
//       { label: 'Id', id: 'id', type: 'number', apiKey: 'id', required: true, validationMessage: 'El ID no puede estar vacío' },
//       { label: 'Valor del Servicio', id: 'valor_servicio', type: 'number', apiKey: 'valor_servicio', required: true, validationMessage: 'El valor del servicio no puede estar vacío' },
//       { label: 'Orden de Servicio', id: 'id_orden_servicio', type: 'select', apiKey: 'id_orden_servicio', 
//         options: [
//           { value: 'orden1', label: 'Orden 1' },
//           { value: 'orden2', label: 'Orden 2' }
//         ],
//         required: true, validationMessage: 'Debe seleccionar una orden de servicio'
//       },
//       { label: 'Servicio', id: 'servicio', type: 'select', apiKey: 'servicio', 
//         options: [
//           { value: 'reparacion electrica', label: 'Reparacion electrica' },
//           { value: 'estudio de consumo', label: 'Estudio de consumo' },
//           { value: 'pancarta', label: 'Pancarta' },
//           { value: 'cambio transformador', label: 'Cambio transformador' }
//         ],
//         required: true, validationMessage: 'Debe seleccionar un servicio'
//       }
//     ]
// });

// initDynamicTable({
//     apiUrl: 'http://localhost:8080/api/detalle_orden_trabajo',
//     fields: [
//       { label: 'Id', id: 'id', type: 'number', apiKey: 'id', required: true, validationMessage: 'El ID no puede estar vacío' },
//       { label: 'Fecha', id: 'fecha', type: 'date', apiKey: 'fecha', required: true, validationMessage: 'La fecha no puede estar vacía' },
//       { label: 'Orden de Trabajo', id: 'orden_trabajo', type: 'select', apiKey: 'orden_trabajo', 
//         options: [
//           { value: 'ordenTrabajo1', label: 'Orden de Trabajo 1' },
//           { value: 'ordenTrabajo2', label: 'Orden de Trabajo 2' }
//         ],
//         required: true, validationMessage: 'Debe seleccionar una orden de trabajo'
//       },
//       { label: 'Estado de Orden', id: 'estado_orden', type: 'select', apiKey: 'estado_orden', 
//         options: [
//           { value: 'ejecutado', label: 'Ejecutado' },
//           { value: 'pendiente asignacion', label: 'Pendiente asignacion' },
//           { value: 'en proceso', label: 'En proceso' },
//           { value: 'Cancelado', label: 'Cancelado' },
//           { value: 'rechazado', label: 'Rechazado' }
//         ],
//         required: true, validationMessage: 'Debe seleccionar un estado de orden'
//       },
//       { label: 'Servicio', id: 'servicio', type: 'select', apiKey: 'servicio', 
//         options: [
//           { value: 'reparacion electrica', label: 'Reparacion electrica' },
//           { value: 'estudio de consumo', label: 'Estudio de consumo' },
//           { value: 'pancarta', label: 'Pancarta' },
//           { value: 'cambio transformador', label: 'Cambio transformador' }
//         ],
//         required: true, validationMessage: 'Debe seleccionar un servicio'
//       }
//     ]
// });

// initDynamicTable({
//     apiUrl: 'http://localhost:8080/api/direccion',
//     fields: [
//       { label: 'Calle', id: 'calle', type: 'text', apiKey: 'calle', required: true, validationMessage: 'La calle no puede estar vacía y debe tener entre 1 y 100 caracteres' },
//       { label: 'Carrera', id: 'carrera', type: 'text', apiKey: 'carrera', validationMessage: 'Este campo es opcional' },
//       { label: 'Descripción', id: 'descripcion', type: 'text', apiKey: 'descripcion', validationMessage: 'Este campo es opcional' },
//       { label: 'Barrio', id: 'barrio', type: 'text', apiKey: 'barrio', validationMessage: 'Este campo es opcional' },
//       { label: 'Ciudad', id: 'ciudad', type: 'select', apiKey: 'ciudad', validationMessage: 'Este campo es opcional' }
//     ]
// });

// initDynamicTable({
//     apiUrl: 'http://localhost:8080/api/email_persona',
//     fields: [
//       { label: 'Id', id: 'id', type: 'number', apiKey: 'id', required: true, validationMessage: 'El ID no puede estar vacío' },
//           { label: 'Email', id: 'email', type: 'email', apiKey: 'email', required: true, validationMessage: 'El email no puede estar vacío y debe ser válido' },
//           { label: 'Persona', id: 'personas', type: 'select', apiKey: 'personas' },
//           { label: 'Tipo de Email', id: 'tipoEmail', type: 'select', apiKey: 'tipoEmail', 
//             options: [
//               { value: 'profesional', label: 'Profesional' },
//               { value: 'personal', label: 'Personal' },
//               { value: 'educativo', label: 'Educativo' }
//             ]
//           }
//     ]
// });

// initDynamicTable({
//     apiUrl: 'http://localhost:8080/api/empresa',
//     fields: [
//       { label: 'Id', id: 'id', type: 'number', apiKey: 'id', required: true, validationMessage: 'El ID no puede estar vacío' },
//           { label: 'Email', id: 'email', type: 'email', apiKey: 'email', required: true, validationMessage: 'El email no puede estar vacío y debe ser válido' },
//           { label: 'Persona', id: 'personas', type: 'select', apiKey: 'personas' },
//           { label: 'Tipo de Email', id: 'tipoEmail', type: 'select', apiKey: 'tipoEmail', 
//             options: [
//               { value: 'profesional', label: 'Profesional' },
//               { value: 'personal', label: 'Personal' },
//               { value: 'educativo', label: 'Educativo' }
//             ]
//           }
//     ]
// });