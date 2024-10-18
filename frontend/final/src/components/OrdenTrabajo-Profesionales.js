// visualizar las órdenes
const renderizarTablas = () => {
    return /* html */`
    <table class="nombres-table">
        <thead>
            <tr>
                <th>Id Detalle Orden Trabajo</th>
                <th>Fecha</th>
                <th>Estado</th>
                <th>Id Servicio</th>
                <th>Nombre Servicio</th>

                <th>Id Orden de Trabajo</th>    
                <th>Fecha Asignacion</th>      
                <th>Hora Asignacion</th>      
                <th>Id empleado</th>
                <th>Nombre empleado</th>
                <th>Numero Orden Servicio</th>
                <th>Numero Orden Trabajo</th>
                
                
            </tr>
        </thead>
        <tbody class="tbody-info">
        </tbody>
    </table>
    `;
}

const renderizarDatos = (datos,shadowRoot) => {
  const cuerpoData = shadowRoot.querySelector(".tbody-info")

  console.log(cuerpoData)
  cuerpoData.innerHTML = ""

  datos.forEach(dato => {
    const fila = document.createElement("tr");
    fila.innerHTML= `
      <td>${dato.id}</td>
      <td>${dato.fecha}</td>
      <td>${dato.estado_orden?.nombre??"0"}</td>
      <td>${dato.servicio?.id??""}</td>
      <td>${dato.servicio?.nombre??""}</td>

      <td>${dato.orden_trabajo.id}</td>
      <td>${dato.orden_trabajo.fecha_asignacion}</td>
      <td>${dato.orden_trabajo.hora_asignacion}</td>
      <td>${dato.orden_trabajo.personas.nro_Doc}</td>
      <td>${dato.orden_trabajo.personas.nombre}</td>
      <td>${dato.orden_trabajo.ordenServicio.numero_orden}</td>
      <td>${dato.orden_trabajo.numero_orden_trabajo}</td>
      

    `;
    cuerpoData.appendChild(fila)
  });
  
}

export const dataOrdenesTrabajo = async (contenedorPrincipal,idEmpleado)  => {
    console.log(contenedorPrincipal)
    contenedorPrincipal.innerHTML = ""
    contenedorPrincipal.insertAdjacentHTML("beforeend", renderizarTablas())

    const shadowRoot = contenedorPrincipal.shadowRoot || contenedorPrincipal;
    
    try {
        const response = await fetch(`http://localhost:8080/api/detalleorden/empleadoId/${idEmpleado}`, {
            method:"GET",
            headers:{
                'Content-Type':'application/json'
            }
        })
        if(response.ok){
            const Ordenes = await response.json();
            console.log(Ordenes)
            renderizarDatos(Ordenes,shadowRoot);


            
        }
        
    } catch (error) {
        console.error('Error:', error);
    }
    
    
  
}