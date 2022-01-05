import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.graphics.TextGraphics;
import element.Element;
import element.ElementInterface;
import element.position.Position;
import element.position.PositionInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

}
