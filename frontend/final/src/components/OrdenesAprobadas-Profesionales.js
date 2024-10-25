// ver solicitudes aprobadas por los clientes
import { refreshToken } from "./refreshToken";

//ver todas las ordenes de trabajo y su seguimiento
const renderizarTablas = () => {
    return /* html */`
    <table class="nombres-table">
        <thead>
            <tr>
                <th>Id Aprobacion Servicio</th>
                <th>Id Orden Trabajo</th>
                <th>Id Servicio</th>
                <th>Nombre Servicio</th>
                <th>Id Cliente</th>
                <th>Nombre Cliente</th>
                <th>Hallazgo</th>
                <th>Solucion</th>    
                <th>Estado</th>                
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
      <td>${dato.orden_trabajo.id}</td>
      <td>${dato.servicio.id}</td>
      <td>${dato.servicio.nombre}</td>
      <td>${dato.personas?.nro_Doc??"0"}</td>
      <td>${dato.personas?.nombre??"0"}</td>
      <td>${dato.hallazgo}</td>
      <td>${dato.solucion}</td>
      <td>${dato.estado_aprovacion.nombre}</td>
      
    `;
    cuerpoData.appendChild(fila)
  });
  
}

export const dataAprobado = async (contenedorPrincipal,idEmpleado,jwt)  => {
    console.log(contenedorPrincipal)
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
            const response = await fetch(`http://localhost:8080/api/aprobacionservicio/aprobacionPer/3/${idEmpleado}`, {
                method:"GET",
                headers:{
                    'Content-Type':'application/json',
                    'Authorization': `Bearer ${jwt}`
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
        
    } else{
        console.log("Vamos a refrescarnos ATT: jwt")
        refreshToken()
        jwt=localStorage.getItem("jwt")
    }
    
    
  
}