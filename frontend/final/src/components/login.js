import { LitElement, html, css } from 'lit';
import { customElement } from 'lit/decorators.js';

@customElement('login-form')
class LoginForm extends LitElement {
    static styles = css`
        :host {
            display: block;
            max-width: 300px;
            margin: auto;
            padding: 16px;
            border: 1px solid #ccc;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }
        h2 {
            text-align: center;
        }
        .error {
            color: red;
            font-size: 0.9em;
            margin-top: 8px;
        }
        button {
            width: 100%;
            padding: 10px;
            background-color: red;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
    `;

    email = '';
    password = '';
    errorMessage = '';

    render() {
        return html`
            <h2>Iniciar Sesión</h2>
            <form @submit="${this.handleSubmit}">
                <label>
                    Correo Electrónico:
                    <input type="email" @input="${this.handleInput}" name="email" required />
                </label>
                <label>
                    Contraseña:
                    <input type="password" @input="${this.handleInput}" name="password" required />
                </label>
                <button type="submit">Iniciar Sesión</button>
                ${this.errorMessage ? html`<div class="error">${this.errorMessage}</div>` : ''}
            </form>
        `;
    }

    handleInput(event) {
        const { name, value } = event.target;
        if (name === 'email') {
            this.email = value;
        } else if (name === 'password') {
            this.password = value;
        }
    }

    handleSubmit(event) {
        event.preventDefault();
        this.errorMessage = '';

        // Validación simple
        if (!this.email || !this.password) {
            this.errorMessage = 'Por favor, completa todos los campos.';
            return;
        }

        // Aquí puedes manejar el inicio de sesión, por ejemplo, enviando una solicitud a tu API.
        console.log('Iniciando sesión con', this.email, this.password);
        // Simula una llamada a la API
        this.simulateLogin();
    }

    simulateLogin() {
        // Simula una llamada a la API para el inicio de sesión
        setTimeout(() => {
            if (this.email === 'usuario@example.com' && this.password === 'contraseña') {
                alert('Inicio de sesión exitoso');
                this.email = '';
                this.password = '';
                this.errorMessage = '';
                this.requestUpdate(); // Actualiza el componente
            } else {
                this.errorMessage = 'Credenciales incorrectas. Inténtalo de nuevo.';
                this.requestUpdate(); // Actualiza el componente
            }
        }, 1000);
    }
}
customElements.define('login-form', LoginForm);

document.querySelector('#app').innerHTML = '<login-form></login-form>';
