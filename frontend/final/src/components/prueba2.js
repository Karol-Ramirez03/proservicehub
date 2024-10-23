import { initDynamicPanel } from "./prueba";
import { initDynamicTable } from "./prueba";



// Para otra tabla, simplemente cambia los parámetros
initDynamicPanel({
    totalFetches:3,
    buttonText: '+ Registrar Producto',
    panelTitle: 'Agregar Nuevo Producto',
    submitButtonText: 'Registrar Producto',
    apiUrl: 'http://localhost:8080/api/producto',
    fields: [
        { label: 'ID Producto', id: 'idProducto', type: 'text', apiKey: 'id_producto'},
        { label: 'Descripción', id: 'descripcion', type: 'text', apiKey: 'descripcion' },
        { label: 'Precio', id: 'precioProducto', type: 'number', apiKey: 'precio' },
        { label: 'Persona', id: 'persona', type: 'number', apiKey: 'personas',apiExtension:'personas' },
        { label: 'Rol', id: 'rol', type: 'number', apiKey: 'rol',apiExtension:'rol' },
        { label: 'Tipo Persona', id: 'tipoPersona', type: 'number', apiKey: 'tipo_persona',apiExtension:'tipopersona' }
        
        // Otros campos según sea necesario
    ]
});

export const listaCruds=[
    [{
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
    },{
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
    }],
    [{
        buttonText: '+ Registrar Producto',
        panelTitle: 'Agregar Nuevo Producto',
        submitButtonText: 'Registrar Producto',
        apiUrl: 'http://localhost:8080/api/producto',
        fields: [
            { label: 'ID Producto', id: 'idProducto', type: 'text', apiKey: 'id_producto' },
            { label: 'Descripción', id: 'descripcion', type: 'text', apiKey: 'descripcion' },
            { label: 'Precio', id: 'precioProducto', type: 'number', apiKey: 'precio' }
        ]
    },{
        apiUrl: 'http://localhost:8080/api/producto',
        fields: [
            { label: 'ID Producto', id: 'idProducto', type: 'text', apiKey: 'id_producto' },
            { label: 'Descripción', id: 'descripcion', type: 'text', apiKey: 'descripcion' },
            { label: 'Precio', id: 'precioProducto', type: 'number', apiKey: 'precio' }
        ]
    }],
    [{
        buttonText: '+ Registrar Rol',
        panelTitle: 'Agregar Nuevo Rol',
        submitButtonText: 'Registrar Rol',
        apiUrl: 'http://localhost:8080/api/rol',
        fields: [
            { label: 'Id', id: 'id', type: 'number', apiKey: 'id' },
            { label: 'Nombre', id: 'nombre', type: 'text', apiKey: 'nombre' }
        ]
    },{
        apiUrl: 'http://localhost:8080/api/rol',
        fields: [
            { label: 'Id', id: 'id', type: 'number', apiKey: 'id' },
            { label: 'Nombre', id: 'nombre', type: 'text', apiKey: 'nombre' }
    ]
    }],
    [{
        buttonText: '+ Registrar Personas',
        panelTitle: 'Agregar Nuevo Personas',
        submitButtonText: 'Registrar Personas',
        apiUrl: 'http://localhost:8080/api/personas',
        fields: [
            { label: 'Numero Documento', id: 'numerodocumento', type: 'number', apiKey: ' Nro_Doc' },
            { label: 'Nombre', id: 'nombre', type: 'text', apiKey: 'nombre' },
            { label: 'Apellido', id: 'apellido', type: 'text', apiKey: 'apellido' },
            { label: 'Fecha Registro', id: 'fechaRegistro', type: 'date', apiKey: 'fechaRegistro' },
            { label: 'Sucursal', id: 'sucursal', type: 'select', apiKey: 'sucursal', 
                options: [
                    { value: 'sucursal1', label: 'Sucursal 1' },
                    { value: 'sucursal2', label: 'Sucursal 2' }
                ],
                required: true, validationMessage: 'Debe seleccionar una sucursal'
                },
            { label: 'Tipo de Persona', id: 'tipoPersona', type: 'select', apiKey: 'tipoPersona', 
                options: [
                    { value: 'natural', label: 'Natural' },
                    { value: 'juridico', label: 'Juridico' }
                ],
                required: true, validationMessage: 'Debe seleccionar un tipo de persona'
                }
        ]
    },{
        apiUrl: 'http://localhost:8080/api/personas',
        fields: [
        { label: 'Numero Documento', id: 'numerodocumento', type: 'number', apiKey: ' Nro_Doc' },
        { label: 'Nombre', id: 'nombre', type: 'text', apiKey: 'nombre' },
        { label: 'Apellido', id: 'apellido', type: 'text', apiKey: 'apellido' },
        { label: 'Fecha Registro', id: 'fechaRegistro', type: 'date', apiKey: 'fechaRegistro' },
        { label: 'Sucursal', id: 'sucursal', type: 'select', apiKey: 'sucursal', 
                options: [
                { value: 'sucursal1', label: 'Sucursal 1' },
                { value: 'sucursal2', label: 'Sucursal 2' }
                ],
                required: true, validationMessage: 'Debe seleccionar una sucursal'
            },
        { label: 'Tipo de Persona', id: 'tipoPersona', type: 'select', apiKey: 'tipoPersona', 
                options: [
                { value: 'natural', label: 'Natural' },
                { value: 'juridico', label: 'Juridico' }
                ],
                required: true, validationMessage: 'Debe seleccionar un tipo de persona'
            }
        ]
    }],
    [{
        buttonText: '+ Registrar Ciudad',
        panelTitle: 'Agregar Nueva Ciudad',
        submitButtonText: 'Registrar Ciudad',
        apiUrl: 'http://localhost:8080/api/ciudad',
        fields: [
            { label: 'Id', id: 'id', type: 'number', apiKey: ' id' },
            { label: 'Nombre', id: 'nombre', type: 'text', apiKey: 'nombre' },
            { label: 'Region', id: 'region', type: 'text', apiKey: 'region' }
        ]
    },{
        apiUrl: 'http://localhost:8080/api/ciudad',
        fields: [
            { label: 'Id', id: 'id', type: 'number', apiKey: ' id' },
            { label: 'Nombre', id: 'nombre', type: 'text', apiKey: 'nombre' },
            { label: 'Region', id: 'region', type: 'text', apiKey: 'region' }
        ]
    }],
    [{
        buttonText: '+ Registrar Compra',
        panelTitle: 'Agregar Nueva Compra',
        submitButtonText: 'Registrar Compra',
        apiUrl: 'http://localhost:8080/api/compra',
        fields: [
            { label: 'Id', id: 'id', type: 'number', apiKey: ' id' },
            { label: 'Fecha Compra', id: 'fechacompra', type: 'date', apiKey: 'fecha_compra' },
            { label: 'Total', id: 'total', type: 'number', apiKey: 'total', required: true, validationMessage: 'No puede estar vacio' },
            { label: 'Estado Compra', id: 'estadoCompra', type: 'select', apiKey: 'estado_compra', 
            options: [
                { value: 'ejecutado', label: 'Ejecutado' },
                { value: 'pendiente', label: 'Pendiente' },
                { value: 'cancelado', label: 'Cancelado' },
                { value: 'rechazado', label: 'Rechazado' }
                ]
            },
            { label: 'Cliente', id: 'personas', type: 'select', apiKey: 'personas', 
            options: [
                { value: 'persona1', label: 'Persona 1' },
                { value: 'persona2', label: 'Persona 2' }
            ],
            required: true, validationMessage: 'Debe seleccionar un cliente'
            }
        ]
    },{
        apiUrl: 'http://localhost:8080/api/compra',
        fields: [
        { label: 'Id', id: 'id', type: 'number', apiKey: ' id' },
        { label: 'Fecha Compra', id: 'fechacompra', type: 'date', apiKey: 'fecha_compra' },
        { label: 'Total', id: 'total', type: 'number', apiKey: 'total', required: true, validationMessage: 'No puede estar vacio' },
        { label: 'Estado Compra', id: 'estadoCompra', type: 'select', apiKey: 'estado_compra', 
            options: [
                { value: 'ejecutado', label: 'Ejecutado' },
                { value: 'pendiente', label: 'Pendiente' },
                { value: 'cancelado', label: 'Cancelado' },
                { value: 'rechazado', label: 'Rechazado' }
            ]
        },
        { label: 'Cliente', id: 'personas', type: 'select', apiKey: 'personas', 
            options: [
            
            { value: 'persona1', label: 'Persona 1' },
            { value: 'persona2', label: 'Persona 2' }
            ],
            required: true, validationMessage: 'Debe seleccionar un cliente'
        }
        ]
    }],
    [{
        buttonText: '+ Registrar Detalle compra',
        panelTitle: 'Agregar Nueva Detalle compra',
        submitButtonText: 'Registrar Detalle compra',
        apiUrl: 'http://localhost:8080/api/detalle_compra',
        fields: [
            { label: 'Cantidad', id: 'cantidad', type: 'number', apiKey: 'cantidad', required: true, validationMessage: 'La cantidad no puede estar vacía' },
            { label: 'Precio Unitario', id: 'precio_unitario', type: 'number', apiKey: 'precio_unitario', required: true, validationMessage: 'El precio unitario no puede estar vacío' },
            { label: 'Insumo', id: 'insumo', type: 'select', apiKey: 'insumo', 
                options: [ 
                  { value: 'insumo1', label: 'Insumo 1' },
                  { value: 'insumo2', label: 'Insumo 2' }
                ]
              },
              { label: 'Compra', id: 'compra', type: 'select', apiKey: 'compra', 
                options: [
                  { value: 'compra1', label: 'Compra 1' },
                  { value: 'compra2', label: 'Compra 2' }
                ]
              }
        ]
    },{
        apiUrl: 'http://localhost:8080/api/detalle_compra',
        fields: [
            { label: 'Cantidad', id: 'cantidad', type: 'number', apiKey: 'cantidad', required: true, validationMessage: 'La cantidad no puede estar vacía' },
            { label: 'Precio Unitario', id: 'precio_unitario', type: 'number', apiKey: 'precio_unitario', required: true, validationMessage: 'El precio unitario no puede estar vacío' },
            { label: 'Insumo', id: 'insumo', type: 'select', apiKey: 'insumo', 
                options: [ 
                { value: 'insumo1', label: 'Insumo 1' },
                { value: 'insumo2', label: 'Insumo 2' }
                ]
            },
            { label: 'Compra', id: 'compra', type: 'select', apiKey: 'compra', 
                options: [

                { value: 'compra1', label: 'Compra 1' },
                { value: 'compra2', label: 'Compra 2' }
                ]
            }   
        ]
    }],
    [{
        buttonText: '+ Registrar Detalle Orden Servicio',
        panelTitle: 'Agregar Nuevo Detalle Orden Servicio',
        submitButtonText: 'Registrar Detalle Orden Servicio',
        apiUrl: 'http://localhost:8080/api/detalle_orden_servicio',
        fields: [
          { label: 'Id', id: 'id', type: 'number', apiKey: 'id', required: true, validationMessage: 'El ID no puede estar vacío' },
          { label: 'Valor del Servicio', id: 'valor_servicio', type: 'number', apiKey: 'valor_servicio', required: true, validationMessage: 'El valor del servicio no puede estar vacío' },
          { label: 'Orden de Servicio', id: 'id_orden_servicio', type: 'select', apiKey: 'id_orden_servicio', 
            options: [
              { value: 'orden1', label: 'Orden 1' },
              { value: 'orden2', label: 'Orden 2' }
            ],
            required: true, validationMessage: 'Debe seleccionar una orden de servicio'
          },
          { label: 'Servicio', id: 'servicio', type: 'select', apiKey: 'servicio', 
            options: [
              { value: 'reparacion electrica', label: 'Reparacion electrica' },
              { value: 'estudio de consumo', label: 'Estudio de consumo' },
              { value: 'pancarta', label: 'Pancarta' },
              { value: 'cambio transformador', label: 'Cambio transformador' }
            ],
            required: true, validationMessage: 'Debe seleccionar un servicio'
          }
        ]
    },{
        apiUrl: 'http://localhost:8080/api/detalle_orden_servicio',
        fields: [
        { label: 'Id', id: 'id', type: 'number', apiKey: 'id', required: true, validationMessage: 'El ID no puede estar vacío' },
        { label: 'Valor del Servicio', id: 'valor_servicio', type: 'number', apiKey: 'valor_servicio', required: true, validationMessage: 'El valor del servicio no puede estar vacío' },
        { label: 'Orden de Servicio', id: 'id_orden_servicio', type: 'select', apiKey: 'id_orden_servicio', 
            options: [
            { value: 'orden1', label: 'Orden 1' },
            { value: 'orden2', label: 'Orden 2' }
            ],
            required: true, validationMessage: 'Debe seleccionar una orden de servicio'
        },
        { label: 'Servicio', id: 'servicio', type: 'select', apiKey: 'servicio', 
            options: [
            { value: 'reparacion electrica', label: 'Reparacion electrica' },
            { value: 'estudio de consumo', label: 'Estudio de consumo' },
            { value: 'pancarta', label: 'Pancarta' },
            { value: 'cambio transformador', label: 'Cambio transformador' }
            ],
            required: true, validationMessage: 'Debe seleccionar un servicio'
        }
        ]
    }],
    [{
        buttonText: '+ Registrar Detalle Orden Trabajo',
        panelTitle: 'Agregar Nuevo Detalle Orden Trabajo',
        submitButtonText: 'Registrar Detalle Orden Trabajo',
        apiUrl: 'http://localhost:8080/api/detalle_orden_trabajo',
        fields: [
          { label: 'Id', id: 'id', type: 'number', apiKey: 'id', required: true, validationMessage: 'El ID no puede estar vacío' },
          { label: 'Fecha', id: 'fecha', type: 'date', apiKey: 'fecha', required: true, validationMessage: 'La fecha no puede estar vacía' },
          { label: 'Orden de Trabajo', id: 'orden_trabajo', type: 'select', apiKey: 'orden_trabajo', 
            options: [
              { value: 'ordenTrabajo1', label: 'Orden de Trabajo 1' },
              { value: 'ordenTrabajo2', label: 'Orden de Trabajo 2' }
            ],
            required: true, validationMessage: 'Debe seleccionar una orden de trabajo'
          },
          { label: 'Estado de Orden', id: 'estado_orden', type: 'select', apiKey: 'estado_orden', 
            options: [
              { value: 'ejecutado', label: 'Ejecutado' },
              { value: 'pendiente asignacion', label: 'Pendiente asignacion' },
              { value: 'en proceso', label: 'En proceso' },
              { value: 'Cancelado', label: 'Cancelado' },
              { value: 'rechazado', label: 'Rechazado' }
            ],
            required: true, validationMessage: 'Debe seleccionar un estado de orden'
          },
          { label: 'Servicio', id: 'servicio', type: 'select', apiKey: 'servicio', 
            options: [
              { value: 'reparacion electrica', label: 'Reparacion electrica' },
              { value: 'estudio de consumo', label: 'Estudio de consumo' },
              { value: 'pancarta', label: 'Pancarta' },
              { value: 'cambio transformador', label: 'Cambio transformador' }
            ],
            required: true, validationMessage: 'Debe seleccionar un servicio'
          }
        ]
    },{
        apiUrl: 'http://localhost:8080/api/detalle_orden_trabajo',
        fields: [
          { label: 'Id', id: 'id', type: 'number', apiKey: 'id', required: true, validationMessage: 'El ID no puede estar vacío' },
          { label: 'Fecha', id: 'fecha', type: 'date', apiKey: 'fecha', required: true, validationMessage: 'La fecha no puede estar vacía' },
          { label: 'Orden de Trabajo', id: 'orden_trabajo', type: 'select', apiKey: 'orden_trabajo', 
            options: [
              { value: 'ordenTrabajo1', label: 'Orden de Trabajo 1' },
              { value: 'ordenTrabajo2', label: 'Orden de Trabajo 2' }
            ],
            required: true, validationMessage: 'Debe seleccionar una orden de trabajo'
          },
          { label: 'Estado de Orden', id: 'estado_orden', type: 'select', apiKey: 'estado_orden', 
            options: [
              { value: 'ejecutado', label: 'Ejecutado' },
              { value: 'pendiente asignacion', label: 'Pendiente asignacion' },
              { value: 'en proceso', label: 'En proceso' },
              { value: 'Cancelado', label: 'Cancelado' },
              { value: 'rechazado', label: 'Rechazado' }
            ],
            required: true, validationMessage: 'Debe seleccionar un estado de orden'
          },
          { label: 'Servicio', id: 'servicio', type: 'select', apiKey: 'servicio', 
            options: [
              { value: 'reparacion electrica', label: 'Reparacion electrica' },
              { value: 'estudio de consumo', label: 'Estudio de consumo' },
              { value: 'pancarta', label: 'Pancarta' },
              { value: 'cambio transformador', label: 'Cambio transformador' }
            ],
            required: true, validationMessage: 'Debe seleccionar un servicio'
          }
        ]  
    }],
    [{
        buttonText: '+ Registrar Direccion  ',
        panelTitle: 'Agregar Nuevo Direccion  ',
        submitButtonText: 'Registrar Direccion  ',
        apiUrl: 'http://localhost:8080/api/direccion',
        fields: [          
            { label: 'Calle', id: 'calle', type: 'text', apiKey: 'calle', required: true, validationMessage: 'La calle no puede estar vacía y debe tener entre 1 y 100 caracteres' },
            { label: 'Carrera', id: 'carrera', type: 'text', apiKey: 'carrera', validationMessage: 'Este campo es opcional' },
            { label: 'Descripción', id: 'descripcion', type: 'text', apiKey: 'descripcion', validationMessage: 'Este campo es opcional' },
            { label: 'Barrio', id: 'barrio', type: 'text', apiKey: 'barrio', validationMessage: 'Este campo es opcional' },
            { label: 'Ciudad', id: 'ciudad', type: 'select', apiKey: 'ciudad', validationMessage: 'Este campo es opcional' }
        ]
    },{
        apiUrl: 'http://localhost:8080/api/direccion',
        fields: [
        { label: 'Calle', id: 'calle', type: 'text', apiKey: 'calle', required: true, validationMessage: 'La calle no puede estar vacía y debe tener entre 1 y 100 caracteres' },
        { label: 'Carrera', id: 'carrera', type: 'text', apiKey: 'carrera', validationMessage: 'Este campo es opcional' },
        { label: 'Descripción', id: 'descripcion', type: 'text', apiKey: 'descripcion', validationMessage: 'Este campo es opcional' },
        { label: 'Barrio', id: 'barrio', type: 'text', apiKey: 'barrio', validationMessage: 'Este campo es opcional' },
        { label: 'Ciudad', id: 'ciudad', type: 'select', apiKey: 'ciudad', validationMessage: 'Este campo es opcional' }
        ]
    }],
    [{
        buttonText: '+ Registrar Email Persona  ',
        panelTitle: 'Agregar Nuevo Email Persona ',
        submitButtonText: 'Registrar Email Persona ',
        apiUrl: 'http://localhost:8080/api/email_persona',
        fields: [          
          { label: 'Id', id: 'id', type: 'number', apiKey: 'id', required: true, validationMessage: 'El ID no puede estar vacío' },
          { label: 'Email', id: 'email', type: 'email', apiKey: 'email', required: true, validationMessage: 'El email no puede estar vacío y debe ser válido' },
          { label: 'Persona', id: 'personas', type: 'select', apiKey: 'personas' },
          { label: 'Tipo de Email', id: 'tipoEmail', type: 'select', apiKey: 'tipoEmail', 
            options: [
              { value: 'profesional', label: 'Profesional' },
              { value: 'personal', label: 'Personal' },
              { value: 'educativo', label: 'Educativo' }
            ]
          }
        ]
    },{
        apiUrl: 'http://localhost:8080/api/email_persona',
        fields: [
        { label: 'Id', id: 'id', type: 'number', apiKey: 'id', required: true, validationMessage: 'El ID no puede estar vacío' },
            { label: 'Email', id: 'email', type: 'email', apiKey: 'email', required: true, validationMessage: 'El email no puede estar vacío y debe ser válido' },
            { label: 'Persona', id: 'personas', type: 'select', apiKey: 'personas' },
            { label: 'Tipo de Email', id: 'tipoEmail', type: 'select', apiKey: 'tipoEmail', 
                options: [
                { value: 'profesional', label: 'Profesional' },
                { value: 'personal', label: 'Personal' },
                { value: 'educativo', label: 'Educativo' }
                ]
            }
        ]
    }],
    [{
        buttonText: '+ Registrar Empresa  ',
        panelTitle: 'Agregar Nueva Empresa ',
        submitButtonText: 'Registrar Empresa ',
        apiUrl: 'http://localhost:8080/api/empresa',
        fields: [          
          { label: 'Id', id: 'id', type: 'number', apiKey: 'id', required: true, validationMessage: 'El ID no puede estar vacío' },
          { label: 'Nombre', id: 'nombre', type: 'text', apiKey: 'nombre', required: true, validationMessage: 'El nombre no puede estar vacío y debe tener entre 1 y 100 caracteres' },
          { label: 'Tipo de Empresa', id: 'tipo_empresa', type: 'select', apiKey: 'tipo_empresa', 
            options: [
              { value: 'publica', label: 'Publica' },
              { value: 'privada', label: 'Privada' },
              { value: 'guvernamental', label: 'Guvernamental' },
              { value: 'Internacional', label: 'Internacional' }
            ],
            required: true, validationMessage: 'El tipo de empresa no puede estar vacío'
          }
        ]
    },{
        apiUrl: 'http://localhost:8080/api/empresa',
        fields: [
          { label: 'Id', id: 'id', type: 'number', apiKey: 'id', required: true, validationMessage: 'El ID no puede estar vacío' },
          { label: 'Email', id: 'email', type: 'email', apiKey: 'email', required: true, validationMessage: 'El email no puede estar vacío y debe ser válido' },
          { label: 'Persona', id: 'personas', type: 'select', apiKey: 'personas' },
          { label: 'Tipo de Email', id: 'tipoEmail', type: 'select', apiKey: 'tipoEmail', 
            options: [
                { value: 'profesional', label: 'Profesional' },
                { value: 'personal', label: 'Personal' },
                { value: 'educativo', label: 'Educativo' }
            ]
            }
        ] 
    }],
    [{
        buttonText: '+ Registrar Aprovacion Servicio  ',
        panelTitle: 'Agregar Nuevo Aprovacion Servicio ',
        submitButtonText: 'Registrar Aprovacion Servicio ',
        apiUrl: 'http://localhost:8080/api/aprovacion_servicio',
        fields: [          
            { label: 'Id', id: 'id', type: 'number', apiKey: 'id', required: true, validationMessage: 'El ID no puede estar vacío' },
            { label: 'Orden de Trabajo', id: 'orden_trabajo', type: 'select', apiKey: 'orden_trabajo' }, 
            { label: 'Cliente', id: 'personas', type: 'select', apiKey: 'personas', 
              options: [
                { value: 'cliente1', label: 'Cliente 1' },
                { value: 'cliente2', label: 'Cliente 2' }
              ],
              required: true, validationMessage: 'Debe seleccionar un cliente'
            },
            { label: 'Servicio', id: 'servicio', type: 'select', apiKey: 'servicio', 
                options: [
                  { value: 'reparacion electrica', label: 'Reparacion electrica' },
                  { value: 'estudio de consumo', label: 'Estudio de consumo' },
                  { value: 'pancarta', label: 'Pancarta' },
                  { value: 'cambio transformador', label: 'Cambio transformador' }
                ],
                required: true, validationMessage: 'Debe seleccionar un servicio'
              },
            { label: 'Hallazgo', id: 'hallazgo', type: 'text', apiKey: 'hallazgo', required: false, placeholder: 'Ingrese el hallazgo encontrado' },
            { label: 'Solución', id: 'solucion', type: 'text', apiKey: 'solucion', required: false, placeholder: 'Ingrese la solución implementada' },
            { label: 'Motivo de Rechazo', id: 'motivoRechazo', type: 'text', apiKey: 'motivoRechazo', required: false, placeholder: 'Ingrese el motivo de rechazo (si aplica)' },
            { label: 'Estado de Aprobación', id: 'estado_aprobacion', type: 'select', apiKey: 'estado_aprobacion', 
              options: [
                { value: 'ejecutado', label: 'Ejecutado' },
                { value: 'no aprobado', label: 'No aprobado' },
                { value: 'aprobado', label: 'Aprobado' },
                { value: 'pendiente', label: 'Pendiente' }
              ],
              required: true, validationMessage: 'Debe seleccionar un estado de aprobación'
            }
        ]
    },{
        apiUrl: 'http://localhost:8080/api/aprovacion_servicio',
        fields: [
        { label: 'Id', id: 'id', type: 'number', apiKey: 'id', required: true, validationMessage: 'El ID no puede estar vacío' },
        { label: 'Orden de Trabajo', id: 'orden_trabajo', type: 'select', apiKey: 'orden_trabajo' }, 
        { label: 'Cliente', id: 'personas', type: 'select', apiKey: 'personas', 
            options: [
            { value: 'cliente1', label: 'Cliente 1' },
            { value: 'cliente2', label: 'Cliente 2' }
            ],
            required: true, validationMessage: 'Debe seleccionar un cliente'
        },
        { label: 'Servicio', id: 'servicio', type: 'select', apiKey: 'servicio', 
            options: [
                { value: 'reparacion electrica', label: 'Reparacion electrica' },
                { value: 'estudio de consumo', label: 'Estudio de consumo' },
                { value: 'pancarta', label: 'Pancarta' },
                { value: 'cambio transformador', label: 'Cambio transformador' }
            ],
            required: true, validationMessage: 'Debe seleccionar un servicio'
            },
        { label: 'Hallazgo', id: 'hallazgo', type: 'text', apiKey: 'hallazgo', required: false, placeholder: 'Ingrese el hallazgo encontrado' },
        { label: 'Solución', id: 'solucion', type: 'text', apiKey: 'solucion', required: false, placeholder: 'Ingrese la solución implementada' },
        { label: 'Motivo de Rechazo', id: 'motivoRechazo', type: 'text', apiKey: 'motivoRechazo', required: false, placeholder: 'Ingrese el motivo de rechazo (si aplica)' },
        { label: 'Estado de Aprobación', id: 'estado_aprobacion', type: 'select', apiKey: 'estado_aprobacion', 
            options: [
            { value: 'ejecutado', label: 'Ejecutado' },
            { value: 'no aprobado', label: 'No aprobado' },
            { value: 'aprobado', label: 'Aprobado' },
            { value: 'pendiente', label: 'Pendiente' }
            ],
            required: true, validationMessage: 'Debe seleccionar un estado de aprobación'
        }
        ]
    }],
    [{
        buttonText: '+ Registrar Empresa Servicio  ',
        panelTitle: 'Agregar Nueva Empresa Servicio ',
        submitButtonText: 'Registrar Aprovacion Servicio ',
        apiUrl: 'http://localhost:8080/api/empresa_servicio',
        fields: [          
          { label: 'ID Empresa-Servicio', id: 'id', type: 'text', apiKey: 'id', required: true, validationMessage: 'El ID no puede estar vacío' },
          { label: 'Valor del Servicio', id: 'valorServicio', type: 'number', apiKey: 'valorServicio', required: true, validationMessage: 'El valor del servicio no puede estar vacío' },
          { label: 'Sucursal', id: 'sucursal', type: 'select', apiKey: 'sucursal', 
            options: [
              { value: '1', label: 'Sucursal 1' }, 
              { value: '2', label: 'Sucursal 2' } 
            ],
            required: true, validationMessage: 'Debe seleccionar una sucursal'
          },
          { label: 'Servicio', id: 'servicio', type: 'select', apiKey: 'servicio', 
            options: [
              { value: 'reparacion electrica', label: 'Reparacion electrica' },
              { value: 'estudio de consumo', label: 'Estudio de consumo' },
              { value: 'pancarta', label: 'Pancarta' },
              { value: 'cambio transformador', label: 'Cambio transformador' }
            ],
            required: true, validationMessage: 'Debe seleccionar un servicio'
          }
        ]
    },{
        apiUrl: 'http://localhost:8080/api/empresa_servicio',
        fields: [
          { label: 'ID Empresa-Servicio', id: 'id', type: 'text', apiKey: 'id', required: true, validationMessage: 'El ID no puede estar vacío' },
        { label: 'Valor del Servicio', id: 'valorServicio', type: 'number', apiKey: 'valorServicio', required: true, validationMessage: 'El valor del servicio no puede estar vacío' },
        { label: 'Sucursal', id: 'sucursal', type: 'select', apiKey: 'sucursal', 
          options: [
            { value: '1', label: 'Sucursal 1' }, 
            { value: '2', label: 'Sucursal 2' } 
          ],
          required: true, validationMessage: 'Debe seleccionar una sucursal'
        },
        { label: 'Servicio', id: 'servicio', type: 'select', apiKey: 'servicio', 
          options: [
            { value: 'reparacion electrica', label: 'Reparacion electrica' },
            { value: 'estudio de consumo', label: 'Estudio de consumo' },
            { value: 'pancarta', label: 'Pancarta' },
            { value: 'cambio transformador', label: 'Cambio transformador' }
          ],
          required: true, validationMessage: 'Debe seleccionar un servicio'
        }
        ] 
    }],
    [{
        buttonText: '+ Registrar Estado Aprobacion  ',
        panelTitle: 'Agregar Nuevo Estado Aprobacion ',
        submitButtonText: 'Registrar Estado Aprobacion ',
        apiUrl: 'http://localhost:8080/api/estado_aprobacion',
        fields: [          
            { label: 'Nombre', id: 'nombre', type: 'text', apiKey: 'nombre', required: true, validationMessage: 'El nombre no puede estar vacío' },
            { label: 'ID', id: 'id', type: 'number', apiKey: 'id', required: true, validationMessage: 'El ID no puede estar vacío' }
        ]
    },{
        apiUrl: 'http://localhost:8080/api/estado_aprobacion',
        fields: [
            { label: 'ID', id: 'id', type: 'number', apiKey: 'id', required: true, validationMessage: 'El ID no puede estar vacío' },
            { label: 'Nombre', id: 'nombre', type: 'text', apiKey: 'nombre', required: true, validationMessage: 'El nombre no puede estar vacío' }
        ]
    }],
    [{

    },{
        
    }],
    [{

    },{
        
    }],
    [{

    },{
        
    }],
    [{

    },{
        
    }],
    [{

    },{
        
    }],
    [{

    },{
        
    }],
    [{

    },{
        
    }],
    [{

    },{
        
    }],
    [{

    },{
        
    }],

    [{

    },{
        
    }],

]



























