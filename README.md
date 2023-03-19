# Payment

## Prerequisite

* Java 8
* Maven 3.6.3 or higher
* PostgreSQL 13 running on port 5432
* Create database with name <b>payment</b>

## Running the application
 
* Load the project in any developer tool i.e. Eclipse or Intellij.
* Open <b>application.yml</b> and specify PostgreSQL <b>username</b> and <b>password</b> which you specified during postgreSQL installation.
* Run the project as Spring Boot Application.
* Tomcat server will start on port 8080.
* Schema & data in the databases will be automatically populated by liquibase. 

## Endpoints

* Go to the browser and enter following url, which will open swagger ui having all the endpoints available
```
http://localhost:8080/swagger-ui.html
```


