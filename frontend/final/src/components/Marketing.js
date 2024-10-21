import {LitElement, html } from 'lit'
import { data3top } from './MarketingConsultas';
class  PagInicioMarketing extends LitElement {
    constructor(){
        super()
    }

    render(){
    return html `
    <link rel="stylesheet" href="src/recursosHumanos.css"/>
    <div class="container">
      <nav>
        <h1>Portal de Marketing</h1>
        <div class="container-user">
          <img src="User (2).png" alt="">
          <h3>user</h3>
        </div>
      </nav>  
      <section class="container-principal container-tarj">
        <h1>Punto Informacion</h1>
        <div class="tarj">

        </div>
      </section>  

    </div>
    `;
    }
    //
    updated() {
        const contenedor = this.shadowRoot.querySelector(".tarj")
        data3top(contenedor)

    }

}

customElements.define("inicio-marketing", PagInicioMarketing)