# Microservices with RabbitMQ

This project is a simple example of a microservices architecture using Spring Boot and RabbitMQ.

## Technologies Used

*   Java 17
*   Spring Boot 3.5.5
*   RabbitMQ
*   PostgreSQL
*   Maven

## Architecture

The project consists of two microservices:

*   **mspedido:** This microservice is responsible for creating and managing orders. It exposes a REST API for creating new orders. When a new order is created, it sends a message to a RabbitMQ queue.
*   **msprocessamento:** This microservice listens to the RabbitMQ queue for new order messages. When it receives a new message, it processes the order.

## How to Run

1.  **Clone the repository:**
    ```bash
    git clone https://github.com/faleite/microservice-matheus.git
    ```
2.  **Configure the databases:**
    *   Create two PostgreSQL databases named `mspedido` and `msprocessamento`.
    *   Update the `application.properties` files in each microservice with your database credentials.
3.  **Configure RabbitMQ:**
    *   Create a free account on [CloudAMQP](https://www.cloudamqp.com/).
    *   Create a new instance and get the connection URL.
    *   Update the `application.properties` files in each microservice with your RabbitMQ connection URL.
4.  **Run the microservices:**
    *   Run the `mspedido` microservice:
        ```bash
        cd spring.boot.curso.mspedido
        mvn spring-boot:run
        ```
    *   Run the `msprocessamento` microservice:
        ```bash
        cd spring.boot.curso.msprocessamento
        mvn spring-boot:run
        ```

## Endpoints

The `mspedido` microservice exposes the following endpoint:

*   **POST /pedidos:** Creates a new order.

    **Request body:**
    ```json
    {
      "nome": "John Doe",
      "itens": [
        {
          "descricao": "Product 1",
          "quantidade": 1
        },
        {
          "descricao": "Product 2",
          "quantidade": 2
        }
      ]
    }
    ```

