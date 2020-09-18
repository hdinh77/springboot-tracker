# springboot-tracker

## Notes while building the Coronavirus tracker
 - start.spring.io will initialize a Spring Boot application for you
 - not going to use a database here, using public data
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
 - 