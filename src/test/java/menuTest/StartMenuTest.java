package menuTest;

import com.googlecode.lanterna.screen.Screen;
import game.GameInterface;
import menu.submenu.StartMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

public class StartMenuTest {

    private GameInterface game;
    private Screen screen;
    private StartMenu menu;


    @BeforeEach
    public void helper() {
        game = mock(GameInterface.class);
        screen = mock(Screen.class);
        menu = new StartMenu(game, screen);
    }

    @Test
    public void constructorTest() {
        assertTrue(menu != null);
    }

    @Test
    public void listUpdatedTest() {
        assertTrue(menu.getButtonsList().size() > 0);
    }

}
