import { dataComprasAux } from "./auxiliarcompas.js";
import { dataInsumoRiesgo } from "./insumosRiesgo.js";


const botonCompra = document.querySelector(".boton-compra")
const contenedor = document.querySelector(".table-container")
const divApp=document.querySelector("#app")
const botonInsumoRiesgo= document.querySelector(".boton-insumo-riesgo")


const jwt = localStorage.getItem("jwt")

botonCompra.addEventListener("click", (e) => {
    // initInsumoPanel();
    dataComprasAux(contenedor,jwt)
});

botonInsumoRiesgo.addEventListener("click", (e) => {
    dataInsumoRiesgo(contenedor,jwt)
});


