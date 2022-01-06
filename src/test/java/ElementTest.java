import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.graphics.TextGraphics;
import element.Element;
import element.ElementInterface;
import element.Static.Wall;
import element.position.Position;
import element.position.PositionInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


public class ElementTest {
    private PositionInterface position;
    private ElementInterface element;

    @BeforeEach
    public void helper() {
        position = mock(PositionInterface.class);
        element = new Element(position, "#FF0000", SGR.BOLD, "X") {
            @Override
            public void draw(TextGraphics screen) {
            }
        };
    }

    @Test
    public void setPositionTest() {
        PositionInterface newPosition = mock(Position.class);
        element.setPosition(newPosition);
        assertEquals(element.getPosition(), newPosition);
    }

    @Test
    public void GetPositionTest() {
        ElementInterface element = new Element(position, "#FF0000", SGR.BOLD, "X") {
            @Override
            public void draw(TextGraphics screen) {
            }
        };
        PositionInterface newPosition = element.getPosition();
        assertEquals(newPosition, position);
    }

    @Test
    public void verifyDrawTest() {
        ElementInterface tempElem = mock(ElementInterface.class);
        TextGraphics graphics = mock(TextGraphics.class);
        tempElem.draw(graphics);
        verify(tempElem, times(1)).draw(graphics);
    }

    @Test
    public void getFormatTest() {
        ElementInterface tempElem = new Element(position, "#FF0000", SGR.BOLD, "X") {
            @Override
            public void draw(TextGraphics screen) {
            }
        };
        assertEquals(tempElem.getFormat(), element.getFormat());
    }

    @Test
    public void getColorTest() {
        ElementInterface tempElem = new Element(position, "#FF0000", SGR.BOLD, "X") {
            @Override
            public void draw(TextGraphics screen) {
            }
        };
        assertEquals(tempElem.getColor(), element.getColor());
    }

    @Test
    public void getCharacterTest() {
        ElementInterface tempElem = new Element(position, "#FF0000", SGR.BOLD, "X") {
            @Override
            public void draw(TextGraphics screen) {
            }
        };
        assertEquals(tempElem.getCharacter(), element.getCharacter());
    }

    @Test
    public void equalsTest() {
        ElementInterface tempWall1 = new Wall(position, "#FF0000", SGR.BOLD, "X");
        ElementInterface tempWall2 = new Wall(position, "#FF0000", SGR.BOLD, "X");
        ElementInterface tempWall3 = new Wall(position, "#FF0055", SGR.ITALIC, "Y");
        ElementInterface tempWall4 = new Wall(position, "#FF0000", SGR.BLINK, "X");
        ElementInterface tempWall5 = new Wall(position, "#000000", SGR.BORDERED, "Z");
        ElementInterface tempWall6 = new Wall(position, "#000000", SGR.BORDERED, "Z");
        assertTrue(tempWall1.equals(tempWall2));
        assertTrue(tempWall5.equals(tempWall6));
        assertFalse(tempWall1.equals(tempWall3));
        assertFalse(tempWall4.equals(tempWall5));
        assertFalse(tempWall1.equals(tempWall6));
    }
    @Test
    public void constructorTest() {
        ElementInterface tempElem = new Element(position, "#FF0000", SGR.BOLD, "X") {
            @Override
            public void draw(TextGraphics screen) {
            }
        };
        assertTrue(tempElem != null);
    }
}
