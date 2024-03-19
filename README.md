Spring Boot Chat Application
1.Configuration
Configuration Files
AppConfig.java: Contains the configuration for Spring Security, CORS, and password encoding.
Security Configuration
The AppConfig.java file contains configuration related to Spring Security, including:

Session management
HTTP security
CORS configuration
Form-based authentication
Password encoding using BCrypt
CORS Configuration
The CORS configuration allows cross-origin requests from http://localhost:3000/ with the following settings:

Allowed origins: http://localhost:3000/
Allowed methods: All (*)
Allow credentials: Enabled
Allowed headers: All (*)
Exposed headers: Authorization
Max age: 3600 seconds
Password Encoding
User passwords are encoded using BCrypt, a cryptographic hash function.

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
2.# HomeController in Let'sChat Spring Boot Chatting Application

## Description
The `HomeController` class in the Let'sChat Spring Boot application is responsible for handling requests to the root endpoint ("/"). It provides a simple welcome message to users accessing the API.

## Endpoint

### Home Endpoint
- **GET** `/`
  - Description: Endpoint welcoming users to the Let'sChat API.
  - Response: 
    ```json
    {
      "message": "Welcome to our Let'sChat API using Spring Boot"
    }
    ```
    The response contains a welcome message indicating the usage of the Let'sChat API with Spring Boot.

## Usage
- Accessing the root endpoint ("/") returns a welcome message to users, indicating the successful setup and availability of the Let'sChat API.
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
3.Exception Handling 

## Description
The `GlobleException` class in the Let'sChat Spring Boot application handles various exceptions that may occur during the execution of the application. It provides centralized error handling mechanisms to ensure a smooth user experience and proper handling of unexpected situations.

## Exception Handlers

### UserException
- Handles exceptions related to user-related operations.
- Returns a `BAD_REQUEST` response with an appropriate error message.

### MessageException
- Handles exceptions related to messaging operations.
- Returns a `BAD_REQUEST` response with an appropriate error message.

### MethodArgumentNotValidException
- Handles exceptions related to method arguments not being valid, typically used for input validation errors.
- Returns a `BAD_REQUEST` response with a validation error message.

### NoHandlerFoundException
- Handles exceptions when no handler is found for a particular request.
- Returns a `BAD_REQUEST` response with an error message indicating that the endpoint was not found.

### Other Exceptions
- Handles any other uncaught exceptions.
- Returns a `BAD_REQUEST` response with a generic error message.

## Error Detail Format
- Each exception handler returns an `ErrorDetail` object containing:
  - Timestamp: The date and time when the error occurred.
  - Message: A descriptive error message indicating the nature of the error.
  - Details: Additional details about the error, such as the endpoint or validation error message.

## Usage
- This exception handling mechanism ensures that any unexpected errors are properly handled and returned to the client in a consistent format.
- Developers can extend this mechanism to handle additional custom exceptions as needed.
-----------------------------------------------------------------------------------------------------------------------------------------------------------
4. User Entity 

## Description
The `User` entity class in the Let'sChat Spring Boot application represents a user of the chat application. It stores information such as the user's full name, email, profile picture URL, and password.

## Fields
- `id`: Auto-generated unique identifier for the user.
- `full_name`: Full name of the user.
- `email`: Email address of the user.
- `profile_picture`: URL of the user's profile picture.
- `password`: Password for the user account.

## Relationships
- **One-to-Many**: A user can have multiple notifications associated with them, but this relationship is currently commented out in the code.

## Constructor
- Constructs a User object with the provided parameters.

## Usage
- The User entity class is used to represent users within the Let'sChat application.
- Developers can interact with User objects to perform operations such as user registration, authentication, and profile management.


