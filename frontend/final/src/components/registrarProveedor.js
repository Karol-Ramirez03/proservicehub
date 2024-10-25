import { refreshToken } from "./refreshToken";

export function initProveedorPanel(jwt) {
    const app = document.querySelector('#app');

    let isPanelOpen = false;

    function createButton() {
        const button = document.createElement('button');
        button.textContent = '+ Registrar proveedor';
        button.className = 'add-button';
        button.addEventListener('click', togglePanel);
        return button;
    }

    function createPanel() {
        const modal = document.createElement('div');
        modal.className = 'modal';

        const panel = document.createElement('div');
        panel.className = 'panel';

        const header = document.createElement('div');
        header.className = 'panel-header';

        const title = document.createElement('h2');
        title.textContent = 'Agregar Nuevo Proveedor';
        title.className = 'panel-title';

        const closeButton = document.createElement('button');
        closeButton.textContent = '×';
        closeButton.className = 'close-button';
        closeButton.addEventListener('click', togglePanel);

        header.appendChild(title);
        header.appendChild(closeButton);

        const form = document.createElement('form');
        form.className = 'panel-body';
        form.addEventListener('submit', handleSubmit);

        const fields = [
            { label: 'Nombre', id: 'nombre', type: 'text' },
            { label: 'Email', id: 'email', type: 'email' },
            { label: 'Contraseña', id: 'password', type: 'text' },
            { label: 'Sucursal Id', id: 'sucursal', type: 'number' },
            { label: 'Nit', id: 'nit', type: 'text' }
        ];

        fields.forEach(field => {
            const formGroup = document.createElement('div');
            formGroup.className = 'form-group';

            const label = document.createElement('label');
            label.textContent = field.label;
            label.setAttribute('for', field.id);

            const input = document.createElement('input');
            input.id = field.id;
            input.placeholder = `Ingrese ${field.label.toLowerCase()}`;
            input.type = field.type;

            formGroup.appendChild(label);
            formGroup.appendChild(input);
            form.appendChild(formGroup);
        });

        const submitButton = document.createElement('button');
        submitButton.textContent = 'Registrar Proveedor';
        submitButton.className = 'submit-button';
        submitButton.type = 'submit';

        form.appendChild(submitButton);

        panel.appendChild(header);
        panel.appendChild(form);
        modal.appendChild(panel);

        return modal;
    }

    function togglePanel() {
        isPanelOpen = !isPanelOpen;
        render();
    }

    async function handleSubmit(e) {
        e.preventDefault();

        const nombre = document.getElementById('nombre').value;
        const email = document.getElementById('email').value;
        const password = document.getElementById('password').value;
        const sucursal = document.getElementById('sucursal').value;
        const nit = document.getElementById('nit').value;
        

        // Validación básica 
        if (!nombre || !email || !password || !sucursal || !nit ) {
            alert("Por favor, completa todos los campos.");
            return;
        }

        const nuevoProveedor = {
            "nombre":nombre,
            "apellido": "", 
            "nro_Doc": parseInt(nit, 10), 
            "sucursal":{
                "id":parseInt(sucursal, 10)
            } ,
            "fechaRegistro": "2024-10-12",
            "tipoPersona":{
                "id":11
            }
        };
    
        console.log('Insumo registrado:', nuevoProveedor);
        let data = false;
        try {
            const response = await fetch(`http://localhost:8080/auth/validate-token`, {
                method:"GET",
                headers:{
                    'Content-Type':'application/json',
                    'Authorization': `Bearer ${jwt}`
                }
            })
            if(response.ok){
                data = await response.json();
                console.log(data)
    
    
            }else{
                alert("Usuario No Existente o no ha realizado Compras")
    
            }
            
        } catch (error) {
            console.error('Error:', error);
        }
        if (data) {
        
            fetch('http://localhost:8080/api/personas', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                    'Authorization': `Bearer ${jwt}`

                },
                body: JSON.stringify(nuevoProveedor)
            })
            .then(response => response.json())
            .then(data => {
                console.log('Insumo almacenado:', data);
                
            })
            .catch(error => {
                console.error('Error al almacenar el insumo:', error);
            });

            const newUser={
                "usuario":email,
                "contraseña":password,
                "rol":{
                    "id":11
                },
                "personas":{
                    "nro_Doc":parseInt(nit, 10)
                }
            }
            console.log(newUser)

            
            fetch('http://localhost:8080/api/login', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                    'Authorization': `Bearer ${jwt}`
                },
                body: JSON.stringify(newUser)
            })
            .then(response => response.json())
            .then(data => {
                console.log('Insumo almacenado:', data);
                
            })
            .catch(error => {
                console.error('Error al almacenar el insumo:', error);
            });

        }else{
            console.log("Vamos a refrescarnos ATT: jwt")
            refreshToken()
            jwt=localStorage.getItem("jwt")
        }

        isPanelOpen = false;
        render();
    }

    function render() {
        app.innerHTML = '';
        app.appendChild(createButton());
        if (isPanelOpen) {
            app.appendChild(createPanel());
        }
    }

    render();
}