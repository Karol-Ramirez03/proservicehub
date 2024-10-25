import { dataProveedorInsumo } from "./proveedoresInsumo.js";
import { initProveedorPanel } from "./registrarProveedor.js";


const botonProInsumo = document.querySelector(".boton-proveedor-insumo")
const contenedor = document.querySelector(".table-container")
const jwt = localStorage.getItem("jwt")

initProveedorPanel(jwt);

botonProInsumo.addEventListener("click", (e) => {
    dataProveedorInsumo(contenedor,jwt)
});


