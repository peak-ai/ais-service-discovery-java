package ais.service.discovery.java;

import ais.service.discovery.java.aws.AWSFactory;

import java.util.List;

public class Example {
    public static void main(String args[]) {
        try {
            System.out.println("GETTTT");
            IDiscovery discovery = AWSFactory.build("eu-west-1");
            List<Message> messages = discovery.listen("ais-latest.relevance.queue");

            for (Message message : messages) {
                System.out.println(message.getBody());
            }

            System.out.println("Got here...");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
