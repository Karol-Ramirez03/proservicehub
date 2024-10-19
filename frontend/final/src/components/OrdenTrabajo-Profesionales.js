// visualizar las órdenes
// //solicitar al cliente la aprobación de una reparación a partir de hallazgos encontrados

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
                <th>solicitar</th>
                
                
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
      <td><button class="boton" id="${dato.orden_trabajo.id}">Solicitar Aprobacion</button></td>
      
      <tr class="cont${dato.orden_trabajo.id}" id="${dato.orden_trabajo.id}">        </tr>
    `;
    cuerpoData.appendChild(fila)

    const filaForm = document.createElement("tr");
    filaForm.classList.add(`cont${dato.orden_trabajo.id}`); 
    cuerpoData.appendChild(filaForm);
    
  });
  
}
const renderizarSolicitar = (shadowRoot,filaid) => {
    const fila = shadowRoot.querySelector(`.cont${filaid}`)
    fila.innerHTML = ""
    fila.innerHTML =`
        <td colspan="13">
            <form colspan="13" class="formfila">
                <div class="group">
                    <label for="idDet">Id Orden Trabajo:</label>
                    <input type="number" id="idDet" name="idDet"required>
                </div>
        
                <div class="group">
                    <label for="Hallazgo">Hallazgo:</label>
                    <input type="text" id="Hallazgo" name="Hallazgo"  required>
                </div>
        
                <div class="group">
                    <label for="Solucion">Solucion:</label>
                    <input type="text" id="Solucion" name="Solucion"  required>
                
                </div>
                <div class="group">
                    <button type="submit" class="btn-registro">Registrar</button>                
                </div>
                <div class="group">
                    <button type="submit" class="btn-cancelar">cancelar</button>                
                </div>
            </form>
            </td>
    `;

    const formFila = shadowRoot.querySelector(`.cont${filaid} .formfila`);

    const btnRegistrar = formFila.querySelector(".btn-registro");
    const btnCancelar = formFila.querySelector(".btn-cancelar");

    btnRegistrar.addEventListener("click", async (e) => {
        e.preventDefault();

        const idDet = formFila.querySelector("#idDet").value;
        //iddet o es necesario ya que lo obtenemos de otros medios (filaid)
        const hallazgo = formFila.querySelector("#Hallazgo").value;
        const solucion = formFila.querySelector("#Solucion").value;
        const idtra = parseInt(filaid,10)
        const enviarData = {
            "orden_trabajo":idtra,
            "hallazgo":hallazgo,
            "solucion":solucion

        }
        if (idDet && hallazgo && solucion) {
            console.log("Datos registrados:", { idtra, hallazgo, solucion });
            alert("Registro completado!");
            try {
                const response = await fetch(`http://localhost:8080/api/aprobacionservicio/agregar`, {
                    method:"POST",
                    headers:{
                        'Content-Type':'application/json'
                    },
                    body: JSON.stringify(enviarData)
                })
                if(response.ok){
                    const Ordenes = await response.json();
                    console.log(Ordenes)

                    
                }
                
            } catch (error) {
                console.error('Error:', error);
            }

        } else {
            alert("Por favor, complete todos los campos.");
        }
    });

    btnCancelar.addEventListener("click", (e) => {
        e.preventDefault();
        fila.innerHTML = "";
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

            const botonsolicitar = shadowRoot.querySelectorAll(".boton")
            botonsolicitar.forEach(boton => {
                boton.addEventListener("click", (e) => {
                    e.preventDefault();
                    const botonid = e.target.id;
                    renderizarSolicitar(shadowRoot,botonid)
                });
            });
            
        }
        
    } catch (error) {
        console.error('Error:', error);
    }
    

  
}