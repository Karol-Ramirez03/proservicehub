import { LitElement, html, css } from 'lit';
import { customElement } from 'lit/decorators.js';


class InicioForm extends LitElement {

  
  static properties = {
    condition: {},
    btnguardar: {},
  };

  constructor(){
    super()

  }

  render(){
    // this.attachShadow({mode: 'open'})
    // this.shadowRoot.innerHTML
    return html`
    <link rel="stylesheet" href="src/index.css" />
   <div class="login-container">
        <div class="login-box">
             <img src="public/User (2).png" alt="img" class="img">
            <h2 class= "welcome" >Bienvenido</h2>
            <div class="tabs">
                <button class="active">Iniciar sesión</button>
                <button class= "reg">Registrarse</button>
            </div>
            <form class="login-form">
                <div class="input-group">
                    <input type="email" name="email" placeholder="Correo electrónico" required>
                </div>
                <div class="input-group">
                    <input type="password" name="password" placeholder="Contraseña" required>
                </div>
                <div class="options">
                    <label>
                        <input type="checkbox"> Recordarme
                    </label>
                    <a href="#">¿Olvidaste tu contraseña?</a>
                </div>
                <button type="submit" class="guardar login-btn">Iniciar sesión</button>
            </form>
        </div>
    </div>
    `
  }

  updated(){
    const btnguardar= this.shadowRoot.querySelector(".guardar")
    const btnLogin=this.shadowRoot.querySelector(".active")
    
    btnLogin.addEventListener("click",(e)=>{
      location.reload();
    })
    btnguardar.addEventListener("click",(e)=>{
      e.preventDefault();
      console.log("holaaaa")
      this._handleSubmit(e)
    })

    const btnregister= this.shadowRoot.querySelector(".reg")
    btnregister.addEventListener("click",(e)=>{
      console.log("hola")
      e.preventDefault;
      this._handleRegister(e)
    })
    
  }
  _handleSubmit(e) {
    e.preventDefault();
    const form =this.shadowRoot.querySelector(".login-form")
    const formData= new FormData(form)
    const username=formData.get('email')
    const password=formData.get('password')
    const loginData = {
      usuario: username,
      contraseña: password
    };
    
    console.log(loginData)
    const url = `http://localhost:8080/api/login?username=${username}&password=${password}`
    fetch(url, {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json',
      },
    })
    .then(response => {
      if (!response.ok) {
        throw new Error('Error en la autenticación');
      }
      return response.json();
    })
    .then(data => {
      console.log('Inicio de sesión exitoso:', data);
      // Aquí puedes manejar la respuesta, como guardar el token o redirigir al usuario
    })
    .catch(error => {
      console.error('Error en el inicio de sesión:', error);
    });
  }

  _handleRegister(e) {
    e.preventDefault()
    console.log("funcionooo")
    const divform= this.shadowRoot.querySelector(".login-form")
    divform.innerHTML=`
                <input type="text" name="username" placeholder="Nombre de usuario" required>
              </div>
              <div class="input-group">
                <input type="email" name="email" placeholder="Correo electrónico" required>
              </div>
              <div class="input-group">
                <input type="password" name="password" placeholder="Contraseña" required>
              </div>
              <button type="submit" class="guardar register-btn">Registrarse</button>
              `

    // e.preventDefault();
    // const form = this.shadowRoot.querySelector(".register-form");
    // const formData = new FormData(form);
    // const username = formData.get('username');
    // const email = formData.get('email');
    // const password = formData.get('password');
    // const registerData = {
    //   usuario: username,
    //   correo: email,
    //   contraseña: password,
    };
}


customElements.define("inicio-form",InicioForm)
