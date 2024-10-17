const rnderizarInicio = () => {

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
                <th>Estado</th>
                <th>Acciones</th>
            </tr>
        </thead>
        <tbody class="tbody-info">
        </tbody>
    </table>
    `;
}

const renderizarDatos = (datos,orden) => {
    const cuerpoData = document.querySelector(".tbody-info");

    cuerpoData.innerHTML = "";
    console.log(datos)
    console.log(orden)
    for(let cont = 0; cont <datos.length; cont++){
        const fila = document.createElement("tr"); // Asegúrate de usar "tr" entre comillas
        fila.innerHTML = `
        <td>${datos[cont].id}</td>
        <td>${datos[cont].nombre}</td>
        <td>${datos[cont].requiere_insumo}</td>
        <td>${datos[cont].tiempo_ejecucion}</td>
        <td>${orden[cont].estado_orden_servicio.nombre}</td>
        <td><button id="${datos[cont].id}">Detalles</button></td> 
        `;
        cont+=1
        cuerpoData.appendChild(fila);
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
                console.log(orden)
                ordenList.push(orden)
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
                                console.log(servicio)
                                list.push(servicio)
                                
                                
                            }
                            
                        } catch (error) {
                            console.error('Error:', error);
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
    while (list.length==ordenList.length){
        console.log(list)
        renderizarDatos(list,ordenList);

    }
    
    
}

