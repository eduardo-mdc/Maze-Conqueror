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
    private Portal portalATemp;
    private Portal portalBTemp;

    @BeforeEach
    public void helper() {
        handler = new PortalHandler(new Maze(new Game(), 10));
        portalATemp = handler.getPortalA();
        portalBTemp = handler.getPortalB();
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
        assertEquals(portalATemp, handler.getPortalA());
        assertEquals(portalBTemp, handler.getPortalB());
        assertTrue(handler.getPortalA() != handler.getPortalB());
    }

    @Test
    public void getOtherPortal() {
        Portal otherB = handler.getOtherPortal(portalATemp);
        assertEquals(otherB, portalBTemp);
        Portal otherA = handler.getOtherPortal(portalATemp);
        assertEquals(otherA, portalBTemp);
    }
}
