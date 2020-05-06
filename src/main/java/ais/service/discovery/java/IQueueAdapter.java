package ais.service.discovery.java;

import java.util.List;

public interface IQueueAdapter {
    public List<Message> listen(Service service);
    public String queue(Service service, String body);
}
