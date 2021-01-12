package ais.service.discovery.java.aws;

import ais.service.discovery.java.ILocator;
import ais.service.discovery.java.Service;
import com.amazonaws.services.servicediscovery.AWSServiceDiscovery;
import com.amazonaws.services.servicediscovery.model.DiscoverInstancesRequest;
import com.amazonaws.services.servicediscovery.model.DiscoverInstancesResult;
import com.amazonaws.services.servicediscovery.model.HealthStatus;
import com.amazonaws.services.servicediscovery.model.HttpInstanceSummary;

public class AWSLocator implements ILocator {

    private AWSServiceDiscovery serviceDiscovery = null;

    public AWSLocator(AWSServiceDiscovery serviceDiscovery) {
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
        String name = instanceSummary.getAttributes().get("name");
        String urn = instanceSummary.getAttributes().get("urn");

        // @todo - maybe make these args into a separate object/model
        return new Service(
            arn,
            url,
            namespace,
            service,
            instance,
            name,
            urn
        );
    }
}
