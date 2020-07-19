# api-logger-batch

## Description
Spring Batch app which pulls log files from a path and exports them to a db by demand or on a scheduled basis.

## Design
Simple Spring Batch application. Is designed to work with log files with the structure of logback-encoder, that's why is mainly oriented to APIs.

The app provides two ways to pull log files from the path of your chose, one with an endpoint that being hit, it will trigger the job, and a scheduler that will configure the application to pull files from the path in the time window that is setted.
The log files pulled will be processed and imported to a database running on a Docker container.

Includes:
- Spring MVC
- Spring Boot
- Spring Batch processors, writers and listeners
- Docker compose to start up the db
- Hibernate framework for data writing and retrieving
- OpenApi UI to test the imports
- Controllers to trigger the import job and to search for logs.

## Using the app
Before testing the app, you should start the database with Docker compose. Head to the resources directory where the docker-compose.yaml file is located, and run 

```bash
 docker-compose up
```
or docker-compose up -d if you want to detach.

This will start the stock-db pointing to the default MySQL port. You can use MySQL Workbench or any other client to test connection. Check user and password presents on the yaml in case that you have any issues connecting.
Run the command docker-compose logs to check the logs from the db if you are dettaching.

To build the app without tests, run:

```bash
 mvn clean install -DskipTests=true
```

And then execute

```bash
java -jar api-logger-batch/target/api-logger-batch-1.0-SNAPSHOT.jar
```

- Starting the app with a time window configured on the application.properties will trigger the import job on a scheduled basis. If any time is setted, you will need to hit the /logImport endpoint to trigger a job.
- Also you can configure if you want to wipe the existent logs from the db before executing a new job.
- Use the /logSearch endpoints to perform searches of the logs present on the database, using Swagger UI or Postman. (Swagger UI url is http://localhost:8080/swagger-ui.html).
- You can check the logfiles for detailed import results.
