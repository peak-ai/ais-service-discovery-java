package ais.service.discovery.java;

public class Service {
    public String arn;
    public String url;
    public String namespace;
    public String service;
    public String instance;

    public Service(
            String arn,
            String url,
            String namespace,
            String service,
            String instance
    ) {
        this.arn = arn;
        this.url = url;
        this.namespace = namespace;
        this.service = service;
        this.instance = instance;
    }
}
