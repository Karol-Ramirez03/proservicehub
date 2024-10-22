import { LitElement, html, css } from 'lit';
import { listaCruds } from './prueba2';
import { initDynamicPanel } from './prueba';
import { initDynamicTable } from './prueba';

class MenuCrud extends LitElement {
    static styles = css`
    .menu {
    display: grid;
    grid-template-columns: repeat(auto-fit, minmax(140px, 1fr));
    gap: 20px;
    margin-top: 25px;
    justify-items: center;
}
  nav{
    display: flex;
    color: white;
    align-items: center;
    background-color: #2563EB;
    justify-content: space-between;
    padding: 1%;
  
  }
.menu-item {
    text-align:center;
    color: rgb(10, 9, 9);
    padding: 4px;
    border: 1px solid #ccc;
    width: 130px;
    text-align: center;
    background-color: #f4f4f4;
    border-color: solid 3px;
    border-radius: 9px;
    cursor: pointer;
    font-size: 13px;
    display: flex;
    align-items: center;
    justify-content:space-evenly;
}

.menu-item:hover {
    background-color: #ddd;
}

.small-image {
    width: 44px; 
}

    `;

    static properties = {
        menuItems: { type: Array }
    };

    constructor() {
        super();
        this.menuItems = [
            { title: 'Insumos', imageUrl: 'public/edit.png', route: '/insumo',id:0 },
            { title: 'Productos', imageUrl: 'public/edit.png', route: '/producto' },
            { title: 'Rol', imageUrl: 'public/edit.png', route: '/rol' },
            { title: 'Personas', imageUrl: 'public/edit.png', route: '/personas' },
            { title: 'Ciudad', imageUrl: 'public/edit.png', route: '/ciudad' },
            { title: 'Compra', imageUrl: 'public/edit.png', route: '/compra' },
            { title: 'Detalle Compra', imageUrl: 'public/edit.png', route: '/detalle_compra' },
            { title: 'Detalle Orden Servicio', imageUrl: 'public/edit.png', route: '/detalle_orden_servicio' },
            { title: 'Detalle Orden Trabajo', imageUrl: 'public/edit.png', route: '/detalle_orden_trabajo' },
            { title: 'Direccion', imageUrl: 'public/edit.png', route: '/direccion' },
            { title: 'Email Persona', imageUrl: 'public/edit.png', route: '/email_persona' },
            { title: 'Empresa', imageUrl: 'public/edit.png', route: '/empresa' },
            { title: 'Aprovacion Servicio', imageUrl: 'public/edit.png', route: '/aprovacion_servicio' },
            { title: 'Empresa Servicio', imageUrl: 'public/edit.png', route: '/empresa_servicio' },
            { title: 'Estado Aprobacion', imageUrl: 'public/edit.png', route: '/estado_aprobacion' },
            { title: 'Estado Compra', imageUrl: 'public/edit.png', route: '/estado_compra' },
            { title: 'Estado Orden', imageUrl: 'public/edit.png', route: '/estado_orden' },
            { title: 'Estado Orden Servicio', imageUrl: 'public/edit.png', route: '/estado_orden_servicio' },
            { title: 'Login', imageUrl: 'public/edit.png', route: '/login' },
            { title: 'Orden Servicio', imageUrl: 'public/edit.png', route: '/orden_servicio' },
            { title: 'Orden Trabajo', imageUrl: 'public/edit.png', route: '/orden_trabajo' },
            { title: 'Pais', imageUrl: 'public/edit.png', route: '/pais' },
            { title: 'Persona Insumo', imageUrl: 'public/edit.png', route: '/persona_insumo' },
            { title: 'Region', imageUrl: 'public/edit.png', route: '/region' },
            { title: 'Servicio', imageUrl: 'public/edit.png', route: '/servicio' },
            { title: 'Servicio Insumo', imageUrl: 'public/edit.png', route: '/servicio_insumo' },
            { title: 'Sucursal', imageUrl: 'public/edit.png', route: '/sucursal' },
            { title: 'Telefono Persona', imageUrl: 'public/edit.png', route: '/telefono_persona' },
            { title: 'Telefono Sucursal', imageUrl: 'public/edit.png', route: '/telefono_sucursal' },
            { title: 'Tipo Email', imageUrl: 'public/edit.png', route: '/tipo_email' },
            { title: 'Tipo Empresa', imageUrl: 'public/edit.png', route: '/tipo_empresa' },
            { title: 'Tipo Persona', imageUrl: 'public/edit.png', route: '/tipo_persona' },
            { title: 'Tipo Telefono', imageUrl: 'public/edit.png', route: '/tipo_telefono' }
            
        ];
    }

    render() {
        return html`
            <div class="menu"> 
                ${this.menuItems.map(item => html`
                    <div class="menu-item" id="${item.id}">
                        <span>${item.title}</span>
                        <img src="${item.imageUrl}" alt="${item.title}" class="small-image">
                    </div>
                `)}
            </div>

        `;
    }

    updated(){
        const botones=this.shadowRoot.querySelectorAll(".menu-item")
        botones.forEach(boton => {
            boton.addEventListener("click",(e)=>{
                e.preventDefault()
                const id=e.target.id
                console.log(id)
                console.log(listaCruds[id])
                initDynamicPanel(listaCruds[id][0])
                initDynamicTable(listaCruds[id][1])
            })
        });
    }
}

customElements.define('menu-crud', MenuCrud);
