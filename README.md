# AIS Service Discovery Java

## Status

The package is available in the Maven Central repository: [ais-service-discovery-java](https://search.maven.org/artifact/com.github.peak-ai/ais-service-discovery-java) 

Compatible Java SDK version: `adopt-openj9-1.8`

## Example Useage

```java
Discovery discovery = new AWSFactory.build();
Service service = discovery.discover();

Request request = new Request(
    jsonString,
    options,
);

Response response = discovery.request("namespace.my-service->update", request);

Event event = new Event(jsonString, opts);
discovery.publish("namespace.my-srv.inst", event);

List<Message> messages = discovery.listen(addr, opts);
```
