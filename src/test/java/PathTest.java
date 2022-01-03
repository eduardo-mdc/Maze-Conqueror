import com.googlecode.lanterna.graphics.TextGraphics;
import element.Static.Path;
import element.position.PositionInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class PathTest {
    private Path path;
    private PositionInterface position;

    @BeforeEach
    public void helper() {
        position = mock(PositionInterface.class);
        path = mock(Path.class);
    }

    @Test
    public void drawTest() {
        TextGraphics graphics = mock(TextGraphics.class);
        path.draw(graphics);
        verify(path, times(1)).draw(graphics);
    }

}
