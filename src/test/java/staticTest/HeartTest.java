package staticTest;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.graphics.TextGraphics;
import element.Static.Bomb;
import element.Static.Heart;
import element.position.PositionInterface;
import net.jqwik.api.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class HeartTest {
    private Heart heart;
    private PositionInterface position;

    @BeforeEach
    public void helper() {
        position = mock(PositionInterface.class);
        heart = mock(Heart.class);
    }

    @Property
    public void constructorTest(@ForAll("lengthOne") String character) {
        heart = new Heart(position, "#FF0000", SGR.BOLD, character);
        assertTrue(heart != null);
    }

    @Provide
    Arbitrary<String> lengthOne() {
        return Arbitraries.strings().ofMaxLength(1);
    }

    @Test
    public void verifyDrawTest() {
        TextGraphics graphics = mock(TextGraphics.class);
        heart.draw(graphics);
        verify(heart, times(1)).draw(graphics);
    }

}
