[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-2972f46106e565e64193e422d61a12cf1da4916b45550586e14ef0a7c637dd04.svg)](https://classroom.github.com/a/hyJnVW-l)

## Banking Application Setup

This README outlines the steps for setting up a Spring Boot-based banking application for CS-460.

### 1. Project Creation with Spring Initializr

1. **Visit:** [https://start.spring.io/](https://start.spring.io/)
2. **Project:** Select **Maven Project**.
3. **Language:** Choose **Java**.
4. **Spring Boot:** Select the **latest stable version** (e.g., 3.3.4 as of October 2024).
5. **Project Metadata:**
   - **Group:**  `edu.ensign.cs460`
   - **Artifact:** `banking-api`
   - **Name:** Should autofill as `banking-application`.
   - **Description:**  `A Spring Boot-based banking application for CS-460 course.`
   - **Package name:** Should autofill based on Group and Artifact. Adjust if necessary to match your institution's naming conventions.
   - **Packaging:** Choose **Jar**.
   - **Java:** Select **21**.
6. **Dependencies:**
   - **Add the following dependencies by typing into the search box and selecting each:**
     - Spring Data JPA
     - Spring Web
     - Spring Security
     - MySQL Driver
     - H2 Database
     - Spring Boot DevTools
     - Lombok (to reduce boilerplate code)
     - Validation - Bean Validation with Hibernate Validator
7. **Generate and Download:** Click the button at the bottom of the page. This will download a .zip file containing your project setup.

### 2. Importing the Project into Github Codespaces

1. **Copy `banking-api.zip` to your Github Codespace.**
2. **Open the terminal and run:** `bin/extract banking-api.zip`

### 3. Verifying Project Setup

1. **Expand the project structure in VS Code within your Github Codespace** to familiarize yourself with the layout.
2. **Open the `pom.xml` file.** Review the dependencies and ensure they match what was specified in Spring Initializr.
3. **Run the `BankingApiApplication` class** (it should have a main method with `@SpringBootApplication` annotation) using `mvn package spring-boot:run`.
4. **If the application starts without errors, you have successfully set up your project.**

### 4. Committing Changes to Git

1. **Stage all files:** `git add .`
2. **Commit the changes with a message:** `git commit -am "Initial commit"` 

You're now ready to start developing your banking application! 

# File structure for this project
```
project-root/
├── pom.xml                    # Maven configuration file
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── edu/
│   │   │       └── ensign/
│   │   │           └── cs460/
│   │   │               ├── controller/       # Presentation Layer
│   │   │               │   ├── UserController.java
│   │   │               │   └── ProductController.java
│   │   │               ├── service/          # Service Layer
│   │   │               │   ├── UserService.java
│   │   │               │   ├── ProductService.java
│   │   │               │   └── impl/
│   │   │               │       ├── UserServiceImpl.java
│   │   │               │       └── ProductServiceImpl.java
│   │   │               ├── repository/       # Data Access Layer
│   │   │               │   ├── UserRepository.java
│   │   │               │   └── ProductRepository.java
│   │   │               ├── domain/           # Domain Layer (Entities/DTOs)
│   │   │               │   ├── User.java
│   │   │               │   ├── Product.java
│   │   │               │   └── DTO/
│   │   │               │       ├── UserDTO.java
│   │   │               │       └── ProductDTO.java
│   │   │               └── config/           # Configuration
│   │   │                   ├── AppConfig.java
│   │   │                   └── WebConfig.java
│   │   ├── resources/
│   │   │   ├── application.properties        # App-level properties
│   │   │   ├── data.sql                      # Optional: Initial seed data
│   │   │   └── schema.sql                    # Optional: DB schema definition
│   │   └── webapp/                           # For web-tier resources (if applicable)
│   │       ├── WEB-INF/
│   │       │   └── web.xml                   # Optional: Deployment descriptor
│   │       ├── templates/                   # For Thymeleaf/Freemarker templates
│   │       │   └── index.html
│   │       └── static/                       # Static resources
│   │           ├── css/
│   │           ├── js/
│   │           └── images/
│   └── test/
│       ├── java/
│       │   └── edu/
│       │       └── ensign/
│       │           └── cs460/
│       │               ├── controller/
│       │               ├── service/
│       │               ├── repository/
│       │               └── domain/
│       └── resources/
│           ├── application-test.properties  # Test-specific properties
│           └── test-data.sql                # Optional: Seed test DB
└── target/                                   # Compiled files (generated by Maven)
```