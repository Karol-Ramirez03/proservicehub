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
//         { label: 'Fecha Registro', id: 'fechaRegistro', type: 'date', apiKey: 'fechaRegistro' }
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
//         }
//     ]
  ///no supe como hacer que en estado fuese select y se desplegaran las op
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
//             { label: 'Id', id: 'id', type: 'number', apiKey: 'id', required: true, validationMessage: 'El ID no puede estar vacío' },
//             { label: 'Valor del Servicio', id: 'valor_servicio', type: 'number', apiKey: 'valor_servicio', required: true, validationMessage: 'El valor del servicio no puede estar vacío' }
//         ]
// });

// initDynamicPanel({
//         buttonText: '+ Registrar Detalle Trabajo',
//         panelTitle: 'Agregar Nuevo Detalle Orden Trabajo',
//         submitButtonText: 'Registrar Detalle Orden Trabajo',
//         apiUrl: 'http://localhost:8080/api/detalle_orden_trabajo',
//         fields: [
//             { label: 'Id', id: 'id', type: 'number', apiKey: 'id', required: true, validationMessage: 'El ID no puede estar vacío' },
//             { label: 'Fecha', id: 'fecha', type: 'date', apiKey: 'fecha', required: true, validationMessage: 'La fecha no puede estar vacía' }

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
//         { label: 'Numero Documento', id: 'numerodocumento', type: 'number', apiKey: ' Nro_Doc' },
//         { label: 'Nombre', id: 'nombre', type: 'text', apiKey: 'nombre' },
//         { label: 'Apellido', id: 'apellido', type: 'text', apiKey: 'apellido' },
//         { label: 'Fecha Registro', id: 'fechaRegistro', type: 'date', apiKey: 'fechaRegistro' }
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
//         }
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
//         { label: 'Id', id: 'id', type: 'number', apiKey: 'id', required: true, validationMessage: 'El ID no puede estar vacío' },
//         { label: 'Valor del Servicio', id: 'valor_servicio', type: 'number', apiKey: 'valor_servicio', required: true, validationMessage: 'El valor del servicio no puede estar vacío' }
//     ]
// });

// initDynamicTable({
//     apiUrl: 'http://localhost:8080/api/detalle_orden_trabajo',
//     fields: [
//         { label: 'Id', id: 'id', type: 'number', apiKey: 'id', required: true, validationMessage: 'El ID no puede estar vacío' },
//         { label: 'Fecha', id: 'fecha', type: 'date', apiKey: 'fecha', required: true, validationMessage: 'La fecha no puede estar vacía' }
//     ]
// });