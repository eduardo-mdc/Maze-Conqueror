package handlerTest;

import com.googlecode.lanterna.graphics.TextGraphics;
import handler.LevelHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class LevelHandlerTest {

    private LevelHandler handler;

    @BeforeEach
    public void helper() {
        handler = new LevelHandler();
    }

    @Test
    public void getLevelTest() {
        //default level value is 9.
        assertEquals(9, handler.getLevel());
    }

    @Test
    public void nextLevelTest() {
        assertEquals(9, handler.getLevel());
        while (handler.getLevel() != 15)
            handler.nextLevel();
        assertEquals(15, handler.getLevel());
    }

    @Test
    public void verifyDraw() {
        LevelHandler handlerTemp = mock(LevelHandler.class);
        TextGraphics graphics = mock(TextGraphics.class);
        handlerTemp.draw(graphics);
        verify(handlerTemp, times(1)).draw(graphics);
    }

}
