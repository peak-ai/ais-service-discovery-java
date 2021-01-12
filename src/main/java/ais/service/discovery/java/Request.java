package ais.service.discovery.java;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public final class Request<T> {
    private final String body;

    public Request(T data) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        this.body = mapper.writeValueAsString(data);
    }

    public String getBody() {
        return this.body;
    }
}
