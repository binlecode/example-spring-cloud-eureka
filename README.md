

## build eureka service discovery web application jar
```bash
./gradlew :eureka-service:assemble
```

## to run eureka service in single server mode
```bash
cd eureka-service/build/libs\
java -jar eureka-service-0.0.1-SNAPSHOT.jar
```

## to run eureka service as a 3 node cluster based on profiles

First, edit hosts file to add alias to localhost (127.0.0.1) loop-back ip:
```bash
127.0.0.1 peer1.
127.0.0.1 peer2
127.0.0.1 peer3
```
then run the SpringBoot jar with different spring profiles
```bash
cd eureka-service/build/libs
java -jar eureka-service-0.0.1-SNAPSHOT.jar --spring.profiles.active=peer1
java -jar eureka-service-0.0.1-SNAPSHOT.jar --spring.profiles.active=peer2
java -jar eureka-service-0.0.1-SNAPSHOT.jar --spring.profiles.active=peer3
```

## swagger2 support
Every Spring Boot microservice annotated with ```@EnableSwagger2``` exposes the Swagger API documentation under the path ```/v2/api-docs```


## hello-service in cluster via multiple profiles

```bash
cd hello-service
./gradlew assemble
cd build/libs
java -jar hello-service-0.0.1-SNAPSHOT.jar --spring.profiles.active=svc1
java -jar hello-service-0.0.1-SNAPSHOT.jar --spring.profiles.active=svc2
```

