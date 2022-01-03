import com.googlecode.lanterna.graphics.TextGraphics;
import element.Static.HpBar;
import element.position.PositionInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class HpBarTest {

    private HpBar hpbar;
    private PositionInterface position;

    @BeforeEach
    public void helper() {
        position = mock(PositionInterface.class);
        hpbar = mock(HpBar.class);
    }

    @Test
    public void drawTest() {
        TextGraphics graphics = mock(TextGraphics.class);
        hpbar.draw(graphics);
        verify(hpbar, times(1)).draw(graphics);
    }

}
