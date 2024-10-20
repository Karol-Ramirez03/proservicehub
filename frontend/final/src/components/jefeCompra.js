import { dataProveedorInsumo } from "./proveedoresInsumo.js";
import { initProveedorPanel } from "./registrarProveedor.js";


const botonInsumo = document.querySelector(".boton-proveedor-insumo")
const contenedor = document.querySelector(".table-container")
const botonCompra = document.querySelector(".boton-proveedor")
const divApp=document.querySelector("#app")

initProveedorPanel();

botonInsumo.addEventListener("click", (e) => {
    dataProveedorInsumo(contenedor)
});

// botonCompra.addEventListener("click", (e) => {
//     divApp.innerHTML=""
//     dataProveedor(contenedor,clienteId)
// });