initDynamicPanel({
  buttonText: '+ Registrar Estado Compra  ',
  panelTitle: 'Agregar Nuevo Estado Compra ',
  submitButtonText: 'Registrar Estado Compra ',
  apiUrl: 'http://localhost:8080/api/estado_compra',
  fields: [          
    { label: 'ID', id: 'id', type: 'number', apiKey: 'id', required: true, validationMessage: 'El ID no puede estar vacío' },
    { label: 'Nombre', id: 'nombre', type: 'text', apiKey: 'nombre', required: true, validationMessage: 'El nombre no puede estar vacío' }
  ]
});

initDynamicPanel({
  buttonText: '+ Registrar Estado Orden  ',
  panelTitle: 'Agregar Nuevo Estado Orden ',
  submitButtonText: 'Registrar Estado Orden ',
  apiUrl: 'http://localhost:8080/api/estado_orden',
  fields: [          
    { label: 'ID', id: 'id', type: 'number', apiKey: 'id', required: true, validationMessage: 'El ID no puede estar vacío' },
    { label: 'Nombre', id: 'nombre', type: 'text', apiKey: 'nombre', required: true, validationMessage: 'El nombre no puede estar vacío' }
  ]
});

initDynamicPanel({
  buttonText: '+ Registrar Estado Orden Servicio ',
  panelTitle: 'Agregar Nuevo Estado Orden Servicio ',
  submitButtonText: 'Registrar Estado Orden Servicio',
  apiUrl: 'http://localhost:8080/api/estado_orden_servicio',
  fields: [          
    { label: 'ID', id: 'id', type: 'number', apiKey: 'id', required: true, validationMessage: 'El ID no puede estar vacío' },
    { label: 'Nombre', id: 'nombre', type: 'text', apiKey: 'nombre', required: true, validationMessage: 'El nombre no puede estar vacío' }
  ]
});

