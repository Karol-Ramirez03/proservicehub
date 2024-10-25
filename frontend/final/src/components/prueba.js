export function initDynamicPanel(config) {
    const app = document.querySelector('#app');
    let isPanelOpen = false;

    function createButton() {
        const button = document.createElement('button');
        button.textContent = config.buttonText || '+ Registrar';
        button.className = 'add-button';
        button.addEventListener('click', togglePanel);
        return button;
    }

    function createPanel() {
        const modal = document.createElement('div');
        modal.className = 'modal';

        const panel = document.createElement('div');
        panel.className = 'panel';

        const header = document.createElement('div');
        header.className = 'panel-header';

        const title = document.createElement('h2');
        title.textContent = config.panelTitle || 'Agregar Nuevo Elemento';
        title.className = 'panel-title';

        const closeButton = document.createElement('button');
        closeButton.textContent = '×';
        closeButton.className = 'close-button';
        closeButton.addEventListener('click', togglePanel);

        header.appendChild(title);
        header.appendChild(closeButton);

        const form = document.createElement('form');
        form.className = 'panel-body';
        form.addEventListener('submit', handleSubmit);
        let fetchCount=0;
        config.fields.forEach(field => {
            const formGroup = document.createElement('div');
            formGroup.className = 'form-group';
            const label = document.createElement('label');
            label.textContent = field.label;
            label.setAttribute('for', field.id);
            
            if (field.label=="Persona" ||field.label=="Rol"  ||field.label=="Tipo de Persona" ||field.label=="Sucursal" 
                ||field.label=="Estado Compra" ||field.label=="Cliente"  ||field.label=="Tipo Compra"  ||field.label=="Region" 
                ||field.label=="Insumo" ||field.label=="Compra" ||field.label=="Orden de Servicio" ||field.label=="Servicio" 
                ||field.label=="Orden de Trabajo" ||field.label=="Estado de Orden" ||field.label=="Ciudad" ||field.label=="Tipo de Email"
                ||field.label=="Tipo de Empresa" ||field.label=="Estado de Aprobación" ||field.label=="Empleado" ||field.label=="Estado de la Orden" 
                ||field.label=="Proveedor" ||field.label=="País" ||field.label=="Dirección" ||field.label=="Empresa" ||field.label=="Tipo de Teléfono"
            ){
                const select= document.createElement('select')
                select.id=field.id;
                select.innerHTML=`<option value="12" disabled selected>Seleccionar ${field.label}</option>`
                fetch(`http://localhost:8080/api/${field.apiExtension}`, {
                    method: 'GET',
                    headers: {
                        'Content-Type': 'application/json'
                    }
                })
                .then(response => response.json())
                .then(data => {
                    console.log('datos mios:', data);
                    data.forEach(dato=>{
                        let id=dato.id;
                        let valor=dato.nombre;
                        if(field.label=="Persona" ||field.label=="Cliente" ||field.label=="Empleado" ||field.label=="Proveedor"  ){
                            id=dato.nro_Doc;
                            valor=dato.nombre;
                        }
                        select.innerHTML+=`<option value="${id}">${valor}</option>`
                    })

                    console.log(select)
                    formGroup.appendChild(label);
                    formGroup.appendChild(select);
                    form.appendChild(formGroup);

                    fetchCount+=1;
                    if (fetchCount === config.totalFetches) {
                        const submitButton = document.createElement('button');
                        submitButton.textContent = config.submitButtonText || 'Registrar';
                        submitButton.className = 'submit-button';
                        submitButton.type = 'submit';
                        form.appendChild(submitButton);
                    }
                })
                .catch(error => {
                    console.error('Error al almacenar el elemento:', error);
                });

            }else{
                const input = document.createElement('input');
                input.id = field.id;
                input.placeholder = `Ingrese ${field.label.toLowerCase()}`;
                input.type = field.type;

                formGroup.appendChild(label);
                formGroup.appendChild(input);
                form.appendChild(formGroup);
            }
            
            
        });

        

        if ( config.totalFetches=== 0) {
            const submitButton = document.createElement('button');
            submitButton.textContent = config.submitButtonText || 'Registrar';
            submitButton.className = 'submit-button';
            submitButton.type = 'submit';
            form.appendChild(submitButton);
        }

        panel.appendChild(header);
        panel.appendChild(form);
        modal.appendChild(panel);

        return modal;
    }

    function togglePanel() {
        isPanelOpen = !isPanelOpen;
        render();
    }

    function handleSubmit(e) {
        e.preventDefault();

        const nuevoElemento = {};
        config.fields.forEach(field => {
            const value = document.getElementById(field.id).value;
            console.log(value)
            if (!value) {
                alert(`Por favor, completa el campo: ${field.label}.`);
                return;
            }
            nuevoElemento[field.apiKey] = field.type === 'number' ? parseFloat(value) : value;
        });

        console.log('Elemento registrado:', nuevoElemento);

        fetch(config.apiUrl, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(nuevoElemento)
        })
        .then(response => response.json())
        .then(data => {
            console.log('Elemento almacenado:', data);
        })
        .catch(error => {
            console.error('Error al almacenar el elemento:', error);
        });

        isPanelOpen = false;
        render();
    }

    function render() {
        app.innerHTML = '';
        app.appendChild(createButton());
        if (isPanelOpen) {
            app.appendChild(createPanel());
        }
    }

    render();
}

