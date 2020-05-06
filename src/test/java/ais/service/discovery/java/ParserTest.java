package ais.service.discovery.java;

import ais.service.discovery.java.Parser;
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
                "instance"
        );

        assertSame(expected, actual);
    }
}
