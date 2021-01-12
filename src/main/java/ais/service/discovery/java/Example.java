package ais.service.discovery.java;

import ais.service.discovery.java.aws.AWSFactory;

import java.util.List;

public class Example {
    public static void main(String[] args) {
        try {
            IDiscovery discovery = AWSFactory.build("eu-west-1");
            List<Message> messages = discovery.listen("ais-latest.relevance.queue");

            for (Message message : messages) {
                System.out.println(message.getBody());
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
