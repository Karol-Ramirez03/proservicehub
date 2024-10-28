import { refreshToken } from "./refreshToken";

export function initInsumoPanel(jwt) {
    const app = document.querySelector('#app');

    let isPanelOpen = false;

    function createButton() {
        const button = document.createElement('button');
        button.textContent = '+ Registrar producto';
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
        title.textContent = 'Agregar Nuevo Insumo';
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
            { label: 'Código Interno', id: 'codigoInterno', type: 'text' },
            { label: 'Nombre', id: 'nombre', type: 'text' },
            { label: 'Precio', id: 'productPrice', type: 'number' },
            { label: 'Stock', id: 'stock', type: 'number' },
            { label: 'Stock Mínimo', id: 'stockMinimo', type: 'number' },
            { label: 'Stock Máximo', id: 'stockMaximo', type: 'number' }
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
        submitButton.textContent = 'Registrar Insumo';
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

        const codigoInterno = document.getElementById('codigoInterno').value;
        const nombre = document.getElementById('nombre').value;
        const productPrice = document.getElementById('productPrice').value;
        const stock = document.getElementById('stock').value;
        const stockMinimo = document.getElementById('stockMinimo').value;
        const stockMaximo = document.getElementById('stockMaximo').value;

        // Validación básica 
        if (!codigoInterno || !nombre || !productPrice || !stock || !stockMinimo || !stockMaximo) {
            alert("Por favor, completa todos los campos.");
            return;
        }

        const nuevoInsumo = {
            "codigo_interno":codigoInterno,
            "nombre":nombre,
            "precio_unitario": parseFloat(productPrice), 
            "stock": parseInt(stock, 10), 
            "stock_minimo": parseInt(stockMinimo, 10),
            "stock_maximo": parseInt(stockMaximo, 10)
        };

    
        console.log('Insumo registrado:', nuevoInsumo);
        let data = false;
        jwt = localStorage.getItem("jwt")
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
        
            fetch('http://localhost:8080/api/insumo', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                    'Authorization': `Bearer ${jwt}`
                },
                body: JSON.stringify(nuevoInsumo)
            })
            .then(response => response.json())
            .then(data => {
                console.log('Insumo almacenado:', data);
                
            })
            .catch(error => {
                console.error('Error al almacenar el insumo:', error);
            });
        } else{
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