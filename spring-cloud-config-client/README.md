# Spring Config Client

### Prerequisites

* JDK 8
* Maven 3.0+

### How to Run

```
mvn spring-boot:run -Dspring-boot.run.profiles=development   
OR  
mvn clean package   
java -jar -Dspring.profiles.active=development -Dserver.port=8080 target/spring-cloud-config-client-1.0.jar  
```

Navigate to: http://localhost:8080/whoami/Mr_Pink

### Dynamic update of properties

To update a property on the fly (i.e. without having to restart config-client application):  
1. Update a property in spring-cloud-config-repo project and then push the change to github
2. Navigate to http://localhost:8888/config-client/development (or production depending on which property file you changed in previous step) to confirm config server is picking up the updated property
3. curl -X POST http://localhost:8080/actuator/refresh
4. Navigate to: http://localhost:8080/whoami/Mr_Pink and you should see the updated property
