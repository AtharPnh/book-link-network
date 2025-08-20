# Book Link Network

An online application to share books, inspired by the "Book Social Network" exercise from the BoualiAli YouTube channel. A full-stack project built using TypeScript, Java, HTML, and CSS.

## Purpose & Overview

This application enables users to create and explore a network of shared book links—browse titles, add recommendations, comment, and connect over what they're reading. This project is a hands-on implementation of concepts from BoualiAli's tutorial and serves as a foundation for social features in book-related apps.

## Features

* **User Registration**: Users can register for a new account
* **Email Validation**: Accounts are activated using secure email validation codes
* **User Authentication**: Existing users can log in to their accounts securely
* **Book Management**: Users can create, update, share, and archive their books
* **Book Borrowing**: Implements necessary checks to determine if a book is borrowable
* **Book Returning**: Users can return borrowed books
* **Book Return Approval**: Functionality to approve book returns
* **Feedback System**: Users can leave feedback and ratings for books

## Technologies Used

### Frontend
* Angular 17
* TypeScript
* HTML5
* CSS3

### Backend
* Java 21
* Spring Boot
* Spring Security
* JWT Authentication
* PostgreSQL (via Docker)

## Project Structure

```
book-link-network/
├── book-link/                    # Backend Spring Boot application
│   ├── src/main/java/           # Java source code
│   ├── src/main/resources/      # Configuration files
│   └── pom.xml                  # Maven dependencies
├── book-link/book-network-ui/   # Frontend Angular application
│   ├── src/app/                 # Angular components and services
│   ├── src/app/modules/book/    # Book-related components
│   ├── src/app/pages/           # Page components
│   ├── src/app/services/        # API services
│   └── package.json             # Node.js dependencies
├── docker-compose.yml           # Container orchestration
└── README.md                    # This file
```

## Getting Started

### Prerequisites

* Java (JDK 21)
* Node.js (v18+) and npm
* Docker & Docker Compose
* Maven (optional, can use Maven wrapper)

### Backend Setup

1. **Clone the repository:**
   ```bash
   git clone https://github.com/AtharPnh/book-link-network.git
   cd book-link-network
   ```

2. **Start the database using Docker:**
   ```bash
   docker-compose up -d
   ```

3. **Navigate to the backend directory:**
   ```bash
   cd book-link
   ```

4. **Install dependencies and build:**
   ```bash
   mvn clean install
   ```

5. **Run the application:**
   ```bash
   # Replace x.x.x with the current version from pom.xml
   java -jar target/book-network-api-x.x.x.jar
   ```

### Frontend Setup

1. **Navigate to the frontend directory:**
   ```bash
   cd book-link/book-network-ui
   ```

2. **Install dependencies:**
   ```bash
   npm install
   ```

3. **Start the development server:**
   ```bash
   npm start
   ```

## Usage

* **Backend API**: Access the API at http://localhost:8088
* **Frontend Application**: Access the application at http://localhost:4200
* **API Documentation**: Swagger UI available at http://localhost:8088/swagger-ui.html

## API Endpoints

The application provides RESTful APIs for:
* Authentication (register, login, activate account)
* Book management (CRUD operations)
* Book borrowing and returning
* Feedback and ratings
* User management

## Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Submit a pull request
