const rnderizarInicio = () => {

}

const renderizarTablas = () => {
    return /* html */`
    <link rel="stylesheet" href="src/cliente.css"/>
    <table class="nombres-table">
        <thead>
            <tr>
                <th>Id servicio</th>
                <th>Servicio</th>
                <th>Estado Solicitud</th>
                <th>Encargado</th>
                <th colspan="3">Acciones</th>
            </tr>
        </thead>
        <tbody class="tbody-info">
        </tbody>
    </table>
    `;
}

const renderizarDatos = (datos,shadowRoot) => {
    const cuerpoData = document.querySelector(".tbody-info")

    console.log("funciona")
    cuerpoData.innerHTML = ""

    datos.forEach(async dato => {
    var fila2=""
            
        const fila = document.createElement("tr");
        fila.innerHTML = `
        <td>${dato.id}</td>
        <td>${dato.servicio.nombre}</td>
        <td>${dato.estado_aprovacion.nombre}</td>
        <td>${dato.orden_trabajo.personas.nombre}</td>
        <td><button class="detalles" id="detalles"  data-id="${dato.id}">Ver detalles</button></td>
        <td></td>
        <td></td>
        `;
        cuerpoData.appendChild(fila);
        fila2 = document.createElement("tr");
        fila2.className=`detalle-${dato.id}`
        cuerpoData.appendChild(fila2)
    
    })
    addInfoEventListener(shadowRoot,datos);

}

const addInfoEventListener = (shadowRoot, datos) => {
    console.log("aqui llego");
    const btnDetalles = shadowRoot.querySelectorAll(".tbody-info");
    console.log(btnDetalles);
    
    btnDetalles.forEach(detalle => {
        detalle.addEventListener("click", (e) => {
            if (e.target.id === "detalles") {
                const idCompra = e.target.dataset.id;
                const dataUsar = datos.find(dato => dato.id == idCompra);
                
                if (!dataUsar) {
                    console.error("No se encontró el dato con id:", idCompra);
                    return;
                }
                
                const filas = shadowRoot.querySelector(`.detalle-${idCompra}`);
                filas.innerHTML = `
                    <td><strong>Hallazgos:</strong></td>
                    <td colspan="1">${dataUsar.hallazgo}</td>
                    <td><strong>Solucion:</strong></td>
                    <td>${dataUsar.solucion}</td>
                    <td><button class="cerrar" id="${idCompra}">Cerrar</button></td>
                    
                `;

                // Agregar botón "Cerrar" si el estado no es 4
                if (dataUsar.estado_aprovacion.id == 4) {
                    filas.innerHTML += `
                    <td><button class="cancelar" id="${idCompra}">Denegar</button></td>
                    <td><button class="aprobar" id="${idCompra}">Aprobar</button></td>
                    `;
                }
                filas.innerHTML+=`<tr class="div-${idCompra}"></tr>`


                // Asignar eventos a los nuevos botones
                agregarEventosBotones(filas, dataUsar,idCompra);
            }
        });
    });
};

const agregarEventosBotones = (filas, dataUsar,idCompra) => {
    const btnDenegar = filas.querySelector('.cancelar');
    const btnAprobar = filas.querySelector('.aprobar');
    const btnCerrar = filas.querySelector('.cerrar');
    const divFila= filas.querySelector(`div-${idCompra}`)
    if (btnDenegar) {
        btnDenegar.addEventListener('click', async () => {
            divFila.innerHTML=`
            <td></td>
            <td class="cantidad-input" colspan="2">
                <form class="form-${idCompra}">
                    <div class="form-group">
                        <label for="cantidad">cantidad a ordenar:</label>
                        <input type="number" id="cantidad" name="cantidad"required>
                    </div>
                </form>
            </td>
            <td><button class="enviar" id="${idCompra}">Enviar</button></td>
            `
            console.log(`Denegar id: ${dataUsar.id}`);
            const solicitud={
                "estado_aprobacion":{
                    "id":2
                }
            }
            try {
                const response2 = await fetch(`http://localhost:8080/api/aprobacionservicio/${idCompra}`, {
                    method:"PUT",
                    headers:{
                        'Content-Type':'application/json'
                    },
                    body:JSON.stringify(solicitud)
                })
                if(response2.ok){
                    const servicio = await response2.json();
                    renderizarDatos(servicio,orden,detalles);

                    
                }
                
            } catch (error) {
                console.error('Error:', error);
            }finally{
                

            }
        });
    }

    if (btnAprobar) {
        btnAprobar.addEventListener('click', () => {
            console.log(`Aprobar id: ${dataUsar.id}`);
            // Lógica para aprobar PROCEDURE ACTUALIZAR ESTADO
        });
    }

    if (btnCerrar) {
        btnCerrar.addEventListener('click', () => {
            eliminarFila(filas);
        });
    }
};

const eliminarFila = (filas) => {
    filas.innerHTML = "";
};




export const dataAprobacion= async (contenedorPrincipal,clienteId)  => {
    contenedorPrincipal.innerHTML = ""
    contenedorPrincipal.insertAdjacentHTML("beforeend", renderizarTablas())
    const shadowRoot = contenedorPrincipal.shadowRoot || contenedorPrincipal;
    try {
        const response = await fetch("http://localhost:8080/api/aprobacionservicio/persona/1005539417", {
            method:"GET",
            headers:{
                'Content-Type':'application/json'
            }
        })
        if(response.ok){
            const aprobaciones = await response.json();
            renderizarDatos(aprobaciones,shadowRoot);
            
        }
        
    } catch (error) {
        console.error('Error:', error);
    }

}

