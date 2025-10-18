# Backend Wizards - Dynamic Profile Endpoint

This is a Spring Boot application that implements a simple RESTful API endpoint for the Backend Wizards Stage 0 task. The `/me` endpoint returns user profile information along with a dynamic cat fact fetched from the Cat Facts API.

## Features
- GET `/me` endpoint returning JSON with user details, timestamp, and a random cat fact.
- Dynamic data: Timestamp updates per request, and a new cat fact is fetched each time.
- Error handling for API failures.

## Setup Instructions
1. Clone the repository: `git clone https://github.com/yourusername/your-repo-name.git`
2. Open the project in IntelliJ IDEA (ensure you have Java JDK 17+ and Maven installed).
3. Install dependencies: Run `mvn clean install` in the terminal (or let IntelliJ handle it).
4. Configure environment variables (see below).

## How to Run Locally
1. In IntelliJ, open `ProfileApiApplication.java` and click the Run button.
2. Alternatively, in the terminal: `mvn spring-boot:run`.
3. The app will start on `http://localhost:8080`.
4. Test the endpoint: Use Postman or curl to send a GET request to `http://localhost:8080/me`.
- Expected response: JSON with status, user, timestamp, and fact.
- Example: `curl http://localhost:8080/me`

## Dependencies and Installation
- **Java JDK**: Version 17 or later (download from [oracle.com](https://www.oracle.com/java/technologies/javase-downloads.html)).
- **Maven**: Included in the project (`pom.xml`). Install via `brew install maven` (Mac) or download from [maven.apache.org](https://maven.apache.org/download.cgi).
- **Spring Boot Dependencies** (listed in `pom.xml`):
    - `spring-boot-starter-web`: For REST endpoints and HTTP clients.
    - `jackson-databind`: For JSON parsing (included with Spring Web).
- Install all via Maven: `mvn clean install`.

## Environment Variables
Edit `src/main/resources/application.properties` with your details:
- `user.email`: Your email address (e.g., `your.email@example.com`).
- `user.name`: Your full name (e.g., `Your Full Name`).
- `user.stack`: Your backend stack (e.g., `Spring Boot/Java`).
  For deployment on Railway, add these as variables in the Railway dashboard instead of hardcoding.

## Testing
- Test locally before deployment: Ensure the endpoint returns 200 OK, correct JSON structure, and dynamic data (timestamp and fact change per request).
- Use Postman for manual testing.
- No automated tests are included, but you can add JUnit tests in the future (e.g., for the controller).

## API Documentation
- **Endpoint**: GET `/me`
- **Response Format**:
  ```json
  {
    "status": "success",
    "user": {
      "email": "your.email@example.com",
      "name": "YusufNehemiah",
      "stack": "SpringBoot"
    },
    "timestamp": "2023-10-15T12:34:56.789Z",
    "fact": "Cats have over 20 muscles that control their ears."
  }