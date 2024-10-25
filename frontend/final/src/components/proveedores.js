import { dataProveedorInsumos } from "./insumosProveedor";
import { dataVentas } from "./ventasProveedor";
import { dataVentasPendiente } from "./ventasPendienteProveedor";


const botonProInsumo = document.querySelector(".boton-insumos")
const contenedor = document.querySelector(".table-container")
const btnVentas=document.querySelector(".boton-ventas")
const btnPendiente=document.querySelector(".boton-pendiente")



// initProveedorPanel();
const usuario=JSON.parse(localStorage.getItem("usuario"))
const idUsuario=usuario.personas.nro_Doc
console.log(idUsuario)

const jwt = localStorage.getItem("jwt")

botonProInsumo.addEventListener("click", (e) => {
    dataProveedorInsumos(contenedor,idUsuario,jwt)
});

btnVentas.addEventListener("click",(e)=>{
    dataVentas(contenedor,idUsuario,jwt)
})

btnPendiente.addEventListener("click",(e)=>{
    dataVentasPendiente(contenedor,idUsuario,jwt)
})