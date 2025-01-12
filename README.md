# springboot-waste-management
This is a Spring Boot application that provides RESTful APIs to manage waste categories, disposal guidelines, and recycling tips. The application uses an in-memory H2 database for testing and development purposes.
________________________________________
Project Description
The Waste Management API allows clients to manage and retrieve data about waste categories, disposal guidelines, and recycling tips. It ensures:
•	Data integrity through input validation.
•	RESTful API principles.
•	Structured JSON responses for all endpoints.
This project demonstrates best practices for designing a Spring Boot application, including proper package structure, use of JPA for database interaction, and validation using annotations.
________________________________________
Features
•	Create, read, update, and delete waste categories.
•	Manage disposal guidelines associated with waste categories.
•	Manage recycling tips.
•	Input validation to ensure data integrity.
•	Structured error handling.
________________________________________
Technologies Used
•	Java: Programming language.
•	Spring Boot: Framework for building the REST API.
•	Spring Data JPA: For database interaction.
•	H2 Database: In-memory database for testing and development.
•	Jakarta Validation: For input validation.
•	Postman: For testing API endpoints.
________________________________________
Setup and Running
Prerequisites
•	Java 17 or later
•	IntelliJ IDEA or any IDE of choice
•	Maven
Steps to Run
1.	Clone the repository.
2.	Open the project in your IDE.
3.	Ensure Maven dependencies are downloaded (check the pom.xml).
4.	Run the application using your IDE or the following command:
mvn spring-boot:run
5.	The application will start on http://localhost:8080/.
6.	Use Postman or any HTTP client to test the API endpoints.
________________________________________
Author
Mbali Banda
Feel free to reach out for questions or feedback.
________________________________________
Notes
1.	Input validation is implemented for all request payloads.
2.	The in-memory H2 database is reset each time the application restarts.
3.	Error messages are returned in JSON format for invalid inputs.
________________________________________


