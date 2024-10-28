import { refreshToken } from "./refreshToken";
const renderizarDatos = (datos, contenedorPrincipal) => {

    const tarjetasHtml = `
        <div class="tarjeta">
            <img class="imageninfo" src="ventas.png" alt="">
            <h3 class="tituloinfo">Top 3 Insumos Mas Vendidos</h3>
            <p class="textoinfo">
            ${datos.map(dato => `Cantidad: ${dato.cantidad??""} - Insumo: ${dato.insumo?.nombre??""}`)}
            </p>
       </div>
    `
    contenedorPrincipal.innerHTML += tarjetasHtml;
};
const renderizarTop3personasInversion = (datos, contenedorPrincipal) => {

    const tarjetasHtml = `
        <div class="tarjeta">
            <img class="imageninfo" src="ventas.png" alt="">
            <h3 class="tituloinfo">Top 3 Clientes Mas Inversiones</h3>
            ${datos.map(dato => 
                `<p class="textoinfo"> 
                    Nombre: ${dato.nombre} ${dato.apellido}, Telefono: ${dato.telefono??"Sin Telefono"}
                </p>
                <p class="textoinfo"> 
                    total inversion: ${dato.total}
                </p>`
            )}
            
       </div>
    `
    contenedorPrincipal.innerHTML += tarjetasHtml;
};
const renderizarDatosmenosInsumo = (datos, contenedorPrincipal) => {

    const tarjetasHtml = `
        <div class="tarjeta">
            <img class="imageninfo" src="ventas.png" alt="">
            <h3 class="tituloinfo">Top 3 Insumos Menos Vendidos</h3>
            <p class="textoinfo">
            ${datos.map(dato => `Cantidad: ${dato.cantidad} - Insumo: ${dato.insumo.nombre}`)}
            </p>
       </div>
    `
    contenedorPrincipal.innerHTML += tarjetasHtml;
};
const renderizarDatosservice = (datos, contenedorPrincipal) => {

    const tarjetasHtml = datos.map(dato => `
        <div class="tarjeta">
            <img class="imageninfo" src="ventas.png" alt="">
            <h3 class="tituloinfo">Servicio Mas Solicitado Del Mes</h3>
            <p class="textoinfo">Solicitudes: ${dato.cantidad} - Servicio: ${dato.servicio.nombre}</p>
        </div>
    `)
    contenedorPrincipal.innerHTML += tarjetasHtml;
};
const renderizarDatosservicemenos = (datos, contenedorPrincipal) => {

    const tarjetasHtml = datos.map(dato => `
        <div class="tarjeta">
            <img class="imageninfo" src="ventas.png" alt="">
            <h3 class="tituloinfo">Servicio Menos Solicitado Del Mes</h3>
            <p class="textoinfo">Solicitudes: ${dato.cantidad} - Servicio: ${dato.servicio.nombre}</p>
        </div>
    `)
    contenedorPrincipal.innerHTML += tarjetasHtml;
};
const renderizarusuariosCompras = (contenedorPrincipal,shadowRoot,jwt) => {

    const tarjetasHtml = /*html*/ `
        <div class="tarjeta">
            <form id="registroForm newForm" >
                <h3 class="tituloinfo">Informacion </h3>
        
                <div class="form-group">
                    <label for="clienteId">Id Cliente:</label>
                    <input type="number" id="clienteId" name="clienteId"  required>
                </div>
                <div class="form-group">
                    <button type="button" class="btn-cancelar">Ver</button>                
                </div>
            </form>
        </div>

    `
    contenedorPrincipal.innerHTML += tarjetasHtml;

    const form = shadowRoot.querySelector('.tarjeta:last-child .btn-cancelar');
    form.addEventListener('click', async (e)  =>  {
        e.preventDefault(); 
        const clienteId = shadowRoot.querySelector('#clienteId').value;
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
            if (clienteId && clienteId > 0 ) { 
                console.log(clienteId);
                try {
                    const response = await fetch(`http://localhost:8080/api/personas/personas/${clienteId}`, {
                        method:"GET",
                        headers:{
                            'Content-Type':'application/json',
                            'Authorization': `Bearer ${jwt}`
                        }
                    })
                    if(response.ok){
                        const Ordenes = await response.json();
                        console.log(Ordenes)
                        generarCarta(Ordenes, contenedorPrincipal);
    
            
                    }else{
                        alert("Usuario No Existente o no ha realizado Compras")
    
                    }
                    
                } catch (error) {
                    console.error('Error:', error);
                }
                
            } else {
                alert('El ID del cliente no puede estar vacío ni ser negativo');
            }
            
        }else{
            console.log("Vamos a refrescarnos ATT: jwt")
            refreshToken()
            jwt=localStorage.getItem("jwt")
        }


    });

};
const generarCarta = (ordenes,contenedorPrincipal) => {
    
    ordenes.forEach(dato => {
        const divcont = document.createElement("div")
        divcont.className="tarjeta"
        divcont.innerHTML = `
        
            <img class="imageninfo" src="ventas.png" alt="">
            <h3 class="tituloinfo">${dato.nombre} ${dato.apellido}</h3>
            <p class="textoinfo">producto mas comprado:${dato.insumo.nombre}</p>
            <p class="textoinfo">Codigo Interno Producto:${dato.insumo.codigo_interno}</p>
            <p class="textoinfo">cantidad comprado: ${dato.cantidad}</p>
            <p class="textoinfo">Numero Telefono : ${dato.telefono??"Sin Numero"}</p>
       
    `;
    contenedorPrincipal.appendChild(divcont)
    });
};
export const data3top = async (contenedorPrincipal,jwt)  => {
    console.log(contenedorPrincipal)
    console.log(jwt)

    let data = false;
    jwt = localStorage.getItem("jwt")
    const shadowRoot = contenedorPrincipal.shadowRoot || contenedorPrincipal;
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

        try {
            const response = await fetch(`http://localhost:8080/api/detallecompra/top3`, {
                method:"GET",
                headers:{
                    'Content-Type':'application/json',
                    'Authorization':`Bearer ${jwt}`
                }
            })
            if(response.ok){
                const Ordenes = await response.json();
                console.log(Ordenes)
                renderizarDatos(Ordenes,contenedorPrincipal);
    
    
            }
            
        } catch (error) {
            console.error('Error:', error);
        }
    
        try {
            const response = await fetch(`http://localhost:8080/api/detallecompra/top3menos`, {
                method:"GET",
                headers:{
                    'Content-Type':'application/json',
                    'Authorization': `Bearer ${jwt}`
                }
            })
            console.log(jwt)
            if(response.ok){
                const Ordenes = await response.json();
                console.log(Ordenes)
                renderizarDatosmenosInsumo(Ordenes,contenedorPrincipal);
    
            }
            
        } catch (error) {
            console.error('Error:', error);
        }
        try {
            console.log("JWT Token:", jwt)
    
            const response = await fetch(`http://localhost:8080/api/personas/inversion`, {
                method:"GET",
                headers:{
                    'Content-Type':'application/json',
                    'Authorization': `Bearer ${jwt}`
                }
            })
    
        console.log("Response status:", response.status);
            if(response.ok){
                const Ordenes = await response.json();
                console.log(Ordenes)
                renderizarTop3personasInversion(Ordenes,contenedorPrincipal);
    
            } else{
                console.error("Failed to fetch:", response.statusText);
            }
    
        } catch (error) {
            console.error('Error:', error);
    
        }
        try {
            const response = await fetch(`http://localhost:8080/api/detalleordenservicio/mas`, {
                method:"GET",
                headers:{
                    'Content-Type':'application/json',
                    'Authorization': `Bearer ${jwt}`
                }
            })
            if(response.ok){
                const Ordenes = await response.json();
                console.log(Ordenes)
                renderizarDatosservice(Ordenes,contenedorPrincipal);
    
    
            }
            
        } catch (error) {
            console.error('Error:', error);
        }
        try {
            const response = await fetch(`http://localhost:8080/api/detalleordenservicio/menos`, {
                method:"GET",
                headers:{
                    'Content-Type':'application/json',
                    'Authorization': `Bearer ${jwt}`
                }
            })
            
            if(response.ok){
                const Ordenes = await response.json();
                console.log(Ordenes)
                renderizarDatosservicemenos(Ordenes,contenedorPrincipal);
                renderizarusuariosCompras(contenedorPrincipal,shadowRoot,jwt);
    
            }
            
        } catch (error) {
            console.error('Error:', error);
        }
        
        
    } else{
        console.log("Vamos a refrescarnos ATT: jwt")
        refreshToken()
        jwt=localStorage.getItem("jwt")
    }
    

}