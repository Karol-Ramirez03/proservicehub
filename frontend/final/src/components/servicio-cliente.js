import { refreshToken } from "./refreshToken";

const renderizarInicio = () => {
    // Puedes agregar aquí cualquier contenido inicial que necesites.
}

const renderizarTablas = () => {
    return /* html */`
    <table class="nombres-table">
        <thead>
            <tr>
                <th>id</th>
                <th>nombre</th>
                <th>Requiere Insumo</th>
                <th>Tiempo Ejecución</th>
                <th>Acciones</th>
            </tr>
        </thead>
        <tbody class="tbody-info">
        </tbody>
    </table>
    `;
}

const renderizarDatos = (datos,shadowRoot,idUsuario,jwt) => {
    const cuerpoData = document.querySelector(".tbody-info");

    cuerpoData.innerHTML = "";

    datos.forEach(dato => {
        const fila = document.createElement("tr"); // Asegúrate de usar "tr" entre comillas
        fila.innerHTML = `
        <td>${dato.id}</td>
        <td>${dato.nombre}</td>
        <td>${dato.requiere_insumo}</td>
        <td>${dato.tiempo_ejecucion}</td>
        <td><button class="solicitar" id="${dato.id}">Solicitar</button></td>
        `;
        cuerpoData.appendChild(fila);
    });

    addOrdenEvenListener(shadowRoot,datos,idUsuario,jwt)
}

const addOrdenEvenListener=(shadowRoot,datos,idUsuario,jwt)=>{
    const btnSolicitar=document.querySelectorAll(".solicitar");

    const idCliente=idUsuario
    btnSolicitar.forEach(boton=>{
        boton.addEventListener("click",async (e)=>{
            e.preventDefault()
            const idServicio=e.target.id
            const datosEnviar={
                "idCliente":idCliente,
                "idServicio":idServicio
            }
            let data = false;

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
                    alert("Usuario No Existente o no ha realizado Compras")

                }
                
            } catch (error) {
                console.error('Error:', error);
            }
            if (data) {
                try {
                    const response = await fetch("http://localhost:8080/api/ordenservicio/agregar", {
                        method: "POST",
                        headers: {
                            'Content-Type': 'application/json',
                            'Authorization': `Bearer ${jwt}`
                        },
                        body:JSON.stringify(datosEnviar)
                    });
                    if (response.ok) {
    
                    }
                } catch (error) {
                    console.error('Error:', error);
                }
                
            } else{
                console.log("Vamos a refrescarnos ATT: jwt")
                refreshToken()
                jwt=localStorage.getItem("jwt")
            }
          
        })
    })
}

export const dataServicios = async (contenedorPrincipal,idUsuario,jwt) => {
    contenedorPrincipal.innerHTML = "";
    contenedorPrincipal.insertAdjacentHTML("beforeend", renderizarTablas());
    const shadowRoot = contenedorPrincipal.shadowRoot || contenedorPrincipal;
    let data = false;

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
            alert("Usuario No Existente o no ha realizado Compras")

        }
        
    } catch (error) {
        console.error('Error:', error);
    }
    if (data) {
        try {
            const response = await fetch("http://localhost:8080/api/servicio", {
                method: "GET",
                headers: {
                    'Content-Type': 'application/json',
                    'Authorization': `Bearer ${jwt}`
                }
            });
            if (response.ok) {
                const servicios = await response.json();
                renderizarDatos(servicios,shadowRoot,idUsuario,jwt);
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
