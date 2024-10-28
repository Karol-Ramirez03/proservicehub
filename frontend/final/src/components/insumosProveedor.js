import { refreshToken } from "./refreshToken";

const rnderizarInicio = () => {

}

const renderizarTablas = () => {
    return /* html */`
    <link rel="stylesheet" href="src/cliente.css"/>
    <table class="nombres-table">
        <thead>
            <tr>
            <th>Id Insumo</th>
            <th>Nombre</th>
            <th>Codigo </th>
            <th>Precio unitario</th>
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
            const fila = document.createElement("tr");
            fila.innerHTML = `
            <td>${dato.insumo.id}</td>
            <td>${dato.insumo.nombre}</td>
            <td>${dato.insumo.codigo_interno}</td>
            <td>${dato.insumo.precio_unitario}</td>
            <td></td>
            `;
            cuerpoData.appendChild(fila);
            const fila2 = document.createElement("table");
            fila2.style.width = "260%"; 
            fila2.classList.add(`insumo-${dato.personas.nro_Doc}`,"nombres-table")
            cuerpoData.appendChild(fila2)
            
    
    });

}

export const dataProveedorInsumos = async (contenedorPrincipal,idUsuario,jwt)  => {
    contenedorPrincipal.innerHTML = ""
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
            const response = await fetch(`http://localhost:8080/api/personainsumo/insumos/${idUsuario}`, {
                method: "GET",
                headers: {
                    'Content-Type': 'application/json',
                'Authorization': `Bearer ${jwt}`
                }
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
        
    } else{
        console.log("Vamos a refrescarnos ATT: jwt")
        refreshToken()
        jwt=localStorage.getItem("jwt")
    }
    
}

