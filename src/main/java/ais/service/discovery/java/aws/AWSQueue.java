package ais.service.discovery.java.aws;

import java.util.Collections;
import java.util.List;

import ais.service.discovery.java.IQueueAdapter;
import ais.service.discovery.java.Service;
import ais.service.discovery.java.Message;

import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageResult;

public class AWSQueue implements IQueueAdapter {

    private AmazonSQSClient client = null;

    public AWSQueue(AmazonSQSClient client) {
        this.client = client;
    }

    public List<Message> listen(Service service) {
        String url = service.getUrl();
        List<Message> messages = Collections.emptyList();

        List<com.amazonaws.services.sqs.model.Message> sqsMessages = this.client.receiveMessage(url).getMessages();
        for (com.amazonaws.services.sqs.model.Message message: sqsMessages) {
            messages.add(new Message(message.getBody()));
        }
        return messages;
    }

    public String queue(Service service, String body) {
        SendMessageRequest request = new SendMessageRequest()
                .withQueueUrl(service.getUrl())
                .withMessageBody(body);
        SendMessageResult result = this.client.sendMessage(request);
        return result.getMessageId();
    }
}
