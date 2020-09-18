# springboot-tracker
Created by Heather Dinh

![Image of COVID-19 Tracker](/image.jpg)

## TO RUN
 1. Download repository and change directory into its location
 2. Make sure you have your JAVA_HOME environment variable pointing to installation of Java and Maven is installed
 3. In the Command Prompt, run ```$ mvn spring-boot:mvn```
 4. In a browser (like Chrome), type in ```localhost:8080``` to display the web page!

## Notes while building the Coronavirus tracker
 - location: cd Desktop/csProjects/springboot-tracker/tracker
 - start.spring.io will initialize a Spring Boot application for you
 - probably better to use IntelliJ, but I'm just going to use Visual Studio
 - not going to use a database here, using public data
 - @ symbol is an annotation

## HTTP protocol
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

## Parsing CSV file
 - the pom.xml file (stands for Project Object Model) contains all config info used by Maven in the project
 - need to add a dependency in the pom.xml so that we can read csv file
 - need to pass in a reader to the csv iterator, convert string to StringReader object
 - ```@Scheduled``` programs this function to run automatically on a regular basis
 - need to specify a time, so use the "cron" expression which takes a string that has second, minute, day etc.
 - by doing ```cron = "* * * * * *"``` this makes it run every second
 - creating a list to store all the values, updates every hour

## Controllers to access page from URL
 - to render this in a UI format (basically go to a URL and have this data in the page)
 - in order to get any page to show up when you access a URL, have to create a ```@Controller```
 - this HomeController should map to an html file that is located in the resources/templates folder
 - when the GetMapping is called, it maps this to the root url
 - home template is the html file
 - this works because we are using the Thymeleaf dependency, so Spring Boot knows to do this
 - have to use ```localhost:8080``` port
 - when you call controller and access the URL, put things on the Model
 - pass in this Model object and this object will be accessible when rendering the HTML, can add attributes to it
 ```model.addAttribute("testName", "TEST");```
 - the s: is adding a String attribute to the model with value of the o:
 - Thymeleaf is used to access this new attribute in the HTML file
 - add the attribute to the model object, and access in the HTML by using th
 ```<p th:text="${testName}"></p>```
 - since using a service, can AutoWire into the Controller
 - using a table, loop through all the stats in the locationStats ArrayList
 - use ```th:each="location: ${locationStats}"``` to loop through, and the th:text from before to display attributes

## Bootstrap Styling
 - jumbotron used just to show more attention to all total cases
 - total cases in general computed by adding all the total cases for each city
```allStats.stream().mapToInt(stat->stat.getLatestTotalCases()).sum();```
 - .stream() converts to a stream that is readable to console
 - .mapToInt(stat->stat.getLatestTotalCases()) gets each latest case and turns it into an int
 - .sum() adds all these cases together
 - <hr> is a horizontal ruler


## Maven
 - make sure that the environment variable named "JAVA_HOME" points to the installation of Java in Program Files
 - can see where JAVA_HOME is by typing in ```$echo %JAVA_HOME%``` which works for env vars
 - to run Maven, cd into the project (in this case it is in the tracker file) and type in command
```mvn spring-boot:run```
 - 