export const initDynamicTable = (config) => {
    const app = document.querySelector('#app2');

    const renderizarTablas = () => {
        return /* html */`
        <table class="nombres-table">
            <thead>
                <tr>
                    ${config.fields.map(field => `<th>${field.label}</th>`).join('')}
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody class="tbody-info"></tbody>
        </table>
        `;
    };

    const renderizarDatos = (datos) => {
        const cuerpoData = app.querySelector(".tbody-info");
        cuerpoData.innerHTML = "";

        datos.forEach(dato => {
            const fila = document.createElement("tr");
                let cont=0
                config.fields.map(field =>{
                    if (field.label=="Numero Documento"){
                        fila.innerHTML+=`<td id="${field.id}-${dato.nro_Doc}">${dato.nro_Doc}</td>`
                        cont+=1
                    }else if(field.label=="Sucursal" || field.label=="Tipo de Persona"|| field.label=="Region" || field.label=="Estado Compra" | field.label=="Tipo Compra"|| field.label=="Insumo" || field.label=="Ciudad"|| field.label=="Servicio" || field.label=="Estado de Aprobación"|| field.label=="Rol"|| field.label=="Estado de la Orden"|| field.label=="Estado de Orden"|| field.label=="País"|| field.label=="Empresa"){
                        const api=field.apiKey
                        fila.innerHTML+=`<td id="${field.id}-${dato[api].id}">${dato[api].nombre}</td>`
                        cont+=1
                    }else if(field.label=="Fecha Registro" || field.label=="Fecha Compra" || field.label=="Fecha de Creación"  || field.label=="Fecha de Orden" ){
                        const fecha=dato[field.apiKey]
                        const fechaSinHora = fecha.split("T")[0];
                        fila.innerHTML+=`<td id="${field.id}-${dato.id}">${fechaSinHora}</td>`
                        cont+=1
                    }else if(field.label=="Id"){
                        fila.innerHTML+=`<td id="${field.id}-${dato.id}">${dato.id}</td>`
                        cont+=1
                    }else if(field.label=="Cliente"|| field.label=="Persona"|| field.label=="Proveedor"){
                        fila.innerHTML+=`<td id="${field.id}-${dato.personas.nro_Doc}">${dato.personas.nro_Doc}</td>`
                        cont+=1
                    }else if(field.label=="Compra"){
                        fila.innerHTML+=`<td id="${field.id}-${dato.compra.id}">${dato.compra.id}</td>`
                        cont+=1
                    }else if(field.label=="Orden de Trabajo"){
                        fila.innerHTML+=`<td id="${field.id}-${dato.orden_trabajo.numero_orden_trabajo}">${dato.orden_trabajo.numero_orden_trabajo}</td>`
                        cont+=1
                    }else if(field.label=="Tipo de Empresa"){
                        fila.innerHTML+=`<td id="${field.id}-${dato.tipo_empresa.id}">${dato.tipo_empresa.descripcion}</td>`
                        cont+=1
                    }else if(field.label=="Dirección"){
                        fila.innerHTML+=`<td id="${field.id}-${dato.direccion.id}">Cll: ${dato.direccion.calle} Cr: ${dato.direccion.carrera} ${dato.direccion.barrio}, ${dato.direccion.descripcion}</td>`
                        cont+=1
                    }else{
                        fila.innerHTML+=`<td id="${field.id}-${dato.id}">${dato[field.apiKey]}</td>`
                        cont+=1
                    }
                    if(cont==config.fields.length){
                        fila.innerHTML+=`<td>
                        <button class="editar" id="${dato.nro_Doc}">Editar</button>
                        <button class="eliminar" id="${dato.nro_Doc}">Eliminar</button>
                    </td>`
                    }
                });
                    
            
            cuerpoData.appendChild(fila);

            const editarButton = fila.querySelector(".editar");
            editarButton.addEventListener("click", () => editarFila(fila, dato));

            const eliminarButton = fila.querySelector(".eliminar");
            eliminarButton.addEventListener("click", () => eliminarFila(dato.id));
        });
    };

    const editarFila = (fila, dato) => {
        fila.innerHTML = `
            ${config.fields.map(field => `
                <td id="${field.id}-${dato.id}">
                    <input type="${field.type}" value="${dato[field.apiKey]}">
                </td>
            `).join('')}
            <td>
                <button class="guardar" id="${dato.id}">Guardar</button>
                <button class="cancelar" id="${dato.id}">Cancelar</button>
            </td>
        `;

        const guardarButton = fila.querySelector(".guardar");
        guardarButton.addEventListener("click", async () => {
            const updatedData = {};
            config.fields.forEach(field => {
                const input = fila.querySelector(`#${field.id}-${dato.id} input`);
                updatedData[field.apiKey] = field.type === 'number' ? parseFloat(input.value) : input.value;
            });

            try {
                const response = await fetch(`${config.apiUrl}/${dato.id}`, {
                    method: "PUT",
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify(updatedData)
                });

                if (response.ok) {
                    const updatedDatos = await response.json();
                    location.reload();
                    renderizarDatos(updatedDatos);
                    
                }
            } catch (error) {
                console.error('Error:', error);
            }
        });

        const cancelarButton = fila.querySelector(".cancelar");
        cancelarButton.addEventListener("click", () => {
            renderizarDatos(dato); // Vuelve a renderizar los datos originales
        });
    };

    const eliminarFila = async (id) => {
        if (confirm("¿Estás seguro de que deseas eliminar este registro?")) {
            try {
                const response = await fetch(`${config.apiUrl}/${id}`, {
                    method: "DELETE",
                });

                if (response.ok) {
                    const updatedDatos = await response.json();
                    location.reload();
                    renderizarDatos(updatedDatos);
                } else {
                    console.error('Error al eliminar:', response.statusText);
                }
            } catch (error) {
                console.error('Error:', error);
            }
        }
    };

    const dataFetch = async () => {
        app.innerHTML = renderizarTablas();
        try {
            const response = await fetch(config.apiUrl, {
                method: "GET",
                headers: {
                    'Content-Type': 'application/json'
                }
            });

            if (response.ok) {
                const datos = await response.json();
                console.log(datos)
                renderizarDatos(datos);
            }
        } catch (error) {
            console.error('Error:', error);
        }
    };

    dataFetch();
};
