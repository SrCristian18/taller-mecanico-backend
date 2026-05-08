# Backend Best Practices and Architecture Guidelines

## Project Context
A mechanical workshop receives several vehicles daily for different types of services (repair, maintenance, diagnostics, etc.). Currently, the owner lacks a digital tool to register and track the status of each vehicle during the service process. Information about vehicles and services is handled manually or informally, leading to potential data loss, difficulty in tracking progress, and uncertainty about service duration.

This backend aims to provide the digital foundation to solve these issues.

## Requirements

### Functional Requirements
1. **Register Vehicle**: Store information about vehicles entering the workshop.
2. **Register Owner**: Store data of the vehicle owner.
3. **Register Service Type**: Record the requested service (repair, maintenance, etc.).
4. **List Vehicles**: Display all registered vehicles.
5. **Update Status**: Track and update the service progress.
6. **Finish Service**: Mark a service as completed.
7. **Time Calculation**: Calculate the total time taken for each service.
8. **Service History**: Consult past services performed.

### Non-Functional Requirements
1. **Efficiency**: Registration must take less than 1 minute.
2. **Security**: Information must be stored securely.
3. **Usability**: The interface (and API consumption) should be simple and intuitive.
4. **Performance**: Fast queries for registered vehicles.
5. **Responsive Design**: The system's interface must adapt and work seamlessly across different devices (mobile, tablet, desktop).

---

## 1. Hexagonal Architecture (Ports and Adapters)

The project follows the Hexagonal Architecture to decouple the core business logic from external concerns (databases, APIs, frameworks).

### Domain Layer (Core)
- **Location**: `src/main/java/com/tallerMecanico/domain/`
- **Rules**:
  - Must be pure Java (no Spring annotations, no JPA).
  - Contains **Models** (`com.tallerMecanico.domain.model`) which are the business objects.
  - Defines **Ports** (`com.tallerMecanico.domain.ports`):
    - **In**: Interfaces for Use Cases (e.g., `VehicleUseCase`).
    - **Out**: Interfaces for persistence or external services (e.g., `VehicleRepositoryPort`).

### Application Layer
- **Location**: `src/main/java/com/tallerMecanico/application/`
- **Rules**:
  - Contains **Services** that implement the **In Ports**.
  - Orchestrates domain models to fulfill a use case.
  - No business logic here (it belongs in the Domain Models or Domain Services).

### Infrastructure Layer (Adapters)
- **Location**: `src/main/java/com/tallerMecanico/infrastructure/`
- **Rules**:
  - Contains **Adapters** that implement **Out Ports** (e.g., `JpaVehicleRepositoryAdapter`).
  - Contains **Controllers** (Input Adapters) for REST API.
  - This is where Spring annotations live (`@RestController`, `@Service`, `@Repository`, `@Entity`).
  - Handles DTOs and Mappers.

---

## 2. No Hard Deletes Policy

**CRITICAL RULE**: Never implement a physical `DELETE` operation in the database.

- **Soft Delete**: All entities that require a "deletion" mechanism must use a status field.
- **Implementation**:
    - Use a boolean `active` field (default `true`).
    - Alternatively, use a `status` Enum (e.g., `ACTIVE`, `INACTIVE`, `DELETED`).
    - Filter results by default to show only active records.

---

## 3. General Programming Practices

### SOLID Principles
- **Single Responsibility**: Each class should have one reason to change.
- **Open/Closed**: Software entities should be open for extension but closed for modification.
- **Liskov Substitution**: Subtypes must be substitutable for their base types.
- **Interface Segregation**: Don't force clients to depend on methods they don't use.
- **Dependency Inversion**: Depend on abstractions (Ports), not concretions.

### Clean Code & Standards
- **Meaningful Names**: Use descriptive names for variables, methods, and classes.
- **Small Methods**: Keep methods focused and short.
- **Error Handling**: Use custom exceptions and a global exception handler (`@ControllerAdvice`) in the infrastructure layer.
- **Mappers**: Use MapStruct or manual mappers to separate Domain models from Persistence/Web DTOs.
- **Immutable Objects**: Favor record types (if using Java 14+) or final fields for DTOs and Domain objects.

---

## 4. Testing Strategy
- **Unit Tests**: Focus on the Domain and Application layers. No Spring context should be loaded.
- **Integration Tests**: Focus on the Infrastructure layer (Persistence and API). Use `@SpringBootTest` or `@DataJpaTest`.
- **Naming**: Use `should_ExpectedBehavior_When_Condition` pattern.

---

## 5. Technology Stack
- **Language**: Java
- **Framework**: Spring Boot
- **Persistence**: Spring Data JPA
- **Build Tool**: Maven
