package myproject.basic.helper;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GreetServerTest {

    EchoClient client;

    @Before
    public void setup() {
        client = new EchoClient();
        client.startConnection("34.78.165.222", 80);
    }

    @After
    public void tearDown() {
        client.stopConnection();
    }

    @Test
    public void givenClient_whenServerEchosMessage_thenCorrect() {
        String resp1 = client.sendMessage("hello");
        String resp2 = client.sendMessage("world");
        String resp3 = client.sendMessage("!");
        //String resp4 = client.sendMessage(".");

        assertEquals("hello", resp1);
        assertEquals("world", resp2);
        assertEquals("!", resp3);
        //assertEquals("good bye", resp4);
    }

}