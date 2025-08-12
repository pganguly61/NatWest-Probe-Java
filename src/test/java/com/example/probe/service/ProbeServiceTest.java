package com.example.probe.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProbeServiceTest {

    @Test
    void testMoveForward() {
        ProbeService service = new ProbeService();
        service.executeCommands("FF");
        assertEquals("0 2 N", service.getState());
    }

    @Test
    void testTurnLeftAndRight() {
        ProbeService service = new ProbeService();
        service.executeCommands("R");
        assertEquals("0 0 E", service.getState());
        service.executeCommands("L");
        assertEquals("0 0 N", service.getState());
    }

    @Test
    void testBoundary() {
        ProbeService service = new ProbeService();
        service.executeCommands("FFFFF");
        assertEquals("0 4 N", service.getState());
    }
}
