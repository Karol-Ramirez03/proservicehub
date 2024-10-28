import { dataProveedorInsumo } from "./proveedoresInsumo.js";
import { initProveedorPanel } from "./registrarProveedor.js";
import { logout } from "./logout.js";


const botonProInsumo = document.querySelector(".boton-proveedor-insumo")
const contenedor = document.querySelector(".table-container")
const jwt = localStorage.getItem("jwt")
const logoutBtn=document.querySelector(".logout")

initProveedorPanel(jwt);

botonProInsumo.addEventListener("click", (e) => {
    dataProveedorInsumo(contenedor,jwt)
});

logoutBtn.addEventListener("click",(e)=>{
    logout();
    })


