# Spring boot rest controller example

### Prerequisites

* JDK 11
* Maven 3.0+

### How to Run

#### Standalone
Open a command prompt and in the same directory as the pom run:
```
mvn clean package -PskipBdds
mvn spring-boot:run OR java -jar target/football-team-rest-service-1.0.jar
```

#### Docker
```
mvn clean package -PskipBdds
docker build -t footie-app:1.0 .
docker-compose -f docker-compose.yaml up -d
```

NOTE: When running docker locally port 8080 is used by default as specified in docker-compose.yaml.  In the jenkins pipeline the port is set in the jenkinsFile - environment variable HOST_PORT

### URLS

* Get all teams - http://localhost:8080/
* Get specific team - http://localhost:8080/{team} e.g. spurs
* Get teams in order of stadium capacity: http://localhost:8080/capacity?sort=asc and http://localhost:8080/capacity?sort=desc
* Create a team - Open git bash command prompt and run following curl
```
curl -X POST -H "Content-Type: application/json" -d '{
  "name": "Liverpool",
  "city": "Merseyside",
  "owner": "Americans",
  "stadiumCapacity": 47000,
  "competition": "fa cup",
  "numberOfPlayers": 17,
  "dateOfCreation": "17/07/2012"
}' 'http://localhost:8080/create'
```

Swagger/OpenApi 3.0 accessible at http://localhost:8080/swagger-ui.html

### BDDS

mvn test -Djenkins.hostPort=8080

### Tools used
Predominantly used Spring Boot for following reasons:
* Simple to create production grade stand-alone applications
* Easy dependency management - makes pom easy to read
* Embedded servlet container support
* @RestController renders JSON response by default
