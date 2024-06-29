# Personal Trainor Backend
## Motivation
Wanted to make a backend so the user:
- Can make an account
- Details are saved encyrpted in the database
- Add a workout
- Change password

## Setup instructions for Backend

To set up the project you will need to:
1. Install IntelliJ IDEA or another IDE that is suitable for JDK 17.
2. Install postgreSQL.
3. Clone the project repository from GitHub.
4. Import the project into your IDE.
5. Make a postgreSQL database on your system with the following command `createdb twitter`. See the `application.properties` file for the path that the application requires to access the database 
6. Run the project.
   
## The RESTful route endpoints:

The default port the project will be run on is port 8080 but any can be used. You can access the API endpoints with the following URL **`https://localhost:{port}/{endpoint}`**. See the table below for all available endpoints.

|Controller | Mapping |Path | Description |
|----------|-----------|------|-------------|
| User | GET	| `localhost:8080/users` | Get all users details
| | POST	| `localhost:8080/users` | Create a new account
| | POST	| `localhost:8080/users/authenticate` | Check whether log-in details are correct
| | PUT	| `localhost:8080/users/changePassword` | Change the password for the account in use
| Workout | GET	| `localhost:8080/workouts` | Get all workouts for the user
| | POST	| `localhost:8080/workouts/postWorkout/{userId}` | Add a workout for the user


## Tech Stack

The technologies used for this project are:

- Intelliji IDEA, running JDK 17
- Spring Boot
- H2 Server
- Postman
- Postico

## Dependencies

The dependencies required for the project to run are:
- SpringBoot Web
- SpringBoot DevTools
- PostgreSQL
- SpringBoot Starter Data JPA