initDynamicPanel({
  buttonText: '+ Registrar Login ',
  panelTitle: 'Agregar Nuevo Login ',
  submitButtonText: 'Registrar Login',
  apiUrl: 'http://localhost:8080/api/login',
  fields: [          
    { label: 'ID', id: 'id', type: 'number', apiKey: 'id', required: true, validationMessage: 'El ID no puede estar vacío' },
    { label: 'Usuario', id: 'usuario', type: 'text', apiKey: 'usuario', required: true, unique: true, validationMessage: 'El usuario no puede estar vacío y debe ser único' },
    { label: 'Contraseña', id: 'contraseña', type: 'password', apiKey: 'contraseña', required: true, unique: true, validationMessage: 'La contraseña no puede estar vacía y debe ser única' },
    { label: 'Rol', id: 'rol', type: 'select', apiKey: 'rol', 
  options: [
    { value: '2', label: 'Cliente' }, 
    { value: '9', label: 'Profesional' },
    { value: '11', label: 'Proveedor' } 
  ],
  required: true, validationMessage: 'Debe seleccionar un rol'
    },
    { label: 'Persona', id: 'personas', type: 'select', apiKey: 'personas', 
  options: [
    { value: '1', label: 'Persona 1' }, 
    { value: '2', label: 'Persona 2' }  
  ],
  required: true, validationMessage: 'Debe seleccionar una persona'
    }
  ]
});

