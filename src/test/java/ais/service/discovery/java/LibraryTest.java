package ais.service.discovery.java;

import org.junit.Test;
import ais.service.discovery.java.ILocator;

import java.util.List;

import static org.junit.Assert.*;

class MockLocator implements ILocator {
    public Service service = null;

    MockLocator(Service mock) {
        this.service = mock;
    }

    public Service find(String namespace, String service, String instance) {
        return this.service;
    }
}

class MockQueue implements IQueueAdapter {

    @Override
    public List<Message> listen(Service service) {
        return null;
    }

    @Override
    public String queue(Service service, String body) {
        return null;
    }
}

class MockFunction implements IFunctionAdapter {

    @Override
    public Response request(Service service, Request request) {
        return null;
    }
}

class MockPubsub implements IPubsubAdapter {
    @Override
    public void publish(Service service, Event event) {

    }

    @Override
    public Event subscribe(Service service) {
        return null;
    }
}

public class LibraryTest {
    @Test public void testDiscovery() {
        Service expectedService = new Service(
                "",
                "",
                "my-namespace",
                "some-service",
                "an-instance",
                "",
                ""
        );

        ILocator mockLocator = new MockLocator(expectedService);
        IQueueAdapter mockQueue = new MockQueue();
        IFunctionAdapter mockFunction = new MockFunction();
        IPubsubAdapter mockPubsub =new MockPubsub();

        Discovery discovery = new Discovery(mockLocator, mockQueue, mockFunction, mockPubsub);

        assertEquals(expectedService, discovery.discover("my-namespace.some-service->an-instance"));
    }
}
