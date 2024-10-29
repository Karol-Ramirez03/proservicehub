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
             <img src="public/user.png" alt="img" class="img">
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
                </div>
                <button type="submit" class="guardar login-btn">Iniciar sesión</button>
            </form>
        </div>
    </div>
    `
  }

  updated() {
    const btnguardar = this.shadowRoot.querySelector(".guardar");
    const btnLogin = this.shadowRoot.querySelector(".active");
    const btnregister = this.shadowRoot.querySelector(".reg");
    const divLogin=this.shadowRoot.querySelector(".login-form")
    const shadowRoot=divLogin.shadowRoot || divLogin;
    
  
    // Asegúrate de que los botones existen
    if (!btnguardar) {
      console.error("El botón 'guardar' no fue encontrado.");
      return;
    }
    if (!btnLogin) {
      console.error("El botón 'login' no fue encontrado.");
      return;
    }
    if (!btnregister) {
      console.error("El botón 'registrar' no fue encontrado.");
      return;
    }
  
    // Evento para el botón de login que recarga la página
    btnLogin.addEventListener("click", (e) => {
      location.reload(); // Asegúrate de que esto es necesario, puede interferir con el comportamiento deseado.
    });
  
    // Evento para el botón de guardar que maneja el submit
    btnguardar.addEventListener("click", (e) => {
      e.preventDefault();
      console.log("holaaaa");
      this._handleSubmit(e);
    });
  
    // Evento para el botón de registro
    btnregister.addEventListener("click", (e) => {
      e.preventDefault(); // Aquí faltaba ejecutar la función
      console.log("hola");
      this._handleRegister(e,shadowRoot);
    });
  }
  
  async _handleSubmit(e) {
    e.preventDefault();
  
    const form = this.shadowRoot.querySelector(".login-form");
    
    if (!form) {
      console.error("Formulario de login no encontrado.");
      return;
    }
  
    const formData = new FormData(form);
    const username = formData.get('email');
    const password = formData.get('password');
    
    ///////////////////////////////////////////////////////login
    
    localStorage.clear();
    console.log('LocalStorage ha sido limpiado.');
    
    const loginData = {
      "username":username,
      "password":password
    }
    console.log(username)    


    

    try {
        const response = await fetch(`http://localhost:8080/auth/authenticate`, {
            method:"POST",
            headers:{
                'Content-Type':'application/json'      
              },
            body: JSON.stringify(loginData)
        })
        if(response.ok){
            const jwt = await response.json();
            console.log(jwt.jwt)
            localStorage.setItem('jwt', jwt.jwt)//-----------------
            localStorage.setItem('refreshToken', jwt.refreshToken)
            try {
              // Enviar los datos de autenticación al backend
              const response2 = await fetch(`http://localhost:8080/api/login/usuario/${username}`, {
                method: 'GET', // Cambiado a POST
                headers: {
                  'Content-Type': 'application/json',
                  'Authorization': `Bearer ${jwt.jwt}`  
                } // Enviar los datos en el cuerpo de la solicitud
              });
          
              // if (!response.ok) {
              //   throw new Error('Error en la autenticación');
              // }
          
              const data = await response2.json(); // Obtener la respuesta del servidor
              console.log(data.contraseña +" ----- contraseña")
              console.log(data)
              const idRol=data.rol.id;
              localStorage.setItem("usuario",JSON.stringify(data))
              switch(idRol){
                case 1:
                  window.location.assign("http://localhost:5173/menucruds.html")
                  break;
                case 2:
                  window.location.assign("http://localhost:5173/cliente.html")
                  break;
                case 3:
                  window.location.assign("http://localhost:5173/recursosHumano.html")
                  break;
                case 4:
                  window.location.assign("http://localhost:5173/jefeBodega.html")
                  break;
                case 5:
                  window.location.assign("http://localhost:5173/jefeBodega.html")
                  break;
                case 6:
                  window.location.assign("http://localhost:5173/marketing.html")
                  break;
                case 7:
                  window.location.assign("http://localhost:5173/menucruds.html")
                  break;
                case 8:
                  window.location.assign("http://localhost:5173/menucruds.html")
                  break;
                case 9:
                  window.location.assign("http://localhost:5173/profesionalesServicios.html")
                  break;
                case 10:
                  window.location.assign("http://localhost:5173/auxiliarBodega.html")
                  break;
                case 11:
                  window.location.assign("http://localhost:5173/proveedores.html")
                  break;
                case 12:
                  window.location.assign("http://localhost:5173/jefeCompra.html")
                  break;
              }
                
              
              
          
              // Reseteo del formulario
              form.reset();
            } catch (error) {
              console.error('Error en el inicio de sesión:', error);
            }


        }else{
            alert("Problemas Para Autenticarse Volver a intentarlo mas tarde")
            const errorMessage = await response.text();
            console.error("Error en la autenticación: ", response.status, errorMessage);

        }
        
    } catch (error) {
        console.error('Error:', error);
    }




  }
  
    

  async _handleRegister(e,shadowRoot) {
    e.preventDefault()
    console.log("reg")
    const divform= this.shadowRoot.querySelector(".login-form")
    divform.innerHTML=`
            
              <div class ="input-group">
                <input type="text" name="username" placeholder="Nombre" required>
              </div>
              <div class ="input-group">
                <input type="text" name="lastname" placeholder="Apellido" required>
              </div>
              <div class="input-group">
                <input type="email" name="email" placeholder="Correo electrónico" required>
              </div>
              <div class="input-group">
                <input type="password" name="password" placeholder="Contraseña" required>
              </div>  
              <div class="input-group">
                <input type="text" id="documentNumber" name="documentNumber" placeholder="Número de documento" required>
              </div>
              <div class="input-group op">
                <select id="idSucursal" name="idSucursal">
                  
                </select>
                <select id="idtipo" name="tipopersona">
                  <option value="" disabled selected>Seleccionar tipo</option>
                  <option value="2">Cliente</option>
                  <option value="11">Proveedor</option>
                  <option value="9">Profesional</option>
                </select>  

              </div>

              <button class="guardar register-btn">Registrarse</button>
            </div> 
               `;

            const sucursalOption=shadowRoot.querySelector("#idSucursal")
            sucursalOption.innerHTML=`
                  <option value="" disabled selected>Seleccionar sucursal</option>
                  
                  `
            
            const btn=shadowRoot.querySelector(".register-btn")
            try {
              // Enviar los datos de autenticación al backend
              const response = await fetch(`http://localhost:8080/api/sucursal`, {
                method: 'GET',
                headers: {
                  'Content-Type': 'application/json',
                }
              });
              const data = await response.json(); 
              console.log(data)
              data.forEach(sucursal => {
                sucursalOption.innerHTML+=`
                  <option value="${sucursal.id}">${sucursal.nombre}</option>
                  `
              });
            } catch (error) {
              console.error('Error en el inicio de sesión:', error);
            }
            btn.addEventListener("click",(e)=>{
              
              console.log(divform)
              this._handleSubmit2(e,divform); 
            });
              
            }          
          
  async _handleSubmit2(e,form) {  
    
    e.preventDefault();
    console.log(form)
    const formData = new FormData(form);
    const username = formData.get('username');
    const lastname = formData.get('lastname');
    const email = formData.get('email');
    const password = formData.get('password');
    const number = formData.get('documentNumber');
    const sucursal = Number(formData.get('idSucursal'));
    const tpersona = Number(formData.get('tipopersona'));
    // const trol = Number(formData.get('idrol'));
    let num=Number(number)
    const registerData = {
      "nombre": username,
      "apellido": lastname,
      "sucursal": {
        "id": sucursal
      },
      "tipoPersona": {
        "id":tpersona
      },
      "nro_Doc": num
    }
    
    console.log(registerData)
    ///////////////////////////////////register
    try {
      // Enviar los datos de autenticación al backend
      const response = await fetch(`http://localhost:8080/api/personas`, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body:JSON.stringify(registerData)
      });
      const data = await response.json(); 
      form.reset()
      console.log("weno")
    } catch (error) {
      console.error('Error en el inicio de sesión:', error);
    }
    const newUser={
      "nombre":email,
      "username":email,
      "password":password,
      "repeatedPassword":password,
      "idPersonas":{
        "nro_Doc":number
      },
      "role":{
        "id":tpersona
      }
    }
    console.log(newUser)
    try {
      // Enviar los datos de autenticación al backend
      const response = await fetch(`http://localhost:8080/api/login/post`, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body:JSON.stringify(newUser)
      });
      const data = await response.json(); 
      form.reset()
      console.log("weno")
    } catch (error) {
      console.error('Error en el inicio de sesión:', error);
    }
  }
  

}


customElements.define("inicio-form",InicioForm)
