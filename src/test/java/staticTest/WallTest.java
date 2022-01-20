package staticTest;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.graphics.TextGraphics;
import element.Static.Wall;
import element.position.PositionInterface;
import net.jqwik.api.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class WallTest {
    private Wall wall;
    private PositionInterface position;

    @BeforeEach
    public void helper() {
        position = mock(PositionInterface.class);
        wall = mock(Wall.class);
    }

    @Property
    public void constructorTest(@ForAll("lengthOne") String character) {
        Wall wall = new Wall(position, "#FFFFFF", SGR.BOLD, character);
        assertTrue(wall != null);
    }

    @Provide
    Arbitrary<String> lengthOne() {
        return Arbitraries.strings().ofMaxLength(1);
    }

    @Test
    public void verifyDrawTest() {
        TextGraphics graphics = mock(TextGraphics.class);
        wall.draw(graphics);
        verify(wall, times(1)).draw(graphics);
    }
}