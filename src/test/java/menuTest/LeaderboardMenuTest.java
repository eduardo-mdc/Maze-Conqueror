package menuTest;

import com.googlecode.lanterna.screen.Screen;
import game.GameInterface;
import menu.MenuInterface;
import menu.submenu.GameOverMenu;
import menu.submenu.LeaderboardMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

public class LeaderboardMenuTest {
    private GameInterface game;
    private Screen screen;
    private LeaderboardMenu menu;


    @BeforeEach
    public void helper() throws IOException {
        game = mock(GameInterface.class);
        screen = mock(Screen.class);
        menu = new LeaderboardMenu(game, screen);
    }

    @Test
    public void constructorTest() {
        assertTrue(menu != null);
    }

    @Test
    public void defaultTextTest() {
        assertEquals(menu.getText(), "GAME OVER@");
    }
}
