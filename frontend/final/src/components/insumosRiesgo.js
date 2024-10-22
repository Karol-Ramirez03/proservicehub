const rnderizarInicio = () => {

}

const renderizarTablas = () => {
    return /* html */`
    <link rel="stylesheet" href="src/cliente.css"/>
    <table class="nombres-table">
        <thead>
            <tr>
                <th>Id</th>
                <th>Nombre</th>
                <th>Codigo interno</th>
                <th>Stock</th>
                <th>Stock minimo</th>
                <th>Proveedor</th>
                <th>Acciones</th>
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
    console.log(datos)
    datos.forEach(async dato => {
        if (dato.stock<dato.stock_minimo){
            console.log(dato)
            const fila = document.createElement("tr");
            fila.innerHTML = `
            <td>${dato.id}</td>
            <td>${dato.nombre}</td>
            <td>${dato.codigo_interno}</td>
            <td>${dato.stock}</td>
            <td>${dato.stock_minimo}</td>
            <td>Proveedor</td>
            <td><button class="comprar" id="${dato.id}" >Generar pedido</button></td>
            `;
            cuerpoData.appendChild(fila);
            const fila2 = document.createElement("table");
            fila2.style.width = "260%"; 
            fila2.classList.add(`comprar-${dato.id}`,"nombres-table")
            cuerpoData.appendChild(fila2)
            
        }
            
    
    });

    _addEventInsumo(shadowRoot,datos)

}


const _addEventInsumo = (shadowRoot,datos) => {
    const botonesComprar = document.querySelectorAll(".comprar");
    
    botonesComprar.forEach(boton => {
        boton.addEventListener("click", (event) => {
            
            const idCompra = event.target.id; // Obtiene el id del botón que fue clickeado
            const filas=shadowRoot.querySelector(`.comprar-${idCompra}`)
            filas.innerHTML=`
            <td></td>
            <td class="cantidad-input" colspan="2">
                <form class="form-${idCompra}">
                    <div class="form-group">
                        <label for="cantidad">cantidad a ordenar:</label>
                        <input type="number" id="cantidad" name="cantidad"required>
                    </div>
                </form>
            </td>
            <td><button class="cancelar" id="${idCompra}">Cancelar</button></td>
            <td><button class="orden" id="${idCompra}">Ordenar</button></td>
            <td></td>
            
            `
            agregarEventListener(shadowRoot,datos)

            
        });
    });
}

const agregarEventListener=(shadowRoot,datos2)=>{
    const btnCancelar=shadowRoot.querySelectorAll(".cancelar")
    const btnOrden=shadowRoot.querySelectorAll(".orden")

    btnCancelar.forEach(boton => {
        boton.addEventListener("click", (event) => {
            const idCompra = event.target.id; // Obtiene el id del botón que fue clickeado
            const fila=shadowRoot.querySelector(`.comprar-${idCompra}`)
            fila.innerHTML=""
            
    });

    btnOrden.forEach(boton2 => {
        boton2.addEventListener("click", async (event) => {
            const idCompra = event.target.id;
            const fila=shadowRoot.querySelector(`.comprar-${idCompra}`)
            const form=shadowRoot.querySelector(`.form-${idCompra}`)
            const datos = Object.fromEntries(new FormData(form).entries());
            const producto = JSON.parse(JSON.stringify(datos));
            
            const {cantidad}=producto
            const idInsumo =datos2[idCompra-1]["id"]

            const datosEnviar={
                "idCliente":1005539417,
                "idProducto":idInsumo,
                "cantidad":cantidad,
                "tipo_compra":1
            }
            try {
                const response = await fetch("http://localhost:8080/api/compra/agregar", {
                    method:"POST",
                    headers:{
                        'Content-Type':'application/json'
                    },
                    body:JSON.stringify(datosEnviar)
                })
                if(response.ok){
                    console.log("Orden exitosa")
                    fila.innerHTML=""
                }
                
            } catch (error) {
                console.error('Error:', error);
            }
        });
    });
});
}

export const dataInsumoRiesgo = async (contenedorPrincipal,clienteId)  => {
    contenedorPrincipal.innerHTML = ""
    contenedorPrincipal.insertAdjacentHTML("beforeend", renderizarTablas())
    const shadowRoot = contenedorPrincipal.shadowRoot || contenedorPrincipal;
    try {
        const response = await fetch(`http://localhost:8080/api/insumo`, {
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

