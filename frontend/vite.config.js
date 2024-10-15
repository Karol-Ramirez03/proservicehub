import { defineConfig } from 'vite';

export default defineConfig({

    build: {
        outDir: '../src/main/resources/static', // Ruta de salida para los archivos generados
      },

    server: {
        proxy: {
            '/api': {
                target: 'http://localhost:5500', 
                changeOrigin: true,
                secure: false,
            },
        },
    },
});