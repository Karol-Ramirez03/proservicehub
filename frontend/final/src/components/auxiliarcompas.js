const rnderizarInicio = () => {

}

const renderizarTablas = () => {
    return /* html */`
    <link rel="stylesheet" href="src/cliente.css"/>
    <table class="nombres-table">
        <thead>
            <tr>
                <th>id</th>
                <th>Fecha de compra</th>
                <th>Estado</th>
                <th>Detalles</th>
                <th>Efectuar</th>
            </tr>
        </thead>
        <tbody class="tbody-info">
        </tbody>
    </table>
    `;
}

const renderizarDatos = (datos,shadowRoot,contenedorPrincipal) => {
    const cuerpoData = document.querySelector(".tbody-info")

    console.log("funciona")
    cuerpoData.innerHTML = ""

    datos.forEach(async dato => {
    var fila2=""

    try {
        const response2 = await fetch(`http://localhost:8080/api/compra/${dato.id}/estado/nombre`, {
            method: "GET"
        });
    
        if (response2.ok) {
            const estado = await response2.text();
            const fechaCompra = new Date(dato.fecha_compra).toLocaleDateString('en-CA');
            const fila = document.createElement("tr");
            fila.innerHTML = `
            <td>${dato.id}</td>
            <td >${fechaCompra}</td>
            <td>${estado}</td>
            <td><button class="detalles" id="detalles"  data-id="${dato.id}">Ver detalles</button></td>
            <td><button class="vender" id="vender"  data-id="${dato.id}">Vender</button></td>
            `;
            cuerpoData.appendChild(fila);
            fila2 = document.createElement("table");
            fila2.style.width = "200%"; 
            fila2.classList.add(`detalle-${dato.id}`,"nombres-table")
            cuerpoData.appendChild(fila2)

        } else {
            console.error(`Error en la solicitud: ${response2.status} - ${response2.statusText}`);
        }
    
    } catch (error) {
        console.error('Error:', error);
    }
    
    
    });
    
    
    addInfoEventListener(shadowRoot);

}

const addInfoEventListener = (shadowRoot) => {
    console.log("aqui llego");
    const btnDetalles = shadowRoot.querySelectorAll(".tbody-info");
    console.log(btnDetalles);

    btnDetalles.forEach(detalle => {
        detalle.addEventListener("click", async (e) => {
            if (e.target.id === "detalles") {
                const idCompra = e.target.dataset.id; // Obtiene el id del botón que fue clickeado
                const filas = shadowRoot.querySelector(`.detalle-${idCompra}`);

                try {
                    const response = await fetch(`http://localhost:8080/api/detallecompra/compra/${idCompra}`, {
                        method: "GET",
                        headers: {
                            'Content-Type': 'application/json'
                        }
                    });

                    if (response.ok) {
                        const detalles = await response.json();
                        filas.innerHTML = ""; // Limpia el contenido de filas

                        // Crea la fila de encabezados
                        const fila = document.createElement("tr");
                        fila.innerHTML = `
                            <th>Id Insumo</th>
                            <th>Nombre</th>
                            <th>Cantidad</th>
                            <th>Precio <button class="cancelar" id="cerrar" data-id="${idCompra}">Cerrar</button></th>
                            <th></th>
                        `;
                        filas.appendChild(fila);

                        // Agrega los detalles
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

                        // Agregar evento al botón "Cerrar"
                        const cerrarButton = fila.querySelector(".cancelar");
                        cerrarButton.addEventListener("click", () => {
                            filas.innerHTML = ""; // Limpia los datos de la fila
                        });
                    }

                } catch (error) {
                    console.error('Error:', error);
                }
            }else if(e.target.id === "vender"){
                console.log("Vendido al mejor")
                
            }
        });
    });
};


export const dataComprasAux = async (contenedorPrincipal,clienteId)  => {
    contenedorPrincipal.innerHTML = ""
    contenedorPrincipal.insertAdjacentHTML("beforeend", renderizarTablas())
    const shadowRoot = contenedorPrincipal.shadowRoot || contenedorPrincipal;
    try {
        const response = await fetch("http://localhost:8080/api/compra/tipocompra/2", {
            method:"GET",
            headers:{
                'Content-Type':'application/json'
            }
        })
        if(response.ok){
            const compras = await response.json();
            renderizarDatos(compras,shadowRoot,contenedorPrincipal);
            
        }
        
    } catch (error) {
        console.error('Error:', error);
    }
}