initDynamicPanel({
  buttonText: '+ Registrar Orden Servicio ',
  panelTitle: 'Agregar Nuevo Orden Servicio ',
  submitButtonText: 'Registrar Orden Servicio',
  apiUrl: 'http://localhost:8080/api/orden_servicio',
  fields: [          
    { label: 'Número de Orden', id: 'numero_orden', type: 'number', apiKey: 'numero_orden', required: true, validationMessage: 'El número de orden no puede estar vacío' },
    { label: 'Fecha de Orden', id: 'fecha_orden', type: 'date', apiKey: 'fecha_orden', required: true, validationMessage: 'La fecha de orden no puede estar vacía' },
    { label: 'Cliente', id: 'personas', type: 'select', apiKey: 'personas', 
      options: [
        { value: '1', label: 'Cliente 1' }, 
        { value: '2', label: 'Cliente 2' }  
      ],
      required: true, validationMessage: 'Debe seleccionar un cliente'
    },
    { label: 'Empleado', id: 'persona', type: 'select', apiKey: 'persona', 
      options: [
        { value: '1', label: 'Empleado 1' }, 
        { value: '2', label: 'Empleado 2' }  
      ],
      required: true, validationMessage: 'Debe seleccionar un empleado'
    },
    { label: 'Estado de la Orden', id: 'estado_orden_servicio', type: 'select', apiKey: 'estado_orden_servicio', 
      options: [
        { value: 'ejecutado', label: 'Ejecutado' },
        { value: 'pendiente', label: 'Pendiente' },
        { value: 'cancelado', label: 'Cancelado' },
        { value: 'rechazado', label: 'Rechazado' }
      ],
      required: true, validationMessage: 'Debe seleccionar un estado de la orden'
    }
  ]
});

