package ais.service.discovery.java.aws;

import ais.service.discovery.java.Event;
import ais.service.discovery.java.IPubsubAdapter;
import ais.service.discovery.java.Service;
import com.amazonaws.services.sns.AmazonSNS;

import com.amazonaws.services.sns.model.PublishRequest;

public class AWSEvents implements IPubsubAdapter {
    private final AmazonSNS client;

    public AWSEvents(AmazonSNS client) {
        this.client = client;
    }

    public void publish(Service service, Event event) {
        PublishRequest request = new PublishRequest()
                .withTopicArn(service.getArn())
                .withMessage(event.toString());

        this.client.publish(request);
    }

    public Event subscribe(Service service) {
        // You can't directly subscribe to an event in AWS
        return null;
    }
}
