package staticTest;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.graphics.TextGraphics;
import element.Static.Trophy;
import element.position.PositionInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class TrophyTest {
    private Trophy trophy;
    private PositionInterface position;

    @BeforeEach
    public void helper() {
        position = mock(PositionInterface.class);
        trophy = mock(Trophy.class);
    }

    @Test
    public void verifyDrawTest() {
        TextGraphics graphics = mock(TextGraphics.class);
        trophy.draw(graphics);
        verify(trophy, times(1)).draw(graphics);
    }

    @Test
    public void constructorTest() {
        Trophy trophy = new Trophy(position, "#F3CA28", SGR.BOLD, "$");
        assertTrue(trophy != null);
    }
}