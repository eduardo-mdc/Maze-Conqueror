package handlerTest;

import element.Static.Portal;
import game.Game;
import handler.PortalHandler;
import maze.Maze;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PortalHandlerTest {

    private PortalHandler handler;

    @BeforeEach
    public void helper() {
        handler = new PortalHandler(new Maze(new Game(), 10));
    }

    @Test
    public void constructorTest() throws IOException {
        PortalHandler handlerTemp = new PortalHandler(new Maze(new Game(), 15));
        assertTrue(handlerTemp != null);
        assertTrue(handler != null);
        assertTrue(handlerTemp.getPortalA() != null);
        assertTrue(handlerTemp.getPortalB() != null);
    }

    @Test
    public void getPortalsTest() {
        Portal portalATemp = handler.getPortalA();
        Portal portalBTemp = handler.getPortalB();
        assertEquals(portalATemp, handler.getPortalA());
        assertEquals(portalBTemp, handler.getPortalB());
        assertTrue(handler.getPortalA() != handler.getPortalB());
    }

}
