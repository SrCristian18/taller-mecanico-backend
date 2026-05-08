# Taller-mecanico-backend

## Ejecución del sistema completo (Con Docker - Recomendado)
Todo el ecosistema (Frontend, Backend y Base de Datos) está orquestado mediante Docker Compose.

**IMPORTANTE:** Para que Docker Compose funcione correctamente, debes tener ambos repositorios clonados dentro de la misma carpeta padre, con los nombres exactos `taller-mecanico-backend` y `taller-mecanico-frontend`.

```bash
# Ejemplo de estructura requerida:
# /proyectos
# ├── taller-mecanico-backend
# └── taller-mecanico-frontend

# 1. Clona ambos repositorios:
git clone https://github.com/SrCristian18/taller-mecanico-backend.git
git clone https://github.com/SrCristian18/taller-mecanico-frontend.git

# 2. Ingresa a la carpeta del backend y ejecuta Docker Compose:
cd taller-mecanico-backend
docker-compose up -d --build
```

## Ejecución Local (Sin Docker)
Para ejecutar el backend de forma local sin Docker, es necesario tener Java instalado y una base de datos MySQL corriendo.

1. Configura tus credenciales de MySQL en `src/main/resources/application.yml`.
2. Ejecuta la aplicación usando el wrapper de Maven:
```bash
./mvnw spring-boot:run
```

## Acceso
- **Frontend**: http://localhost:3000
- **Backend API**: http://localhost:8080
- **Swagger UI**: http://localhost:8080/swagger-ui.html
