package ais.service.discovery.java;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;
import static org.junit.Assert.*;

public class RequestTest {
    static class TestClass {
        public final String name;

        public TestClass(String name) {
            this.name = name;
        }
    }

    @Test public void testCanCreateJSONRequest() throws JsonProcessingException {
        Request<TestClass> req = new Request<>(new TestClass("test"));
        assertEquals("{\"name\":\"test\"}", req.getBody());
    }
}
