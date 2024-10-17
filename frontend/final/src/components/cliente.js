import { dataInsumos } from "./insumo-cliente.js";
import { dataServicios } from "./servicio-cliente";
import { dataCompras } from "./compras-cliente.js";
import { dataMisServicios } from "./mis-servicios-cliente.js";
import { dataAprobacion } from "./solicitudServicios.js";


const botonInsumo = document.querySelector(".boton-insumo")
const contenedor = document.querySelector(".table-container")
const botonServicios = document.querySelector(".boton-servicio")
const botonCompra = document.querySelector(".boton-compra")
const botonMisServicios = document.querySelector(".boton-mis-servicio")
const botonAprobacion=document.querySelector(".aprobacion-servicios")


const clienteId=10255

botonInsumo.addEventListener("click", (e) => {
    dataInsumos(contenedor)
});

botonServicios.addEventListener("click", (e) => {
    dataServicios(contenedor)
});

botonCompra.addEventListener("click", (e) => {
    dataCompras(contenedor,clienteId)
});

botonMisServicios.addEventListener("click", (e) => {
    dataMisServicios(contenedor)
});

botonAprobacion.addEventListener("click", (e) => {
    dataAprobacion(contenedor)
});


