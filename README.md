# Spring Boot Quiz Application

This is a simple Quiz application built using Spring Boot. The application allows users to perform CRUD operations on quiz questions, create quizzes based on categories, and calculate quiz scores. This project is built for learning and understanding the basic concepts of Spring Boot, Spring MVC, and working with databases using Spring Data JPA.

## Features

- CRUD operations on quiz questions.
- Fetch questions based on category or difficulty level.
- Create quizzes with a specified number of questions and category.
- Calculate quiz scores after taking a quiz.

## Technology Stack

- **Spring Boot**
- **Maven**
- **Spring Web**
- **Spring Data JPA**
- **PostgreSQL**
- **Lombok**

## Prerequisites

- Java 8 or higher
- Maven 3.6+
- PostgreSQL
- IDE (IntelliJ IDEA, Eclipse, etc.)

## Setup

1. **Create Spring Boot Project**:
   - Go to [start.spring.io](https://start.spring.io) and create a Spring Boot project with the following dependencies:
     - Spring Web
     - PostgreSQL Driver
     - Spring Data JPA
     - Lombok

2. **Database Configuration**:
   - Configure the database connection in `src/main/resources/application.properties`:

     ```properties
     spring.datasource.url=jdbc:postgresql://localhost:5432/quizdb
     spring.datasource.username=your_db_username
     spring.datasource.password=your_db_password
     spring.jpa.hibernate.ddl-auto=update
     spring.jpa.show-sql=true
     ```

3. **Database Setup**:
   - Create a PostgreSQL database named `quizdb`.
   - Create a table in the database for storing quiz questions.

4. **Build the Application**:
   - The application follows the MVC pattern and consists of three layers:
     1. **Controller Layer**: Handles incoming HTTP requests.
     2. **Service Layer**: Processes the requests and applies business logic.
     3. **DAO Layer**: Interacts with the database.

5. **Entity Class**:
   - Create an entity class in `src/main/java/com/example/quizapp/model` to represent the database table.

6. **Controller**:
   - Create a `QuestionController` class annotated with `@RestController` to handle CRUD operations.

7. **Service Layer**:
   - Create a service class in the `service` package to process user requests.

8. **DAO Layer**:
   - Use Spring Data JPA to create a repository interface for database interactions.

## Usage

1. **Fetching All Questions**:
   - You can fetch all questions from the database using a GET request.

2. **Fetching Questions by Category**:
   - Fetch questions based on category or difficulty level.

3. **Adding or Deleting Questions**:
   - Use POST requests to add questions and DELETE requests to delete them.

4. **Creating a Quiz**:
   - Create a quiz by specifying the category, number of questions, and title.

5. **Taking a Quiz**:
   - Take the quiz and calculate the score based on the answers provided.

## Note

This is a backend-only application with no UI. You can use tools like Postman to interact with the endpoints.

## Learning Resources

This project was built for learning purposes with guidance from Navin sir. I'm following his content which has been a valuable resource over the years.

## License

This project is open-source and available under the MIT License.
