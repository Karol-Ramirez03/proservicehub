import { dataProveedorInsumos } from "./insumosProveedor";
import { dataVentas } from "./ventasProveedor";
import { dataVentasPendiente } from "./ventasPendienteProveedor";


const botonProInsumo = document.querySelector(".boton-insumos")
const contenedor = document.querySelector(".table-container")
const btnVentas=document.querySelector(".boton-ventas")
const btnPendiente=document.querySelector(".boton-pendiente")



// initProveedorPanel();

botonProInsumo.addEventListener("click", (e) => {
    dataProveedorInsumos(contenedor)
});

btnVentas.addEventListener("click",(e)=>{
    dataVentas(contenedor)
})

btnPendiente.addEventListener("click",(e)=>{
    dataVentasPendiente(contenedor)
})