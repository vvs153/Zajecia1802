## Spring Demo Application

### Introduction
To jest pierwsza aplikacja Spring. lol

### Features
Aplokacja zawiera technologie:
- JPA,
- Spring Boot,
- MySQL,
- REST API

Aplikacja umozliwia:
- Dodawanie encji student
- Usuwanie encji student (po id)
- Edycja encji student (mozliwa zmiana tylko imienia)
- Listowanie encji student
- Szukanie encji student po identyfikatorze:
  - -PathVariable -> /student/3 
  - -RequestParam -> /student/byId?studentId=3

### How to configure and run
Aby skonfigurować aplikację, należy dostarczyć parametry do połączenia z bazą danych.
Parametry znajdują się w `/src/main/resources/application.yaml`. Należy wypełnić:

```yaml
spring:
  datasource:
    url: jdbc:mysql:// # wypełnij adres połączenia / fill connection string url
    password: # wypełnij hasło / fill password
    username: # wypełnij login / fill username
  jpa:
    hibernate:
      ddl-auto: update
```

Do uruchomienia aplikacji należy użyć komendy:
```shell
$ mvn spring-boot:run
```
### Authors
Bob