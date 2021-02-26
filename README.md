# Magnificent Health Check Application

This project helps to monitor the health of Magnificent application which is running on end point -  http://localhost:12345. The results are captured in a JSON file "healthcheck.json" where administrator can see the status of Magnificent application.

# Prerequisites

* You must be able to work with [GitHub](https://help.github.com/articles/set-up-git) repositories.
* Clone repository.

        git clone https://github.com/Pratibha24/HealthCheckApplication.git
        
* Install the latest version of [Java](preferably Java 1.8).
* You may need to set `JAVA_HOME`.
* Install Maven and set `MAVEN_HOME`.

# Technicals

I have created a spring boot application and exposed an endpoint http://localhost:9001/health which says that "Health checks log will be available in healthcheck.json file"
Once the application is up and running, Administrator can check the logs present in the JSON file under the project root directory.

# Compile and Execute

In order to compile and build the project:
	
	1. navigate to folder where project is cloned ie. inside HealthCheckApplication folder
	2. execute the command
       mvn spring-boot:run
As a result you will get "Started HealthCheckServiceApplication in XXX seconds".

Administrator can invoke the http://localhost:9001/health endpoint to log the health status summary of Magnificent application in json file.


