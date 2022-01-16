package menuTest;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import game.Game;
import game.GameInterface;
import menu.Menu;
import menu.MenuInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class MenuTest {
    private MenuInterface menu;
    private Screen screen;
    private GameInterface game;

    @BeforeEach
    public void helper() throws IOException {
        game = new Game();
        screen = new TerminalScreen(new DefaultTerminalFactory().createTerminal());
        menu = new Menu(game, screen);
    }

    @Test
    public void constructorTest() throws IOException {
        MenuInterface tempMenu = new Menu(game, screen);
        assertTrue(tempMenu != null);
        assertTrue(menu != null);
    }

    @Test
    public void getBackGroundColorTest() {
        //The default color is BLACK.
        String defaultColor = menu.getBackGroundColor();
        assertEquals(defaultColor, "BLACK");
    }

    @Test
    public void getGameTest() throws IOException {
        MenuInterface tempMenu = new Menu(game, screen);
        assertEquals(tempMenu.getGame(), game);
        assertEquals(menu.getGame(), game);
    }

    @Test
    public void getScreenTest() throws IOException {
        MenuInterface tempMenu = new Menu(game, null);
        assertEquals(tempMenu.getScreen(), null);
        assertEquals(menu.getScreen(), screen);
    }

    @Test
    public void getButtonListTest() throws IOException {
        assertEquals(menu.getButtonsList().size(), 0);
    }

    @Test
    public void getTextListTest() throws IOException {
        //default walls value
        assertEquals(menu.getTextList().size(), 396);
    }

    @Test
    public void loadWallsTest() {
        assertEquals(menu.getTextList().size(), 396);
        menu.loadWalls();
        assertEquals(menu.getTextList().size(), 396 * 2);
        menu.loadWalls();
        assertEquals(menu.getTextList().size(), 396 * 3);
    }

    @Test
    public void getMiddleTest() {
        String text = menu.getText();
        assertEquals(menu.getMiddle(10, text), 10 / 2);
    }

    @Test
    public void iterateSelectionTest() {
        //default size of the button list is zero.
        assertEquals(menu.getSelected(), 0);
        menu.iterateSelection(-98);
        assertEquals(menu.getSelected(), -1);
        menu.iterateSelection(100);
        assertEquals(menu.getSelected(), 0);
    }

    @Test
    public void verifySelectTest() {
        MenuInterface menuTemp = mock(MenuInterface.class);
        menuTemp.select();
        verify(menuTemp, times(1)).select();
    }

    @Test
    public void splitTextTest() {

    }

    @Test
    public void buttonDrawTest() {

    }

    @Test
    public void textMenuElementDrawTest() {

    }

    @Test
    public void verifyDrawTest() {
        MenuInterface menuTemp = mock(MenuInterface.class);
        menuTemp.draw();
        verify(menuTemp, times(1)).draw();
    }
}
