package ais.service.discovery.java;

import ais.service.discovery.java.ILocator;
import ais.service.discovery.java.Service;

public class Discovery implements IDiscovery {

    private static ILocator locator = null;

    public Discovery(ILocator locator) {
        this.locator = locator;
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
    public Message listen(String addr) {
        return null;
    }
}
