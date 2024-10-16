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

const renderizarDatos = (datos) => {
    const cuerpoData = document.querySelector(".tbody-info");

    cuerpoData.innerHTML = "";

    datos.forEach(dato => {
        const fila = document.createElement("tr"); // Asegúrate de usar "tr" entre comillas
        fila.innerHTML = `
        <td>${dato.id}</td>
        <td>${dato.nombre}</td>
        <td>${dato.requiere_insumo}</td>
        <td>${dato.tiempo_ejecucion}</td>
        <td><button id="${dato.id}">Comprar</button></td>
        `;
        cuerpoData.appendChild(fila);
    });
}

const comprar = (id) => {
    //
    console.log(`Comprar servicio con ID: ${id}`);
}

export const dataServicios = async (contenedorPrincipal) => {
    contenedorPrincipal.innerHTML = "";
    contenedorPrincipal.insertAdjacentHTML("beforeend", renderizarTablas());

    try {
        const response = await fetch("http://localhost:8080/api/servicio", {
            method: "GET",
            headers: {
                'Content-Type': 'application/json'
            }
        });
        if (response.ok) {
            const servicios = await response.json();
            renderizarDatos(servicios);
        }
    } catch (error) {
        console.error('Error:', error);
    }
}
