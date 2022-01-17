package handlerTest;

import com.googlecode.lanterna.graphics.TextGraphics;
import handler.BombsHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class BombsHandlerTest {
    private BombsHandler handler;

    @BeforeEach
    public void helper() {
        handler = new BombsHandler();
    }

    @Test
    public void constructorTest() throws IOException {
        BombsHandler handlerTemp = new BombsHandler();
        assertTrue(handlerTemp != null);
        assertTrue(handler != null);
    }

    @Test
    public void getBombsTest() {
        assertEquals(handler.getBombs(), 5);
        handler.setBomb(12);
        assertEquals(handler.getBombs(), 12);
    }

    @Test
    public void setBombsTest() {
        handler.setBomb(-8);
        assertEquals(handler.getBombs(), 0);
        handler.setBomb(10);
        assertEquals(handler.getBombs(), 10);
    }

    @Test
    public void incrementBombsTest() {
        assertEquals(handler.getBombs(), 5);
        handler.incrementBombs(5);
        assertEquals(handler.getBombs(), 10);
    }

    @Test
    public void verifyDrawTest() {
        BombsHandler handlerTemp = mock(BombsHandler.class);
        TextGraphics graphics = mock(TextGraphics.class);
        handlerTemp.draw(graphics);
        verify(handlerTemp, times(1)).draw(graphics);
    }

}
