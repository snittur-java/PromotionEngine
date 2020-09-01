# PromotionEngine

This is a spring boot application which perform promotion engine task. Application is built using 
Spring 2.1.16.RELEASE
Maven3.6.3
Java 8
Please use java 8 for building the maven project

After building maven clean install. Please start the application. once application is up and running. Swagger is enabled for API testing
and can be tested to validate the result http://localhost:8080/swagger-ui.html
Unit test cases has been added.
In build memory H2 database has been added.
Since by default it will no create the tables of this spring boot version. Please login to http://localhost:8080/h2-console
credentails has been provided in application.properties. in SRC/MAIN/RESOuRCE folder data.sql is provided this can run on h2 console to store data.
If unable to perform h2 data base, application still works has been provided with static loading of data.

Global exception has been added using advice to check for bad request and if there are any sql exception or any exception catching at the advice level
Spring jp has been used to conect the h2 database

Loging has been enabled log4j2 has been usedto log the information

