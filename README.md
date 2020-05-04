# AIS Service Discovery Java

## Status

__Work in progress__.


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
