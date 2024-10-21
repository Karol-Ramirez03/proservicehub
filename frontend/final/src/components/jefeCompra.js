import { dataProveedorInsumo } from "./proveedoresInsumo.js";
import { initProveedorPanel } from "./registrarProveedor.js";


const botonProInsumo = document.querySelector(".boton-proveedor-insumo")
const contenedor = document.querySelector(".table-container")


initProveedorPanel();

botonProInsumo.addEventListener("click", (e) => {
    dataProveedorInsumo(contenedor)
});


