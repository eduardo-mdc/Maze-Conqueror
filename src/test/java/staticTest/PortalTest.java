package staticTest;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.graphics.TextGraphics;
import element.Static.Portal;
import element.position.PositionInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class PortalTest {

    private Portal portal;
    private PositionInterface position;

    @BeforeEach
    public void helper() {
        position = mock(PositionInterface.class);
        portal = mock(Portal.class);
    }

    @Test
    public void constructorTest() {
        portal = new Portal(position, "BLUE", SGR.BOLD, "p");
        assertTrue(portal != null);
    }

    @Test
    public void verifyDrawTest() {
        TextGraphics graphics = mock(TextGraphics.class);
        portal.draw(graphics);
        verify(portal, times(1)).draw(graphics);
    }


}