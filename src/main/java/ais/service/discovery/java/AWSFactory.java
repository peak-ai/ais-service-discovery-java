package ais.service.discovery.java;

import ais.service.discovery.java.IDiscovery;
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

        ILocator locator = new AwsLocator(serviceDiscovery);

        return new Discovery(locator);
    }
}
