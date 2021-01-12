package ais.service.discovery.java;

import org.junit.Test;
import static org.junit.Assert.*;

public class ParserTest {
    @Test public void testCanParseServiceAddr() {
        String given = "ais.service->instance";
        Service actual = Parser.parse(given);
        Service expected = new Service(
                "",
                "",
                "ais",
                "service",
                "instance",
                "",
                ""
        );

        assertEquals(expected.namespace, actual.namespace);
        assertEquals(expected.service, actual.service);
        assertEquals(expected.instance, actual.instance);
    }
}
