const rnderizarInicio = () => {

}

const renderizarTablas = () => {
    return /* html */`
    <link rel="stylesheet" href="src/cliente.css"/>
    <table class="nombres-table">
        <thead>
            <tr>
                <th>id</th>
                <th>Estado Solicitud</th>
                <th>Encargado</th>
                <th>Acciones</th>
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
            <td>${fechaCompra}</td>
            <td>${estado}</td>
            <td><button class="detalles" id="detalles"  data-id="${dato.id}">Ver detalles</button></td>
            `;
            cuerpoData.appendChild(fila);
            fila2 = document.createElement("tr");
            fila2.className=`detalle-${dato.id}`
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

const addInfoEventListener=(shadowRoot)=>{
    console.log("aqui llego")
    const btnDetalles=shadowRoot.querySelectorAll(".tbody-info")
    console.log(btnDetalles)
    btnDetalles.forEach(detalle=>{
        
        detalle.addEventListener("click",(e)=>{
            if (e.target.id == "detalles"){
                console.log("SIIII")
                const idCompra = e.target.dataset.id; // Obtiene el id del botón que fue clickeado
                console.log(idCompra)
                const filas=shadowRoot.querySelector(`.detalle-${idCompra}`)
                filas.innerHTML=`
                <td></td>
                <td class="cantidad-input" colspan="1">
                    <form class="form-${idCompra}">
                        <div class="form-group">
                            <label for="cantidad">cantidad a ordenar:</label>
                            <input type="number" id="cantidad" name="cantidad"required>
                        </div>
                    </form>
                </td>
                <td><button class="cancelar" id="${idCompra}">Cancelar</button></td>
                <td><button class="orden" id="${idCompra}">Ordenar</button></td>
                
                `
            }
            
        })
    })

}


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
            const compras = await response.json();
            renderizarDatos(compras,shadowRoot);
            
        }
        
    } catch (error) {
        console.error('Error:', error);
    }

  
  
}