// initDynamicPanel({
//   buttonText: '+ Registrar Orden Servicio ',
//   panelTitle: 'Agregar Nuevo Orden Servicio ',
//   submitButtonText: 'Registrar Orden Servicio',
//   apiUrl: 'http://localhost:8080/api/orden_trabajo',
//   fields: [          
//     { label: 'Número de Orden', id: 'numero_orden', type: 'number', apiKey: 'numero_orden', required: true, validationMessage: 'El número de orden no puede estar vacío' },
//     { label: 'Fecha de Orden', id: 'fecha_orden', type: 'date', apiKey: 'fecha_orden', required: true, validationMessage: 'La fecha de orden no puede estar vacía' },
//     { label: 'Cliente', id: 'personas', type: 'select', apiKey: 'personas', 
//       options: [
//         { value: '1', label: 'Cliente 1' }, 
//         { value: '2', label: 'Cliente 2' }  
//       ],
//       required: true, validationMessage: 'Debe seleccionar un cliente'
//     },
//     { label: 'Empleado', id: 'persona', type: 'select', apiKey: 'persona', 
//       options: [
//         { value: '1', label: 'Empleado 1' }, 
//         { value: '2', label: 'Empleado 2' }  
//       ],
//       required: true, validationMessage: 'Debe seleccionar un empleado'
//     },
//     { label: 'Estado de la Orden', id: 'estado_orden_servicio', type: 'select', apiKey: 'estado_orden_servicio', 
//       options: [
//         { value: 'ejecutado', label: 'Ejecutado' },
//         { value: 'pendiente', label: 'Pendiente' }, 
//         { value: 'cancelado', label: 'Cancelado' },
//         { value: 'rechazado', label: 'Rechazado' }
//       ],
//       required: true, validationMessage: 'Debe seleccionar un estado de la orden'
//     }
//   ]
// });

// initDynamicPanel({
//   buttonText: '+ Registrar Pais ',
//   panelTitle: 'Agregar Nuevo Pais ',
//   submitButtonText: 'Registrar Pais',
//   apiUrl: 'http://localhost:8080/api/pais',
//   fields: [          
//     { label: 'ID', id: 'id', type: 'number', apiKey: 'id', required: true, validationMessage: 'El ID no puede estar vacío' },
//     { label: 'Nombre', id: 'nombre', type: 'text', apiKey: 'nombre', required: true, validationMessage: 'El nombre no puede estar vacío' }
//   ]
// });

