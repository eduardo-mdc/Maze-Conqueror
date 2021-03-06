package staticTest;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.graphics.TextGraphics;
import element.Static.HpBar;
import element.Static.Path;
import element.position.PositionInterface;
import net.jqwik.api.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class HpBarTest {

    private HpBar hpbar;
    private PositionInterface position;

    @BeforeEach
    public void helper() {
        position = mock(PositionInterface.class);
        hpbar = mock(HpBar.class);
    }

    @Test
    public void verifyDrawTest() {
        TextGraphics graphics = mock(TextGraphics.class);
        hpbar.draw(graphics);
        verify(hpbar, times(1)).draw(graphics);
    }

    @Test
    public void constructorTest() {
        HpBar hpBar = new HpBar(position, "#FFFFFF", SGR.BOLD, ".");
        assertTrue(hpBar != null);
    }

    @Property
    public void constructorPropertyTest(@ForAll("lengthOne") String character) {
        Path pathTemp = new Path(position, "RED", SGR.BOLD, character);
        assertTrue(pathTemp != null);
    }

    @Provide
    Arbitrary<String> lengthOne() {
        return Arbitraries.strings().ofMaxLength(1);
    }
}
