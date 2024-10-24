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

botonProInsumo.addEventListener("click", (e) => {
    dataProveedorInsumos(contenedor,idUsuario)
});

btnVentas.addEventListener("click",(e)=>{
    dataVentas(contenedor,idUsuario)
})

btnPendiente.addEventListener("click",(e)=>{
    dataVentasPendiente(contenedor,idUsuario)
})