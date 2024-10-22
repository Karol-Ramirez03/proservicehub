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
          <img src="public/user 2.png" alt="user-icon" class="small-image">
          <h3>user</h3>
        </div>
      </nav>  
      <section class="container-principal">
        <div class="container-button">
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
      const botonServicios = this.shadowRoot.querySelector(".servicios")
      const botonTrabajos = this.shadowRoot.querySelector(".trabajos")
      const botonAprobado = this.shadowRoot.querySelector(".aprobado")
      const contenedorPrincipal = this.shadowRoot.querySelector('.table-container');
     

      const usuario=JSON.parse(localStorage.getItem("usuario"))
      const idUsuario=usuario.personas.nro_Doc
      console.log(idUsuario)

      botonServicios.addEventListener("click", (e) => {
          e.preventDefault()
          
          dataserviciosAsignado(contenedorPrincipal,idUsuario)

        });

      botonTrabajos.addEventListener("click", (e) => {
        e.preventDefault()
        
        dataOrdenesTrabajo(contenedorPrincipal,idUsuario)

      });
      botonAprobado.addEventListener("click", (e) => {
          e.preventDefault()
          dataAprobado(contenedorPrincipal,idUsuario)
        });



        
    }

}

customElements.define("inicio-profesional", PagInicioProfesionalServicios)