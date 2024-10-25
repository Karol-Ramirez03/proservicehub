import {LitElement, html } from 'lit'
import { data3top } from './MarketingConsultas.js';
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
        // const encrpit=JSON.parse(localStorage.getItem("jwt"))
        // console.log(encrpit)
        const contenedor = this.shadowRoot.querySelector(".tarj")
        // let jwt ="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJjb25zdWx0YXMiLCJpYXQiOjE3Mjk4NjA2MDEsImV4cCI6MTcyOTg2MjQwMX0.R5-pnYEc5oQrcHB11Js8JR04yugkQQHeMqF2wZHyEqM"
        let jwt = localStorage.getItem('jwt')
        console.log(jwt)
        data3top(contenedor,jwt)

    }

}

customElements.define("inicio-marketing", PagInicioMarketing)