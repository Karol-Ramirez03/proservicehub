import { initDynamicPanel } from "./prueba";
import { initDynamicTable } from "./prueba";

initDynamicPanel({
    buttonText: '+ Registrar Insumo',
    panelTitle: 'Agregar Nuevo Insumo',
    submitButtonText: 'Registrar Insumo',
    apiUrl: 'http://localhost:8080/api/insumo',
    fields: [
        { label: 'Código Interno', id: 'codigoInterno', type: 'text', apiKey: 'codigo_interno' },
        { label: 'Nombre', id: 'nombre', type: 'text', apiKey: 'nombre' },
        { label: 'Precio', id: 'productPrice', type: 'number', apiKey: 'precio_unitario' },
        { label: 'Stock', id: 'stock', type: 'number', apiKey: 'stock' },
        { label: 'Stock Mínimo', id: 'stockMinimo', type: 'number', apiKey: 'stock_minimo' },
        { label: 'Stock Máximo', id: 'stockMaximo', type: 'number', apiKey: 'stock_maximo' }
    ]
});

// // Para otra tabla, simplemente cambia los parámetros
// initDynamicPanel({
//     buttonText: '+ Registrar Producto',
//     panelTitle: 'Agregar Nuevo Producto',
//     submitButtonText: 'Registrar Producto',
//     apiUrl: 'http://localhost:8080/api/producto',
//     fields: [
//         { label: 'ID Producto', id: 'idProducto', type: 'text', apiKey: 'id_producto' },
//         { label: 'Descripción', id: 'descripcion', type: 'text', apiKey: 'descripcion' },
//         { label: 'Precio', id: 'precioProducto', type: 'number', apiKey: 'precio' }
//         // Otros campos según sea necesario
//     ]
// });

initDynamicTable({
    apiUrl: 'http://localhost:8080/api/insumo',
    fields: [
        { label: 'ID', id: 'id', type: 'text', apiKey: 'id' },
        { label: 'Nombre', id: 'nombre', type: 'text', apiKey: 'nombre' },
        { label: 'Código Interno', id: 'codigo', type: 'text', apiKey: 'codigo_interno' },
        { label: 'Precio', id: 'precio', type: 'number', apiKey: 'precio_unitario' },
        { label: 'Stock', id: 'stock', type: 'number', apiKey: 'stock' },
        { label: 'Min Stock', id: 'stockMinimo', type: 'number', apiKey: 'stock_minimo' },
        { label: 'Max Stock', id: 'stockMaximo', type: 'number', apiKey: 'stock_maximo' }
    ]
});

// // Puedes inicializar otra tabla de la misma manera:
// initDynamicTable({
//     apiUrl: 'http://localhost:8080/api/producto',
//     fields: [
//         { label: 'ID Producto', id: 'idProducto', type: 'text', apiKey: 'id_producto' },
//         { label: 'Descripción', id: 'descripcion', type: 'text', apiKey: 'descripcion' },
//         { label: 'Precio', id: 'precioProducto', type: 'number', apiKey: 'precio' }
//         // Otros campos según sea necesario
//     ]
// });

