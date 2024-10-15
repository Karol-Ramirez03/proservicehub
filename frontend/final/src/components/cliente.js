import { dataInsumos } from "./insumo-cliente.js";
import { dataServicios } from "./servicio-cliente";

const botonInsumo = document.querySelector(".boton-insumo")
const contenedor = document.querySelector(".table-container")
const botonServicios = document.querySelector(".boton-servicio")

botonInsumo.addEventListener("click", (e) => {
    dataInsumos(contenedor)
});

botonServicios.addEventListener("click", (e) => {
    dataServicios(contenedor)
});