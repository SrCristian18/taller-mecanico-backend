# Taller-mecanico-backend
### Autores
- [Cristian Arenas Cogollo](https://github.com/SrCristian18) 
- [Greison Castilla Carmona](https://github.com/GreisonCastilla)
- [Gabriel Lara Montiel](https://github.com/gabriel-David-Lara-Montiel)
- [Viviana Prasca Mendez](https://github.com/vivianaPM)

## Pasos para ejecutar el sistema completo con Docker (Backend, Kafka y Base de datos)

#### 1. Clonar el repositorio:
``git clone https://github.com/SrCristian18/taller-mecanico-backend.git``

### 2. Ingresa a la carpeta del backend:
``cd taller-mecanico-backend``

- Primero se levanta la BD y Kafka con el comando
``docker compose up -d db kafka --build``
- Después de que ambos contenedores hayan iniciado, al revisar la consola de cada uno, debemos esperar a que estén listos, pues ambas tecnologías tardan un poco en arrancar antes que el backend, y sin ella este último no puede levantarse.

- Una vez que el servidor esté listo, se levanta el backend con el siguiente comando
``docker compose up -d backend --build``

Nota: En caso de que se presenten problemas con el contenedor, primero se tendrá que levantar la base de datos, luego Kafka y por último el backend. El frontend está comentado para evitar que se levante, ya que no será necesito utilizarlo.

### 3. Interactuar con el backend mediante Swagger:
Para interactuar con el proyecto, se debe utilizar Swagger para revisar los endpoints y utilizar sus funcionaliades.

## Acceso
- **Swagger UI**: http://localhost:8080/swagger-ui.html
