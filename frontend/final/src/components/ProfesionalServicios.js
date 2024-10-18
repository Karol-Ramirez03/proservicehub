import {LitElement, html } from 'lit'
import { dataAprobado } from './OrdenesAprobadas-Profesionales.js';
import { dataserviciosAsignado } from './OrdenAsignada-Profesionales.js';
import { dataOrdenesTrabajo } from './OrdenTrabajo-Profesionales.js';

class  PagInicioProfesionalServicios extends LitElement {
    constructor(){
        super()
    }

    render(){
    return html `
    <link rel="stylesheet" href="src/recursosHumanos.css"/>
    <div class="container">
      <nav>
        <h1>Portal de Profesionales De Servicios</h1>
        <div class="container-user">
          <img src="User (2).png" alt="">
          <h3>user</h3>
        </div>
      </nav>  
      <section class="container-principal">
        <div class="container-button">
          <button class="ordenes">Detalle Orden</button>
          <button class="servicios">Ordenes</button>
          <button class="trabajos">Trabajo</button>
          <button class="aprobado">Solicitudes Aprobadas</button>
        </div>

        <div class="table-container">

        </div>
      </section>  

    </div>
    `;
    }
    //
    updated() {
      const botonOrdenes = this.shadowRoot.querySelector(".ordenes")
      const botonServicios = this.shadowRoot.querySelector(".servicios")
      const botonTrabajos = this.shadowRoot.querySelector(".trabajos")
      const botonAprobado = this.shadowRoot.querySelector(".aprobado")
      const contenedorPrincipal = this.shadowRoot.querySelector('.table-container');
     

      botonOrdenes.addEventListener('click', (e) => {
          e.preventDefault()

        });

      botonServicios.addEventListener("click", (e) => {
          e.preventDefault()
          let idEmpleado = 12;
          dataserviciosAsignado(contenedorPrincipal,idEmpleado)

        });

      botonTrabajos.addEventListener("click", (e) => {
        e.preventDefault()
        let idEmpleado = 12;
        dataOrdenesTrabajo(contenedorPrincipal,idEmpleado)

      });
      botonAprobado.addEventListener("click", (e) => {
          e.preventDefault()
          dataAprobado(contenedorPrincipal)

        });



        
    }

}

customElements.define("inicio-profesional", PagInicioProfesionalServicios)