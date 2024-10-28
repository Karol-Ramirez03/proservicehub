import { dataComprasAux } from "./auxiliarcompas.js";
import { dataInsumoRiesgo } from "./insumosRiesgo.js";
import { logout } from "./logout.js";


const botonCompra = document.querySelector(".boton-compra")
const contenedor = document.querySelector(".table-container")
const botonInsumoRiesgo= document.querySelector(".boton-insumo-riesgo")
const logoutBtn=document.querySelector(".logout")


const jwt = localStorage.getItem("jwt")

botonCompra.addEventListener("click", (e) => {
    dataComprasAux(contenedor,jwt)
});

botonInsumoRiesgo.addEventListener("click", (e) => {
    dataInsumoRiesgo(contenedor,jwt)
});

logoutBtn.addEventListener("click",(e)=>{
logout();
})


