

const renderizarTablas = () => {
    return /* html */`
    <table class="nombres-table">
        <thead>
            <tr>
                <th>Id Orden de Trabajo</th>    
                <th>Fecha Asignacion</th>      
                <th>Hora Asignacion</th>      
                <th>Id empleado</th>
                <th>Nombre empleado</th>
                <th>Numero Orden Servicio</th>
                <th>Numero Orden Trabajo</th>

                <th>Id Detalle Orden Trabajo</th>
                <th>Fecha</th>
                <th>Estado</th>
                <th>Id Servicio</th>
                <th>Nombre Servicio</th>
                <th>Asignar Fecha</th>
                
            </tr>
        </thead>
        <tbody class="tbody-info">
        </tbody>
    </table>
    `;
}

const renderizarDatos = (datos) => {
  const cuerpoData = document.querySelector(".tbody-info")

  console.log("funciona")
  cuerpoData.innerHTML = ""

  datos.forEach(dato => {
    const fila = document.createElement("tr");
    fila.innerHTML= `
    <td>${dato.id}</td>
    <td>${dato.fecha_asignacion}</td>
    <td>${dato.hora_asignacion}</td>
    <td>${dato.id_empleado}</td>
    <td>${dato.id_empleado}</td>
    <button class="boton-orden">Ordenes</button>

    `;
    cuerpoData.appendChild(fila)
  });
}

export const dataInsumos = async (contenedorPrincipal)  => {
    contenedorPrincipal.innerHTML = ""
    contenedorPrincipal.insertAdjacentHTML("beforeend", renderizarTablas())

    try {
        const response = await fetch("http://localhost:8080/api/insumo", {
            method:"GET",
            headers:{
                'Content-Type':'application/json'
            }
        })
        if(response.ok){
            const insumos = await response.json();
            renderizarDatos(insumos);
        }
        
    } catch (error) {
        console.error('Error:', error);
    }
  
}