package ais.service.discovery.java.aws;

import ais.service.discovery.java.*;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.servicediscovery.AWSServiceDiscovery;
import com.amazonaws.services.servicediscovery.AWSServiceDiscoveryClientBuilder;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.lambda.AWSLambda;
import com.amazonaws.services.lambda.AWSLambdaClientBuilder;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSAsyncClientBuilder;


public class AWSFactory {
    public static IDiscovery build(String region) {
        ProfileCredentialsProvider creds = new ProfileCredentialsProvider();
        AWSServiceDiscovery serviceDiscovery = AWSServiceDiscoveryClientBuilder
                .standard()
                .withCredentials(creds)
                .withRegion(region)
                .build();

        AmazonSQS sqs = AmazonSQSClientBuilder
                .standard()
                .withCredentials(creds)
                .withRegion(region)
                .build();

        AWSLambda lambda = AWSLambdaClientBuilder
                .standard()
                .withCredentials(creds)
                .withRegion(region)
                .build();

        AmazonSNS sns = AmazonSNSAsyncClientBuilder
                .standard()
                .withCredentials(creds)
                .withRegion(region)
                .build();

        ILocator locator = new AWSLocator(serviceDiscovery);
        IQueueAdapter queueAdapter = new AWSQueue(sqs);
        IFunctionAdapter functionAdapter = new AWSFunction(lambda);
        IPubsubAdapter pubsubAdapter = new AWSEvents(sns);

        return new Discovery(
            locator,
            queueAdapter,
            functionAdapter,
            pubsubAdapter
        );
    }
}
