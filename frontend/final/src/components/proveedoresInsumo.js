const rnderizarInicio = () => {

}

const renderizarTablas = () => {
    return /* html */`
    <link rel="stylesheet" href="src/cliente.css"/>
    <table class="nombres-table">
        <thead>
            <tr>
                <th>Id</th>
                <th>Proveedor</th>
                <th>Nit</th>
                <th>Email</th>
                <th>Ver insumos</th>
                <th>Añadir Insimo</th>
            </tr>
        </thead>
        <tbody class="tbody-info">
        </tbody>
    </table>

    <div id="floatingPanel" style="display: none;">
    <div class="panel-content">
        <button id="closePanel">Cerrar</button>
        <form id="insumoForm">
            <label for="selectInsumo">Seleccionar Insumo:</label>
            <select id="selectInsumo"></select>
            <button type="submit">Agregar Insumo</button>
        </form>
    </div>
</div>
</div>
    `;
}

const renderizarDatos = (datos,shadowRoot,contenedorPrincipal) => {
    const cuerpoData = document.querySelector(".tbody-info")

    console.log("funciona")
    cuerpoData.innerHTML = ""
    console.log(datos)
    datos.forEach(async dato => {
            const fila = document.createElement("tr");
            fila.innerHTML = `
            <td>${dato.id}</td>
            <td>${dato.personas.nombre}</td>
            <td>${dato.personas.nro_Doc}</td>
            <td>${dato.usuario}</td>
            <td><button class="insumos" id="insumos" data-id="${dato.personas.nro_Doc}">Insumos</button></td>
            <td><button class="Addinsumos" id="AddInsumos" data-id="${dato.personas.nro_Doc}">Agregar insumo</button></td>
            `;
            cuerpoData.appendChild(fila);
            const fila2 = document.createElement("table");
            fila2.style.width = "260%"; 
            fila2.classList.add(`insumo-${dato.personas.nro_Doc}`,"nombres-table")
            cuerpoData.appendChild(fila2)
            
    
    });

    _addEventInsumo(shadowRoot,contenedorPrincipal)

}


const _addEventInsumo = (shadowRoot) => {
    console.log("aqui llego");
    const btnDetalles = shadowRoot.querySelectorAll(".tbody-info");
    console.log(btnDetalles);

    btnDetalles.forEach(detalle => {
        detalle.addEventListener("click", async (e) => {
            if (e.target.id === "insumos") {
                const idPersona = e.target.dataset.id;
                const filas = shadowRoot.querySelector(`.insumo-${idPersona}`);

                try {
                    const response = await fetch(`http://localhost:8080/api/personainsumo/insumos/${idPersona}`, {
                        method: "GET",
                        headers: {
                            'Content-Type': 'application/json'
                        }
                    });

                    if (response.ok) {
                        const detalles = await response.json();
                        filas.innerHTML = ""; 

                        const fila = document.createElement("tr");
                        fila.innerHTML = `
                            <th>Id Insumo</th>
                            <th>Nombre</th>
                            <th>Cantidad</th>
                            <th>Precio </th>
                            <th><button style="position: relative; left: 20px;" class="cancelar" id="cerrar" data-id="${idPersona}">Cerrar</button></th>
                        `;
                        filas.appendChild(fila);

                        
                        detalles.forEach(detalle => {
                            const newFila = document.createElement("tr");
                            newFila.innerHTML = `
                                <td>${detalle.insumo.id}</td>
                                <td>${detalle.insumo.nombre}</td>
                                <td>${detalle.cantidad}</td>
                                <td>${detalle.precio_unitario}</td>
                                <td></td>
                            `;
                            filas.appendChild(newFila);
                        });

                    
                        const cerrarButton = fila.querySelector(".cancelar");
                        cerrarButton.addEventListener("click", () => {
                            filas.innerHTML = ""; 
                        });
                    }

                } catch (error) {
                    console.error('Error:', error);
                }
            }
            if (e.target.classList.contains("Addinsumos")) {
                const idPersona = e.target.dataset.id; 
                const floatingPanel = document.getElementById("floatingPanel");
                const selectInsumo = document.getElementById("selectInsumo");
                selectInsumo.innerHTML = "";

                
                try {
                    const response = await fetch(`http://localhost:8080/api/insumo`, {
                        method: "GET",
                        headers: {
                            'Content-Type': 'application/json'
                        }
                    });

                    if (response.ok) {
                        const detalles = await response.json();
                        detalles.forEach(detalle => {
                            selectInsumo.innerHTML += `
                            <option value="${detalle.id}">${detalle.nombre}</option>
                            `;
                        });
                    }
                } catch (error) {
                    console.error('Error:', error);
                }

                floatingPanel.style.display = "block"; 

                const insumoForm = document.getElementById("insumoForm");
                insumoForm.onsubmit = async (event) => {
                    event.preventDefault(); 
                    let num=Number(idPersona)
                    let ser=Number(selectedInsumo)
                    const selectedInsumo = selectInsumo.value;
                    const newPerIn={
                        "id":{
                            "idPersona": num,
                            "idInsumo": ser,
                        },
                        "servicio":{
                            "id":1 //cambiar esto
                        },
                        "personas":{
                            "nro_Doc":idPersona
                        },
                        "insumo":{
                            "id":ser
                        }
                    }
                    
                    try {
                        const response = await fetch(`http://localhost:8080/api/personainsumo`, {
                            method: "POST",
                            headers: {
                                'Content-Type': 'application/json'
                            },
                            body: JSON.stringify(newPerIn)
                        });

                        if (response.ok) {
                            
                            console.log('Insumo agregado exitosamente');
                        }
                    } catch (error) {
                        console.error('Error al agregar insumo:', error);
                    }
                };
            }
        });
    });

   
    document.getElementById("closePanel").addEventListener("click", () => {
        document.getElementById("floatingPanel").style.display = "none";
        });
};

export const dataProveedorInsumo = async (contenedorPrincipal,clienteId)  => {
    contenedorPrincipal.innerHTML = ""
    contenedorPrincipal.insertAdjacentHTML("beforeend", renderizarTablas())
    const shadowRoot = contenedorPrincipal.shadowRoot || contenedorPrincipal;
    try {
        const response = await fetch(`http://localhost:8080/api/login/rol/11`, {
            method: "GET"
        });
    
        if (response.ok) {
            const usuarios = await response.json();
            renderizarDatos(usuarios,shadowRoot,contenedorPrincipal);


        } else {
            console.error(`Error en la solicitud: ${response.status} - ${response.statusText}`);
        }
    
    } catch (error) {
        console.error('Error:', error);
    }
    
}

