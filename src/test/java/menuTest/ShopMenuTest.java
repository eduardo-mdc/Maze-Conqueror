package menuTest;

import com.googlecode.lanterna.screen.Screen;
import game.Game;
import game.GameInterface;
import menu.submenu.ShopMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

public class ShopMenuTest {
    private GameInterface game;
    private Screen screen;
    private ShopMenu menu;


    @BeforeEach
    public void helper() {
        screen = mock(Screen.class);
        game = new Game();
        game.initialize();
        menu = new ShopMenu(game, screen);
    }

    @Test
    public void constructorTest() {
        assertTrue(menu != null);
    }

    @Test
    public void addToTextListTest() {
        int size = menu.getTextList().size();
        assertEquals(menu.getTextList().size(), size);
        menu.addToTextList();
        assertEquals(menu.getTextList().size(), size + 5);
    }

    @Test
    public void addObjectsTest() {
        int size = menu.getTextList().size();
        int btnSize = menu.getButtonsList().size();
        int totalItems = game.getShopHandler().getTotalItems();
        assertEquals(menu.getTextList().size(), size);
        menu.addObjects();
        assertEquals(menu.getTextList().size(), size + (totalItems * 3));
        assertTrue(menu.getButtonsList().size() > btnSize);
    }
}

