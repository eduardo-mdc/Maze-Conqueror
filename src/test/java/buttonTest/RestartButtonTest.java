package buttonTest;

import element.position.Position;
import element.position.PositionInterface;
import game.Game;
import game.GameInterface;
import menu.ButtonInterface;
import menu.button.RestartButton;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class RestartButtonTest {
    private ButtonInterface restartButton;
    private GameInterface game;
    private PositionInterface position;

    @BeforeEach
    public void helper() {
        game = new Game();
        position = new Position(3, 5);
        restartButton = new RestartButton(game, position);
    }

    @Test
    public void constructorTest() {
        ButtonInterface restartButtonTemp = new RestartButton(game, position);
        assertTrue(restartButtonTemp != null);
        assertTrue(restartButton != null);
    }

    @Test
    public void executeTest() {
        //set game state to the value of 4
        assertEquals(game.getState(), 0);
        restartButton.execute();
        assertEquals(game.getState(), 4);
    }
}