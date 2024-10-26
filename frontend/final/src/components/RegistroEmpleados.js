import { refreshToken } from "./refreshToken";

const renderizarTablas = () => {
    return /* html */`
    <div class="contenedor-formularioper">
    
        <h1>Registrar Empleado</h1>
            <form id="registroForm">
                <div class="form-group">
                    <label for="nombre">Nombre:</label>
                    <input type="text" id="nombre" name="nombre"required>
                </div>
        
                <div class="form-group">
                    <label for="apellido">Apellido:</label>
                    <input type="text" id="apellido" name="apellido"  required>
                </div>
        
                <div class="form-group">
                    <label for="sucursal">Sucursal:</label>
                    <input type="number" id="sucursal" name="sucursal"  required>
                
                </div>
        
                <div class="form-group">
                    <label for="tipoPersona">Tipo de Persona:</label>
                    <input type="number" id="tipoPersona" name="tipoPersona"  required>
                    
                </div>
        
                <div class="form-group">
                    <label for="nroDoc">Número de Documento:</label>
                    <input type="number" id="nroDoc" name="nroDoc" required>
                </div>
                <div class="form-group">
                    <label for="usuario">Usuario:</label>
                    <input type="email" id="usuario" name="usuario" required>
                </div>
                <div class="form-group">
                    <label for="password">Password:</label>
                    <input type="text" id="password" name="password" required>
                </div>
                <div class="form-group">
                    <label for="id_rol">Id Rol:</label>
                    <input type="number" id="id_rol" name="id_rol" required>
                </div>
        
                <div class="form-group">
                    <button type="submit" class="btn-registro">Registrar</button>                
                </div>
            </form>
    
    </div>
    `;
}

export const dataRegistro = async (contenedorPrincipal,jwt)  => {
    console.log(contenedorPrincipal)
    contenedorPrincipal.innerHTML = ""
    contenedorPrincipal.insertAdjacentHTML("beforeend", renderizarTablas())

    const shadowRoot = contenedorPrincipal.shadowRoot || contenedorPrincipal;

    const registroForm = shadowRoot.querySelector("#registroForm");;

    registroForm.addEventListener("submit", async (e) => {
        e.preventDefault();
        const nombre = shadowRoot.querySelector("#nombre").value;
        const apellido = shadowRoot.querySelector("#apellido").value;
        const fechaActual = new Date().toISOString();
        const sucursalId = shadowRoot.querySelector("#sucursal").value;
        const tipoPersonaId = shadowRoot.querySelector("#tipoPersona").value;
        const nroDoc = shadowRoot.querySelector("#nroDoc").value;
        const usuario = shadowRoot.querySelector("#usuario").value;
        const password = shadowRoot.querySelector("#password").value;
        const idRol = shadowRoot.querySelector("#id_rol").value;

        const datosEnviar =	{
            "nombre": nombre,
            "apellido": apellido,
            "fechaRegistro":fechaActual,
            "sucursal": {id: sucursalId},
            "tipoPersona": {id:tipoPersonaId},
            "nro_Doc": nroDoc
        }
        const DatosLogin = {
            "username": usuario,
            "password": password,
            "repeatedPassword":password,
            "role": {"id": idRol},
            "idPersonas":{"nro_Doc":nroDoc}
          }
        console.log(datosEnviar)

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
            try {
                const response = await fetch("http://localhost:8080/api/personas", {
                    method:"POST",
                    headers:{
                        'Content-Type':'application/json',
                        'Authorization': `Bearer ${jwt}`
                    },
                    body:JSON.stringify(datosEnviar)
                })
                if(response.ok){
                    const Ordenes = await response.json();
                    console.log(Ordenes)
                    registroForm.reset()
        
                }
                
            } catch (error) {
                console.error('Error:', error);
            }
            try {
                const response = await fetch("http://localhost:8080/api/login/post", {
                    method:"POST",
                    headers:{
                        "Content-Type":"application/json",
                        'Authorization': `Bearer ${jwt}`
                    },
                    body:JSON.stringify(DatosLogin)
                })
                if (response.ok) {
                    const Ordenes = await response.json();
                    console.log(Ordenes)
                    
                    
                }else{
                    alert("verifica los datos contraseña mayor de 8 caracteres")
                }
                
            } catch (error) {
                console.error('Error:',error)
                
            }
            
        } else{
            console.log("Vamos a refrescarnos ATT: jwt")
            refreshToken()
            jwt=localStorage.getItem("jwt")
        }
        
        
    })
  
}