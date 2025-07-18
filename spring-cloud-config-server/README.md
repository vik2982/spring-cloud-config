# Spring Config Server

### Prerequisites

* JDK 8
* Maven 3.0+

### How to Run

```
mvn spring-boot:run  
OR  
mvn clean package  
java -jar -Dserver.port=8888 target/spring-cloud-config-server-1.0.jar  
```

### H2
Console url: http://localhost:8888/h2-console/  

### Database Config
http://localhost:8888/configclient/development/1.1 <br/>
http://localhost:8888/config-client/production/1.1

### Git repo Config
(In application.yaml comment out jdbc and uncomment git.  Then rebuild) <br/>
http://localhost:8888/config-client/development  
http://localhost:8888/config-client/production

