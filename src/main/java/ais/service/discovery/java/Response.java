package ais.service.discovery.java;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.ByteBufferBackedInputStream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class Response<T> {
    private final ByteBuffer body;
    private final Number statusCode;

    public Response(ByteBuffer body, Number statusCode) {
        this.body = body;
        this.statusCode = statusCode;
    }

    public ByteBuffer getBody() {
        return this.body;
    }

    public Number getStatusCode() {
        return this.statusCode;
    }

    public T getResult(Class<T> type) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        InputStream is = new ByteBufferBackedInputStream(this.body);
        InputStreamReader r = new InputStreamReader(is, StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(r);

        return type.cast(mapper.readValue(br, type));
    }
}
