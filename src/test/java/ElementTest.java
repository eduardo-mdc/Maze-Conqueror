import com.googlecode.lanterna.graphics.TextGraphics;
import element.Element;
import element.ElementInterface;
import element.position.Position;
import element.position.PositionInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ElementTest {
    PositionInterface position;
    ElementInterface element;

    @BeforeEach
    public void helper() {
        position = Mockito.mock(PositionInterface.class);
        element = new Element(position) {
            @Override
            public void draw(TextGraphics screen) {
            }
        };
    }

    @Test
    public void setPositionTest() {
        PositionInterface newPosition = Mockito.mock(Position.class);
        element.setPosition(newPosition);
        assertEquals(element.getPosition(), newPosition);
    }

    @Test
    public void GetPositionTest() {
        ElementInterface element = new Element(position) {
            @Override
            public void draw(TextGraphics screen) {
            }
        };
        PositionInterface newPosition = element.getPosition();
        assertEquals(newPosition, position);

    }
}
