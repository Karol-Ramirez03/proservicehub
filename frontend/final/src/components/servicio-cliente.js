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

const renderizarDatos = (datos,shadowRoot) => {
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

    addOrdenEvenListener(shadowRoot,datos)
}

const addOrdenEvenListener=(shadowRoot,datos)=>{
    const btnSolicitar=document.querySelectorAll(".solicitar");

    const idCliente=1005539417
    btnSolicitar.forEach(boton=>{
        boton.addEventListener("click",async (e)=>{
            e.preventDefault()
            const idServicio=e.target.id
            const datosEnviar={
                "idCliente":idCliente,
                "idServicio":idServicio
            }
            try {
                const response = await fetch("http://localhost:8080/api/ordenservicio/agregar", {
                    method: "POST",
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body:JSON.stringify(datosEnviar)
                });
                if (response.ok) {

                }
            } catch (error) {
                console.error('Error:', error);
            }
        })
    })
}

export const dataServicios = async (contenedorPrincipal) => {
    contenedorPrincipal.innerHTML = "";
    contenedorPrincipal.insertAdjacentHTML("beforeend", renderizarTablas());
    const shadowRoot = contenedorPrincipal.shadowRoot || contenedorPrincipal;
    try {
        const response = await fetch("http://localhost:8080/api/servicio", {
            method: "GET",
            headers: {
                'Content-Type': 'application/json'
            }
        });
        if (response.ok) {
            const servicios = await response.json();
            renderizarDatos(servicios,shadowRoot);
        }
    } catch (error) {
        console.error('Error:', error);
    }
}
