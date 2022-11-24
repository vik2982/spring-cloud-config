# Spring boot rest controller example

### Prerequisites

* JDK 1.8+
* Maven 3.0+

### How to Run

#### Standalone
Open a command prompt and in the same directory as the pom run:
```
mvn spring-boot:run
```
Alternatively:
```
mvn clean package -PexcludeBdds
java -jar target/football-team-rest-service-1.0.jar
```

#### Docker
```
mvn clean package -PexcludeBdds
docker build -t footie-app:1.0 .
docker-compose -f docker-compose.yaml up
```

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
### Tools used
Predominantly used Spring Boot for following reasons:
* Simple to create production grade stand-alone applications
* Easy dependency management - makes pom easy to read
* Embedded servlet container support
* @RestController renders JSON response by default

