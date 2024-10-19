// //solicitar al cliente la aprobación de una reparación a partir de hallazgos encontrados


// const renderizarTablas = () => {
//     return /* html */`
//     <div class="contenedor-formularioper">
    
//         <h1>Trabajo Realizado</h1>
//             <form id="registroForm">
//                 <div class="form-group">
//                     <label for="idDet">Id Detalle Orden Trabajo</label>
//                     <input type="number" id="idDet" name="idDet"required>
//                 </div>
        
//                 <div class="form-group">
//                     <label for="Hallazgo">Hallazgo:</label>
//                     <input type="text" id="Hallazgo" name="Hallazgo"  required>
//                 </div>
        
//                 <div class="form-group">
//                     <label for="Solucion">Solucion:</label>
//                     <input type="text" id="Solucion" name="Solucion"  required>
                
//                 </div>
//             </form>
    
//     </div>
//     `;
// }

// export const dataRegistro = async (contenedorPrincipal)  => {
//     console.log(contenedorPrincipal)
//     contenedorPrincipal.innerHTML = ""
//     contenedorPrincipal.insertAdjacentHTML("beforeend", renderizarTablas())

//     const shadowRoot = contenedorPrincipal.shadowRoot || contenedorPrincipal;

//     const registroForm = shadowRoot.querySelector("#registroForm");;

//     registroForm.addEventListener("submit", async (e) => {
//         e.preventDefault();
//         const idDet = shadowRoot.querySelector("#idDet").value;
//         const Hallazgo = shadowRoot.querySelector("#Hallazgo").value;
//         const Solucion = shadowRoot.querySelector("#Solucion").value;

//         const datosEnviar = {

//         }

//         console.log(datosEnviar)
//         try {
//             const response = await fetch("http://localhost:8080/api/personas", {
//                 method:"POST",
//                 headers:{
//                     'Content-Type':'application/json'
//                 },
//                 body:JSON.stringify(datosEnviar)
//             })
//             if(response.ok){
//                 const Ordenes = await response.json();
//                 console.log(Ordenes)
//                 registroForm.reset()
    
//             }
            
//         } catch (error) {
//             console.error('Error:', error);
//         }

//     })
  
// }