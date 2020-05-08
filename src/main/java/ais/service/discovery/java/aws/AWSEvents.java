package ais.service.discovery.java.aws;

import ais.service.discovery.java.Event;
import ais.service.discovery.java.Service;
import com.amazonaws.services.sns.AmazonSNSClient;

import com.amazonaws.services.sns.model.PublishRequest;

public class AWSEvents {
    private AmazonSNSClient client = null;

    AWSEvents(AmazonSNSClient client) {
        this.client = client;
    }

    public void publish(Service service, Event event) {

        PublishRequest request = new PublishRequest()
                .withTopicArn(service.getArn())
                .withMessage(event.toString());

        this.client.publish(request);
    }

    public void subscribe(Service service) {
        // You can't directly subscribe to an event in AWS
        return;
    }
}
