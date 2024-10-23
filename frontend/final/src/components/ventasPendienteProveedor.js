const rnderizarInicio = () => {

}

const renderizarTablas = () => {
    return /* html */`
    <link rel="stylesheet" href="src/cliente.css"/>
    <table class="nombres-table">
        <thead>
            <tr>
                <th>id</th>
                <th>Fecha de Venta</th>
                <th>Estado</th>
                <th>Acciones</th>
                <th>Venta</th>
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
        if(dato.estado_compra.id==2){
            const fechaCompra = new Date(dato.fecha_compra).toLocaleDateString('en-CA');
            const fila = document.createElement("tr");
            fila.innerHTML = `
            <td>${dato.id}</td>
            <td >${fechaCompra}</td>
            <td>${dato.estado_compra.nombre}</td>
            <td><button class="detalles" id="detalles"  data-id="${dato.id}">Ver detalles</button></td>
            <td><button class="vender" id="vender"  data-id="${dato.id}">Vender</button></td>
            `;
            cuerpoData.appendChild(fila);
            fila2 = document.createElement("table");
            fila2.style.width = "200%"; 
            fila2.classList.add(`detalle-${dato.id}`,"nombres-table")
            cuerpoData.appendChild(fila2)
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
                const idCompra = e.target.dataset.id; // Obtiene el id del botón que fue clickeado
                const filas = shadowRoot.querySelector(`.detalle-${idCompra}`);
                let insumos=[]
                try {
                    const response = await fetch(`http://localhost:8080/api/detallecompra/compra/${idCompra}`, {
                        method: "GET",
                        headers: {
                            'Content-Type': 'application/json'
                        }
                    });

                    if (response.ok) {
                        const detalles = await response.json();
                        let cont=0;
                        detalles.forEach(detalle => {

                            const insumo={
                                "insumoId":detalle.insumo.id,
                                "cantidadSolicitada":detalle.cantidad
                            }
                            insumos[cont]=insumo;
                            cont+=1;
                            console.log(insumos)
                        });
                    }

                } catch (error) {
                    console.error('Error:', error);
                }

                insumos.map(async insumo => {
                    console.log(insumo);
                    try {
                        const response = await fetch("http://localhost:8080/api/insumo/actualizar-stock-proveedor", {
                            method: "POST",
                            headers: {
                                'Content-Type': 'application/json'
                            },
                            body: JSON.stringify(insumo)
                        });
        
                        if (response.ok) {
                            console.log("Bien")
                            // Verificamos si hay contenido en la respuesta
                            if (response.status === 204) { // 204 No Content
                                console.log('Stock actualizado correctamente, sin contenido en la respuesta.');
                            } else {
                                const compras = await response.json(); // Aquí se puede agregar el manejo de respuesta si existe
                                console.log('Respuesta recibida:', compras);
                            }
                        } else {
                            console.error('Error en la respuesta:', response.status);
                        }
                    } catch (error) {
                        console.error('Error:', error);
                    }
                });
        
                try {
                    const response = await fetch(`http://localhost:8080/api/compra/actualizarestadocompra/${idCompra}`, {
                        method: "POST",
                        headers: {
                            'Content-Type': 'application/json'
                        },
                        body: JSON.stringify()
                    });
        
                    if (response.ok) {
                        
                        console.log("Estado actualizado")
                    }
                } catch (error) {
                    console.error('Error:', error);
                }

                // // Esperar a que todas las promesas se resuelvan
                // Promise.all(fetchPromises).then(() => {
                //     actualizarStock(suficiente,insumos,idCompra);
                // });
                
            }

        });
    });
};


export const dataVentasPendiente = async (contenedorPrincipal,idUsuario)  => {
    contenedorPrincipal.innerHTML = ""
    contenedorPrincipal.insertAdjacentHTML("beforeend", renderizarTablas())
    const shadowRoot = contenedorPrincipal.shadowRoot || contenedorPrincipal;
    try {
        const response = await fetch(`http://localhost:8080/api/compra/persona/${idUsuario}`, {
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

