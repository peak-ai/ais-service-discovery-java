package ais.service.discovery.java.aws;

import java.util.List;

import ais.service.discovery.java.IQueueAdapter;
import ais.service.discovery.java.Service;
import ais.service.discovery.java.Message;

public class AWSQueue implements IQueueAdapter {
    public AWSQueue() {}

    public List<Message> listen(Service service) {
        return null;
    }

    public String queue(Service service, String body) {
        return null;
    }
}
