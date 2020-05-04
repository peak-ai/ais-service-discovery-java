package ais.service.discovery.java;

public interface IDiscovery {
    public Service discover(String addr);
    public Response request(String addr, Request request);
    public void publish(String addr, Event event);
    public Message listen(String addr);
}
