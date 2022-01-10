
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;

import game.Game;
import menu.MenuOLD;
import menu.MenuInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;


public class MenuOLDTest {
    private MenuInterface menu;
    private Screen screen;
    private Game game;

    @BeforeEach
    public void helper() throws IOException {
        game = new Game();
        screen = new TerminalScreen(new DefaultTerminalFactory().createTerminal());
        menu = new MenuOLD(game, screen, 0);
    }

    @Test
    public void constructorTest() throws IOException {
        MenuInterface tempMenu = new MenuOLD(game, screen, 0);
        assertTrue(tempMenu != null);
    }

    @Test
    public void getBackGroundColorTest() {
        String defaultColor = menu.getBackGroundColor();
        assertEquals(defaultColor, "#000000");
    }

    @Test
    public void setBackGroundColor() {
        String defaultColor = menu.getBackGroundColor();
        assertEquals(defaultColor, "#000000");
        menu.setBackGroundColor("#9F1414");
        String newColor = menu.getBackGroundColor();
        assertEquals(newColor, "#9F1414");
    }

    @Test
    public void getGameTest() throws IOException {
        MenuInterface tempMenu = new MenuOLD(null, screen, 0);
        assertEquals(tempMenu.getGame(), null);
        assertEquals(menu.getGame(), game);
    }

    @Test
    public void getScreenTest() throws IOException {
        MenuInterface tempMenu = new MenuOLD(null, screen, 0);
        assertFalse(tempMenu.getScreen() == null);
        assertEquals(menu.getScreen(), screen);
    }


}
