# ListaProductos-Microservicio-RESTful

## Descripción

El proyecto **ListaProductos-Microservicio-RESTful** es un microservicio desarrollado con Spring Boot que proporciona una API RESTful para gestionar productos. Permite realizar operaciones CRUD (Crear, Leer, Actualizar y Eliminar) sobre productos en una base de datos. El microservicio está diseñado para ser parte de un sistema más grande, permitiendo la integración con otros microservicios y aplicaciones.

## Características

- **CRUD Completo**: Permite crear, leer, actualizar y eliminar productos.
- **Documentación**: Genera documentación Javadoc para una comprensión más clara del código y su uso.
- **Manejo de Excepciones**: Implementa un manejador global de excepciones para gestionar errores de forma centralizada.
- **Diseño Modular**: Basado en una arquitectura de microservicios, facilita la escalabilidad y mantenimiento.

## Requisitos

- **Java 21**: Se recomienda utilizar Java 21 para ejecutar el proyecto.
- **Maven**: Se requiere Apache Maven para la construcción y gestión del proyecto.

## Instalación

### Clonar el Repositorio

```bash
git clone https://github.com/tuusuario/ListaProductos-Microservicio-RESTful.git
cd ListaProductos-Microservicio-RESTful
```

### Construir el Proyecto

1. Asegúrate de tener Maven instalado en tu sistema.
2. Ejecuta el siguiente comando para construir el proyecto:

```bash
mvn clean install
```

### Ejecutar el Microservicio

Para iniciar el microservicio, usa el siguiente comando:

```bash
mvn spring-boot:run
```

El microservicio se iniciará en `http://localhost:8080`.

## Endpoints

- **GET /products**: Obtiene la lista de todos los productos.
- **GET /products/{id}**: Obtiene un producto específico por ID.
- **POST /products**: Crea un nuevo producto.
- **PUT /products/{id}**: Actualiza un producto existente por ID.
- **DELETE /products/{id}**: Elimina un producto por ID.

## Ejemplos

### Obtener Todos los Productos

```bash
curl -X GET http://localhost:8080/products
```

### Crear un Nuevo Producto

```bash
curl -X POST http://localhost:8080/products -H "Content-Type: application/json" -d '{"name":"Producto1","price":100.0}'
```

### Actualizar un Producto

```bash
curl -X PUT http://localhost:8080/products/1 -H "Content-Type: application/json" -d '{"name":"Producto1 Actualizado","price":120.0}'
```

### Eliminar un Producto

```bash
curl -X DELETE http://localhost:8080/products/1
```

## Contribuciones

Si deseas contribuir a este proyecto, por favor sigue estos pasos:

1. Haz un fork del repositorio.
2. Crea una nueva rama para tus cambios.
3. Realiza tus modificaciones y prueba.
4. Envía un pull request describiendo tus cambios.

## Licencia

Este proyecto está licenciado bajo la [MIT License](LICENSE).