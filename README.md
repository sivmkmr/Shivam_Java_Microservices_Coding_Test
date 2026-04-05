# Shivam_Java_Microservices_Coding_Test

## Order Management Service

A simple Spring Boot-based Order Management microservice that provides REST APIs to create, retrieve, update, and list orders.  
This project follows clean architecture principles with controller, service, and exception handling layers.

---

## Features

- Create a new order
- Get order by ID
- Update order status with validation
- List all orders
- In-memory storage using `ConcurrentHashMap`
- Input validation and global exception handling

---

## Tech Stack

- Java 17+
- Spring Boot
- Maven
- REST APIs

---

## Project Structure

```
com.shivam.ordermanagement
 ├── controller
 ├── service
 ├── model
 ├── dto
 ├── exception
```

---

## How to Run

1. Clone the repository  
2. Navigate to project folder  
3. Run the application:

```
mvn spring-boot:run
```

4. Application will start at:
```
http://localhost:8080
```

---

## API Endpoints

### Create Order

```
POST /orders
```

```
curl -X POST http://localhost:8080/orders \
  -H "Content-Type: application/json" \
  -d '{
    "customerName": "Alice",
    "amount": 99.99
  }'
```

---

### Get Order by ID

```
GET /orders/{orderId}
```

```
curl http://localhost:8080/orders/{orderId}
```

---

### Update Order Status

```
PUT /orders/{orderId}/status
```

```
curl -X PUT http://localhost:8080/orders/{orderId}/status \
  -H "Content-Type: application/json" \
  -d '{
    "status": "PROCESSING"
  }'
```

---

### Get All Orders

```
GET /orders
```

```
curl http://localhost:8080/orders
```

---

## Validation Rules

- `customerName` must not be empty
- `amount` must be greater than 0

---

## Order Status Flow

Allowed transitions:
- NEW → PROCESSING
- PROCESSING → COMPLETED

Invalid transitions will return:
```
400 Bad Request
```

---

## Error Handling

- 400 → Invalid request / validation failure  
- 404 → Order not found  
- 400 → Invalid status transition  

---

## Design Decisions

- Used layered architecture (Controller → Service → Model)
- In-memory storage using `ConcurrentHashMap` for simplicity
- DTOs used for request handling
- Global exception handler implemented for clean error responses

---

## Assumptions

- No database is used (as per assignment requirement)
- Application is stateless
- Order ID is generated using UUID

---
