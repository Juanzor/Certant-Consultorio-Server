# Prueba tecnica para Certant. Gestion de turnos y pacientes.

## Tecnologias, herramientas y librerias usadas:
* MySql
* Java 21
* Lombok
* Swagger
* ModelMapper
* Postman
* Intellij

###  1. Ejecutar los scripts en Mysql Workbench que dejé en resources 

###  2. Configurar application.properties con datos locales:

```
server.port=[puerto]
spring.datasource.url=jdbc:mysql://localhost:3306/consultoriodb
spring.datasource.username=[nombreUsuarioMysql]
spring.datasource.password=[passwordUsuarioMysql]
spring.jpa.hibernate.ddl-auto=update
springdoc.swagger-ui.path=/swagger-ui.html
```
###  [Frontend en este repositorio](https://github.com/Juanzor/Certant-Consultorio-Client)

###  Para usar Swagger: `localhost:[puerto]/swagger-ui.html`

### Al realizar un update en swagger realizarlo con este formato de ejemplo:

```
{
  "fecha": "2024-10-15",
  "hora":"07:00:00",
  "profesionalId": 1,
  "pacienteId": 1,
  "consultorioId": 1,
  "estado": false
}
```
                              
	
