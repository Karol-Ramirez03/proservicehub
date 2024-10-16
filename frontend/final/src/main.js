// import { LitElement, html, css } from 'lit';
// import { customElement } from 'lit/decorators.js';

// @customElement("inicio-form")
// class InicioForm extends LitElement {
//   static properties = {
//     isRegistering: { type: Boolean }, // Propiedad para manejar el estado del formulario
//   };

//   constructor() {
//     super();
//     this.isRegistering = false; // Por defecto, se muestra el formulario de inicio de sesión
//   }

//   render() {
//     return html`
//       <link rel="stylesheet" href="src/index.css" />
//       <div class="login-container">
//         <div class="login-box">
//           <img src="public/User (2).png" alt="img" class="img">
//           <h2 class="welcome">Bienvenido</h2>
//           <div class="tabs">
//             <button class="${!this.isRegistering ? 'active' : ''}" @click="${this.showLogin}">Iniciar sesión</button>
//             <button class="${this.isRegistering ? 'active' : ''}" @click="${this.showRegister}">Registrarse</button>
//           </div>
//           ${this.isRegistering ? this.renderRegisterForm() : this.renderLoginForm()}
//         </div>
//       </div>
//     `;
//   }

//   renderLoginForm() {
//     return html`
//       <form class="login-form">
//         <div class="input-group">
//           <input type="email" name="email" placeholder="Correo electrónico" required>
//         </div>
//         <div class="input-group">
//           <input type="password" name="password" placeholder="Contraseña" required>
//         </div>
//         <div class="options">
//           <label>
//             <input type="checkbox"> Recordarme
//           </label>
//           <a href="#">¿Olvidaste tu contraseña?</a>
//         </div>
//         <button type="submit" class="guardar login-btn" @click="${this._handleSubmit}">Iniciar sesión</button>
//       </form>
//     `;
//   }

//   // renderRegisterForm() {
//   //   return html`
//   //     <form class="register-form">
//   //       <div class="input-group">
//   //         <input type="text" name="username" placeholder="Nombre de usuario" required>
//   //       </div>
//   //       <div class="input-group">
//   //         <input type="email" name="email" placeholder="Correo electrónico" required>
//   //       </div>
//   //       <div class="input-group">
//   //         <input type="password" name="password" placeholder="Contraseña" required>
//   //       </div>
//   //       <button type="submit" class="guardar register-btn" @click="${this._handleRegister}">Registrarse</button>
//   //     </form>
//   //   `;
//   // }

//   showLogin() {
//     this.isRegistering = false; 
//   }

//   // showRegister() {
//   //   this.isRegistering = true; 
//   // }

//   _handleSubmit(e) {
//     e.preventDefault();
//     const form = this.shadowRoot.querySelector(".login-form");
//     const formData = new FormData(form);
//     const username = formData.get('email');
//     const password = formData.get('password');
//     const loginData = {
//       usuario: username,
//       contraseña: password,
//     };

//     console.log(loginData);
//     const url = `http://localhost:8080/api/login?username=${username}&password=${password}`;
//     fetch(url, {
//       method: 'GET',
//       headers: {
//         'Content-Type': 'application/json',
//       },
//     })
//       .then(response => {
//         if (!response.ok) {
//           throw new Error('Error en la autenticación');
//         }
//         return response.json();
//       })
//       .then(data => {
//         console.log('Inicio de sesión exitoso:', data);
//       })
//       .catch(error => {
//         console.error('Error en el inicio de sesión:', error);
//       });
//   }

// //   _handleRegister(e) {
// //     e.preventDefault();
// //     const form = this.shadowRoot.querySelector(".register-form");
// //     const formData = new FormData(form);
// //     const username = formData.get('username');
// //     const email = formData.get('email');
// //     const password = formData.get('password');
// //     const registerData = {
// //       usuario: username,
// //       correo: email,
// //       contraseña: password,
// //     };

// //     console.log(registerData);
// //     const url = `http://localhost:8080/api/register`; 
// //     fetch(url, {
// //       method: 'POST', 
// //       headers: {
// //         'Content-Type': 'application/json',
// //       },
// //       body: JSON.stringify(registerData), 
// //     })
// //       .then(response => {
// //         if (!response.ok) {
// //           throw new Error('Error en el registro');
// //         }
// //         return response.json();
// //       })
// //       .then(data => {
// //         console.log('Registro exitoso:', data);
// //       })
// //       .catch(error => {
// //         console.error('Error en el registro:', error);
// //       });
// //   }
// }

// customElements.define("inicio-form", InicioForm);

















































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
    btnguardar.addEventListener("click",(e)=>{
      e.preventDefault();
      console.log("holaaaa")
      this._handleSubmit(e)
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
}


customElements.define("inicio-form",InicioForm)
