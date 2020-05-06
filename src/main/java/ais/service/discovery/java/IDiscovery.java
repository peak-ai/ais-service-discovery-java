package ais.service.discovery.java;

import java.util.List;

public interface IDiscovery {
    public Service discover(String addr);
    public Response request(String addr, Request request);
    public void publish(String addr, Event event);
    public List<Message> listen(String addr);
}
