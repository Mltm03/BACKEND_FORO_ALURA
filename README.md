# API RESTful de Foro de Discusión con Spring Boot

Este proyecto es una **API RESTful** construida con **Spring Boot** para gestionar un foro de discusión. Permite registrar, listar, actualizar y desactivar temas de conversación (topics), asociándolos con usuarios y cursos.

---

## 🚀 Características principales

- **CRUD completo de Topics** con:
  - Validaciones personalizadas para asegurar que el título y mensaje sean únicos.
  - Asociación con entidades `User` y `Course` mediante sus IDs.
- Conversión eficiente entre entidades y DTOs (como `DataNewTopic`, `DataFromTopic`, `ListAllTopic`, etc.).
- Paginación de resultados mediante `Pageable` para consultas eficientes.
- **Soft delete**: los temas no se eliminan físicamente, sino que se marcan como inactivos.
- Manejo centralizado de errores usando `@RestControllerAdvice` para excepciones comunes como:
  - `IllegalArgumentException`
  - `EntityNotFoundException`

---

## 🏗️ Arquitectura y buenas prácticas

- Estructura en capas:
  - **Controller**: manejo de peticiones HTTP.
  - **Service**: lógica de negocio.
  - **Repository**: acceso a datos con Spring Data JPA.
- Inyección de dependencias con `@Autowired`.
- Uso de `@Transactional` en métodos que modifican datos para asegurar consistencia.
- Validaciones con **Jakarta Bean Validation** (`@Valid`).

---

## 📦 Tecnologías utilizadas

- Java 17+
- Spring Boot
- Spring Data JPA y Hibernate
- Jakarta Bean Validation
- PostgreSQL (o cualquier base compatible con JPA)
- Lombok (opcional)
- Maven o Gradle

---

## 📌 Endpoints principales

| Método | Ruta            | Descripción                                |
| ------ | --------------- | ------------------------------------------|
| POST   | `/topics`       | Crear un nuevo topic con validación       |
| GET    | `/topics`       | Listar topics paginados (ej: `?page=0&size=5`) |
| PUT    | `/topics/{id}`  | Actualizar título y mensaje de un topic   |
| DELETE | `/topics/{id}`  | Soft delete: marcar topic como inactivo   |

---

## Cómo ejecutar

1. Configura la conexión a la base de datos en `application.properties` o `application.yml`.
2. Ejecuta la aplicación con tu IDE o con:

   ```bash
   ./mvnw spring-boot:run
   # o si usas Gradle
   ./gradlew bootRun
