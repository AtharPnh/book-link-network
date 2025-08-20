# Book Link Network<br>
An online application to share books, inspired by the “Book Social Network” exercise from the BoualiAli YouTube channel. A full-stack project built using TypeScript, Java, HTML, and CSS.<br>
# Purpose & Overview<br>
This application enables users to create and explore a network of shared book links—browse titles, add recommendations, comment, and connect over what they’re reading. This project is a hands-on implementation of concepts from BoualiAli’s tutorial and serves as a foundation for social features in book-related apps.<br>
# Feature<br>
* User Registration: Users can register for a new account.<br>
* Email Validation: Accounts are activated using secure email validation codes.<br>
* User Authentication: Existing users can log in to their accounts securely.<br>
* Book Management: Users can create, update, share, and archive their books.<br>
* Book Borrowing: Implements necessary checks to determine if a book is borrowable.<br>
* Book Returning: Users can return borrowed books.<br>
* Book Return Approval: Functionality to approve book returns.<br>
# Technologies Used<br>
* Frontend: Angular, HTML, CSS<br>
* Backend: Java, Spring Boot<br>
# Project Structure<br>
book-link-network/<br>
├── book-link/               # Core app logic<br>
├── docker-compose.yml       # Container orchestration<br>
├── src/                     # Source code (frontend + backend)<br>
├── README.md                # This file<br>
├── .idea/                   # IDE-specific config<br>
└── *.iml<br>
# Getting Started<br>
Prerequisites<br>
Java (JDK 21)<br>
Node.js + npm (for frontend tasks)<br>
Docker & Docker Compose (if applicable)<br>
To set up the backend of the Book Social Network project, follow these steps:<br>
1. Clone the repository:<br>
>git clone https://github.com/AtharPnh/book-link-network.git<br>
2. Run the docker-compose file<br>
>docker-compose up -d<br>
3. Navigate into the project:<br>
>cd book-link-network<br>
4. Install dependencies (assuming Maven is installed):<br>
>mvn clean install<br>
5. Run the application but first replace the x.x.x with the current version from the pom.xml file<br>
>java -jar target/book-network-api-x.x.x.jar<br>
# Usage<br>
Access the application at http://localhost:8088<br>
