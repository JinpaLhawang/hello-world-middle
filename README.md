# hello-world-middle

## Setup

```
git clone https://github.com/JinpaLhawang/hello-world-middle.git
cd hello-world-middle
```

## Testing and Building

```
mvn test
mvn package
```

## Running

```
mvn spring-boot:run
```

### Requesting from REST Interface

```
curl -i http://localhost:8091
curl -i http://localhost:8091/properties
```

### Checking Eureka Client Service Discovery Instance Details

```
curl -i http://localhost:8091/service-instances/hello-world-middle -H "Content-Type:application/json"
```
