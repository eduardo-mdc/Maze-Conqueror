package staticTest;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.graphics.TextGraphics;
import element.Static.Wall;
import element.position.PositionInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class WallTest {
    private Wall wall;
    private PositionInterface position;

    @BeforeEach
    public void helper() {
        position = mock(PositionInterface.class);
        wall = mock(Wall.class);
    }

    @Test
    public void verifyDrawTest() {
        TextGraphics graphics = mock(TextGraphics.class);
        wall.draw(graphics);
        verify(wall, times(1)).draw(graphics);
    }

    @Test
    public void constructorTest() {
        Wall wall = new Wall(position, "#FFFFFF", SGR.BOLD, "#");
        assertTrue(wall != null);
    }
}