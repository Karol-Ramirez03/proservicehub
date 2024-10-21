import { dataComprasAux } from "./auxiliarcompas.js";
import { dataProveedor } from "./proveedorJefeBodega.js";
import { initInsumoPanel } from "./registroInsumo.js";


const botonCompra = document.querySelector(".boton-compra")
const contenedor = document.querySelector(".table-container")
const divApp=document.querySelector("#app")




botonCompra.addEventListener("click", (e) => {
    // initInsumoPanel();
    dataComprasAux(contenedor)
});

// botonCompra.addEventListener("click", (e) => {
//     divApp.innerHTML=""
//     dataProveedor(contenedor,clienteId)
// });

