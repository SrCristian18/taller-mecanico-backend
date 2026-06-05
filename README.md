# Taller-mecanico-backend

## Ejecución del sistema completo (Con Docker - Recomendado)
Todo el ecosistema (Backend, Kafka y Base de Datos) está orquestado mediante Docker Compose.

```bash
# Ejemplo de estructura requerida:
# /proyectos
# ├── taller-mecanico-backend

# 1. Clonar el repositorio:
git clone https://github.com/SrCristian18/taller-mecanico-backend.git

# 2. Ingresa a la carpeta del backend y ejecuta Docker Compose en el siguiente orden:
cd taller-mecanico-backend

# Primero se levanta la BD y Kafka
docker compose up -d db kafka --build

# Cuando estén sanos, especialemte la base de datos, se levanta el backend
docker-compose up -d backend --build
```
Nota: En caso de que se presenten problemas con el contenedor, primero se tendrá que levantar la base de datos, luego Kafka y por último el backend. El frontend está comentado para evitar que se levante, ya que no será necesito utilizarlo.

## Acceso
- **Backend API**: http://localhost:8080
- **Swagger UI**: http://localhost:8080/swagger-ui.html