import {LitElement, html } from 'lit'

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
          <button class="registro">Ordenes Asignadas- Solicitar Aprobacion</button>
          <button class="servicio-no-asignado">Servicios Asignados</button>
          <button class="boton-orden">Solicitudes Aprobadas</button>
        </div>

        <div class="table-container">

        </div>
      </section>  

    </div>
    `;
    }
    updated() {


        
    }

}

customElements.define("inicio-profesional", PagInicioProfesionalServicios)