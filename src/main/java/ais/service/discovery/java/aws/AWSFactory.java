package ais.service.discovery.java.aws;

import ais.service.discovery.java.Discovery;
import ais.service.discovery.java.IDiscovery;
import ais.service.discovery.java.ILocator;
import ais.service.discovery.java.IQueueAdapter;
import com.amazonaws.auth.EnvironmentVariableCredentialsProvider;
import com.amazonaws.services.servicediscovery.AWSServiceDiscovery;
import com.amazonaws.services.servicediscovery.AWSServiceDiscoveryClientBuilder;

public class AWSFactory {
    public static IDiscovery build(String region) {
        AWSServiceDiscovery serviceDiscovery = AWSServiceDiscoveryClientBuilder
                .standard()
                .withCredentials(new EnvironmentVariableCredentialsProvider())
                .withRegion(region)
                .build();

        ILocator locator = new AWSLocator(serviceDiscovery);
        IQueueAdapter queueAdapter = new AWSQueue();

        return new Discovery(locator, queueAdapter);
    }
}
