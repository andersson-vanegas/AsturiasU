**COMO EJECUTAR ESTE PROYECTO**


DESCRIPCION DEL PROYECTO:

crud de productos con una arquitectura  de carpetas hexagonal permitiendo
visualizar las diferentes logicas para manejar un servicio mas flexible
uso de herramientas como :
-map struct con fines de conectar los campos entre entidades y modelos
- jpa
- postgrest


PASOS: 

1) CREACION DE LA BASE DE DATOS DE POSTGRES

lo realice con una base de datos postgres para agregarle un poco de dificultad 
a la prueba, por favor crea una base de datos poostgres en PgAdmin con estos datos

NAME_DATABASE: db_paymentPlatform
USERNAME: postgres
PASSWORD: postgrest
URL : jdbc:postgresql://localhost:5432/db_paymentPlatform

2) EJECUTAR MICROSERVICIO DE Payment Platform
ejecuta el servicio de Payment Platform y este se encargara de crear la tabla necesaria 
para funcionar correctamente

PUERTO: 8080
