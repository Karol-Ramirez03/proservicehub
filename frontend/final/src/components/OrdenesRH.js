//ver todas las ordenes de trabajo y su seguimiento
import { refreshToken } from "./refreshToken";

import { dataNewFecha } from "./actualizarServicio";
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
                
                <th>Asignar Fecha</th>
                
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
      <td>${dato.orden_trabajo.ordenServicio?.numero_orden??"NULL"}</td>
      <td>${dato.orden_trabajo.numero_orden_trabajo}</td>
      
      <td><button class="boton-fecha" id="${dato.id}">Asignar Fecha</button></td>

    `;
    cuerpoData.appendChild(fila)
  });
  
}

export const dataOrdenes = async (contenedorPrincipal,jwt)  => {
    console.log(contenedorPrincipal)
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
            alert("Usuario No Existente o no ha realizado Compras")
        }
        
    } catch (error) {
        console.error('Error:', error);
    }
    
    if (data) {
        try {
            const response = await fetch("http://localhost:8080/api/detalleorden", {
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
                const botonesFecha = shadowRoot.querySelectorAll(".boton-fecha")
                botonesFecha.forEach(boton => {
                    boton.addEventListener("click", (e) => {
                        e.preventDefault();
                        const idDetalle = e.target.id;
                        console.log(idDetalle)
                        console.log("Se ha hecho clic en el botón de asignar fecha");
                        dataNewFecha(contenedorPrincipal,idDetalle,jwt)
    
                    });
                });
    
                
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