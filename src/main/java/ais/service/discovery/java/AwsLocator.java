package ais.service.discovery.java;

import com.amazonaws.services.servicediscovery.AWSServiceDiscovery;
import com.amazonaws.services.servicediscovery.model.DiscoverInstancesRequest;
import com.amazonaws.services.servicediscovery.model.DiscoverInstancesResult;
import com.amazonaws.services.servicediscovery.model.HttpInstanceSummary;

public class AwsLocator implements ILocator {

    private AWSServiceDiscovery serviceDiscovery = null;

    public AwsLocator(AWSServiceDiscovery serviceDiscovery) {
        this.serviceDiscovery = serviceDiscovery;
    }

    public Service find(String namespace, String service, String instance) {
        DiscoverInstancesRequest request = new DiscoverInstancesRequest();
        request.setNamespaceName(namespace);
        request.setServiceName(service);
        DiscoverInstancesResult res = this.serviceDiscovery.discoverInstances(request);

        HttpInstanceSummary instanceSummary = res.getInstances().get(0);

        String arn = instanceSummary.getAttributes().get("arn");
        String url = instanceSummary.getAttributes().get("url");

        return new Service(
                arn,
                url,
                namespace,
                service,
                instance
        );
    }
}
