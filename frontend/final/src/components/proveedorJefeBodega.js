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
                <th>Email</th>
                <th>Fecha de inicio</th>
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
    const fechaCompra = new Date(dato.personas.fechaRegistro).toLocaleDateString('en-CA');
            const fila = document.createElement("tr");
            fila.innerHTML = `
            <td>${dato.id}</td>
            <td>${dato.personas.nombre}</td>
            <td>${dato.usuario}</td>
            <td >${fechaCompra}</td>
            `;
            cuerpoData.appendChild(fila);
    
    });

}

export const dataProveedor = async (contenedorPrincipal,clienteId,jwt)  => {
    contenedorPrincipal.innerHTML = ""
    contenedorPrincipal.insertAdjacentHTML("beforeend", renderizarTablas())
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
            const response = await fetch(`http://localhost:8080/api/login/rol/11`, {
                method: "GET",
                headers:{
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
        
    } else {



        //implementar
        
    }
    
    
}

