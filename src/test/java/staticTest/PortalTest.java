package staticTest;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.graphics.TextGraphics;
import element.Static.Portal;
import element.position.PositionInterface;
import net.jqwik.api.*;
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

    @Property
    public void constructorTest(@ForAll("lengthOne") String character) {
        portal = new Portal(position, "BLUE", SGR.BOLD, character);
        assertTrue(portal != null);
    }

    @Provide
    Arbitrary<String> lengthOne() {
        return Arbitraries.strings().ofMaxLength(1);
    }

    @Test
    public void verifyDrawTest() {
        TextGraphics graphics = mock(TextGraphics.class);
        portal.draw(graphics);
        verify(portal, times(1)).draw(graphics);
    }
}