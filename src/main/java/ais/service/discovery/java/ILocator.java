package ais.service.discovery.java;

public interface ILocator {
    public Service find(
            String namespace,
            String service,
            String instance
    );
}
