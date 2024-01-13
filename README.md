This demo was created following the youtube tutorial: https://www.youtube.com/watch?v=mPPhcU7oWDU&ab_channel=ProgrammingTechie with some tests and changes here and there.

To use zipkin:
1) run command docker run -p -d 9411:9411 openzipkin/zipkin
2) start all microservices
3) execute a request to a microservice
4) open localhost:9411 to see zipking tracing the requests between the microservices
