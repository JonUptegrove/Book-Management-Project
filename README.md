
# BookMarket – Book Management System

BookMarket is a web-based book marketplace and inventory management application built with Java, Spring Boot, Thymeleaf, and MySQL. Users can browse and search for books, add items to a shopping cart, and complete a demonstration checkout. Administrators have additional tools for managing the book inventory and member accounts.

## Features

### User Features
- Browse the available book collection.
- Search and filter books.
- View book information, including title, author, description, price, and stock.
- Create a user account and log in.
- Add books to a shopping cart.
- Adjust item quantities and remove items from the cart.
- Review shopping cart totals.
- Complete a demonstration checkout using mock payment information.

### Administrator Features
- Add books to the catalog.
- Manage member accounts.
- Access administrator-only controls.

### Design Patterns

- **Factory Pattern:** The `MemberFactory` class standardizes the creation of member objects.
- **Facade Pattern:** The `LibraryCheckoutFacade` coordinates checkout operations across services such as `BookService` and `MemberService`, centralizing checkout rules and simplifying the checkout process.

## Technologies Used

- Java 17
- Spring Boot
- Spring MVC
- Spring Data JPA / Hibernate
- Spring Security
- Thymeleaf
- MySQL
- Maven
- HTML
- CSS
- JavaScript

## Getting Started

### Prerequisites

Make sure you have the following installed:

- Java 17 or later
- Maven
- MySQL
- An IDE such as IntelliJ IDEA

### 1. Clone the Repository

```bash
git clone <repository-url>
cd <project-folder>
```

Replace the placeholders with your repository URL and project folder name.

### 2. Create a MySQL Database

Create a database for the application:

```sql
CREATE DATABASE book_marketplace;
```

Use the database name configured in your application settings.

### 3. Configure the Database Connection

Open `src/main/resources/application.properties` and update the database connection settings to match your local MySQL installation.

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/book_marketplace
spring.datasource.username=YOUR_MYSQL_USERNAME
spring.datasource.password=YOUR_MYSQL_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

**Important:** Do not commit personal database passwords or credentials to a public GitHub repository.

### 4. Run the Application

From the project directory, execute:

```bash
mvn spring-boot:run
```

Alternatively, open the project in IntelliJ IDEA and run the Spring Boot application from its main application class.

### 5. Open the Application

Once the server has started, open your browser and navigate to:

```text
http://localhost:8089
```

If your local configuration uses a different port, use that port instead.

## Project Notes

- The application uses MySQL to store book and member information.
- New accounts created through the registration page are intended to receive the standard `USER` role.
- Administrator privileges are managed separately.
- The checkout/payment page is for demonstration purposes only. It does not process real payments.
- Database settings may need to be adjusted for each developer's local environment.

## Future Improvements

Potential future enhancements include:

- Improving shopping cart persistence across sessions.
- Adding order history and purchase records.
- Expanding automated tests for authentication, inventory, and checkout workflows.

## Author

Developed as a Software Engineering project.
