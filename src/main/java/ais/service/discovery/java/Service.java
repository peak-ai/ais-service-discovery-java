package ais.service.discovery.java;

public class Service {
    public String arn;
    public String url;
    public String namespace;
    public String service;
    public String instance;
    public String urn = "";
    public String name = "";

    public Service(
            String arn,
            String url,
            String namespace,
            String service,
            String instance,
            String urn,
            String name
    ) {
        this.arn = arn;
        this.url = url;
        this.namespace = namespace;
        this.service = service;
        this.instance = instance;
        this.urn = urn;
        this.name = name;
    }

    public String getUrl() {
        return this.url;
    }

    public String getArn() {
        return this.arn;
    }

    public String getUrn() { return this.url; }

    public String getName() { return this.name; }
}
