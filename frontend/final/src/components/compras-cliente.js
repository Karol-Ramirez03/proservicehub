const rnderizarInicio = () => {

}

const renderizarTablas = () => {
    return /* html */`
    <table class="nombres-table">
        <thead>
            <tr>
                <th>id</th>
                <th>Fecha de compra</th>
                <th>Codigo Estado</th>
                <th>Acciones</th>
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
    <td>${dato.fecha_compra}</td>
    <td>${dato.estado_compra}</td>
    <td>Comprar</td>
    `;
    cuerpoData.appendChild(fila)
  });
}


export const dataCompras = async (contenedorPrincipal)  => {
    contenedorPrincipal.innerHTML = ""
    contenedorPrincipal.insertAdjacentHTML("beforeend", renderizarTablas())

    try {
        const response = await fetch("http://localhost:8080/api/compra", {
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