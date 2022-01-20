package staticTest;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.graphics.TextGraphics;
import element.ElementInterface;
import element.Static.Coin;
import element.position.PositionInterface;
import net.jqwik.api.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class CoinTest {
    private ElementInterface coin;
    private PositionInterface position;

    @BeforeEach
    public void helper() {
        position = mock(PositionInterface.class);
        coin = mock(Coin.class);
    }

    @Test
    public void constructorTest() {
        assertTrue(coin != null);
    }

    @Provide
    Arbitrary<String> lengthOne() {
        return Arbitraries.strings().ofMaxLength(1);
    }

    @Property
    public void constructorTest(@ForAll("lengthOne") String character) {
        ElementInterface coin = new Coin(position, "YELLOW", SGR.BOLD, character);
        assertTrue(coin != null);
    }

    @Test
    public void verifyDrawTest() {
        TextGraphics graphics = mock(TextGraphics.class);
        coin.draw(graphics);
        verify(coin, times(1)).draw(graphics);
    }
}