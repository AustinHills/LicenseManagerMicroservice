# VST License Manager Microservice

A Spring Boot backend microservice designed to validate license keys. This project demonstrates strict separation of concerns using **Hexagonal Architecture (Ports and Adapters)** and a **Contract-First API design**.

## Architecture & Tech Stack
*   **Java 17 & Spring Boot 3.x**
*   **Hexagonal Architecture:** Business logic is entirely isolated in the Domain Core. It communicates with the outside world strictly through interfaces (Ports).
*   **Contract-First Design (OpenAPI 3.0):** The REST API is defined in `api.yaml`. The Spring web controllers and data transfer objects (DTOs) are automatically generated at compile-time using the `openapi-generator-maven-plugin`.
*   **Spring Data JPA & H2 Database:** An in-memory database used for rapid testing and demonstration, accessed via an Output Adapter to keep the core framework-agnostic.

## Project Structure
*   `adapters.input`: Contains the REST controller catching web traffic and passing it to the Input Port.
*   `core`: The Domain Core containing the business logic (`LicenseService`). This layer has zero dependencies on web frameworks or databases.
*   `ports.input`: Auto-generated interfaces dictating how the outside world can interact with the core.
*   `ports.output`: Interfaces defined by the core dictating what data it needs from the infrastructure.
*   `adapters.output`: The database adapter and Spring Data JPA repository that fulfill the core's data requests.

## How to Run
1. Clone the repository.
2. Run `./mvnw clean compile` to trigger the OpenAPI code generation.
3. Run `./mvnw spring-boot:run` to start the embedded Tomcat server on `localhost:8080`.
4. The H2 database will automatically seed with a test license key for the `Pitchblade` plugin.