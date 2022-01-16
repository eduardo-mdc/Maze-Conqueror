package buttonTest;

import element.position.Position;
import element.position.PositionInterface;
import game.Game;
import game.GameInterface;
import menu.ButtonInterface;
import menu.button.StartButton;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StartButtonTest {
    private ButtonInterface startButton;
    private GameInterface game;
    private PositionInterface position;

    @BeforeEach
    public void helper() {
        game = new Game();
        position = new Position(3, 5);
        startButton = new StartButton(game, position);
    }

    @Test
    public void constructorTest() {
        ButtonInterface startButtonTemp = new StartButton(game, position);
        assertTrue(startButtonTemp != null);
        assertTrue(startButton != null);
    }

    @Test
    public void executeTest() {
        //set game state to the value of 1
        assertEquals(game.getState(), 0);
        startButton.execute();
        assertEquals(game.getState(), 1);
    }
}