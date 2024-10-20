const rnderizarInicio = () => {

}

const renderizarTablas = () => {
    return /* html */`
    <table class="nombres-table">
        <thead>
            <tr>
                <th>id</th>
                <th>nombre</th>
                <th>Valor Servicio</th>
                <th>Tiempo Ejecución</th>
                <th>Estado</th>
                <th>Acciones</th>
            </tr>
        </thead>
        <tbody class="tbody-info">
        </tbody>
    </table>
    `;
}

const renderizarDatos = (datos,orden,detalles) => {
    const cuerpoData = document.querySelector(".tbody-info");

        const fila = document.createElement("tr"); // Asegúrate de usar "tr" entre comillas
        fila.innerHTML = `
        <td>${datos.id}</td>
        <td>${datos.nombre}</td>
        <td>${detalles.valor_servicio}</td>
        <td>${datos.tiempo_ejecucion}</td>
        <td>${orden.estado_orden_servicio.nombre}</td>
        
        `;
        if(orden.estado_orden_servicio.id==2){
            fila.innerHTML+=`<td><button class=" cancelar" id="${datos.id}">Cancelar</button></td> `
        }
        cuerpoData.appendChild(fila);
    
        _addEvent(fila);
}

const _addEvent=(fila)=>{
    const btnCancelar=fila.querySelector(".cancelar")
    if (btnCancelar) {
        btnCancelar.addEventListener('click', async (e) => {
            console.log(e.target.id);
            const orden={
                "estado_orden_servicio":{
                    "id":3
                }
            }
            try {
                const response2 = await fetch(`http://localhost:8080/api/ordenservicio/${e.target.id}`, {
                    method:"PUT",
                    headers:{
                        'Content-Type':'application/json'
                    },
                    body:JSON.stringify(orden)
                })
                if(response2.ok){
                    const servicio = await response2.json();
                    renderizarDatos(servicio,orden,detalles);

                    
                }
                
            } catch (error) {
                console.error('Error:', error);
            }finally{
                

            }
        });
    }
}

export const dataMisServicios= async (contenedorPrincipal,clienteId)  => {
    contenedorPrincipal.innerHTML = ""
    contenedorPrincipal.insertAdjacentHTML("beforeend", renderizarTablas())
    const id=1005539417
    var list=[]
    var ordenList=[]
    try {
        const response = await fetch(`http://localhost:8080/api/ordenservicio/persona/${id}`, {
            method:"GET",
            headers:{
                'Content-Type':'application/json'
            }
        })
        if(response.ok){
            const ordenes = await response.json();
            var cont=0
            ordenes.forEach(async orden=>{
                try {
                    const response2 = await fetch(`http://localhost:8080/api/detalleordenservicio/${orden.numero_orden}`, {
                        method:"GET",
                        headers:{
                            'Content-Type':'application/json'
                        }
                    })
                    if(response2.ok){
                        const detalles = await response2.json();
                        try {
                            const response2 = await fetch(`http://localhost:8080/api/servicio/${detalles.servicio.id}`, {
                                method:"GET",
                                headers:{
                                    'Content-Type':'application/json'
                                }
                            })
                            if(response2.ok){
                                const servicio = await response2.json();
                                renderizarDatos(servicio,orden,detalles);

                                
                            }
                            
                        } catch (error) {
                            console.error('Error:', error);
                        }finally{
                            

                        }
                        
                        
                    }
                    
                } catch (error) {
                    console.error('Error:', error);
                }finally{
                    
                }
            })
            
            
        }
        
    } catch (error) {
        console.error('Error:', error);
    }
    
    
    
    
}

