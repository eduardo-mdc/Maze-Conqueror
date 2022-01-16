import game.Game;
import game.GameInterface;
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

}

