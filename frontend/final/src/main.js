import { LitElement, html, css } from 'lit';
import { customElement } from 'lit/decorators.js';

@customElement('inicio-form')
class InicioForm extends LitElement {
  static styles = css`
    :host {
      background-color: hsl(180, 100%, 50%);
      display: block;
      font-family: Arial, sans-serif;
    }
    .login-container {
      background-color: white;
      border-radius: 8px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
      padding: 40px;
      width: 300px;
      text-align: center;
    }
    h2 {
      color: #333;
      margin-bottom: 20px;
    }
    input {
      width: 100%;
      padding: 10px;
      margin: 10px 0;
      border: 1px solid #ddd;
      border-radius: 4px;
      box-sizing: border-box;
    }
    button {
      width: 100%;
      padding: 10px;
      background-color: #007bff;
      color: white;
      border: none;
      border-radius: 4px;
      cursor: pointer;
      font-size: 16px;
    }
    button:hover {
      background-color: #0056b3;
    }
    .forgot-password {
      margin-top: 15px;
      font-size: 14px;
      color: #007bff;
      text-decoration: none;
    }
  `;

  render() {
    return html`
      <div class="login-container">
        <h2>Login</h2>
        <form @submit=${this._handleSubmit}>
          <input type="text" name="username" placeholder="Username" required>
          <input type="password" name="password" placeholder="Password" required>
          <button type="submit">Login</button>
        </form>
        <a href="#" class="forgot-password">Forgot Password?</a>
      </div>
    `;
  }

  _handleSubmit(e) {
    e.preventDefault();
    const formData = new FormData(e.target);
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

// No necesitas esto, ya que LitElement se encargará de crear el componente cuando se use en HTML.
document.querySelector('#app').innerHTML = '<inicio-form></inicio-form>';
