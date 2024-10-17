import {LitElement, html } from 'lit'
import {dataOrdenes } from './OrdenesRH.js';
import { dataRegistro } from './RegistroEmpleados.js';
import { dataserviciosNo } from './serviciosNoasignados.js';
// registrar empleados
// servicios no asignados - generar ordenes de trabajo
// seguimiento de ordenes de trabajo


class  PagInicioRecursosHumanos extends LitElement {
    constructor(){
        super()
    }

    render(){
    return html `
    <link rel="stylesheet" href="src/recursosHumanos.css"/>
    <div class="container">
      <nav>
        <h1>Portal de Recursos Humanos</h1>
        <div class="container-user">
          <img src="User (2).png" alt="">
          <h3>user</h3>
        </div>
      </nav>  
      <section class="container-principal">
        <div class="container-button">
          <button class="registro">Registro Personal</button>
          <button class="servicio-no-asignado">Servicios</button>
          <button class="boton-orden">Ordenes</button>
        </div>

        <div class="table-container">

        </div>
      </section>  

    </div>
    `;
    }
    updated() {
        const botonOrdenes = this.shadowRoot.querySelector(".boton-orden")
        const botonRegistro = this.shadowRoot.querySelector(".registro")
        const serviciosAsignacion = this.shadowRoot.querySelector(".servicio-no-asignado")
        const contenedorPrincipal = this.shadowRoot.querySelector('.table-container');
       

        botonOrdenes.addEventListener('click', (e) => {
            e.preventDefault()
            dataOrdenes(contenedorPrincipal);
          });
        botonRegistro.addEventListener("click", (e) => {
            e.preventDefault()
            dataRegistro(contenedorPrincipal);
          });
        serviciosAsignacion.addEventListener("click", (e) => {
            e.preventDefault()
            dataserviciosNo(contenedorPrincipal);
          });

        
    }

}

customElements.define("inicio-recursos", PagInicioRecursosHumanos)


