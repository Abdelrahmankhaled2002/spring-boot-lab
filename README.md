## Overview
In this branch, **Spring Data REST** has been integrated into the project to automatically expose RESTful CRUD APIs based on the existing Spring Data JPA repositories.  
This eliminates the need for manually writing service and controller layers for basic CRUD operations.

## Key Changes
- Added **Spring Data REST** dependency in `pom.xml`.
- Removed manual service and controller classes responsible for CRUD operations.
- Leveraged **Spring Data JPA** repositories as the DAO layer for database interaction.
- Spring Boot now automatically handles:
  - Exposing REST endpoints for each entity repository.
  - Mapping HTTP methods to CRUD operations (`GET`, `POST`, `PUT`, `DELETE`).
  - JSON serialization and deserialization for request and response bodies.

## How It Works
1. Define a Spring Data JPA repository interface for your entity.
2. Annotate it with `@Repository` (or leave it unannotated since Spring detects it automatically).
3. Spring Data REST automatically generates endpoints based on repository methods.
4. No manual controller or service code is needed for standard CRUD.

## Example
If you have an entity `Instructor` and a repository:
```java
public interface InstructorRepository extends JpaRepository<Instructor,Integer> {}
