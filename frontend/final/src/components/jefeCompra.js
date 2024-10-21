import { dataProveedorInsumo } from "./proveedoresInsumo.js";
import { initProveedorPanel } from "./registrarProveedor.js";
import { dataInsumoRiesgo } from "./insumosRiesgo.js";


const botonProInsumo = document.querySelector(".boton-proveedor-insumo")
const contenedor = document.querySelector(".table-container")
const botonInsumoRiesgo= document.querySelector(".boton-insumo-riesgo")

initProveedorPanel();

botonProInsumo.addEventListener("click", (e) => {
    dataProveedorInsumo(contenedor)
});

botonInsumoRiesgo.addEventListener("click", (e) => {
    dataInsumoRiesgo(contenedor)
});

