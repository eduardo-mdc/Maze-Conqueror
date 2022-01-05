import game.Game;
import game.GameInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
    public void setStateTest() {
        int state = 5;
        game.setState(state);
        assertEquals(5, game.getState());
    }

    @Test
    public void getScreenHTest() {

    }

    @Test
    public void getScreenWTest() {

    }
}

