import com.googlecode.lanterna.graphics.TextGraphics;
import element.Static.Heart;
import element.position.PositionInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    public void drawTest() {
        TextGraphics graphics = mock(TextGraphics.class);
        heart.draw(graphics);
        verify(heart, times(1)).draw(graphics);
    }

}
