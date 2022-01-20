package menuTest;

import com.googlecode.lanterna.screen.Screen;
import game.Game;
import game.GameInterface;
import menu.submenu.VictoryMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

public class VictoryMenuTest {
    private GameInterface game;
    private Screen screen;
    private VictoryMenu menu;


    @BeforeEach
    public void helper() throws IOException {
        game = new Game();
        screen = mock(Screen.class);
        game.initialize();
        menu = new VictoryMenu(game, screen);
    }

    @Test
    public void constructorTest() {
        assertTrue(menu != null);
    }

    @Test
    public void defaultTextTest() {
        assertEquals(menu.getText(), "VICTORY!!@@@@SCORE " + game.getPointsHandler().getPoints().toString() + "@");
    }

}
