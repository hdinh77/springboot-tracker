# springboot-tracker

## Notes while building the Coronavirus tracker
 - location: cd Desktop/csProjects/springboot-tracker/tracker
 - start.spring.io will initialize a Spring Boot application for you
 - not going to use a database here, using public data
 - @ symbol is an annotation
 - using a raw data csv file from GitHub repo that is updated daily
 - need to convert the URL to a URI because the HTTP request can read that
 - to make requests and responses by HTTP, include libraries from java
```import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;```
 - to take the body of the request and return it as a string
```HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());```
 - this doesn't do anything right now because it is just a class, need to mark it as a Spring service stereotype by using ```@Service```
 - ```@PostConstruct``` tells application to execute this when the Service class is constructed
 - the pom.xml file (stands for Project Object Model) contains all config info used by Maven in the project
 - need to add a dependency in the pom.xml so that we can read csv file
 - need to pass in a reader to the csv iterator, convert string to StringReader object
 - ```@Scheduled``` programs this function to run automatically on a regular basis
 - need to specify a time, so use the "cron" expression which takes a string that has second, minute, day etc.
 - by doing ```cron = "* * * * * *"``` this makes it run every second
 - creating a list to store all the values, updates every hour
 - 


## Maven
 - make sure that the environment variable named "JAVA_HOME" points to the installation of Java in Program Files
 - can see where JAVA_HOME is by typing in ```$echo %JAVA_HOME%``` which works for env vars
 - to run Maven, cd into the project (in this case it is in the tracker file) and type in command
```mvn spring-boot:run```
 - 