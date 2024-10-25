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
            { title: 'Rol', imageUrl: 'public/edit.png', route: '/rol' ,id:1},
            { title: 'Personas', imageUrl: 'public/edit.png', route: '/personas' ,id:2 },
            { title: 'Ciudad', imageUrl: 'public/edit.png', route: '/ciudad' ,id:3},
            { title: 'Compra', imageUrl: 'public/edit.png', route: '/compra' ,id:4},
            { title: 'Detalle Compra', imageUrl: 'public/edit.png', route: '/detalle_compra' ,id:5},
            { title: 'Detalle Orden Servicio', imageUrl: 'public/edit.png', route: '/detalle_orden_servicio' ,id:6},
            { title: 'Detalle Orden Trabajo', imageUrl: 'public/edit.png', route: '/detalle_orden_trabajo' ,id:7},
            { title: 'Direccion', imageUrl: 'public/edit.png', route: '/direccion' ,id:8},
            { title: 'Email Persona', imageUrl: 'public/edit.png', route: '/email_persona' ,id:9},
            { title: 'Empresa', imageUrl: 'public/edit.png', route: '/empresa' ,id:10},
            { title: 'Aprovacion Servicio', imageUrl: 'public/edit.png', route: '/aprovacion_servicio' ,id:11},
            { title: 'Empresa Servicio', imageUrl: 'public/edit.png', route: '/empresa_servicio' ,id:12},
            { title: 'Estado Aprobacion', imageUrl: 'public/edit.png', route: '/estado_aprobacion' ,id:13},
            { title: 'Estado Compra', imageUrl: 'public/edit.png', route: '/estado_compra' ,id:14},
            { title: 'Estado Orden', imageUrl: 'public/edit.png', route: '/estado_orden' ,id:15},
            { title: 'Estado Orden Servicio', imageUrl: 'public/edit.png', route: '/estado_orden_servicio' ,id:16 },
            { title: 'Login', imageUrl: 'public/edit.png', route: '/login' ,id:17},
            { title: 'Orden Servicio', imageUrl: 'public/edit.png', route: '/orden_servicio' ,id:18},
            { title: 'Orden Trabajo', imageUrl: 'public/edit.png', route: '/orden_trabajo' ,id:19},
            { title: 'Pais', imageUrl: 'public/edit.png', route: '/pais' ,id:20},
            { title: 'Persona Insumo', imageUrl: 'public/edit.png', route: '/persona_insumo' ,id:21},
            { title: 'Region', imageUrl: 'public/edit.png', route: '/region' ,id:22},
            { title: 'Servicio', imageUrl: 'public/edit.png', route: '/servicio' ,id:23},
            { title: 'Servicio Insumo', imageUrl: 'public/edit.png', route: '/servicio_insumo' ,id:24},
            { title: 'Sucursal', imageUrl: 'public/edit.png', route: '/sucursal' ,id:25},
            { title: 'Telefono Persona', imageUrl: 'public/edit.png', route: '/telefono_persona' ,id:26},
            { title: 'Telefono Sucursal', imageUrl: 'public/edit.png', route: '/telefono_sucursal' ,id:27},
            { title: 'Tipo Email', imageUrl: 'public/edit.png', route: '/tipo_email' ,id:28},
            { title: 'Tipo Empresa', imageUrl: 'public/edit.png', route: '/tipo_empresa' ,id:29},
            { title: 'Tipo Persona', imageUrl: 'public/edit.png', route: '/tipo_persona' ,id:30},
            { title: 'Tipo Telefono', imageUrl: 'public/edit.png', route: '/tipo_telefono' ,id:31},
            { title: 'Tipo Compra', imageUrl: 'public/edit.png', route: '/tipo_compra' ,id:32}
            
        ];
    }

    render() {
        return html`
            <div class="menu"> 
                ${this.menuItems.map(item => html`
                    <div class="menu-item" id="${item.id}">
                        <span id="${item.id}">${item.title}</span>
                        <img id="${item.id}" src="${item.imageUrl}" alt="${item.title}" class="small-image">
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
                console.log("Aqui llegoo")
            })
        });
    }
}

customElements.define('menu-crud', MenuCrud);


