import { refreshToken } from "./refreshToken";

const rnderizarInicio = () => {

}
const renderizarTablas = () => {
    return /* html */`
    <table class="nombres-table">
        <thead>
            <tr>
                <th>id</th>
                <th>nombre</th>
                <th>Codigo Interno</th>
                <th>stock</th>
                <th>Comprar</th>
            </tr>
        </thead>
        <tbody class="tbody-info">
        </tbody>
    </table>
    `;
}

const renderizarDatos = (datos,shadowRoot,idUsuario,jwt) => {
const cuerpoData = document.querySelector(".tbody-info")

console.log("funciona")
cuerpoData.innerHTML = ""
var fila=""
var fila2=""
datos.forEach(dato => {
    fila = document.createElement("tr");
    fila.innerHTML= `
    <td>${dato.id}</td>
    <td>${dato.nombre}</td>
    <td>${dato.precio_unitario}</td>
    <td>${dato.stock}</td>
    <td><button class="comprar" id="${dato.id}">Comprar</button></td>
    
    `;
    cuerpoData.appendChild(fila)
    fila2 = document.createElement("tr");
    fila2.className=`comprar-${dato.id}`
    cuerpoData.appendChild(fila2)
});
    // Después de que se hayan agregado todas las filas, agrega el EventListener
    agregarTrCompra(shadowRoot,datos,idUsuario,jwt);
}

// Función para agregar EventListeners a los botones
const agregarTrCompra = (shadowRoot,datos,idUsuario,jwt) => {
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
            
            `
            agregarEventListener(shadowRoot,datos,idUsuario,jwt)

            
        });
    });
}

const agregarEventListener=(shadowRoot,datos2,idUsuario,jwt)=>{
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
                "idCliente":idUsuario,
                "idProducto":idInsumo,
                "cantidad":cantidad,
                "tipo_compra":2
            }
            let data = false;
            jwt = localStorage.getItem("jwt")
            try {
                const response = await fetch(`http://localhost:8080/auth/validate-token`, {
                    method:"GET",
                    headers:{
                        'Content-Type':'application/json',
                        'Authorization': `Bearer ${jwt}`
                    }
                })
                if(response.ok){
                    data = await response.json();
                    console.log(data)

                }else{
                    alert("error")
                }
                
            } catch (error) {
                console.error('Error:', error);
            }
            if (data) {
                try {
                    const response = await fetch("http://localhost:8080/api/compra/agregar", {
                        method:"POST",
                        headers:{
                            'Content-Type':'application/json',
                            'Authorization': `Bearer ${jwt}`
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
                
            } else{
                console.log("Vamos a refrescarnos ATT: jwt")
                refreshToken()
                jwt=localStorage.getItem("jwt")
            }
            
        });
    });
});

}



export const dataInsumos = async (contenedorPrincipal,idUsuario,jwt)  => {
    contenedorPrincipal.innerHTML =``
    contenedorPrincipal.insertAdjacentHTML("beforeend", renderizarTablas())
    const shadowRoot = contenedorPrincipal.shadowRoot || contenedorPrincipal;

    let data = false;
    jwt = localStorage.getItem("jwt")
    try {
        const response = await fetch(`http://localhost:8080/auth/validate-token`, {
            method:"GET",
            headers:{
                'Content-Type':'application/json',
                'Authorization': `Bearer ${jwt}`
            }
        })
        if(response.ok){
            data = await response.json();
            console.log(data)

        }else{
            alert("error")
        }
        
    } catch (error) {
        console.error('Error:', error);
    }

    if (data) {
        try {
            const response = await fetch("http://localhost:8080/api/insumo", {
                method:"GET",
                headers:{
                    'Content-Type':'application/json',
                    'Authorization': `Bearer ${jwt}`
                }
            })
            if(response.ok){
                const insumos = await response.json();
                renderizarDatos(insumos,shadowRoot,idUsuario,jwt);
            }
            
        } catch (error) {
            console.error('Error:', error);
        }
        
    } else{
        console.log("Vamos a refrescarnos ATT: jwt")
        refreshToken()
        jwt=localStorage.getItem("jwt")
    }

}



const comprar = (dato)=>{
    
    
}