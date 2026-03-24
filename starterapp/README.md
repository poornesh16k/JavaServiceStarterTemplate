# Java Service Starter Template

A lightweight Spring Boot service template designed to be a clean starting point for production-facing backend services.

## How to run

### Prerequisites
- Java 17+
- Maven 3.9+ or use the included Maven wrapper

### Start locally
1. From the project root, run `./mvnw spring-boot:run`
2. The service starts on `http://localhost:8080`

### Verify endpoints
- `GET /health`
- `POST /example`

Example request:

```json
{
  "userId": "123",
  "value": 42
}
```

Example response:

```json
{
  "status": "SUCCESS",
  "requestId": "uuid-string"
}
```

### Run tests
Run `./mvnw test`

## Design Decisions

- **Package-by-feature structure**: Keeps related controller, API, and domain code together for easier maintenance as the service grows.
- **Thin controllers, explicit service layer**: HTTP handling is isolated from application logic so new business workflows can be added without bloating controllers.
- **Request correlation**: Every request gets an `X-Request-Id` value that is echoed back in the response and added to logs for easier debugging in distributed systems.
- **Validation and centralized error handling**: Invalid requests fail consistently with a structured error response, which is important when multiple teams integrate with the service.
- **Operational defaults**: Graceful shutdown, actuator health support, and request-aware logging are included because starter services should be production-conscious from day one.

## Assumptions

- The `POST /example` endpoint represents placeholder business logic, so it currently validates input, logs the request, and returns a success payload.
- Persistence, authentication, and external integrations were intentionally left out to keep the starter template focused and minimal.
- A single module Spring Boot application is sufficient for the current scope while still demonstrating separation of concerns.

## Future Roadmap

- Add structured JSON logging and metrics export for observability platforms.
- Introduce API versioning and OpenAPI documentation.
- Add resilience patterns for downstream calls, such as retries and timeouts.
- Add authentication/authorization, if the template becomes the default for internal or public APIs.
- Add contract tests, architecture tests, and CI/CD quality gates.

## Endpoints

### `GET /health`
Returns a basic health payload for load balancers and runtime checks.

### `POST /example`
Accepts a payload with `userId` and `value`, validates it, and returns a success response with a request correlation id.
