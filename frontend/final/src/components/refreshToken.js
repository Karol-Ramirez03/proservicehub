export const refreshToken = async () => {
    const currentToken = localStorage.getItem('refreshToken'); // O donde estés almacenando tu token

    try {
        const response = await fetch('http://localhost:8080/auth/refresh-token', {
            method: 'POST',
            headers: {
                'Authorization': `Bearer ${currentToken}`,
                'Content-Type': 'application/json'
            }
        });

        if (!response.ok) {
            throw new Error('Error al refrescar el token');
        }

        const data = await response.json();
        // Guarda el nuevo token en el almacenamiento local o en donde lo necesites
        const newData=data.jwt
        localStorage.setItem('jwt', newData);
        
    } catch (error) {
        console.error('Error al refrescar el token:', error);
    }
};
