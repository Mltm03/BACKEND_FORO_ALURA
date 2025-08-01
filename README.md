Este proyecto es una API RESTful construida con Spring Boot que gestiona un foro de discusión. Permite registrar, listar, actualizar y desactivar (soft delete) temas de conversación (topics), así como asociarlos con usuarios y cursos.

🚀 Características principales:
CRUD de Topics con:

Validaciones personalizadas (título y mensaje únicos).

Asociación con entidades User y Course a través de sus IDs.

Conversión entre entidades y DTOs (DataNewTopic, DataFromTopic, ListAllTopic, etc.).

Paginación de resultados usando Pageable.

Soft delete: los temas no se eliminan físicamente, solo se marcan como inactivos.

Manejo de errores centralizado con @RestControllerAdvice para excepciones comunes como:

IllegalArgumentException

EntityNotFoundException

Buenas prácticas de arquitectura:

Separación por capas (Controller, Service, Repository).

Inyección de dependencias con @Autowired.

Transacciones con @Transactional en los métodos de modificación de datos.

📦 Tecnologías utilizadas:
Java 17+

Spring Boot

Spring Data JPA

Hibernate

Validación con Jakarta Bean Validation (@Valid)

PostgreSQL (o cualquier base de datos compatible con JPA)

Lombok (opcional)

Maven o Gradle

📌 Ejemplo de endpoints:
POST /topics – Crear un nuevo topic con validación

GET /topics?page=0&size=5 – Listar topics paginados

PUT /topics/{id} – Actualizar título y mensaje

DELETE /topics/{id} – Soft delete (marcar como inactivo)
