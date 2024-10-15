import { dataInsumos } from "./insumo-cliente.js";
import { dataServicios } from "./servicio-cliente";
import { dataCompras } from "./compras-cliente.js";

const botonInsumo = document.querySelector(".boton-insumo")
const contenedor = document.querySelector(".table-container")
const botonServicios = document.querySelector(".boton-servicio")
const botonCompra = document.querySelector(".boton-compra")

botonInsumo.addEventListener("click", (e) => {
    dataInsumos(contenedor)
});

botonServicios.addEventListener("click", (e) => {
    dataServicios(contenedor)
});

botonCompra.addEventListener("click", (e) => {
    dataCompras(contenedor)
});

