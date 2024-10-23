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
    width: 125px;
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
            { title: 'Productos', imageUrl: 'public/edit.png', route: '/producto' ,id:1},
            { title: 'Rol', imageUrl: 'public/edit.png', route: '/rol' ,id:2},
            { title: 'Personas', imageUrl: 'public/edit.png', route: '/personas' ,id:3 },
            { title: 'Ciudad', imageUrl: 'public/edit.png', route: '/ciudad' ,id:4},
            { title: 'Compra', imageUrl: 'public/edit.png', route: '/compra' ,id:5},
            { title: 'Detalle Compra', imageUrl: 'public/edit.png', route: '/detalle_compra' ,id:6},
            { title: 'Detalle Orden Servicio', imageUrl: 'public/edit.png', route: '/detalle_orden_servicio' ,id:7},
            { title: 'Detalle Orden Trabajo', imageUrl: 'public/edit.png', route: '/detalle_orden_trabajo' ,id:8},
            { title: 'Direccion', imageUrl: 'public/edit.png', route: '/direccion' ,id:9},
            { title: 'Email Persona', imageUrl: 'public/edit.png', route: '/email_persona' ,id:10},
            { title: 'Empresa', imageUrl: 'public/edit.png', route: '/empresa' ,id:11},
            { title: 'Aprovacion Servicio', imageUrl: 'public/edit.png', route: '/aprovacion_servicio' ,id:12},
            { title: 'Empresa Servicio', imageUrl: 'public/edit.png', route: '/empresa_servicio' ,id:13},
            { title: 'Estado Aprobacion', imageUrl: 'public/edit.png', route: '/estado_aprobacion' ,id:14},
            { title: 'Estado Compra', imageUrl: 'public/edit.png', route: '/estado_compra' ,id:15},
            { title: 'Estado Orden', imageUrl: 'public/edit.png', route: '/estado_orden' ,id:16},
            { title: 'Estado Orden Servicio', imageUrl: 'public/edit.png', route: '/estado_orden_servicio' ,id:17 },
            { title: 'Login', imageUrl: 'public/edit.png', route: '/login' ,id:18},
            { title: 'Orden Servicio', imageUrl: 'public/edit.png', route: '/orden_servicio' ,id:19},
            { title: 'Orden Trabajo', imageUrl: 'public/edit.png', route: '/orden_trabajo' ,id:20},
            { title: 'Pais', imageUrl: 'public/edit.png', route: '/pais' ,id:21},
            { title: 'Persona Insumo', imageUrl: 'public/edit.png', route: '/persona_insumo' ,id:22},
            { title: 'Region', imageUrl: 'public/edit.png', route: '/region' ,id:23},
            { title: 'Servicio', imageUrl: 'public/edit.png', route: '/servicio' ,id:24},
            { title: 'Servicio Insumo', imageUrl: 'public/edit.png', route: '/servicio_insumo' ,id:25},
            { title: 'Sucursal', imageUrl: 'public/edit.png', route: '/sucursal' ,id:26},
            { title: 'Telefono Persona', imageUrl: 'public/edit.png', route: '/telefono_persona' ,id:27},
            { title: 'Telefono Sucursal', imageUrl: 'public/edit.png', route: '/telefono_sucursal' ,id:28},
            { title: 'Tipo Email', imageUrl: 'public/edit.png', route: '/tipo_email' ,id:29},
            { title: 'Tipo Empresa', imageUrl: 'public/edit.png', route: '/tipo_empresa' ,id:30},
            { title: 'Tipo Persona', imageUrl: 'public/edit.png', route: '/tipo_persona' ,id:31},
            { title: 'Tipo Telefono', imageUrl: 'public/edit.png', route: '/tipo_telefono' ,id:32},
            { title: 'Tipo Compra', imageUrl: 'public/edit.png', route: '/tipo_compra' ,id:33}
            
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


