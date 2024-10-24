import { initDynamicPanel } from "./prueba";
import { initDynamicTable } from "./prueba";

export const listaCruds=[
    [{
        totalFetches:0,
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
      ]
  },{
      apiUrl: 'http://localhost:8080/api/producto',
      fields: [
          { label: 'ID Producto', id: 'idProducto', type: 'text', apiKey: 'id_producto'},
          { label: 'Descripción', id: 'descripcion', type: 'text', apiKey: 'descripcion' },
          { label: 'Precio', id: 'precioProducto', type: 'number', apiKey: 'precio' },
          { label: 'Persona', id: 'persona', type: 'number', apiKey: 'personas',apiExtension:'personas' },
          { label: 'Rol', id: 'rol', type: 'number', apiKey: 'rol',apiExtension:'rol' },
          { label: 'Tipo Persona', id: 'tipoPersona', type: 'number', apiKey: 'tipo_persona',apiExtension:'tipopersona' }
      ]
    }],
    [{
        totalFetches:0,
        buttonText: '+ Registrar Rol',
        panelTitle: 'Agregar Nuevo Rol',
        submitButtonText: 'Registrar Rol',
        apiUrl: 'http://localhost:8080/api/rol',
        fields: [
            { label: 'Id', id: 'id', type: 'number', apiKey: 'id' },
            { label: 'Nombre', id: 'nombre', type: 'text', apiKey: 'nombre'}
        ]
    },{ 
        apiUrl: 'http://localhost:8080/api/rol',
        fields: [
            { label: 'Id', id: 'id', type: 'number', apiKey: 'id' },
            { label: 'Nombre', id: 'nombre', type: 'text', apiKey: 'nombre' }
    ]
    }],
    [{
        totalFetches:2,
        buttonText: '+ Registrar Personas',
        panelTitle: 'Agregar Nuevo Personas',
        submitButtonText: 'Registrar Personas',
        apiUrl: 'http://localhost:8080/api/personas',
        fields: [
            { label: 'Numero Documento', id: 'numerodocumento', type: 'number', apiKey: ' Nro_Doc' },
            { label: 'Nombre', id: 'nombre', type: 'text', apiKey: 'nombre' },
            { label: 'Apellido', id: 'apellido', type: 'text', apiKey: 'apellido' },
            { label: 'Fecha Registro', id: 'fechaRegistro', type: 'date', apiKey: 'fechaRegistro' },
            { label: 'Sucursal', id: 'sucursal', type: 'number', apiKey: 'sucursal', apiExtension:'sucursal',
                required: true, validationMessage: 'Debe seleccionar una sucursal' },
            { label: 'Tipo de Persona', id: 'tipoPersona', type: 'number', apiKey: 'tipoPersona', apiExtension:'tipopersona',
                required: true, validationMessage: 'Debe seleccionar un tipo de persona'  }
        ]
    },{
        apiUrl: 'http://localhost:8080/api/personas',
        fields: [
        { label: 'Numero Documento', id: 'numerodocumento', type: 'number', apiKey: ' Nro_Doc' },
        { label: 'Nombre', id: 'nombre', type: 'text', apiKey: 'nombre' },
        { label: 'Apellido', id: 'apellido', type: 'text', apiKey: 'apellido' },
        { label: 'Fecha Registro', id: 'fechaRegistro', type: 'date', apiKey: 'fechaRegistro' },
        { label: 'Sucursal', id: 'sucursal', type: 'number', apiKey: 'sucursal', apiExtension:'sucursal',
                required: true, validationMessage: 'Debe seleccionar una sucursal'  },
        { label: 'Tipo de Persona', id: 'tipoPersona', type: 'number', apiKey: 'tipoPersona', apiExtension:'tipopersona' ,           
                required: true, validationMessage: 'Debe seleccionar un tipo de persona' }
        ]
    }],
    [{
        totalFetches:1,
        buttonText: '+ Registrar Ciudad',
        panelTitle: 'Agregar Nueva Ciudad',
        submitButtonText: 'Registrar Ciudad',
        apiUrl: 'http://localhost:8080/api/ciudad',
        fields: [
            { label: 'Id', id: 'id', type: 'number', apiKey: ' id' },
            { label: 'Nombre', id: 'nombre', type: 'text', apiKey: 'nombre' },
            { label: 'Region', id: 'region', type: 'text', apiKey: 'region', apiExtension:'region' }
        ]
    },{
        apiUrl: 'http://localhost:8080/api/ciudad',
        fields: [
            { label: 'Id', id: 'id', type: 'number', apiKey: ' id' },
            { label: 'Nombre', id: 'nombre', type: 'text', apiKey: 'nombre' },
            { label: 'Region', id: 'region', type: 'text', apiKey: 'region' , apiExtension:'region' }
        ]
    }],
    [{  
        totalFetches:3,
        buttonText: '+ Registrar Compra',
        panelTitle: 'Agregar Nueva Compra',
        submitButtonText: 'Registrar Compra',
        apiUrl: 'http://localhost:8080/api/compra',
        fields: [
            { label: 'Id', id: 'id', type: 'number', apiKey: ' id' },
            { label: 'Fecha Compra', id: 'fechacompra', type: 'date', apiKey: 'fecha_compra' },
            { label: 'Total', id: 'total', type: 'number', apiKey: 'total', required: true, validationMessage: 'No puede estar vacio' },
            { label: 'Estado Compra', id: 'estadoCompra', type: 'number', apiKey: 'estado_compra', apiExtension:'estadocompra'},
            { label: 'Tipo Compra', id: 'tipoCompra', type: 'number', apiKey: 'tipo_compra', apiExtension:'tipocompra'},
            { label: 'Cliente', id: 'personas', type: 'number', apiKey: 'personas', apiExtension:'personas',
            required: true, validationMessage: 'Debe seleccionar un cliente'
            }
        ]
    },{
      apiUrl: 'http://localhost:8080/api/compra',
        fields: [
            { label: 'Id', id: 'id', type: 'number', apiKey: ' id' },
            { label: 'Fecha Compra', id: 'fechacompra', type: 'date', apiKey: 'fecha_compra' },
            { label: 'Total', id: 'total', type: 'number', apiKey: 'total', required: true, validationMessage: 'No puede estar vacio' },
            { label: 'Estado Compra', id: 'estadoCompra', type: 'number', apiKey: 'estado_compra', apiExtension:'estadocompra'},
            { label: 'Tipo Compra', id: 'tipoCompra', type: 'number', apiKey: 'tipo_compra', apiExtension:'tipocompra'},
            { label: 'Cliente', id: 'personas', type: 'number', apiKey: 'personas', apiExtension:'personas',
            required: true, validationMessage: 'Debe seleccionar un cliente'
            }
        ]
    }],
    [{
        totalFetches:2,
        buttonText: '+ Registrar Detalle compra',
        panelTitle: 'Agregar Nueva Detalle compra',
        submitButtonText: 'Registrar Detalle compra',
        apiUrl: 'http://localhost:8080/api/detallecompra',
        fields: [
            { label: 'Id', id: 'id', type: 'number', apiKey: 'id', required: true, validationMessage: 'El ID no puede estar vacío' },
            { label: 'Cantidad', id: 'cantidad', type: 'number', apiKey: 'cantidad', required: true, validationMessage: 'La cantidad no puede estar vacía' },
            { label: 'Precio Unitario', id: 'precio_unitario', type: 'number', apiKey: 'precio_unitario', required: true, validationMessage: 'El precio unitario no puede estar vacío' },
            { label: 'Insumo', id: 'insumo', type: 'number', apiKey: 'insumo',apiExtension:'insumo'},
            { label: 'Compra', id: 'compra', type: 'number', apiKey: 'compra',apiExtension:'compra' }
        ]
    },{
        apiUrl: 'http://localhost:8080/api/detallecompra',
        fields: [
            { label: 'Id', id: 'id', type: 'number', apiKey: 'id', required: true, validationMessage: 'El ID no puede estar vacío' },
            { label: 'Cantidad', id: 'cantidad', type: 'number', apiKey: 'cantidad', required: true, validationMessage: 'La cantidad no puede estar vacía' },
            { label: 'Precio Unitario', id: 'precio_unitario', type: 'number', apiKey: 'precio_unitario', required: true, validationMessage: 'El precio unitario no puede estar vacío' },
            { label: 'Insumo', id: 'insumo', type: 'number', apiKey: 'insumo'},
            { label: 'Compra', id: 'compra', type: 'number', apiKey: 'compra' }
        ]
    }],
    [{
        totalFetches:2,
        buttonText: '+ Registrar Detalle Orden Servicio',
        panelTitle: 'Agregar Nuevo Detalle Orden Servicio',
        submitButtonText: 'Registrar Detalle Orden Servicio',
        apiUrl: 'http://localhost:8080/api/detallordeservicio',
        fields: [
          { label: 'Id', id: 'id', type: 'number', apiKey: 'id', required: true, validationMessage: 'El ID no puede estar vacío' },
          { label: 'Valor del Servicio', id: 'valor_servicio', type: 'number', apiKey: 'valor_servicio', required: true, validationMessage: 'El valor del servicio no puede estar vacío' },
          { label: 'Orden de Servicio', id: 'id_orden_servicio', type: 'number', apiKey: 'id_orden_servicio', apiExtension:'ordenservicio',
            required: true, validationMessage: 'Debe seleccionar una orden de servicio' },
          { label: 'Servicio', id: 'servicio', type: 'number', apiKey: 'servicio',apiExtension:'servicio', 
            required: true, validationMessage: 'Debe seleccionar un servicio' }
        ]
    },{
        apiUrl: 'http://localhost:8080/api/detallordeservicio',
        fields: [
          { label: 'Id', id: 'id', type: 'number', apiKey: 'id', required: true, validationMessage: 'El ID no puede estar vacío' },
          { label: 'Valor del Servicio', id: 'valor_servicio', type: 'number', apiKey: 'valor_servicio', required: true, validationMessage: 'El valor del servicio no puede estar vacío' },
          { label: 'Orden de Servicio', id: 'id_orden_servicio', type: 'number', apiKey: 'id_orden_servicio', apiExtension:'ordenservicio',
            required: true, validationMessage: 'Debe seleccionar una orden de servicio' },
          { label: 'Servicio', id: 'servicio', type: 'number', apiKey: 'servicio',apiExtension:'servicio', 
            required: true, validationMessage: 'Debe seleccionar un servicio' }
        ]
    }],
    [{
        totalFetches:3,
        buttonText: '+ Registrar Detalle Orden Trabajo',
        panelTitle: 'Agregar Nuevo Detalle Orden Trabajo',
        submitButtonText: 'Registrar Detalle Orden Trabajo',
        apiUrl: 'http://localhost:8080/api/detalleordentrabajo',
        fields: [
          { label: 'Id', id: 'id', type: 'number', apiKey: 'id', required: true, validationMessage: 'El ID no puede estar vacío' },
          { label: 'Fecha', id: 'fecha', type: 'date', apiKey: 'fecha', required: true, validationMessage: 'La fecha no puede estar vacía' },
          { label: 'Orden de Trabajo', id: 'orden_trabajo', type: 'number', apiKey: 'orden_trabajo', apiExtension:'ordentrabajo',
            required: true, validationMessage: 'Debe seleccionar una orden de trabajo'},
          { label: 'Estado de Orden', id: 'estado_orden', type: 'number', apiKey: 'estado_orden', apiExtension:'estadoorden',
            required: true, validationMessage: 'Debe seleccionar un estado de orden'},
          { label: 'Servicio', id: 'servicio', type: 'number', apiKey: 'servicio', apiExtension:'servicio',
            required: true, validationMessage: 'Debe seleccionar un servicio' }
        ]
    },{
        apiUrl: 'http://localhost:8080/api/detalleordentrabajo',
        fields: [
          { label: 'Id', id: 'id', type: 'number', apiKey: 'id', required: true, validationMessage: 'El ID no puede estar vacío' },
          { label: 'Fecha', id: 'fecha', type: 'date', apiKey: 'fecha', required: true, validationMessage: 'La fecha no puede estar vacía' },
          { label: 'Orden de Trabajo', id: 'orden_trabajo', type: 'number', apiKey: 'orden_trabajo', apiExtension:'ordentrabajo',
            required: true, validationMessage: 'Debe seleccionar una orden de trabajo'},
          { label: 'Estado de Orden', id: 'estado_orden', type: 'number', apiKey: 'estado_orden', apiExtension:'estadoorden',
            required: true, validationMessage: 'Debe seleccionar un estado de orden'},
          { label: 'Servicio', id: 'servicio', type: 'number', apiKey: 'servicio', apiExtension:'servicio',
            required: true, validationMessage: 'Debe seleccionar un servicio' }
        ]  
    }],
    [{
        totalFetches:1,
        buttonText: '+ Registrar Direccion  ',
        panelTitle: 'Agregar Nuevo Direccion  ',
        submitButtonText: 'Registrar Direccion  ',
        apiUrl: 'http://localhost:8080/api/direccion',
        fields: [          
            { label: 'Calle', id: 'calle', type: 'text', apiKey: 'calle', required: true, validationMessage: 'La calle no puede estar vacía y debe tener entre 1 y 100 caracteres' },
            { label: 'Carrera', id: 'carrera', type: 'text', apiKey: 'carrera', validationMessage: 'Este campo es opcional' },
            { label: 'Descripción', id: 'descripcion', type: 'text', apiKey: 'descripcion', validationMessage: 'Este campo es opcional' },
            { label: 'Barrio', id: 'barrio', type: 'text', apiKey: 'barrio', validationMessage: 'Este campo es opcional' },
            { label: 'Ciudad', id: 'ciudad', type: 'number', apiKey: 'ciudad',apiExtension:'ciudad', validationMessage: 'Este campo es opcional' }
        ]
    },{
        apiUrl: 'http://localhost:8080/api/direccion',
        fields: [          
            { label: 'Calle', id: 'calle', type: 'text', apiKey: 'calle', required: true, validationMessage: 'La calle no puede estar vacía y debe tener entre 1 y 100 caracteres' },
            { label: 'Carrera', id: 'carrera', type: 'text', apiKey: 'carrera', validationMessage: 'Este campo es opcional' },
            { label: 'Descripción', id: 'descripcion', type: 'text', apiKey: 'descripcion', validationMessage: 'Este campo es opcional' },
            { label: 'Barrio', id: 'barrio', type: 'text', apiKey: 'barrio', validationMessage: 'Este campo es opcional' },
            { label: 'Ciudad', id: 'ciudad', type: 'number', apiKey: 'ciudad',apiExtension:'ciudad', validationMessage: 'Este campo es opcional' }
        ]
    }],
    [{
        totalFetches:2,
        buttonText: '+ Registrar Email Persona  ',
        panelTitle: 'Agregar Nuevo Email Persona ',
        submitButtonText: 'Registrar Email Persona ',
        apiUrl: 'http://localhost:8080/api/emailpersona',
        fields: [          
          { label: 'Id', id: 'id', type: 'number', apiKey: 'id', required: true, validationMessage: 'El ID no puede estar vacío' },
          { label: 'Email', id: 'email', type: 'email', apiKey: 'email', required: true, validationMessage: 'El email no puede estar vacío y debe ser válido' },
          { label: 'Persona', id: 'personas', type: 'number', apiKey: 'personas',apiExtension:'personas' },
          { label: 'Tipo de Email', id: 'tipoEmail', type: 'number', apiKey: 'tipoEmail',apiExtension:'tipoEmail' }
        ]
    },{
        apiUrl: 'http://localhost:8080/api/emailpersona',
        fields: [          
          { label: 'Id', id: 'id', type: 'number', apiKey: 'id', required: true, validationMessage: 'El ID no puede estar vacío' },
          { label: 'Email', id: 'email', type: 'email', apiKey: 'email', required: true, validationMessage: 'El email no puede estar vacío y debe ser válido' },
          { label: 'Persona', id: 'personas', type: 'number', apiKey: 'personas',apiExtension:'personas' },
          { label: 'Tipo de Email', id: 'tipoEmail', type: 'number', apiKey: 'tipoEmail',apiExtension:'tipoEmail' }
        ]
    }],
    [{
        totalFetches:1,
        buttonText: '+ Registrar Empresa  ',
        panelTitle: 'Agregar Nueva Empresa ',
        submitButtonText: 'Registrar Empresa ',
        apiUrl: 'http://localhost:8080/api/empresa',
        fields: [          
          { label: 'Id', id: 'id', type: 'number', apiKey: 'id', required: true, validationMessage: 'El ID no puede estar vacío' },
          { label: 'Nombre', id: 'nombre', type: 'text', apiKey: 'nombre', required: true, validationMessage: 'El nombre no puede estar vacío y debe tener entre 1 y 100 caracteres' },
          { label: 'Tipo de Empresa', id: 'tipo_empresa', type: 'number', apiKey: 'tipo_empresa', apiExtension:'tipoEmpresa',
            required: true, validationMessage: 'El tipo de empresa no puede estar vacío'
          }
        ]
    },{
        apiUrl: 'http://localhost:8080/api/empresa',
        fields: [          
          { label: 'Id', id: 'id', type: 'number', apiKey: 'id', required: true, validationMessage: 'El ID no puede estar vacío' },
          { label: 'Nombre', id: 'nombre', type: 'text', apiKey: 'nombre', required: true, validationMessage: 'El nombre no puede estar vacío y debe tener entre 1 y 100 caracteres' },
          { label: 'Tipo de Empresa', id: 'tipo_empresa', type: 'number', apiKey: 'tipo_empresa', apiExtension:'tipoEmpresa',
            required: true, validationMessage: 'El tipo de empresa no puede estar vacío'
          }
        ]
    }],
    [{
        totalFetches:4,
        buttonText: '+ Registrar Aprovacion Servicio  ',
        panelTitle: 'Agregar Nuevo Aprovacion Servicio ',
        submitButtonText: 'Registrar Aprovacion Servicio ',
        apiUrl: 'http://localhost:8080/api/aprovacionservicio',
        fields: [          
            { label: 'Id', id: 'id', type: 'number', apiKey: 'id', required: true, validationMessage: 'El ID no puede estar vacío' },
            { label: 'Orden de Trabajo', id: 'orden_trabajo', type: 'number', apiKey: 'orden_trabajo',apiExtension:'ordentrabajo' }, 
            { label: 'Cliente', id: 'personas', type: 'number', apiKey: 'personas', apiExtension:'personas',             
              required: true, validationMessage: 'Debe seleccionar un cliente' },
            { label: 'Servicio', id: 'servicio', type: 'number', apiKey: 'servicio', apiExtension:'servicio',              
              required: true, validationMessage: 'Debe seleccionar un servicio'},
            { label: 'Hallazgo', id: 'hallazgo', type: 'text', apiKey: 'hallazgo', required: false, placeholder: 'Ingrese el hallazgo encontrado' },
            { label: 'Solución', id: 'solucion', type: 'text', apiKey: 'solucion', required: false, placeholder: 'Ingrese la solución implementada' },
            { label: 'Motivo de Rechazo', id: 'motivoRechazo', type: 'text', apiKey: 'motivoRechazo', required: false, placeholder: 'Ingrese el motivo de rechazo' },
            { label: 'Estado de Aprobación', id: 'estado_aprobacion', type: 'number', apiKey: 'estado_aprobacion', apiExtension:'estadoaprobacion',             
              required: true, validationMessage: 'Debe seleccionar un estado de aprobación'}
        ]
    },{
        apiUrl: 'http://localhost:8080/api/aprovacionservicio',
        fields: [          
            { label: 'Id', id: 'id', type: 'number', apiKey: 'id', required: true, validationMessage: 'El ID no puede estar vacío' },
            { label: 'Orden de Trabajo', id: 'orden_trabajo', type: 'number', apiKey: 'orden_trabajo',apiExtension:'ordentrabajo' }, 
            { label: 'Cliente', id: 'personas', type: 'number', apiKey: 'personas', apiExtension:'personas',             
              required: true, validationMessage: 'Debe seleccionar un cliente' },
            { label: 'Servicio', id: 'servicio', type: 'number', apiKey: 'servicio', apiExtension:'servicio',              
              required: true, validationMessage: 'Debe seleccionar un servicio'},
            { label: 'Hallazgo', id: 'hallazgo', type: 'text', apiKey: 'hallazgo', required: false, placeholder: 'Ingrese el hallazgo encontrado' },
            { label: 'Solución', id: 'solucion', type: 'text', apiKey: 'solucion', required: false, placeholder: 'Ingrese la solución implementada' },
            { label: 'Motivo de Rechazo', id: 'motivoRechazo', type: 'text', apiKey: 'motivoRechazo', required: false, placeholder: 'Ingrese el motivo de rechazo' },
            { label: 'Estado de Aprobación', id: 'estado_aprobacion', type: 'number', apiKey: 'estado_aprobacion', apiExtension:'estadoaprobacion',             
              required: true, validationMessage: 'Debe seleccionar un estado de aprobación'}
        ]
    }],
    [{
        totalFetches:2,
        buttonText: '+ Registrar Empresa Servicio  ',
        panelTitle: 'Agregar Nueva Empresa Servicio ',
        submitButtonText: 'Registrar Aprovacion Servicio ',
        apiUrl: 'http://localhost:8080/api/empresaServicio',
        fields: [          
          { label: 'ID Empresa-Servicio', id: 'id', type: 'text', apiKey: 'id', required: true, validationMessage: 'El ID no puede estar vacío' },
          { label: 'Valor del Servicio', id: 'valorServicio', type: 'number', apiKey: 'valorServicio', required: true, validationMessage: 'El valor del servicio no puede estar vacío' },
          { label: 'Sucursal', id: 'sucursal', type: 'number', apiKey: 'sucursal', apiExtension:'sucursal',           
            required: true, validationMessage: 'Debe seleccionar una sucursal'},
          { label: 'Servicio', id: 'servicio', type: 'number', apiKey: 'servicio', apiExtension:'servicio',            
            required: true, validationMessage: 'Debe seleccionar un servicio'}
        ]
    },{
        apiUrl: 'http://localhost:8080/api/empresaServicio',
        fields: [          
          { label: 'ID Empresa-Servicio', id: 'id', type: 'text', apiKey: 'id', required: true, validationMessage: 'El ID no puede estar vacío' },
          { label: 'Valor del Servicio', id: 'valorServicio', type: 'number', apiKey: 'valorServicio', required: true, validationMessage: 'El valor del servicio no puede estar vacío' },
          { label: 'Sucursal', id: 'sucursal', type: 'number', apiKey: 'sucursal', apiExtension:'sucursal',           
            required: true, validationMessage: 'Debe seleccionar una sucursal'},
          { label: 'Servicio', id: 'servicio', type: 'number', apiKey: 'servicio', apiExtension:'servicio',            
            required: true, validationMessage: 'Debe seleccionar un servicio'}
        ] 
    }],
    [{
        totalFetches:0,
        buttonText: '+ Registrar Estado Aprobacion  ',
        panelTitle: 'Agregar Nuevo Estado Aprobacion ',
        submitButtonText: 'Registrar Estado Aprobacion ',
        apiUrl: 'http://localhost:8080/api/estadoaprobacion',
        fields: [     
          { label: 'ID', id: 'id', type: 'number', apiKey: 'id', required: true, validationMessage: 'El ID no puede estar vacío' },     
          { label: 'Nombre', id: 'nombre', type: 'text', apiKey: 'nombre', required: true, validationMessage: 'El nombre no puede estar vacío' }
        ]
    },{
        apiUrl: 'http://localhost:8080/api/estadoprobacion',
        fields: [     
          { label: 'ID', id: 'id', type: 'number', apiKey: 'id', required: true, validationMessage: 'El ID no puede estar vacío' },     
          { label: 'Nombre', id: 'nombre', type: 'text', apiKey: 'nombre', required: true, validationMessage: 'El nombre no puede estar vacío' }
        ]
    }],
    [{
      totalFetches:0,
      buttonText: '+ Registrar Estado Compra  ',
      panelTitle: 'Agregar Nuevo Estado Compra ',
      submitButtonText: 'Registrar Estado Compra ',
      apiUrl: 'http://localhost:8080/api/estadocompra',
      fields: [          
        { label: 'ID', id: 'id', type: 'number', apiKey: 'id', required: true, validationMessage: 'El ID no puede estar vacío' },
        { label: 'Nombre', id: 'nombre', type: 'text', apiKey: 'nombre', required: true, validationMessage: 'El nombre no puede estar vacío' }
      ]
    },{
      apiUrl: 'http://localhost:8080/api/estadocompra',
      fields: [          
        { label: 'ID', id: 'id', type: 'number', apiKey: 'id', required: true, validationMessage: 'El ID no puede estar vacío' },
        { label: 'Nombre', id: 'nombre', type: 'text', apiKey: 'nombre', required: true, validationMessage: 'El nombre no puede estar vacío' }
      ]  
    }],
    [{
      totalFetches:0,
      buttonText: '+ Registrar Estado Orden  ',
      panelTitle: 'Agregar Nuevo Estado Orden ',
      submitButtonText: 'Registrar Estado Orden ',
      apiUrl: 'http://localhost:8080/api/estadoorden',
      fields: [          
        { label: 'ID', id: 'id', type: 'number', apiKey: 'id', required: true, validationMessage: 'El ID no puede estar vacío' },
        { label: 'Nombre', id: 'nombre', type: 'text', apiKey: 'nombre', required: true, validationMessage: 'El nombre no puede estar vacío' }
      ]
    },{
      apiUrl: 'http://localhost:8080/api/estadoorden',
      fields: [          
        { label: 'ID', id: 'id', type: 'number', apiKey: 'id', required: true, validationMessage: 'El ID no puede estar vacío' },
        { label: 'Nombre', id: 'nombre', type: 'text', apiKey: 'nombre', required: true, validationMessage: 'El nombre no puede estar vacío' }
      ]
    }],
    [{
      totalFetches:0,
      buttonText: '+ Registrar Estado Orden Servicio ',
      panelTitle: 'Agregar Nuevo Estado Orden Servicio ',
      submitButtonText: 'Registrar Estado Orden Servicio',
      apiUrl: 'http://localhost:8080/api/estadoordenservicio',
      fields: [          
        { label: 'ID', id: 'id', type: 'number', apiKey: 'id', required: true, validationMessage: 'El ID no puede estar vacío' },
        { label: 'Nombre', id: 'nombre', type: 'text', apiKey: 'nombre', required: true, validationMessage: 'El nombre no puede estar vacío' }
      ]
    },{
      apiUrl: 'http://localhost:8080/api/estadoordenservicio',
      fields: [          
        { label: 'ID', id: 'id', type: 'number', apiKey: 'id', required: true, validationMessage: 'El ID no puede estar vacío' },
        { label: 'Nombre', id: 'nombre', type: 'text', apiKey: 'nombre', required: true, validationMessage: 'El nombre no puede estar vacío' }
      ] 
    }],
    [{
      totalFetches:2,
      buttonText: '+ Registrar Login ',
      panelTitle: 'Agregar Nuevo Login ',
      submitButtonText: 'Registrar Login',
      apiUrl: 'http://localhost:8080/api/login',
      fields: [          
        { label: 'ID', id: 'id', type: 'number', apiKey: 'id', required: true, validationMessage: 'El ID no puede estar vacío' },
        { label: 'Usuario', id: 'usuario', type: 'text', apiKey: 'usuario', required: true, unique: true, validationMessage: 'El usuario no puede estar vacío y debe ser único' },
        { label: 'Contraseña', id: 'contraseña', type: 'password', apiKey: 'contraseña', required: true, unique: true, validationMessage: 'La contraseña no puede estar vacía y debe ser única' },
        { label: 'Rol', id: 'rol', type: 'number', apiKey: 'rol', apiExtension:'rol',
      required: true, validationMessage: 'Debe seleccionar un rol'},
        { label: 'Persona', id: 'personas', type: 'number', apiKey: 'personas', apiExtension:'personas',
      required: true, validationMessage: 'Debe seleccionar una persona' }
      ]
    },{
      apiUrl: 'http://localhost:8080/api/login',
      fields: [          
        { label: 'ID', id: 'id', type: 'number', apiKey: 'id', required: true, validationMessage: 'El ID no puede estar vacío' },
        { label: 'Usuario', id: 'usuario', type: 'text', apiKey: 'usuario', required: true, unique: true, validationMessage: 'El usuario no puede estar vacío y debe ser único' },
        { label: 'Contraseña', id: 'contraseña', type: 'password', apiKey: 'contraseña', required: true, unique: true, validationMessage: 'La contraseña no puede estar vacía y debe ser única' },
        { label: 'Rol', id: 'rol', type: 'number', apiKey: 'rol', apiExtension:'rol',
      required: true, validationMessage: 'Debe seleccionar un rol'},
        { label: 'Persona', id: 'personas', type: 'number', apiKey: 'personas', apiExtension:'personas',
      required: true, validationMessage: 'Debe seleccionar una persona' }
      ]  
    }],
    [{
      totalFetches:3,
      buttonText: '+ Registrar Orden Servicio ',
      panelTitle: 'Agregar Nuevo Orden Servicio ',
      submitButtonText: 'Registrar Orden Servicio',
      apiUrl: 'http://localhost:8080/api/ordenservicio',
      fields: [          
        { label: 'Número de Orden', id: 'numero_orden', type: 'number', apiKey: 'numero_orden', required: true, validationMessage: 'El número de orden no puede estar vacío' },
        { label: 'Fecha de Orden', id: 'fecha_orden', type: 'date', apiKey: 'fecha_orden', required: true, validationMessage: 'La fecha de orden no puede estar vacía' },
        { label: 'Cliente', id: 'personas', type: 'number', apiKey: 'personas', apiExtension:'personas',
          required: true, validationMessage: 'Debe seleccionar un cliente'},
        { label: 'Empleado', id: 'persona', type: 'number', apiKey: 'persona', apiExtension:'personas',
          required: true, validationMessage: 'Debe seleccionar un empleado'},
        { label: 'Estado de la Orden', id: 'estado_orden_servicio', type: 'number', apiKey: 'estado_orden_servicio', apiExtension:'estadoorden',
          required: true, validationMessage: 'Debe seleccionar un estado de la orden'}
      ]
    },{
      apiUrl: 'http://localhost:8080/api/ordenservicio',
      fields: [          
        { label: 'Número de Orden', id: 'numero_orden', type: 'number', apiKey: 'numero_orden', required: true, validationMessage: 'El número de orden no puede estar vacío' },
        { label: 'Fecha de Orden', id: 'fecha_orden', type: 'date', apiKey: 'fecha_orden', required: true, validationMessage: 'La fecha de orden no puede estar vacía' },
        { label: 'Cliente', id: 'personas', type: 'number', apiKey: 'personas', apiExtension:'personas',
          required: true, validationMessage: 'Debe seleccionar un cliente'},
        { label: 'Empleado', id: 'persona', type: 'number', apiKey: 'persona', apiExtension:'personas',
          required: true, validationMessage: 'Debe seleccionar un empleado'},
        { label: 'Estado de la Orden', id: 'estado_orden_servicio', type: 'number', apiKey: 'estado_orden_servicio', apiExtension:'estadoorden',
          required: true, validationMessage: 'Debe seleccionar un estado de la orden'}
      ]  
    }],
    [{
      totalFetches:2,
      buttonText: '+ Registrar Orden Trabajo ',
      panelTitle: 'Agregar Nuevo Orden Trabajo ',
      submitButtonText: 'Registrar Orden Trabajo',
      apiUrl: 'http://localhost:8080/api/ordentrabajo',
      fields: [          
        { label: 'Número de Orden de Trabajo', id: 'numeroOrdenTrabajo', type: 'number', apiKey: 'numero_orden_trabajo', required: true, validationMessage: 'No puede estar vacío' },
        { label: 'Fecha de Asignación', id: 'fechaAsignacion', type: 'date', apiKey: 'fecha_asignacion', required: true, validationMessage: 'Seleccione una fecha' },
        { label: 'Hora de Asignación', id: 'horaAsignacion', type: 'time', apiKey: 'hora_asignacion', required: true, validationMessage: 'Seleccione una hora' },
        { label: 'Empleado', id: 'personas', type: 'number', apiKey: 'personas', apiExtension:'personas',
          required: true, validationMessage: 'Seleccione un empleado' },
        { label: 'Orden de Servicio', id: 'ordenServicio', type: 'number', apiKey: 'ordenServicio', apiExtension:'ordentrabajo',
          required: true, validationMessage: 'Seleccione una orden de servicio'  }
      ]
    },{
      apiUrl: 'http://localhost:8080/api/ordentrabajo',
      fields: [          
        { label: 'Número de Orden de Trabajo', id: 'numeroOrdenTrabajo', type: 'number', apiKey: 'numero_orden_trabajo', required: true, validationMessage: 'No puede estar vacío' },
        { label: 'Fecha de Asignación', id: 'fechaAsignacion', type: 'date', apiKey: 'fecha_asignacion', required: true, validationMessage: 'Seleccione una fecha' },
        { label: 'Hora de Asignación', id: 'horaAsignacion', type: 'time', apiKey: 'hora_asignacion', required: true, validationMessage: 'Seleccione una hora' },
        { label: 'Empleado', id: 'personas', type: 'number', apiKey: 'personas', apiExtension:'personas',
          required: true, validationMessage: 'Seleccione un empleado' },
        { label: 'Orden de Servicio', id: 'ordenServicio', type: 'number', apiKey: 'ordenServicio', apiExtension:'ordentrabajo',
          required: true, validationMessage: 'Seleccione una orden de servicio'  }
      ]
    }],
    [{
      totalFetches:0,
      buttonText: '+ Registrar Pais ',
      panelTitle: 'Agregar Nuevo Pais ',
      submitButtonText: 'Registrar Pais',
      apiUrl: 'http://localhost:8080/api/pais',
      fields: [          
        { label: 'ID', id: 'id', type: 'number', apiKey: 'id', required: true, validationMessage: 'El ID no puede estar vacío' },
        { label: 'Nombre', id: 'nombre', type: 'text', apiKey: 'nombre', required: true, validationMessage: 'El nombre no puede estar vacío' }
      ]
    },{
      apiUrl: 'http://localhost:8080/api/pais',
      fields: [          
        { label: 'ID', id: 'id', type: 'number', apiKey: 'id', required: true, validationMessage: 'El ID no puede estar vacío' },
        { label: 'Nombre', id: 'nombre', type: 'text', apiKey: 'nombre', required: true, validationMessage: 'El nombre no puede estar vacío' }
      ]  
    }],
    [{
      totalFetches:3,
      buttonText: '+ Registrar Persona Insumo ',
      panelTitle: 'Agregar Nueva Persona Insumo ',
      submitButtonText: 'Registrar Persona Insumo',
      apiUrl: 'http://localhost:8080/api/personainsumo',
      fields: [          
        { label: 'Servicio', id: 'servicio', type: 'number', apiKey: 'servicio', apiExtension:'servicio',            
            required: true, validationMessage: 'Debe seleccionar un servicio'}  ,
        { label: 'Proveedor', id: 'personas', type: 'number', apiKey: 'personas',apiExtension:'personas', required: true, validationMessage: 'Debe seleccionar una persona' },
        { label: 'Insumo', id: 'insumo', type: 'number', apiKey: 'insumo',apiExtension:'insumo', required: true, validationMessage: 'Debe seleccionar un insumo' }
      ]
    },{
      apiUrl: 'http://localhost:8080/api/personainsumo',
      fields: [          
        { label: 'Servicio', id: 'servicio', type: 'number', apiKey: 'servicio', apiExtension:'servicio',            
            required: true, validationMessage: 'Debe seleccionar un servicio'}  ,
        { label: 'Proveedor', id: 'personas', type: 'number', apiKey: 'personas',apiExtension:'personas', required: true, validationMessage: 'Debe seleccionar una persona' },
        { label: 'Insumo', id: 'insumo', type: 'number', apiKey: 'insumo',apiExtension:'insumo', required: true, validationMessage: 'Debe seleccionar un insumo' }
      ] 
    }],
    [{
      totalFetches:1,
      buttonText: '+ Registrar Region ',
      panelTitle: 'Agregar Nueva Region ',
      submitButtonText: 'Registrar Region',
      apiUrl: 'http://localhost:8080/api/region',
      fields: [          
        { label: 'ID', id: 'id', type: 'number', apiKey: 'id' },
        { label: 'Nombre', id: 'nombre', type: 'text', apiKey: 'nombre', 
          required: true, validationMessage: 'El nombre no puede estar vacío' },
        { label: 'País', id: 'pais', type: 'number', apiKey: 'pais', apiExtension:'pais',
          required: true, validationMessage: 'Debe seleccionar un país'
        }
      ]
    },{
      apiUrl: 'http://localhost:8080/api/region',
      fields: [          
        { label: 'ID', id: 'id', type: 'number', apiKey: 'id' },
        { label: 'Nombre', id: 'nombre', type: 'text', apiKey: 'nombre', 
          required: true, validationMessage: 'El nombre no puede estar vacío' },
        { label: 'País', id: 'pais', type: 'number', apiKey: 'pais', apiExtension:'pais',
          required: true, validationMessage: 'Debe seleccionar un país'
        }
      ]  
    }],
    [{
      totalFetches:0,
      buttonText: '+ Registrar Servicio ',
      panelTitle: 'Agregar Nuevo Servicio ',
      submitButtonText: 'Registrar Servicio',
      apiUrl: 'http://localhost:8080/api/servicio',
      fields: [          
        { label: 'ID', id: 'id', type: 'number', apiKey: 'id' },
        { label: 'Nombre', id: 'nombre', type: 'text', apiKey: 'nombre', 
          required: true, validationMessage: 'El nombre no puede estar vacío', maxLength: 50 },
        { label: 'Requiere Insumo', id: 'requiere_insumo', type: 'checkbox', apiKey: 'requiere_insumo', 
          required: true, validationMessage: 'Debe indicar si requiere insumo'   },
        { label: 'Tiempo de Ejecución', id: 'tiempo_ejecucion', type: 'text', apiKey: 'tiempo_ejecucion', 
          required: true, validationMessage: 'El tiempo de ejecución no puede estar vacío' }
      ]
    },{
      apiUrl: 'http://localhost:8080/api/servicio',
      fields: [          
        { label: 'ID', id: 'id', type: 'number', apiKey: 'id' },
        { label: 'Nombre', id: 'nombre', type: 'text', apiKey: 'nombre', 
          required: true, validationMessage: 'El nombre no puede estar vacío', maxLength: 50 },
        { label: 'Requiere Insumo', id: 'requiere_insumo', type: 'checkbox', apiKey: 'requiere_insumo', 
          required: true, validationMessage: 'Debe indicar si requiere insumo'   },
        { label: 'Tiempo de Ejecución', id: 'tiempo_ejecucion', type: 'text', apiKey: 'tiempo_ejecucion', 
          required: true, validationMessage: 'El tiempo de ejecución no puede estar vacío' }
      ]  
    }],
    [{
      totalFetches:2,
      buttonText: '+ Registrar Servicio Insumo ',
      panelTitle: 'Agregar Nuevo Servicio Insumo',
      submitButtonText: 'Registrar Servicio Insumo',
      apiUrl: 'http://localhost:8080/api/servicioinsumo',
      fields: [        
        { label: 'Cantidad', id: 'cantidad', type: 'number', apiKey: 'cantidad', 
          required: true, validationMessage: 'El nombre no puede estar vacío',  maxLength: 50 },
        { label: 'Insumo', id: 'insumo', type: 'number', apiKey: 'insumo', apiExtension:'insumo',
          required: true, validationMessage: 'Debe indicar si requiere insumo' },
        { label: 'Servicio', id: 'id_servicio', type: 'number', apiKey: 'servicio', apiExtension:'servicio',
          required: true, validationMessage: 'El tiempo de ejecución no puede estar vacío' }
      ]
    },{
      apiUrl: 'http://localhost:8080/api/servicioinsumo',
      fields: [        
        { label: 'Cantidad', id: 'cantidad', type: 'number', apiKey: 'cantidad', 
          required: true, validationMessage: 'El nombre no puede estar vacío',  maxLength: 50 },
        { label: 'Insumo', id: 'insumo', type: 'number', apiKey: 'insumo', apiExtension:'insumo',
          required: true, validationMessage: 'Debe indicar si requiere insumo' },
        { label: 'Servicio', id: 'id_servicio', type: 'number', apiKey: 'servicio', apiExtension:'servicio',
          required: true, validationMessage: 'El tiempo de ejecución no puede estar vacío' }
      ]  
    }],
    [{
      totalFetches:2,
      buttonText: '+ Registrar Sucursal',
      panelTitle: 'Agregar Nueva Sucursal',
      submitButtonText: 'Registrar Sucursal',
      apiUrl: 'http://localhost:8080/api/sucursal',
      fields: [          
        { label: 'Nombre', id: 'nombre', type: 'text', apiKey: 'nombre', 
          required: true, validationMessage: 'El nombre no puede estar vacío y debe tener entre 1 y 100 caracteres', 
          minLength: 1, maxLength: 100    },
        { label: 'NIT', id: 'nit', type: 'text', apiKey: 'nit', 
          required: true, validationMessage: 'El NIT no puede estar vacío y debe tener entre 1 y 100 caracteres', 
          minLength: 1, maxLength: 100    },
        { label: 'Fecha de Creación', id: 'fecha_creacion', type: 'datetime-local', apiKey: 'fecha_creacion', 
          required: false   },
        { label: 'Dirección', id: 'direccion', type: 'number', apiKey: 'direccion', apiExtension:'direccion',
          required: true, validationMessage: 'Debe seleccionar una dirección', },
        { label: 'Empresa', id: 'empresa', type: 'number', apiKey: 'empresa', apiExtension:'empresa',
          required: true, validationMessage: 'Debe seleccionar una empresa',}
      ]
    },{
      apiUrl: 'http://localhost:8080/api/sucursal',
      fields: [          
        { label: 'Nombre', id: 'nombre', type: 'text', apiKey: 'nombre', 
          required: true, validationMessage: 'El nombre no puede estar vacío y debe tener entre 1 y 100 caracteres', 
          minLength: 1, maxLength: 100    },
        { label: 'NIT', id: 'nit', type: 'text', apiKey: 'nit', 
          required: true, validationMessage: 'El NIT no puede estar vacío y debe tener entre 1 y 100 caracteres', 
          minLength: 1, maxLength: 100    },
        { label: 'Fecha de Creación', id: 'fecha_creacion', type: 'datetime-local', apiKey: 'fecha_creacion', 
          required: false   },
        { label: 'Dirección', id: 'direccion', type: 'number', apiKey: 'direccion', apiExtension:'direccion',
          required: true, validationMessage: 'Debe seleccionar una dirección', },
        { label: 'Empresa', id: 'empresa', type: 'number', apiKey: 'empresa', apiExtension:'empresa',
          required: true, validationMessage: 'Debe seleccionar una empresa',}
      ]  
    }],
    [{
      totalFetches:2,
      buttonText: '+ Registrar Telefono Persona',
      panelTitle: 'Agregar Nueva Telefono Persona',
      submitButtonText: 'Registrar Telefono Persona',
      apiUrl: 'http://localhost:8080/api/telefonopersona',
      fields: [          
        { label: 'Número de Teléfono', id: 'numero', type: 'number', apiKey: 'numero', 
          required: true, validationMessage: 'El número de teléfono no puede ser nulo'   },
        { label: 'Tipo de Teléfono', id: 'tipoTelefono', type: 'number', apiKey: 'tipoTelefono', apiExtension:'tipotelefono',
          required: true, validationMessage: 'Debe seleccionar un tipo de teléfono',   },
        { label: 'Persona', id: 'personas', type: 'number', apiKey: 'personas', apiExtension:'personas',
          required: true, validationMessage: 'Debe seleccionar una persona', } 
      ]
    },{
      apiUrl: 'http://localhost:8080/api/telefonopersona',
      fields: [          
        { label: 'Número de Teléfono', id: 'numero', type: 'number', apiKey: 'numero', 
          required: true, validationMessage: 'El número de teléfono no puede ser nulo' 
        },
        { label: 'Tipo de Teléfono', id: 'tipoTelefono', type: 'number', apiKey: 'tipoTelefono', apiExtension:'tipotelefono',
          required: true, validationMessage: 'Debe seleccionar un tipo de teléfono',   },
        { label: 'Persona', id: 'personas', type: 'number', apiKey: 'personas', apiExtension:'personas',
          required: true, validationMessage: 'Debe seleccionar una persona', } 
      ]  
    }],
    [{
      totalFetches:1,
      buttonText: '+ Registrar Telefono Sucursal',
      panelTitle: 'Agregar Nueva Telefono Sucursal',
      submitButtonText: 'Registrar Telefono Sucursal',
      apiUrl: 'http://localhost:8080/api/telefonosucursal',
      fields: [          
        { label: 'Número de Sucursal', id: 'numero', type: 'number', apiKey: 'numero', 
          required: true, validationMessage: 'El número no puede estar vacío' },
        { label: 'Sucursal', id: 'sucursal', type: 'number', apiKey: 'sucursal', 
          required: true, validationMessage: 'Debe seleccionar una sucursal', apiExtension:'sucursal', }
      ]
    },{
      apiUrl: 'http://localhost:8080/api/telefonosucursal',
      fields: [          
        { label: 'Número de Sucursal', id: 'numero', type: 'number', apiKey: 'numero', 
          required: true, validationMessage: 'El número no puede estar vacío' },
        { label: 'Sucursal', id: 'sucursal', type: 'number', apiKey: 'sucursal', 
          required: true, validationMessage: 'Debe seleccionar una sucursal', apiExtension:'sucursal', }
      ]  
    }],
    [{
      totalFetches:0,
      buttonText: '+ Registrar Tipo Email',
      panelTitle: 'Agregar Nueva Tipo Email',
      submitButtonText: 'Registrar Tipo Email',
      apiUrl: 'http://localhost:8080/api/tipoemail',
      fields: [          
        { label: 'ID', id: 'id', type: 'number', apiKey: 'id', required: true, validationMessage: 'El ID no puede estar vacío' },
        { label: 'Nombre', id: 'nombre', type: 'text', apiKey: 'nombre', required: true, validationMessage: 'El nombre no puede estar vacío' }
      ]
    },{
      apiUrl: 'http://localhost:8080/api/tipoemail',
      fields: [          
        { label: 'ID', id: 'id', type: 'number', apiKey: 'id', required: true, validationMessage: 'El ID no puede estar vacío' },
        { label: 'Nombre', id: 'nombre', type: 'text', apiKey: 'nombre', required: true, validationMessage: 'El nombre no puede estar vacío' }
      ]  
    }],
    [{
      totalFetches:0,
      buttonText: '+ Registrar Tipo Empresa',
      panelTitle: 'Agregar Nueva Tipo Empresa',
      submitButtonText: 'Registrar Tipo Empresa',
      apiUrl: 'http://localhost:8080/api/tipoempresa',
      fields: [          
        { label: 'ID', id: 'id', type: 'number', apiKey: 'id', required: true, validationMessage: 'El ID no puede estar vacío' },
        { label: 'Descripción',  id: 'descripcion', type: 'text', apiKey: 'descripcion', required: true, validationMessage: 'La descripción no puede estar vacía y debe tener entre 1 y 100 caracteres'}
      ]
    },{
      apiUrl: 'http://localhost:8080/api/tipoempresa',
      fields: [          
        { label: 'ID', id: 'id', type: 'number', apiKey: 'id', required: true, validationMessage: 'El ID no puede estar vacío' },
        { label: 'Descripción',  id: 'descripcion', type: 'text', apiKey: 'descripcion', required: true, validationMessage: 'La descripción no puede estar vacía y debe tener entre 1 y 100 caracteres'}
      ]  
    }],
    [{
      totalFetches:0,
      buttonText: '+ Registrar Tipo Persona',
      panelTitle: 'Agregar Nuevo Tipo Persona',
      submitButtonText: 'Registrar Tipo Persona',
      apiUrl: 'http://localhost:8080/api/tipopersona',
      fields: [          
        { label: 'ID', id: 'id', type: 'number', apiKey: 'id', required: true, validationMessage: 'El ID no puede estar vacío'  },
        { label: 'Nombre',  id: 'nombre', type: 'text', apiKey: 'nombre', required: true, validationMessage: 'El nombre no puede estar vacío y debe tener entre 1 y 100 caracteres' 
        }
      ]
    },{
      apiUrl: 'http://localhost:8080/api/tipopersona',
      fields: [          
        { label: 'ID', id: 'id', type: 'number', apiKey: 'id', required: true, validationMessage: 'El ID no puede estar vacío'  },
        { label: 'Nombre',  id: 'nombre', type: 'text', apiKey: 'nombre', required: true, validationMessage: 'El nombre no puede estar vacío y debe tener entre 1 y 100 caracteres' 
        }
      ]  
    }],
    [{
      totalFetches:0,
      buttonText: '+ Registrar Tipo Telefono',
      panelTitle: 'Agregar Nuevo Tipo Telefono',
      submitButtonText: 'Registrar Tipo Telefono',
      apiUrl: 'http://localhost:8080/api/tipotelefono',
      fields: [          
        { label: 'ID', id: 'id', type: 'number', apiKey: 'id', required: true, validationMessage: 'El ID no puede estar vacío'  },
        { label: 'Nombre',  id: 'nombre', type: 'text', apiKey: 'nombre', required: true, validationMessage: 'El nombre no puede estar vacío y debe tener entre 1 y 100 caracteres' 
        }
      ]
    },{
      apiUrl: 'http://localhost:8080/api/tipotelefono',
      fields: [          
        { label: 'ID', id: 'id', type: 'number', apiKey: 'id', required: true, validationMessage: 'El ID no puede estar vacío'  },
        { label: 'Nombre',  id: 'nombre', type: 'text', apiKey: 'nombre', required: true, validationMessage: 'El nombre no puede estar vacío y debe tener entre 1 y 100 caracteres' 
        }
      ]  
    }],
    [{
      totalFetches:0,
      buttonText: '+ Registrar Tipo Telefono',
      panelTitle: 'Agregar Nuevo Tipo Telefono',
      submitButtonText: 'Registrar Tipo Telefono',
      apiUrl: 'http://localhost:8080/api/tipocompra',
      fields: [          
        { label: 'ID', id: 'id', type: 'number', apiKey: 'id', required: true, validationMessage: 'El ID no puede estar vacío'  },
        { label: 'Nombre',  id: 'nombre', type: 'text', apiKey: 'nombre', required: true, validationMessage: 'El nombre no puede estar vacío y debe tener entre 1 y 100 caracteres' 
        }
      ]
    },{
      apiUrl: 'http://localhost:8080/api/tipocompra',
      fields: [          
        { label: 'ID', id: 'id', type: 'number', apiKey: 'id', required: true, validationMessage: 'El ID no puede estar vacío'  },
        { label: 'Nombre',  id: 'nombre', type: 'text', apiKey: 'nombre', required: true, validationMessage: 'El nombre no puede estar vacío y debe tener entre 1 y 100 caracteres' 
        }
      ]  
    }],
]
