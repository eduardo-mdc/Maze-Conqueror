package menuTest;

import element.position.PositionInterface;
import menu.GenericMenuElement;
import menu.submenu.TextMenuElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

public class TextMenuElementTest {
    private PositionInterface position;
    private String text;
    private GenericMenuElement menuText;


    @BeforeEach
    public void helper() throws IOException {
        position = mock(PositionInterface.class);
        text = "text";
        menuText = new TextMenuElement(position, text);
    }

    @Test
    public void constructorTest() {
        assertTrue(menuText != null);
    }

    @Test
    public void toStringTest() {
        assertEquals(menuText.toString(), "text");
    }

}
