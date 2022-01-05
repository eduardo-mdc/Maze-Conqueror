package staticTest;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.graphics.TextGraphics;
import element.Static.Heart;
import element.Static.Trophy;
import element.position.Position;
import element.position.PositionInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class HeartTest {
    private Heart heart;
    private PositionInterface position;

    @BeforeEach
    public void helper() {
        position = mock(PositionInterface.class);
        heart = mock(Heart.class);
    }

    @Test
    public void verifyDrawTest() {
        TextGraphics graphics = mock(TextGraphics.class);
        heart.draw(graphics);
        verify(heart, times(1)).draw(graphics);
    }

    @Test
    public void constructorTest() {
        Heart heart = new Heart(position, "#FF0000", SGR.BOLD, "X");
        assertTrue(heart != null);
    }

}
