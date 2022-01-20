package menuTest;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import element.position.Position;
import element.position.PositionInterface;
import menu.GenericMenuElement;
import menu.submenu.GenericMenuElementInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class GenericMenuElementTest {

    private GenericMenuElementInterface genericMenu;
    private PositionInterface position;

    @BeforeEach
    public void helper() {
        position = new Position(3, 4);
        genericMenu = new GenericMenuElement(position);
    }

    @Test
    public void constructorTest() {
        assertTrue(genericMenu != null);
    }

    @Test
    public void setTextTest() {
        genericMenu.setText("text");
        assertEquals(genericMenu.getText(), "text");
    }

    @Test
    public void setBackColorTest() {
        genericMenu.setBackColor("BLACK");
        assertEquals(genericMenu.getBackColor(), "BLACK");
    }

    @Test
    public void verifyDraw() {
        GenericMenuElementInterface genericTemp = mock(GenericMenuElement.class);
        TextGraphics graphics = mock(TextGraphics.class);
        genericTemp.draw(graphics);
        verify(genericTemp, times(1)).draw(graphics);
    }
}
