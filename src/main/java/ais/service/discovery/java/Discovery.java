package ais.service.discovery.java;

import java.util.List;

public class Discovery implements IDiscovery {

    private final ILocator locator;
    private final IQueueAdapter queueAdapter;
    private final IFunctionAdapter functionAdapter;
    private final IPubsubAdapter pubsubAdapter;

    public Discovery(
            ILocator locator,
            IQueueAdapter queueAdapter,
            IFunctionAdapter functionAdapter,
            IPubsubAdapter pubsubAdapter
    ) {
        this.locator = locator;
        this.queueAdapter = queueAdapter;
        this.functionAdapter = functionAdapter;
        this.pubsubAdapter = pubsubAdapter;
    }

    @Override
    public Service discover(String addr) {
        Service service = Parser.parse(addr);
        return this.locator.find(service.namespace, service.service, service.instance);
    }

    @Override
    public Response request(String addr, Request request) {
        return this.functionAdapter.request(this.discover(addr), request);
    }

    @Override
    public void publish(String addr, Event event) {
        this.pubsubAdapter.publish(this.discover(addr), event);
    }

    @Override
    public List<Message> listen(String addr) {
        return this.queueAdapter.listen(this.discover(addr));
    }
}
