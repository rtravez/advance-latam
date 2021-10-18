#### advance-latam
backend and frontend

# Backend
# Crear la base de datos en PostgreSQL
`CREATE DATABASE amt`
#
Verificar que la base de datos este corriendo por el puerto por defecto `5432`.
El usuario por defecto de la base es postgres 
La contraseña es: admin

# Spring Tools
El proyecto esta generado con Spring Tools 4.12.0 y Java 11
Realizar el  Cleand and Build al proyecto backed y automáticamente se crea el esquema de base de datos con datos de prueba.
# Frontend
El proyecto fue generado con  [Angular CLI](https://github.com/angular/angular-cli) version 11.2.6.
Ejecutar `npm install` para descargar todas las dependencias del proyecto.
#
Los datos de pruebas son los siguientes:
#
Usuario admin
Contraseña: admin
#
Usuario rene
Contrasena: 12345
#
## Development server
Ejecutar en la consola de proyecto `ng serve -o` y navegar `http://localhost:4200/`.

# Ejercicio
Realizar una aplicación web para registro de autos y validación de hoy no circula. Esta aplicación debe: Tener 2 opciones: 
a. Ingreso de información de auto 
b. Consulta si un vehículo registrado puede circular en la fecha ingresada 
El ingreso de información del auto debe capturar: Placa, color, modelo, chasis, cualquier otra información referente al vehículo. 
La información puede almacenarse en una base de datos de tu elección. 
El formulario de consulta debe permitir ingresar la placa y la fecha actual. 
Se debe validar que la fecha ingresada no sea anterior a la fecha actual. 
Se pueden ingresar fechas futuras Debe mostrar el resultado en un popup con la información del auto y un texto que indique si es libre de circular en la fecha ingresada Si el auto no se encuentra registrado, debe mostrar un mensaje indicando este particular y debe preguntar si desea registrar el vehículo. 
Si el usuario dice que si desea registrar, se debe presentar el formulario de registro de datos. 