// initDynamicPanel({
//   buttonText: '+ Registrar Persona Insumo ',
//   panelTitle: 'Agregar Nueva Persona Insumo ',
//   submitButtonText: 'Registrar Persona Insumo',
//   apiUrl: 'http://localhost:8080/api/persona_insumo',
//   fields: [          
//     { label: 'ID de Servicio', id: 'servicio', type: 'select', apiKey: 'servicio', 
//       options: [
//         { value: '1', label: 'Servicio 1' }, 
//         { value: '2', label: 'Servicio 2' }  
//       ],
//       required: true, validationMessage: 'Debe seleccionar un servicio'
//     },
//     { label: 'Persona', id: 'personas', type: 'select', apiKey: 'personas', required: true, validationMessage: 'Debe seleccionar una persona' },
//     { label: 'Insumo', id: 'insumo', type: 'select', apiKey: 'insumo', required: true, validationMessage: 'Debe seleccionar un insumo' }
//   ]
// });

// initDynamicPanel({
//   buttonText: '+ Registrar Region ',
//   panelTitle: 'Agregar Nueva Region ',
//   submitButtonText: 'Registrar Region',
//   apiUrl: 'http://localhost:8080/api/region',
//   fields: [          
//     { label: 'ID', id: 'id', type: 'number', apiKey: 'id' },
//     { label: 'Nombre', id: 'nombre', type: 'text', apiKey: 'nombre', 
//       required: true, validationMessage: 'El nombre no puede estar vacío' 
//     },
//     { label: 'País', id: 'pais', type: 'select', apiKey: 'pais', 
//       options: [
//         { value: '1', label: 'País 1' }, 
//         { value: '2', label: 'País 2' }  
//       ],
//       required: true, validationMessage: 'Debe seleccionar un país'
//     }
//   ]
// });

// initDynamicPanel({
//   buttonText: '+ Registrar Servicio ',
//   panelTitle: 'Agregar Nuevo Servicio ',
//   submitButtonText: 'Registrar Servicio',
//   apiUrl: 'http://localhost:8080/api/servicio',
//   fields: [          
//     { label: 'ID', id: 'id', type: 'number', apiKey: 'id' },
//     { label: 'Nombre', id: 'nombre', type: 'text', apiKey: 'nombre', 
//       required: true, validationMessage: 'El nombre no puede estar vacío',
//       maxLength: 50 
//     },
//     { label: 'Requiere Insumo', id: 'requiere_insumo', type: 'checkbox', apiKey: 'requiere_insumo', 
//       required: true, validationMessage: 'Debe indicar si requiere insumo' 
//     },
//     { label: 'Tiempo de Ejecución', id: 'tiempo_ejecucion', type: 'text', apiKey: 'tiempo_ejecucion', 
//       required: true, validationMessage: 'El tiempo de ejecución no puede estar vacío'
//     }
//   ]
// });

// initDynamicPanel({
//   buttonText: '+ Registrar Servicio Insumo',
//   panelTitle: 'Agregar Nuevo Servicio Insumo',
//   submitButtonText: 'Registrar Servicio Insumo',
//   apiUrl: 'http://localhost:8080/api/servicio_insumo',
//   fields: [          
//     { label: 'Cantidad', id: 'cantidad', type: 'number', apiKey: 'cantidad', 
//       required: true, validationMessage: 'La cantidad no puede estar vacía' 
//     },
//     { label: 'Insumo', id: 'insumo', type: 'select', apiKey: 'insumo', 
//       required: true, validationMessage: 'Debe seleccionar un insumo',
//       options: [] 
//     },
//     { label: 'Servicio', id: 'servicio', type: 'select', apiKey: 'servicio', 
//       required: true, validationMessage: 'Debe seleccionar un servicio',
//       options: [] 
//     }
//   ]
// });

// initDynamicPanel({
//   buttonText: '+ Registrar Sucursal',
//   panelTitle: 'Agregar Nueva Sucursal',
//   submitButtonText: 'Registrar Sucursal',
//   apiUrl: 'http://localhost:8080/api/sucursal',
//   fields: [          
//     { label: 'Nombre', id: 'nombre', type: 'text', apiKey: 'nombre', 
//       required: true, validationMessage: 'El nombre no puede estar vacío y debe tener entre 1 y 100 caracteres', 
//       minLength: 1, maxLength: 100 
//     },
//     { label: 'NIT', id: 'nit', type: 'text', apiKey: 'nit', 
//       required: true, validationMessage: 'El NIT no puede estar vacío y debe tener entre 1 y 100 caracteres', 
//       minLength: 1, maxLength: 100 
//     },
//     { label: 'Fecha de Creación', id: 'fecha_creacion', type: 'datetime-local', apiKey: 'fecha_creacion', 
//       required: false 
//     },
//     { label: 'Dirección', id: 'direccion', type: 'select', apiKey: 'direccion', 
//       required: true, validationMessage: 'Debe seleccionar una dirección',
//       options: [] 
//     },
//     { label: 'Empresa', id: 'empresa', type: 'select', apiKey: 'empresa', 
//       required: true, validationMessage: 'Debe seleccionar una empresa',
//       options: [] 
//     }
//   ]
// });

// initDynamicPanel({
//   buttonText: '+ Registrar Telefono Persona',
//   panelTitle: 'Agregar Nueva Telefono Persona',
//   submitButtonText: 'Registrar Telefono Persona',
//   apiUrl: 'http://localhost:8080/api/telefono_persona',
//   fields: [          
//     { label: 'Número de Teléfono', id: 'numero', type: 'number', apiKey: 'numero', 
//       required: true, validationMessage: 'El número de teléfono no puede ser nulo' 
//     },
//     { label: 'Tipo de Teléfono', id: 'tipoTelefono', type: 'select', apiKey: 'tipoTelefono', 
//       required: true, validationMessage: 'Debe seleccionar un tipo de teléfono', 
//       options: [] 
//     },
//     { label: 'Persona', id: 'personas', type: 'select', apiKey: 'personas', 
//       required: true, validationMessage: 'Debe seleccionar una persona', 
//       options: [] 
//     } 
//   ]
// });

// initDynamicPanel({
//   buttonText: '+ Registrar Telefono Sucursal',
//   panelTitle: 'Agregar Nueva Telefono Sucursal',
//   submitButtonText: 'Registrar Telefono Sucursal',
//   apiUrl: 'http://localhost:8080/api/telefono_sucursal',
//   fields: [          
//     { label: 'Número de Sucursal', id: 'numero', type: 'number', apiKey: 'numero', 
//       required: true, validationMessage: 'El número no puede estar vacío' 
//     },
//     { label: 'Sucursal', id: 'sucursal', type: 'select', apiKey: 'sucursal', 
//       required: true, validationMessage: 'Debe seleccionar una sucursal', 
//       options: []
//     }
//   ]
// });

// initDynamicPanel({
//   buttonText: '+ Registrar Tipo Email',
//   panelTitle: 'Agregar Nueva Tipo Email',
//   submitButtonText: 'Registrar Tipo Email',
//   apiUrl: 'http://localhost:8080/api/tipo_email',
//   fields: [          
//     { label: 'ID', id: 'id', type: 'number', apiKey: 'id', required: true, validationMessage: 'El ID no puede estar vacío' },
//     { label: 'Nombre', id: 'nombre', type: 'text', apiKey: 'nombre', required: true, validationMessage: 'El nombre no puede estar vacío' }
//   ]
// });

