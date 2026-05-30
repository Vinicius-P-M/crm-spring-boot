# CRM Lead Management API

## 📖 Overview
This project is a RESTful API developed for managing sales leads, focusing on traceability, efficient status workflows, and data persistence. The application was built to demonstrate solid software engineering principles and scalable system architecture.

## 💼 Business Applicability
The system addresses the need to centralise the lifecycle of a potential customer (lead). With this backend, companies can:
- Register new leads with automated validations.
- Monitor lead evolution through different lifecycle stages (statuses).
- Track the date of the last interaction, ensuring no lead is left behind in the sales funnel.

## 🏗️ Architectural Decisions
The architecture was designed following the **Layered Architecture** pattern, aiming for low coupling and high cohesion:

- **Separation of Concerns:** Logic was divided so that each component has a single responsibility:
    - **Model:** Represents business entities and persistence rules (JPA).
    - **Repository:** Data abstraction layer using Spring Data JPA to reduce boilerplate code.
    - **Service:** Orchestration layer where business rules and validations reside, ensuring the Controller remains lean.
    - **Controller:** Entry point (API Layer) that exposes HTTP endpoints and manages the interface contract (JSON).
- **Dependency Injection (IoC):** Extensive use of the Spring Framework to manage component lifecycles, facilitating testing and maintenance.
- **Data Formatting:** Utilisation of `@JsonFormat` to ensure date exchange respects the local standard (`dd/MM/yyyy`) without compromising the `LocalDateTime` object integrity at the server level.

## 🚀 Technologies Used
- **Java 17+**
- **Spring Boot 3.x**
- **Spring Data JPA (Hibernate)**
- **Maven** (Dependency Management)
- **H2 Database** (In-memory persistence for testing and agility)

## 🛠️ How to Run
1. Clone this repository.
2. Ensure you have Java JDK 17+ installed.
3. In your terminal, within the root folder, run:
   ```bash
   ./mvnw spring-boot:run
