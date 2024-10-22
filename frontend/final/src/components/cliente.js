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

const usuario=JSON.parse(localStorage.getItem("usuario"))
const idUsuario=usuario.personas.nro_Doc
console.log(idUsuario)
botonInsumo.addEventListener("click", (e) => {
    dataInsumos(contenedor,idUsuario)
});

botonServicios.addEventListener("click", (e) => {
    dataServicios(contenedor,idUsuario)
});

botonCompra.addEventListener("click", (e) => {
    dataCompras(contenedor,idUsuario)
});

botonMisServicios.addEventListener("click", (e) => {
    dataMisServicios(contenedor,idUsuario)
});

botonAprobacion.addEventListener("click", (e) => {
    dataAprobacion(contenedor,idUsuario)
});


