package ais.service.discovery.java;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.junit.Test;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.*;

public class ResponseTest {
    private static class TestClass {
        public String name;

        public TestClass(@JsonProperty("name") String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    @Test public void testCanCreateJSONResponse() throws IOException {
        Response<TestClass> res = new Response<>(ByteBuffer.wrap("{\"name\":\"test\"}".getBytes(StandardCharsets.UTF_8)), 200);
        TestClass r = res.getResult(TestClass.class);
        assertEquals(r.getName(), "test");
    }
}
