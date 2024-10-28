export const logout = async () => {
    const jwt = localStorage.getItem("jwt")
    try {
        const response = await fetch('http://localhost:8080/auth/logout', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'Authorization': `Bearer ${jwt}`
            }
        });

        if (!response.ok) {
            throw new Error('Error al refrescar el token');
        }

        const data = await response.json();
        localStorage.clear();
        alert("¡Gracias por usar la aplicación! Hasta luego.")
        window.open("http://localhost:5173")
        
    } catch (error) {
        console.error('Error:', error);
    }
};
