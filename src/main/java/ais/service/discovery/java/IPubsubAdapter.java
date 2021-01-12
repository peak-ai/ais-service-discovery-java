package ais.service.discovery.java;

public interface IPubsubAdapter {
    void publish(Service service, Event event);
    Event subscribe(Service service);
}
