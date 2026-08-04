# Secure Event Hub

Secure Event Hub is a backend engineering project designed to explore modern software architecture, secure application development, and distributed systems.

Rather than focusing on feature delivery, this project emphasizes architectural design, engineering trade-offs, clean code, and infrastructure concepts commonly found in production environments.

## Objectives

* Design a maintainable application using **Hexagonal Architecture (Ports & Adapters)**
* Build a RESTful API with **Spring Boot**
* Implement authentication and authorization using **Spring Security** and **JWT**
* Process asynchronous events with **RabbitMQ**
* Containerize the application using **Docker** and **Docker Compose**
* Explore observability, resilience, and infrastructure best practices
* Document architectural decisions and the reasoning behind technical trade-offs

## Technology Stack

* Java 21
* Spring Boot
* Spring Security
* JWT
* PostgreSQL
* RabbitMQ
* Docker & Docker Compose
* Kubernetes *(planned)*
* JUnit & Mockito

## Project Principles

* Architecture before implementation
* Incremental development
* Separation of concerns
* Clean Architecture and Domain-Driven Design principles
* Documented engineering decisions
* Focus on maintainability and scalability

## Domain Exception Rules

1. Every domain error must inherit from `DomainException`.

2. `DomainException` must extend `RuntimeException`.

3. Exceptions must represent business rule violations, not technical or infrastructure failures.

4. The Infrastructure layer must never throw `DomainException`.

5. The Presentation layer must never create domain exceptions; it must only translate them into appropriate HTTP responses.

## Status

🚧 **Work in Progress**

This repository is being developed as a personal engineering project to deepen knowledge of backend architecture, secure application development, messaging, and modern infrastructure while practicing real-world software engineering principles.
