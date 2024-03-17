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