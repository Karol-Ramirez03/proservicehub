import { dataInsumos } from "./insumoJefe.js";
import { dataProveedor } from "./proveedorJefeBodega.js";
import { initInsumoPanel } from "./registroInsumo.js";


const botonInsumo = document.querySelector(".boton-insumo")
const contenedor = document.querySelector(".table-container")
const botonCompra = document.querySelector(".boton-proveedor")
const divApp=document.querySelector("#app")




botonInsumo.addEventListener("click", (e) => {
    initInsumoPanel();
    dataInsumos(contenedor)
});

botonCompra.addEventListener("click", (e) => {
    divApp.innerHTML=""
    dataProveedor(contenedor)
});





