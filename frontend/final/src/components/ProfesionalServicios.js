import {LitElement, html } from 'lit'
import { dataAprobado } from './OrdenesAprobadas-Profesionales.js';
import { dataserviciosAsignado } from './OrdenAsignada-Profesionales.js';
import { dataOrdenesTrabajo } from './OrdenTrabajo-Profesionales.js';
import { refreshToken } from './refreshToken.js';

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
          <input type="checkbox" name="" id="check">
          <label for="check" class="checkbutton">
          <img src="User (2).png" alt="">
          </label>
          <div class="dropdown-content">
            <li class="logout">logout</li>
            <li>perfil</li>
          </div>
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
      // const idUsuario=10
      console.log(idUsuario)

      const jwt = localStorage.getItem("jwt")

      botonServicios.addEventListener("click", (e) => {
          e.preventDefault()
          
          dataserviciosAsignado(contenedorPrincipal,idUsuario,jwt)

        });

      botonTrabajos.addEventListener("click", (e) => {
        e.preventDefault()
        
        dataOrdenesTrabajo(contenedorPrincipal,idUsuario,jwt)

      });
      botonAprobado.addEventListener("click", (e) => {
          e.preventDefault()
          dataAprobado(contenedorPrincipal,idUsuario,jwt)
        });



        
    }

}

customElements.define("inicio-profesional", PagInicioProfesionalServicios)