package handlerTest;


import com.googlecode.lanterna.graphics.TextGraphics;
import handler.PointsHandler;
import net.jqwik.api.Property;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class PointsHandlerTest {
    private PointsHandler handler;

    @BeforeEach
    public void helper() {
        handler = new PointsHandler();
    }

    @Test
    public void constructorTest() throws IOException {
        PointsHandler handlerTemp = new PointsHandler();
        assertTrue(handlerTemp != null);
        assertTrue(handler != null);
    }

    @Test
    public void setPointsTets() {
        handler.setPoints(-500);
        assertEquals(0, handler.getPoints());
        handler.setPoints(100);
        assertEquals(100, handler.getPoints());
    }

    @Test
    public void incrementPointsTets() {
        handler.setPoints(50);
        handler.incrementPoints(100);
        assertEquals(150, handler.getPoints());
    }

    @Test
    public void verifyDrawTest() {
        PointsHandler handlerTemp = mock(PointsHandler.class);
        TextGraphics graphics = mock(TextGraphics.class);
        handlerTemp.draw(graphics);
        verify(handlerTemp, times(1)).draw(graphics);
    }


}
