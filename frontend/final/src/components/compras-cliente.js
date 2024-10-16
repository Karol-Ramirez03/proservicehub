const rnderizarInicio = () => {

}

const renderizarTablas = () => {
    return /* html */`
    <table class="nombres-table">
        <thead>
            <tr>
                <th>id</th>
                <th>Fecha de compra</th>
                <th>Estado</th>
                <th>Acciones</th>
            </tr>
        </thead>
        <tbody class="tbody-info">
        </tbody>
    </table>
    `;
}

const renderizarDatos = (datos,estado) => {
  const cuerpoData = document.querySelector(".tbody-info")

  console.log("funciona")
  cuerpoData.innerHTML = ""

  datos.forEach(async dato => {
    
    try {
        const response2 = await fetch("http://localhost:8080/api/compra/{dato.id}/estado/nombre", {
            method:"GET"
        })
        if(response2.ok){
            const estado = await response2.text();

            const fila = document.createElement("tr");
            fila.innerHTML= `
            <td>${dato.id}</td>
            <td>${dato.fecha_compra}</td>
            <td>${estado}</td>
            <td>Comprar</td>
            `;
            cuerpoData.appendChild(fila)
        }
        
    } catch (error) {
        console.error('Error:', error);
    }


    
  });
}


export const dataCompras = async (contenedorPrincipal,clienteId)  => {
    contenedorPrincipal.innerHTML = ""
    contenedorPrincipal.insertAdjacentHTML("beforeend", renderizarTablas())

    try {
        const response = await fetch("http://localhost:8080/api/compra/persona/{clienteId}", {
            method:"GET",
            headers:{
                'Content-Type':'application/json'
            }
        })
        if(response.ok){
            const compras = await response.json();
            renderizarDatos(compras);
            
        }
        
    } catch (error) {
        console.error('Error:', error);
    }

  
  
}

