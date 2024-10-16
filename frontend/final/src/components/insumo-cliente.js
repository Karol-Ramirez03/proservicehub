const rnderizarInicio = () => {

}


const renderizarTablas = () => {
    return /* html */`
    <table class="nombres-table">
        <thead>
            <tr>
                <th>id</th>
                <th>nombre</th>
                <th>Codigo Interno</th>
                <th>stock</th>
                <th>Comprar</th>
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
    <td>${dato.nombre}</td>
    <td>${dato.precio_unitario}</td>
    <td>${dato.stock}</td>
    <td>Comprar</td>
    `;
    cuerpoData.appendChild(fila)
  });
}

export const dataInsumos = async (contenedorPrincipal)  => {
    contenedorPrincipal.innerHTML = ""
    contenedorPrincipal.insertAdjacentHTML("beforeend", renderizarTablas())

    try {
        const response = await fetch("http://localhost:8080/api/insumo", {
            method:"GET",
            headers:{
                'Content-Type':'application/json'
            }
        })
        if(response.ok){
            const insumos = await response.json();
            renderizarDatos(insumos);
        }
        
    } catch (error) {
        console.error('Error:', error);
    }
  
}