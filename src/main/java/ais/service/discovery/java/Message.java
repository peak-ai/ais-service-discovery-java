package ais.service.discovery.java;

public class Message {

    public String body = "";

    public Message(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public String getBody() {
        return this.body;
    }
}
