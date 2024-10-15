import {LitElement, html } from 'lit'
import { dataInsumos } from './OrdenesRH.js';
// registrar empleados
// servicios no asignados - generar ordenes de trabajo
// seguimiento de ordenes de trabajo


class  PagInicioRecursosHumanos extends LitElement {
    constructor(){
        super()
    }

    render(){
    return html `
    <link rel="stylesheet" href="src/cliente.css"/>
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
          <button class="boton-insumo">Registro Personal</button>
          <button>Servicios</button>
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
        const contenedorPrincipal = this.shadowRoot.querySelector('.table-container');

        botonOrdenes.addEventListener('click', (e) => {
            e.preventDefault
            dataInsumos(contenedorPrincipal);
          });
    }

}

customElements.define("inicio-recursos", PagInicioRecursosHumanos)


