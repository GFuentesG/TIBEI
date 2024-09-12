# PROGRAMA PARA CLINICA - REGISTRO DE ODONTOLOGOS Y PACIENTES
---
Nuestro Sistema para Clinicas, Registro de Odontologos y Pacientes, tiene como caracteristicas:

- Registro de Odontologo
- Listado de Odontologos
- Modificacion de registro de Odontolo
- Eliminacion de registro de Odontologo
- Busqueda de Odontologo por numero de matricula
- Registro de Paciente
- Listado de Pacientes
- Modificacion de perfil del Paciente
- Eliminacion de perfil de Paciente
- Busqueda de Pacierte por DNI           
- Registro de domicilio del Paciente
- Registro de turnos de atencion


## Se ha utilizado las tecnologias como:

- Uso de librerias
- Bootstrap
- Maven
- Spring Boot
- H2 Data Base
- Log4j
- Lombok


## Se ha utilizado excepciones como:

- ResourceNotFoundException
- BadRequestException

El objetivo de este desarrollo es familiarizarse con las caracteristicas del lenguaje Java
y los diferentes framework, librerias y la interconexion del FrontEnd con el BackEnd


## Operacion del Sistema
---
El Sistema tiene como inicio el archivo index.html que tiene enlace a las diferentes funcionalidades del sistema.


### Pre-condicion:
- Para probar el funcionamiento primero se debe ingresar datos de Odontologo y del Paciente, luego se podra listar, modificar, eliminar segun lo que desee probar el usuario y seguidamente podra agendar y listar los turnos


### Los parametros para el ingreso de datos son:

- Odontologo: 
    - nombre
    - apellido
    - matricula
- Paciente:
    - nombre
    - apellido
    - dni
    - fecha de alta
    - domicilio:
        - calle
        - numero
        - localidad
        - provincia
- turno:
    - Odontologo
    - Paciente
    - fecha
    - hora
 

