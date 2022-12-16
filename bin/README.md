# **challenge-backend-sophos**

### Solución de una necesidad para exponer mediante servicios API REST capacidades para realizar el control de una agenda de citas de laboratorio.

---

## Data

### Para la generación de información, se tiene la siguiente estructura de base de datos. 

## *Definición estructural*

* Tests: {“id”, “name”, “description”}
* affiliates: {“id”, “name”, “age”, “mail”}
* appoinments: {“id”, “date”, “hour”, “id_test”, “id_affiliate”}

## *Contrato de datos*

* id: number
* name: string
* description: string
* mail: string
* age: number
* date: Date (‘dd/MM/yyyy’)
* hour: Date (‘hh:mm’)

## Services

### El sistema backend permite exponer al front los servicios para diversas operaciones que realiza tales como CRUD (Create, Remove, Update and Delete)

### Para este fin se crean4 controladores, cada uno con sus respectivos métodos, los cuales vamos a describir a continuación

## *Controladores*

1. tests.controller: Controlador para la tabla Tests, tiene el siguiente grupo de metodos. 
    * a. getlist
    * b. getbyid {id}
    * c. post
    * d. put
    * e. delete {id}

2. affiliates.controller: Controlador para la tabla Affiliates, tiene el siguiente grupo de metodos
    * a. getlist
    * b. getbyid {id}
    * c. post
    * d. put
    * e. delete {id}

3. ppoinments.controller: Controlador para la tabla Appoinments, tiene el siguiente grupo de metodos
    * a. getlist
    * b. getbyid {id}
    * c. post
    * d. put
    * e. delete {id}
    * f. getbydate {date}
    * g. getbyaffiliates {id_affiliate}

## *Descripción de los metodos* 

### A continuación, se a procede a describir la funcionalidad de los métodos, teniendo en cuenta que, según la definición de la data, se debe de conservar un contrato de datos para que los desarrollos sean uniformes y exista una comunicación entre el backend y frontend

1. getlist
    * Entregara todo el listado de registros de la tabla, con todos sus campos
    * Si la consulta no encuentra resultados debe entregar un status code 204
    * Si la consulta es exitosa retorna un status code 200

2. getbyid {id}:
    * Entregará un solo registro que coincida con el id que llega por parámetro, con todos sus campos
    * Si la consulta no encuentra resultados debe entregar un status code 404
    * Si la consulta es exitosa retorna un status code 200

3. post:
    * Permitirá almacenar un nuevo registro en la tabla, recibe en el body la estructura de la tabla, sin el campo id
    * Ten en cuenta que el id para la tabla debe de ser generado o autoasignado.
    * Si la operación de inserción es exitosa, debe retornar un status code 201
    * Si no se pudo realizar la inserción debe retornar 404

4. put:
    * Permite actualizar un campo de la tabla, teniendo presente que el campo id no es un campo modificable, recibe un json con todos los campos de la tabla
    * Si la operación de actualización es exitosa, debe retornar un status code 201
    * En caso de no poder realizar la actualización debe retornar 404

5. delete {id}
    * Permite eliminar un registro de la tabla, el cual debe coincidir con el id recibido por parámetro
    * Si la consulta es exitosa retorna un status code 200
    * En caso de no poder realizar la actualización debe retornar 204

6. getbydate {date} y getbyaffiliates {id_affiliate}
    * getbydate {date}: Trae todas las appoinment de una fecha, agrupadas por affiliate
    * getbyaffiliates {id_affiliate}: Trae todos los appoinment de un affiliate
    * Estos métodos van a permitir retornar una consulta basada en el parámetro que reciben, la cual generara un json

## *Criterio de aceptación*

1. Se generan los endpoint con el siguiente patrón
/api/controller/ y los respectivos métodos Get, Post, Put, Delete.
2. Todos los controladores cuentan con pruebas unitarias.
3. Todos los controladores son probados en postman 


## Tecnologias utilizadas

1. Spring Boot
2. MySQL
3. Postman
4. Intellij

- - - 

## **Edison Estival Restrepo Ospina** 🐯💻👌⚡

### Email : [edisonestival@gmail.com]()

### LinkedIn: [https://www.linkedin.com/in/edisonestivalrestrepoospina/](https://www.linkedin.com/in/edisonestivalrestrepoospina/ "Linkedin")