// initDynamicPanel({
//   buttonText: '+ Registrar Tipo Empresa',
//   panelTitle: 'Agregar Nueva Tipo Empresa',
//   submitButtonText: 'Registrar Tipo Empresa',
//   apiUrl: 'http://localhost:8080/api/tipo_empresa',
//   fields: [          
//     { label: 'ID', id: 'id', type: 'number', apiKey: 'id', required: true, validationMessage: 'El ID no puede estar vacío' },
//     { label: 'Descripción',  id: 'descripcion', type: 'text', apiKey: 'descripcion', required: true, validationMessage: 'La descripción no puede estar vacía y debe tener entre 1 y 100 caracteres'}
//   ]
// });

// initDynamicPanel({
//   buttonText: '+ Registrar Tipo Persona',
//   panelTitle: 'Agregar Nuevo Tipo Persona',
//   submitButtonText: 'Registrar Tipo Persona',
//   apiUrl: 'http://localhost:8080/api/tipo_persona',
//   fields: [          
//     { label: 'ID', id: 'id', type: 'number', apiKey: 'id', required: true, validationMessage: 'El ID no puede estar vacío'  },
//     { label: 'Nombre',  id: 'nombre', type: 'text', apiKey: 'nombre', required: true, validationMessage: 'El nombre no puede estar vacío y debe tener entre 1 y 100 caracteres' 
//     }
//   ]
// });

// initDynamicPanel({
//   buttonText: '+ Registrar Tipo Telefono',
//   panelTitle: 'Agregar Nuevo Tipo Telefono',
//   submitButtonText: 'Registrar Tipo Telefono',
//   apiUrl: 'http://localhost:8080/api/tipo_telefono',
//   fields: [          
//     { label: 'ID', id: 'id', type: 'number', apiKey: 'id', required: true, validationMessage: 'El ID no puede estar vacío'  },
//     { label: 'Nombre',  id: 'nombre', type: 'text', apiKey: 'nombre', required: true, validationMessage: 'El nombre no puede estar vacío y debe tener entre 1 y 100 caracteres' 
//     }
//   ]
// });





































////////////////////////////////////////////////////////////////////////////////////



initDynamicTable({
  apiUrl: 'http://localhost:8080/api/estado_compra',
  fields: [
    { label: 'ID', id: 'id', type: 'number', apiKey: 'id', required: true, validationMessage: 'El ID no puede estar vacío' },
    { label: 'Nombre', id: 'nombre', type: 'text', apiKey: 'nombre', required: true, validationMessage: 'El nombre no puede estar vacío' }
  ]
});

initDynamicTable({
  apiUrl: 'http://localhost:8080/api/estado_orden',
  fields: [
    { label: 'ID', id: 'id', type: 'number', apiKey: 'id', required: true, validationMessage: 'El ID no puede estar vacío' },
    { label: 'Nombre', id: 'nombre', type: 'text', apiKey: 'nombre', required: true, validationMessage: 'El nombre no puede estar vacío' }
  ]
});

initDynamicTable({
  apiUrl: 'http://localhost:8080/api/estado_orden_servicio',
  fields: [
    { label: 'ID', id: 'id', type: 'number', apiKey: 'id', required: true, validationMessage: 'El ID no puede estar vacío' },
    { label: 'Nombre', id: 'nombre', type: 'text', apiKey: 'nombre', required: true, validationMessage: 'El nombre no puede estar vacío' }
  ]
});

initDynamicTable({
  apiUrl: 'http://localhost:8080/api/login',
  fields: [
    { label: 'ID', id: 'id', type: 'number', apiKey: 'id', required: true, validationMessage: 'El ID no puede estar vacío' },
    { label: 'Usuario', id: 'usuario', type: 'text', apiKey: 'usuario', required: true, unique: true, validationMessage: 'El usuario no puede estar vacío y debe ser único' },
    { label: 'Contraseña', id: 'contraseña', type: 'password', apiKey: 'contraseña', required: true, unique: true, validationMessage: 'La contraseña no puede estar vacía y debe ser única' },
    { label: 'Rol', id: 'rol', type: 'select', apiKey: 'rol', 
  options: [
    { value: '2', label: 'Cliente' }, 
    { value: '9', label: 'Profesional' },
    { value: '11', label: 'Proveedor' } 
  ],
  required: true, validationMessage: 'Debe seleccionar un rol'
    },
    { label: 'Persona', id: 'personas', type: 'select', apiKey: 'personas', 
  options: [
    { value: '1', label: 'Persona 1' }, 
    { value: '2', label: 'Persona 2' }  
  ],
  required: true, validationMessage: 'Debe seleccionar una persona'
    }
  ]
});

initDynamicTable({
  apiUrl: 'http://localhost:8080/api/orden_servicio',
  fields: [
    { label: 'Número de Orden', id: 'numero_orden', type: 'number', apiKey: 'numero_orden', required: true, validationMessage: 'El número de orden no puede estar vacío' },
    { label: 'Fecha de Orden', id: 'fecha_orden', type: 'date', apiKey: 'fecha_orden', required: true, validationMessage: 'La fecha de orden no puede estar vacía' },
    { label: 'Cliente', id: 'personas', type: 'select', apiKey: 'personas', 
      options: [
        { value: '1', label: 'Cliente 1' }, 
        { value: '2', label: 'Cliente 2' }  
      ],
      required: true, validationMessage: 'Debe seleccionar un cliente'
    },
    { label: 'Empleado', id: 'persona', type: 'select', apiKey: 'persona', 
      options: [
        { value: '1', label: 'Empleado 1' }, 
        { value: '2', label: 'Empleado 2' }  
      ],
      required: true, validationMessage: 'Debe seleccionar un empleado'
    },
    { label: 'Estado de la Orden', id: 'estado_orden_servicio', type: 'select', apiKey: 'estado_orden_servicio', 
      options: [
        { value: 'ejecutado', label: 'Ejecutado' },
        { value: 'pendiente', label: 'Pendiente' },
        { value: 'cancelado', label: 'Cancelado' },
        { value: 'rechazado', label: 'Rechazado' }
      ],
      required: true, validationMessage: 'Debe seleccionar un estado de la orden'
    }
  ]
});

// initDynamicTable({
//   apiUrl: 'http://localhost:8080/api/orden_trabajo',
//   fields: [
//     { label: 'Número de Orden', id: 'numero_orden', type: 'number', apiKey: 'numero_orden', required: true, validationMessage: 'El número de orden no puede estar vacío' },
//     { label: 'Fecha de Orden', id: 'fecha_orden', type: 'date', apiKey: 'fecha_orden', required: true, validationMessage: 'La fecha de orden no puede estar vacía' },
//     { label: 'Cliente', id: 'personas', type: 'select', apiKey: 'personas', 
//       options: [
//         { value: '1', label: 'Cliente 1' }, 
//         { value: '2', label: 'Cliente 2' }  
//       ],
//       required: true, validationMessage: 'Debe seleccionar un cliente'
//     },
//     { label: 'Empleado', id: 'persona', type: 'select', apiKey: 'persona', 
//       options: [
//         { value: '1', label: 'Empleado 1' }, 
//         { value: '2', label: 'Empleado 2' }  
//       ],
//       required: true, validationMessage: 'Debe seleccionar un empleado'
//     },
//     { label: 'Estado de la Orden', id: 'estado_orden_servicio', type: 'select', apiKey: 'estado_orden_servicio', 
//       options: [
//         { value: 'ejecutado', label: 'Ejecutado' },
//         { value: 'pendiente', label: 'Pendiente' },
//         { value: 'cancelado', label: 'Cancelado' },
//         { value: 'rechazado', label: 'Rechazado' }
//       ],
//       required: true, validationMessage: 'Debe seleccionar un estado de la orden'
//     }
//   ]
// });

// initDynamicTable({
//   apiUrl: 'http://localhost:8080/api/pais',
//   fields: [
//     { label: 'ID', id: 'id', type: 'number', apiKey: 'id', required: true, validationMessage: 'El ID no puede estar vacío' },
//     { label: 'Nombre', id: 'nombre', type: 'text', apiKey: 'nombre', required: true, validationMessage: 'El nombre no puede estar vacío' }
//   ]
// });

