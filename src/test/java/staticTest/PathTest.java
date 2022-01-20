package staticTest;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.graphics.TextGraphics;
import element.Static.Path;
import element.position.PositionInterface;
import net.jqwik.api.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class PathTest {
    private Path path;
    private PositionInterface position;

    @BeforeEach
    public void helper() {
        position = mock(PositionInterface.class);
        path = mock(Path.class);
    }

    @Property
    public void constructorTest(@ForAll("lengthOne") String character) {
        Path pathTemp = new Path(position, "RED", SGR.BOLD, character);
        assertTrue(pathTemp != null);
    }

    @Provide
    Arbitrary<String> lengthOne() {
        return Arbitraries.strings().ofMaxLength(1);
    }

    @Test
    public void verifyDrawTest() {
        TextGraphics graphics = mock(TextGraphics.class);
        path.draw(graphics);
        verify(path, times(1)).draw(graphics);
    }

}
