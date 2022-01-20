package staticTest;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.graphics.TextGraphics;
import element.Static.RedPath;
import element.position.PositionInterface;
import net.jqwik.api.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class RedPathTest {

    private RedPath redPath;
    private PositionInterface position;

    @BeforeEach
    public void helper() {
        position = mock(PositionInterface.class);
        redPath = mock(RedPath.class);
    }

    @Property
    public void constructorTest(@ForAll("lengthOne") String character) {
        RedPath redPath = new RedPath(position, "RED", SGR.BOLD, character);
        assertTrue(redPath != null);
    }

    @Provide
    Arbitrary<String> lengthOne() {
        return Arbitraries.strings().ofMaxLength(1);
    }

    @Test
    public void verifyDrawTest() {
        TextGraphics graphics = mock(TextGraphics.class);
        redPath.draw(graphics);
        verify(redPath, times(1)).draw(graphics);
    }

}
