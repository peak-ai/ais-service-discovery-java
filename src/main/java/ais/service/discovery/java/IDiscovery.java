package ais.service.discovery.java;

import java.util.List;

public interface IDiscovery {
    public Service discover(String addr);
    public <T> Response<T> request(String addr, Request<T> request);
    public void publish(String addr, Event event);
    public List<Message> listen(String addr);
}
