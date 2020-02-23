# Helidon Quickstart MP Example

This example implements a simple Hello World REST service using MicroProfile.

## Build and run

With JDK8+
```bash
mvn package
java -jar target/helidonbar.jar
```

## Exercise the application

```
curl -X GET http://localhost:8080/greet
{"message":"Hello World!"}

curl -X GET http://localhost:8080/greet/Joe
{"message":"Hello Joe!"}

curl -X PUT -H "Content-Type: application/json" -d '{"greeting" : "Hola"}' http://localhost:8080/greet/greeting

curl -X GET http://localhost:8080/greet/Jose
{"message":"Hola Jose!"}
```

## Try health and metrics

```
curl -s -X GET http://localhost:8080/health
{"outcome":"UP",...
. . .

# Prometheus Format
curl -s -X GET http://localhost:8080/metrics
# TYPE base:gc_g1_young_generation_count gauge
. . .

# JSON Format
curl -H 'Accept: application/json' -X GET http://localhost:8080/metrics
{"base":...
. . .

```

## Build the Docker Image

```
docker build -t helidonbar .
```

## Start the application with Docker

```
docker run --rm -p 8080:8080 helidonbar:latest
```

Exercise the application as described above

## Deploy the application to Kubernetes

```
kubectl cluster-info                         # Verify which cluster
kubectl get pods                             # Verify connectivity to cluster
kubectl create -f app.yaml               # Deploy application
kubectl get service helidonbar  # Verify deployed service
```

## Focus
* JAX-RS
    - REST APIs
    - Exception handling
    - Response with Link (Create)
* Config
    - Microprofile configuration options (System, Environment, microprofile-config)
    - System override
        - java -Dapp.welcome="" -jar target\app.jar
    - Environment override
        - Export APP_WELCOME=Welcome {0}
        - java -jar target\app.jar
    - Options
        - @Config / @ConfigProperty
* Health Check
    - In-built outcomes (state & outcome is deprecated in 2.0) /health
        - deadlock detection
        - available disk space
        - available heap memory
    - Custom
        - @Liveness
            - Available in /health/live
        - Readiness
            - @Readiness
            - Available in /health/ready
* Metrics (/metrics) [text and json format]
    - 3 scopes of metrics
        - base (/metrics/base)
        - vendor (/metrics/vendor)
        - application (/metrics/application)
            - types
                - @Counted (Register a Counter metrics)
                - @Timed (Register a Timer metrics)
                - @Metered (Register a Meter metrics)
                - Histogram or Gauge
            - metrics can be configured at the class, method or field
            - Metrics can also be re-used across different methods (reusable = true)
* Fault tolerance
    - Timeout (@Timeout)
    - Retry (@Retry)
    - Fallback (@Fallback)
        - FallbackHandler
        - fallbackMethod
    - Circuit Breaker
        - states (closed / open / half-open)
    - Bulkhead
        - Thread pool isolation (@Bulkhead + @Asynchronous)
            - Max con-current connection + waiting queue size
        - Semaphore isolation (@Bulkhead)
            - con-current number of connection only
* Open API
    - Open api through annotation
    - Static openapi file under META-INF (META-INF/openapi.yaml or openapi.json or openapi.yml)
    - Generate through code (Implement OASModelReader and change configuration 'mp.openapi.model.reader')
* Rest Client
    - Type based rest client
    - Rest client with annotation
* JWT Authentication
    - TODO
* Open tracing
    - @Tracing
    - Zipkin / Jaeger
* General
    - Start up / Shutdown listener

## Reference
    https://download.eclipse.org/microprofile/
    https://github.com/eclipse/microprofile
    https://countrycode.org/
    https://www.sport-histoire.fr/en/Geography/ISO_codes_countries.php
    https://dennis-xlc.gitbooks.io/restful-java-with-jax-rs-2-0-en/content/en/index.html