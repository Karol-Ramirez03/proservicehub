const renderizarFecha = () => {
    return /* html */`
    <div class="contenedor-formularioper">
    <h1>Formulario de Registro</h1>
        <form class="registroForm">
            <div class="form-group">
                <label for="nombre">Nombre:</label>
                <input type="date" id="nombre" name="nombre"required>
            </div>   
            <div class="form-group">
                <button type="submit" class="btn-registro btn-asignar">asignar</button>                
            </div>   
        </form>
       

    </div>
    
    `;
}

export const dataNewFecha = async (contenedorPrincipal, idDetalleOrden)  => {

    contenedorPrincipal.innerHTML = ""
    contenedorPrincipal.insertAdjacentHTML("beforeend", renderizarFecha())

    const shadowRoot = contenedorPrincipal.shadowRoot || contenedorPrincipal;

    const formulario = shadowRoot.querySelector(".registroForm");
    const boton = shadowRoot.querySelector(".btn-asignar");
    const detalleid = idDetalleOrden;

    boton.addEventListener("click", async (e) => {
        e.preventDefault();
        
        const fecha = formulario.querySelector("#nombre").value;
        if (fecha == null || fecha == "") {
            console.log("Fecha no asignada:", fecha);
            
        } else {
            console.log("Fecha asignada:", fecha);
            const datosEnviar =	{
                "fecha": fecha,
            }
            
            try {
                const response = await fetch(`http://localhost:8080/api/detalleorden/${detalleid}`, {
                    method:"PUT",
                    headers:{
                        'Content-Type':'application/json'
                    },
                    body:JSON.stringify(datosEnviar)
                })
                if(response.ok){
                    const Ordenes = await response.json();
                    console.log(Ordenes)
                    formulario.reset()
                }
                
            } catch (error) {
                console.error('Error:', error);
            }

            
        }

    });
    
}

const renderizarEmpleado = () => {
    return /* html */`
    <div class="contenedor-formularioper">
    <h1>Formulario de Registro</h1>
        <form class="registroForm">
            <div class="form-group">
                <label for="idEmpleado">Id Empleado:</label>
                <input type="number" id="idEmpleado" name="idEmpleado" required>
            </div>  
            <div class="form-group">
                <button type="submit" class="btn-registro">Registrar</button>                
            </div>    
        </form>

    </div>
    
    `;
}

export const dataNewEmpleado = async (contenedorPrincipal, idOrdenServicio)  => {
    console.log(contenedorPrincipal)
    contenedorPrincipal.innerHTML = ""
    contenedorPrincipal.insertAdjacentHTML("beforeend", renderizarEmpleado())

    const shadowRoot = contenedorPrincipal.shadowRoot || contenedorPrincipal;

    const formulario = shadowRoot.querySelector(".registroForm");
    const boton = shadowRoot.querySelector(".btn-registro");
    const detalleid = idOrdenServicio;

    boton.addEventListener("click", async (e) => {
        e.preventDefault();
        
        const Dato = formulario.querySelector("#idEmpleado").value;
        if (Dato == null || Dato == "") {
            console.log("Dato no asignada:", Dato);
            
        } else {
            console.log("Dato asignada:", Dato);
            const datosEnviar =	{
                "persona": {
                    "nro_Doc": Dato
                }
            }
            
            try {
                const response = await fetch(`http://localhost:8080/api/ordenservicio/${detalleid}`,  {
                    method:"PUT",
                    headers:{
                        'Content-Type':'application/json'
                    },
                    body: JSON.stringify(datosEnviar)
                })
                if(response.ok){
                    const Ordenes = await response.json();
                    console.log(Ordenes)
                    formulario.reset()
                }
                
            } catch (error) {
                console.error('Error:', error);
            }

            
        }

    });
    
    
}