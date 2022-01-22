package menuTest;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import game.Game;
import game.GameInterface;
import menu.ButtonInterface;
import menu.Menu;
import menu.MenuInterface;
import menu.submenu.TextMenuElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MenuTest {
    private MenuInterface menu;
    private Screen screen;
    private GameInterface game;

    @BeforeEach
    public void helper() throws IOException {
        game = new Game();
        screen = mock(Screen.class);
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
        assertEquals(menu.getTextList().size(), 392);
    }

    @Test
    public void loadWallsTest() {
        assertEquals(menu.getTextList().size(), 392);
        menu.loadWalls();
        assertEquals(menu.getTextList().size(), 392 * 2);
        menu.loadWalls();
        assertEquals(menu.getTextList().size(), 392 * 3);
    }

    @Test
    public void getMiddleTest() {
        String text = menu.getText();
        assertEquals(menu.getMiddle(10, text), 10 / 2);
    }

    @Test
    public void iterateSelectionTest() {
        // text list size increments.
        assertEquals(menu.getTextList().size(), 392);
        menu.splitText("some text", 5, 5);
        assertEquals(menu.getTextList().size(), 393);
        menu.splitText("some text", 5, 5);
        assertEquals(menu.getTextList().size(), 394);
    }

    @Test
    public void verifySelectTest() {
        MenuInterface menuTemp = mock(MenuInterface.class);
        menuTemp.select();
        verify(menuTemp, times(1)).select();
    }

    @Test
    public void splitTextTest() {
        assertEquals(menu.getSelected(), 0);
        menu.iterateSelection(-100);
        assertEquals(menu.getSelected(), -1);
        menu.iterateSelection(200);
        assertEquals(menu.getSelected(), 0);
    }

    @Test
    public void verifyButtonDrawTest() {
        int counter = 0;
        MenuInterface menuTemp = mock(MenuInterface.class);
        ButtonInterface button = mock(ButtonInterface.class);
        TextGraphics textgraphics = screen.newTextGraphics();
        menuTemp.buttonDraw(counter, textgraphics);
        verify(button, times(menuTemp.getButtonsList().size())).draw(textgraphics);
        assertEquals(0, menuTemp.getButtonsList().size());
    }

    @Test
    public void textMenuElementDrawTest() {
        TextMenuElement element = mock(TextMenuElement.class);
        MenuInterface menuTemp = mock(MenuInterface.class);
        TextGraphics textgraphics = screen.newTextGraphics();
        menuTemp.textMenuElementDraw(textgraphics);
        verify(element, times(menuTemp.getTextList().size())).draw(textgraphics);
    }

    @Test
    public void verifyDrawTest() {
        MenuInterface menuTemp = mock(MenuInterface.class);
        menuTemp.draw();
        verify(menuTemp, times(1)).draw();
    }
}
