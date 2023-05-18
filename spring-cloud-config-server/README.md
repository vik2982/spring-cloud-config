# Spring Config Server

### Prerequisites

* JDK 8
* Maven 3.0+

### How to Run

mvn spring-boot:run  
OR  
mvn clean package  
java -jar -Dserver.port=8888 target/spring-cloud-config-server-1.0.jar  

Navigate to:  
http://localhost:8888/config-client/development
http://localhost:8888/config-client/production