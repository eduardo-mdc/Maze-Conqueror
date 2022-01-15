package ButtonTest;


import com.googlecode.lanterna.graphics.TextGraphics;
import element.position.PositionInterface;
import menu.Button;
import menu.ButtonInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class ButtonTest {
    private PositionInterface position;
    private ButtonInterface button;

    @BeforeEach
    public void helper() {
        position = mock(PositionInterface.class);
        button = new Button(position) {
            @Override
            public void execute() {
            }
        };
    }

    @Test
    public void constructorTest() {
        ButtonInterface buttonTemp = new Button(position) {
            @Override
            public void execute() {
            }
        };
        assertTrue(buttonTemp != null);
        assertTrue(button != null);
    }

    @Test
    public void getCurrentColorTest() {
        //WHITE is the default current color.
        assertEquals(button.getCurrentColor(), "WHITE");
    }

    @Test
    public void setCurrentColor() {
        button.setCurrentColor("BLUE");
        assertEquals(button.getCurrentColor(), "BLUE");
    }

    @Test
    public void setSelectedColor() {
        //YELLOW is the default selected color.
        button.setSelected(true);
        assertEquals(button.getCurrentColor(), "YELLOW");
        button.setSelected(false);
        assertEquals(button.getCurrentColor(), "WHITE");
    }

    @Test
    public void verifyDrawTest() {
        ButtonInterface buttonTemp = mock(ButtonInterface.class);
        TextGraphics graphics = mock(TextGraphics.class);
        buttonTemp.draw(graphics);
        verify(buttonTemp, times(1)).draw(graphics);
    }

}
