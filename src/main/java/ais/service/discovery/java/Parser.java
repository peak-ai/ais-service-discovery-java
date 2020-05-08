package ais.service.discovery.java;

public class Parser {
    public static Service parse(String addr) {
        String[] parts = addr.split("->");
        if (parts.length == 0) {
            throw new IllegalArgumentException("No instance seperator detected");
        }

        String namespaceService = parts[0];
        String[] nsParts = namespaceService.split("\\.");
        if (nsParts.length < 1) {
            throw new IllegalArgumentException("Not enough parts for namespace and service");
        }

        String namespace = nsParts[0];
        String service = nsParts[1];
        String instance = parts[1];

        return new Service("", "", namespace, service, instance);
    }
}
