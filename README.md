# Spring Boot Rest API

## Contruir proyecto

```bash
mvn clean install
```

## Ejecutar proyecto

```bash
mvn spring-boot:run
```

## Test con curl 
    
```bash
curl -X GET http://localhost:8080/hello
```

## Test operación reverse
    
```bash
curl http://localhost:8080/reverse?input=hello
```

## Test operación remove-vowels
    
```bash
curl http://localhost:8080/remove-vowels?input=hello
```

## Ejecutar test unitarios

```bash
mvn test
```

## Containerización

### Construir imagen

```bash
docker build -t demo1601 .
```

### Ejecutar imagen

```bash
docker run -p 8080:8080 demo1601
```