// initDynamicTable({
//   apiUrl: 'http://localhost:8080/api/persona_insumo',
//   fields: [
//     { label: 'ID de Servicio', id: 'servicio', type: 'select', apiKey: 'servicio', 
//       options: [
//         { value: '1', label: 'Servicio 1' }, 
//         { value: '2', label: 'Servicio 2' }  
//       ],
//       required: true, validationMessage: 'Debe seleccionar un servicio'
//     },
//     { label: 'Persona', id: 'personas', type: 'select', apiKey: 'personas', required: true, validationMessage: 'Debe seleccionar una persona' },
//     { label: 'Insumo', id: 'insumo', type: 'select', apiKey: 'insumo', required: true, validationMessage: 'Debe seleccionar un insumo' }
//   ]
// });

// initDynamicTable({
//   apiUrl: 'http://localhost:8080/api/region',
//   fields: [
//     { label: 'ID', id: 'id', type: 'number', apiKey: 'id' },
//     { label: 'Nombre', id: 'nombre', type: 'text', apiKey: 'nombre', 
//       required: true, validationMessage: 'El nombre no puede estar vacío' 
//     },
//     { label: 'País', id: 'pais', type: 'select', apiKey: 'pais', 
//       options: [
//         { value: '1', label: 'País 1' }, 
//         { value: '2', label: 'País 2' }  
//       ],
//       required: true, validationMessage: 'Debe seleccionar un país'
//     }
//   ]
// });

// initDynamicTable({
//   apiUrl: 'http://localhost:8080/api/servicio',
//   fields: [
//     { label: 'ID', id: 'id', type: 'number', apiKey: 'id' },
//     { label: 'Nombre', id: 'nombre', type: 'text', apiKey: 'nombre', 
//       required: true, validationMessage: 'El nombre no puede estar vacío',
//       maxLength: 50 
//     },
//     { label: 'Requiere Insumo', id: 'requiere_insumo', type: 'checkbox', apiKey: 'requiere_insumo', 
//       required: true, validationMessage: 'Debe indicar si requiere insumo' 
//     },
//     { label: 'Tiempo de Ejecución', id: 'tiempo_ejecucion', type: 'text', apiKey: 'tiempo_ejecucion', 
//       required: true, validationMessage: 'El tiempo de ejecución no puede estar vacío'
//     }
//   ]
// });

// initDynamicTable({
//   apiUrl: 'http://localhost:8080/api/servicio_insumo',
//   fields: [
//     { label: 'Cantidad', id: 'cantidad', type: 'number', apiKey: 'cantidad', 
//       required: true, validationMessage: 'La cantidad no puede estar vacía' 
//     },
//     { label: 'Insumo', id: 'insumo', type: 'select', apiKey: 'insumo', 
//       required: true, validationMessage: 'Debe seleccionar un insumo',
//       options: [] // Aquí deberías cargar los insumos disponibles
//     },
//     { label: 'Servicio', id: 'servicio', type: 'select', apiKey: 'servicio', 
//       required: true, validationMessage: 'Debe seleccionar un servicio',
//       options: [] // Aquí deberías cargar los servicios disponibles
//     }    
//   ]
// });

// initDynamicTable({
//   apiUrl: 'http://localhost:8080/api/sucursal',
//   fields: [
//     { label: 'Nombre', id: 'nombre', type: 'text', apiKey: 'nombre', 
//       required: true, validationMessage: 'El nombre no puede estar vacío y debe tener entre 1 y 100 caracteres', 
//       minLength: 1, maxLength: 100 
//     },
//     { label: 'NIT', id: 'nit', type: 'text', apiKey: 'nit', 
//       required: true, validationMessage: 'El NIT no puede estar vacío y debe tener entre 1 y 100 caracteres', 
//       minLength: 1, maxLength: 100 
//     },
//     { label: 'Fecha de Creación', id: 'fecha_creacion', type: 'datetime-local', apiKey: 'fecha_creacion', 
//       required: false 
//     },
//     { label: 'Dirección', id: 'direccion', type: 'select', apiKey: 'direccion', 
//       required: true, validationMessage: 'Debe seleccionar una dirección',
//       options: [] 
//     },
//     { label: 'Empresa', id: 'empresa', type: 'select', apiKey: 'empresa', 
//       required: true, validationMessage: 'Debe seleccionar una empresa',
//       options: [] 
//     } 
//   ]
// });

// initDynamicTable({
//   apiUrl: 'http://localhost:8080/api/telefono_persona',
//   fields: [
//     { label: 'Número de Teléfono', id: 'numero', type: 'number', apiKey: 'numero', 
//       required: true, validationMessage: 'El número de teléfono no puede ser nulo' 
//     },
//     { label: 'Tipo de Teléfono', id: 'tipoTelefono', type: 'select', apiKey: 'tipoTelefono', 
//       required: true, validationMessage: 'Debe seleccionar un tipo de teléfono', 
//       options: [] 
//     },
//     { label: 'Persona', id: 'personas', type: 'select', apiKey: 'personas', 
//       required: true, validationMessage: 'Debe seleccionar una persona', 
//       options: [] 
//     }    
//   ]
// });

// initDynamicTable({
//   apiUrl: 'http://localhost:8080/api/telefono_sucursal',
//   fields: [
//     { label: 'Número de Sucursal', id: 'numero', type: 'number', apiKey: 'numero', 
//       required: true, validationMessage: 'El número no puede estar vacío' 
//     },
//     { label: 'Sucursal', id: 'sucursal', type: 'select', apiKey: 'sucursal', 
//       required: true, validationMessage: 'Debe seleccionar una sucursal', 
//       options: [] 
//     }
//   ]
// });

// initDynamicTable({
//   apiUrl: 'http://localhost:8080/api/tipo_email',
//   fields: [
//     { label: 'ID', id: 'id', type: 'number', apiKey: 'id', required: true, validationMessage: 'El ID no puede estar vacío' },
//     { label: 'Nombre', id: 'nombre', type: 'text', apiKey: 'nombre', required: true, validationMessage: 'El nombre no puede estar vacío' }
//   ]
// });

// initDynamicTable({
//   apiUrl: 'http://localhost:8080/api/tipo_empresa',
//   fields: [
//     { label: 'ID', id: 'id', type: 'number', apiKey: 'id', required: true, validationMessage: 'El ID no puede estar vacío' },
//     { label: 'Descripción',  id: 'descripcion', type: 'text', apiKey: 'descripcion', required: true, validationMessage: 'La descripción no puede estar vacía y debe tener entre 1 y 100 caracteres'}
//   ]
// });

// initDynamicTable({
//   apiUrl: 'http://localhost:8080/api/tipo_persona',
//   fields: [
//     { label: 'ID', id: 'id', type: 'number', apiKey: 'id', required: true, validationMessage: 'El ID no puede estar vacío'  },
//     { label: 'Nombre',  id: 'nombre', type: 'text', apiKey: 'nombre', required: true, validationMessage: 'El nombre no puede estar vacío y debe tener entre 1 y 100 caracteres' 
//     }
//   ]
// });

// initDynamicTable({
//   apiUrl: 'http://localhost:8080/api/tipo_telefono',
//   fields: [
//     { label: 'ID', id: 'id', type: 'number', apiKey: 'id', required: true, validationMessage: 'El ID no puede estar vacío'  },
//     { label: 'Nombre',  id: 'nombre', type: 'text', apiKey: 'nombre', required: true, validationMessage: 'El nombre no puede estar vacío y debe tener entre 1 y 100 caracteres' 
//     }
//   ]
// });