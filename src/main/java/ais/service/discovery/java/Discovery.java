package ais.service.discovery.java;

import ais.service.discovery.java.ILocator;
import ais.service.discovery.java.Service;

import java.util.List;

public class Discovery implements IDiscovery {

    private static ILocator locator = null;
    private static IQueueAdapter queueAdapter = null;

    public Discovery(
            ILocator locator,
            IQueueAdapter queueAdapter
    ) {
        this.locator = locator;
        this.queueAdapter = queueAdapter;
    }

    @Override
    public Service discover(String addr) {
        return null;
    }

    @Override
    public Response request(String addr, Request request) {
        return null;
    }

    @Override
    public void publish(String addr, Event event) {

    }

    @Override
    public List<Message> listen(String addr) {
        Service service = Parser.parse(addr);
        Service found = this.locator.find(service.namespace, service.service, service.instance);
        return this.queueAdapter.listen(found);
    }
}
