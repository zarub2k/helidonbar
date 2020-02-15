package com.hustlebar.helidonbar.ping;

import org.eclipse.microprofile.rest.client.RestClientBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

public class PingApiTest {
    static IPingApi pingApi;
    static final String HOST = "http://localhost:8080";

    @BeforeAll
    public static void initAll() throws URISyntaxException {
        pingApi = RestClientBuilder.newBuilder()
                .baseUri(new URI(HOST))
                .build(IPingApi.class);
    }

    @Test
    public void testPing() {
        String ping = pingApi.ping();
        assertEquals("Welcome to Helidon bar!", ping);
    }

    @Test
    public void testWelcome() {
        String welcome = pingApi.welcome("Tham");
        assertEquals("Welcome Tham", welcome);
    }
}
