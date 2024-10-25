const refreshToken=async ()=> {
    const refreshToken = localStorage.getItem('refreshToken'); // Obtener el refresh token
    const username = localStorage.getItem('username'); // Obtener el nombre de usuario

    if (!refreshToken || !username) {
        console.error('Refresh token o username no disponible');
        return;
    }

    const response = await fetch('/api/auth/refresh-token', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ refreshToken, username }), // Enviar refreshToken y username en el body
    });

    if (response.ok) {
        const newAccessToken = await response.text();
        localStorage.setItem('jwt', newAccessToken); // Almacenar el nuevo access token
        console.log('Access token refrescado:', newAccessToken);
    } else {
        console.error('Error al refrescar el token');
    }
}
