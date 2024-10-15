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
            <div class="icon">
                <i class="fas fa-user"></i>
            </div>
            <h2>Bienvenido</h2>
            <div class="tabs">
                <button class="active">Iniciar sesión</button>
                <button>Registrarse</button>
            </div>
            <form>
                <div class="input-group">
                    <input type="email" placeholder="Correo electrónico" required>
                </div>
                <div class="input-group">
                    <input type="password" placeholder="Contraseña" required>
                </div>
                <div class="options">
                    <label>
                        <input type="checkbox"> Recordarme
                    </label>
                    <a href="#">¿Olvidaste tu contraseña?</a>
                </div>
                <button type="submit" class="login-btn">Iniciar sesión</button>
            </form>
        </div>
    </div>
    `
  }

  updated(){
    const btnguardar= this.shadowRoot.querySelector(".guardar")
    btnguardar.addEventListener("click",(e)=>{
      e.preventDefault();
      console.log("holaaaa")
      this._handleSubmit(e)
    })
  }
  _handleSubmit(e) {
    e.preventDefault();
    const formData =this.shadowRoot.querySelector(".login-form")
    const loginData = {
      username: formData.get('username'),
      password: formData.get('password')
    };

    fetch('https://tuapi.com/login', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(loginData)
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
}


customElements.define("inicio-form",InicioForm)
