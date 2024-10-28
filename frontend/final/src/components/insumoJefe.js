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
                <th>Codigo interno</th>
                <th>Precio</th>
                <th>stock</th>
                <th>MinStock</th>
                <th>MaxStock</th>
                <th>Editar</th>
            </tr>
        </thead>
        <tbody class="tbody-info">
        </tbody> 
    </table>
    `;
}
{/* <button class="agregar-insumo"">+ Registrar Insumo</button> */}
const renderizarDatos = (datos,shadowRoot,jwt) => {
const cuerpoData = document.querySelector(".tbody-info")

console.log("funciona")
cuerpoData.innerHTML = ""
var fila=""
var fila2=""
datos.forEach(dato => {

    const fila = document.createElement("tr");
    fila.innerHTML = `
        <td id="id-${dato.id}">${dato.id}</td>
        <td id="nombre-${dato.id}">${dato.nombre}</td>
        <td id="codigo-${dato.id}">${dato.codigo_interno}</td>
        <td id="precio-${dato.id}">${dato.precio_unitario}</td>
        <td id="stock-${dato.id}">${dato.stock}</td>
        <td id="stock-minimo-${dato.id}">${dato.stock_minimo}</td>
        <td id="stock-maximo-${dato.id}">${dato.stock_maximo}</td>
        <td><button class="comprar" id="${dato.id}">Editar</button></td>
    `;
    cuerpoData.appendChild(fila);
    
    
    const fila2 = document.createElement("tr");
    fila2.className = `comprar-${dato.id}`;
    cuerpoData.appendChild(fila2);

    
    const editarButton = fila.querySelector(".comprar");
    editarButton.addEventListener("click", () => {

        fila.innerHTML = `
            <td id="id-${dato.id}">${dato.id}</td>
            <td id="nombre-${dato.id}"><input type="text" placeholder="${dato.nombre}" value="${dato.nombre}"></td>
            <td id="codigo-${dato.id}"><input type="text" placeholder="${dato.codigo_interno}" value="${dato.codigo_interno}"></td>
            <td id="precio-${dato.id}"><input type="number" placeholder="${dato.precio_unitario}" value="${dato.precio_unitario}"></td>
            <td id="stock-${dato.id}">${dato.stock}</td>
            <td id="stock-minimo-${dato.id}"><input type="number" placeholder="${dato.stock_minimo}" value="${dato.stock_minimo}"></td>
            <td id="stock-maximo-${dato.id}"><input type="number" placeholder="${dato.stock_maximo}" value="${dato.stock_maximo}"></td>
            <td><button class="guardar" id="${dato.id}">Guardar</button></td>
        `;
        
        
        const guardarButton = fila.querySelector(".guardar");
        guardarButton.addEventListener("click", async () => {
            const nombreInput = fila.querySelector(`#nombre-${dato.id} input`).value;
            const codigoInput = fila.querySelector(`#codigo-${dato.id} input`).value;
            const precioInput = fila.querySelector(`#precio-${dato.id} input`).value;
            const stockMinInput = fila.querySelector(`#stock-minimo-${dato.id} input`).value;
            const stockMaxInput = fila.querySelector(`#stock-maximo-${dato.id} input`).value;
            
            const uptInsumo={
                "codigo_interno":codigoInput,
                "nombre":nombreInput,
                "precio_unitario": parseFloat(precioInput), 
                "stock": null,
                "stock_minimo": parseInt(stockMinInput, 10),
                "stock_maximo": parseInt(stockMaxInput, 10)
            };
            const id= dato.id
            console.log(uptInsumo)
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
                    const response = await fetch(`http://localhost:8080/api/insumo/${id}`, {
                        method:"PUT",
                        headers:{
                            'Content-Type':'application/json',
                            'Authorization': `Bearer ${jwt}`
                        },
                        body:JSON.stringify(uptInsumo)
                    })
                    if(response.ok){
                        const insumos = await response.json();
                        renderizarDatos(insumos,shadowRoot,jwt);
                    }
                    
                } catch (error) {
                    console.error('Error:', error);
                }
                
            } else{
                console.log("Vamos a refrescarnos ATT: jwt")
                refreshToken()
                jwt=localStorage.getItem("jwt")
            }
            


            fila.innerHTML = `
                <td id="id-${dato.id}">${dato.id}</td>
                <td id="nombre-${dato.id}">${nombreInput}</td>
                <td id="codigo-${dato.id}">${codigoInput}</td>
                <td id="precio-${dato.id}">${precioInput}</td>
                <td id="stock-${dato.id}">${dato.stock}</td>
                <td id="stock-minimo-${dato.id}">${stockMinInput}</td>
                <td id="stock-maximo-${dato.id}">${stockMaxInput}</td>
                <td><button class="comprar" id="${dato.id}">Editar</button></td>
            `;

            // Reagregar el evento al botón "Editar"
            fila.querySelector(".comprar").addEventListener("click", () => {
                // Repite el proceso de edición si lo desea
            });
        });
    });
});

    
}




export const dataInsumos = async (contenedorPrincipal,jwt)  => {
    contenedorPrincipal.innerHTML =``
    contenedorPrincipal.insertAdjacentHTML("beforeend", renderizarTablas())
    const shadowRoot = contenedorPrincipal.shadowRoot || contenedorPrincipal
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
                renderizarDatos(insumos,shadowRoot,jwt);
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