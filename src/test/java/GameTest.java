import game.Game;
import game.GameInterface;
import handler.PointsHandler;
import menu.submenu.*;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.Positive;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class GameTest {
    private GameInterface game;

    @BeforeEach
    public void helper() {
        game = new Game();
    }

    @Test
    public void constructorTest() {
        GameInterface tempGame = new Game();
        assertTrue(tempGame != null);
        assertTrue(game != null);
    }

    @Test
    public void setInitializeTest() {
        boolean init = true;
        game.setInitialize(init);
        assertEquals(true, game.getInitialized());

    }

    @Test
    public void getMenuTest() {
        GameInterface tempGame = new Game();
        assertTrue(null == tempGame.getMenu());
    }

    @Test
    public void setStateTest() {
        int state = 5;
        game.setState(state);
        assertEquals(5, game.getState());
    }

    @Test
    public void setCurrentHpTest() {
        int health = 10;
        game.setCurrentHP(health);
        assertEquals(health, game.getCurrentHP());
    }

    @Test
    public void getCurrentHpTest() {
        //default current is zero
        assertEquals(0, game.getCurrentHP());
    }

    @Test
    public void getScreenHTest() {
        game.setDimension(3, 0, 0);
        assertEquals(3, game.getScreenH());
    }

    @Test
    public void getScreenWTest() {
        game.setDimension(0, 3, 0);
        assertEquals(3, game.getScreenW());
    }

    @Test
    public void getPointsHandlerTest() {
        assertEquals(game.getPointsHandler(), null);
        game.initialize();
        assertTrue(game.getPointsHandler() != null);
    }

    @Test
    public void incrementHeroHpTest() {
        game.initialize();
        game.incrementHeroHp(3);
        assertEquals(5, game.getMaze().getActualHeroHp());
    }

    @Test
    public void getBombsHandlerTest() {
        assertEquals(game.getBombsHandler(), null);
        game.initialize();
        assertTrue(game.getBombsHandler() != null);
    }

    @Test
    public void restartGameStateTest() {
        int restartState = 1;
        game.restartGame();
        assertEquals(restartState, game.getState());
    }

    @Test
    public void restartGameInitializedTest() {
        boolean restartInitialized = false;
        game.restartGame();
        assertEquals(restartInitialized, game.getInitialized());
    }

    @Test
    public void verifyQuitTest() throws IOException {
        GameInterface tempGame = mock(GameInterface.class);
        doNothing().when(tempGame).quit(0);
        tempGame.quit(0);
        verify(tempGame, times(1)).quit(0);
    }

    @Test
    public void loadGameTest() throws IOException {
        assertFalse(game.getInitialized());
        game.runGame();
        assertTrue(game.getInitialized());
    }

    @Test
    public void loadInitialMenuTest() throws IOException {
        assertFalse(game.getMenu() instanceof StartMenu);
        game.loadInitialMenu();
        assertTrue(game.getMenu() instanceof StartMenu);
        assertEquals(game.getState(), 6);
    }

    @Test
    public void loadGameOverMenuTest() throws IOException {
        assertFalse(game.getMenu() instanceof GameOverMenu);
        game.loadGameOverMenu();
        assertTrue(game.getMenu() instanceof GameOverMenu);
        assertEquals(game.getState(), 6);
    }

    @Test
    public void loadVictoryMenuTest() throws IOException {
        assertFalse(game.getMenu() instanceof VictoryMenu);
        game.initialize();
        game.loadVictoryMenu();
        assertTrue(game.getMenu() instanceof VictoryMenu);
        assertEquals(game.getState(), 6);
    }

    @Test
    public void loadInstructionsMenuTest() throws IOException {
        assertFalse(game.getMenu() instanceof InstructionsMenu);
        game.loadInstructionsMenu();
        assertTrue(game.getMenu() instanceof InstructionsMenu);
        assertEquals(game.getState(), 6);
    }

    @Test
    public void winGameTest() {
        assertTrue(game.getState() != 7);
        game.winGame();
        assertTrue(game.getState() == 7);
    }

    @Test
    public void gameOverTest() {
        assertTrue(game.getState() != 5);
        game.gameOver();
        assertTrue(game.getState() == 5);
    }

    @Test
    public void restartGameTest() {
        assertTrue(game.getState() != 1);
        game.restartGame();
        assertTrue(game.getState() == 1);
        assertEquals(game.getInitialized(), false);
    }

    @Test
    public void unlockShopTest() {
        game.initialize();
        int num = game.getShopHandler().getTotalItems();
        game.unlockShop();
        assertEquals(game.getShopHandler().getTotalItems(), num + 1);
    }

    @Test
    public void loadShopTest() throws IOException {
        game.initialize();
        assertFalse(game.getMenu() instanceof ShopMenu);
        game.loadShop();
        assertTrue(game.getMenu() instanceof ShopMenu);
        assertEquals(6, game.getState());
    }

    @Test
    public void loadLeaderboardMenuTest() throws IOException {
        assertFalse(game.getMenu() instanceof LeaderboardMenu);
        game.loadLeaderboardMenu();
        assertTrue(game.getMenu() instanceof LeaderboardMenu);
        assertEquals(6, game.getState());
    }

    @Test
    public void nextMapTest() {
        game.initialize();
        game.nextMap();
        int num = (int) (game.getLevelHandler().getLevel() * 0.3);
        assertEquals(num, game.getDecrease());
        assertEquals(game.getState(), 1);
    }
}

