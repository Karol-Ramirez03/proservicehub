import { dataNewEmpleado } from "./actualizarServicio";
import { refreshToken } from "./refreshToken";

const renderizarTablas = () => {
    return /* html */`
    <table class="nombres-table">
        <thead>
            <tr>
                <th>Id Detalle Orden servicio</th>
                <th>Valor Servicio</th>
                <th>servicio</th>
                <th>Id Orden Servicio</th>
                <th>id cliente</th>
                <th>Id empleado</th>
                <th>empleado nombre</th>
                
                <th>Asignar personal</th>
                
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
      <td>${dato.valor_servicio}</td>
      <td>${dato.servicio.nombre}</td>
      <td>${dato.orden_servicio.numero_orden}</td>
      <td>${dato.orden_servicio?.personas?.nro_Doc ?? ''}</td>
      <td>${dato.orden_servicio?.persona?.nro_Doc ?? '0'}</td>
      <td>${dato.orden_servicio?.persona?.nombre ?? '0'}</td>
      <td><button class="boton-empleado" id="${dato.orden_servicio.numero_orden}">Asignar empleado</button></td>

    `;
    cuerpoData.appendChild(fila)
  });
}

export const dataserviciosNo = async (contenedorPrincipal,jwt)  => {
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
            const response = await fetch("http://localhost:8080/api/detalleordenservicio/estado/2", {
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
    
                const botonEmpleado = shadowRoot.querySelectorAll(".boton-empleado")
                botonEmpleado.forEach(boton => {
                    boton.addEventListener("click", (e) => {
                        e.preventDefault();
                        const idDetalle = e.target.id;
                        console.log(idDetalle)
                        console.log("Se ha hecho clic en el botón de asignar fecha");
                        dataNewEmpleado(contenedorPrincipal,idDetalle)
    
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