<img src="https://blog.commlabindia.com/hubfs/Imported_Blog_Media/animated-gifs-corporate-training.gif" alt="logotype" width="100%"/>

# 🏫 Training Center Management System

This project is a Training Center Management System built with Java Spring Boot, providing RESTful APIs for managing training centers. It includes CRUD operations, validation, exception handling, and filtering capabilities.

## 📋 Features

- Create, Read, Update, and Delete (CRUD) operations for training centers
- Input validation and custom exception handling
- Filtering training centers based on `centerName`, `centerCode`, and `coursesOffered`
- Detailed API documentation with Swagger UI

## 🛠️ Technologies Used

- Java 11
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Jakarta Bean Validation
- Swagger for API documentation

## 📁 Project Structure

```
.
├── src
│ ├── main
│ │ ├── java
│ │ │ └── com
│ │ │ └── trainingCenter
│ │ │ ├── controller
│ │ │ │ └── TrainingCenterController.java
│ │ │ ├── exception
│ │ │ │ ├── GlobalExceptionHandler.java
│ │ │ │ └── ResourceNotFoundException.java
│ │ │ ├── model
│ │ │ │ └── TrainingCenter.java
│ │ │ ├── repository
│ │ │ │ └── TrainingCenterRepository.java
│ │ │ └── service
│ │ │ └── TrainingCenterService.java
│ │ ├── resources
│ │ │ ├── application.properties
│ │ │ 
│ └── test
│ └── java
│ └── com
│ └── trainingCenter
│ └── TrainingCenterApplicationTests.java
├── .gitignore
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md

```

## 🚀 Getting Started

### Prerequisites

- Java 8 or higher
- Maven
- MySQL

### Installation

1. **Clone the repository:**

    ```bash
    git clone https://github.com/rtanwar572/trainingCenter.git
    cd training-center
    ```

2. **Setup MySQL Database:**

    ```sql
    CREATE DATABASE training_center_db;
    ```

3. **Configure `application.properties`:**

   Update the MySQL configuration in `src/main/resources/application.properties`:

    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/training_center_db
    spring.datasource.username=root
    spring.datasource.password=yourpassword
    spring.jpa.hibernate.ddl-auto=update
    ```

4. **Build the project:**

    ```bash
    mvn clean install
    ```

5. **Run the application:**

    ```bash
    mvn spring-boot:run
    ```

6. **Access Swagger UI:**

   Open your browser and go to [http://localhost:8081/swagger-ui.html](http://localhost:8081/swagger-ui.html) to explore the API documentation.

## 📄 API Endpoints

### Create a Training Center

- **URL:** `/api/training-centers`
- **Method:** `POST`
- **Request Body:**
    ```json
    {
        "centerName": "Java Bootcamp",
        "centerCode": "JB2023",
        "address": {
            "detail": "123 Street",
            "city": "New York",
            "state": "NY",
            "pincode": "10001"
        },
        "studentCapacity": 100,
        "coursesOffered": ["Java", "Spring Boot"],
        "contactEmail": "contact@javabootcamp.com",
        "contactPhone": "1234567890"
    }
    ```

### Get All Training Centers

- **URL:** `/api/training-centers`
- **Method:** `GET`
- **Query Parameters (optional):**
    - `centerName` (e.g., `centerName=Java`)
    - `centerCode` (e.g., `centerCode=JB2023`)
    - `course` (e.g., `course=Java`)

### Get a Training Center by ID

- **URL:** `/api/training-centers/{id}`
- **Method:** `GET`

### Update Training Center Name by ID

- **URL:** `/api/training-centers/{id}`
- **Method:** `PUT`
- **Request Body:**
    ```json
    {
        "centerName": "Updated Center Name"
    }
    ```

### Delete a Training Center by ID

- **URL:** `/api/training-centers/{id}`
- **Method:** `DELETE`

## 🛠️ Required Dependencies

Add the following dependencies in your `pom.xml`:

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-validation</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springdoc</groupId>
        <artifactId>springdoc-openapi-ui</artifactId>
        <version>1.5.10</version>
    </dependency>
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <scope>runtime</scope>
    </dependency>
    <dependency>
        <groupId>jakarta.validation</groupId>
        <artifactId>jakarta.validation-api</artifactId>
    </dependency>
    <!-- Other dependencies as required -->
</dependencies>

```

## 🔄 Running Tests
To run tests, execute:
```
mvn test

```

## 🌟 Contributions
Contributions are welcome! Please create an issue or submit a pull request for any feature requests or bug fixes.

## 📄 License
This project is licensed under the MIT License. See the LICENSE file for details.

