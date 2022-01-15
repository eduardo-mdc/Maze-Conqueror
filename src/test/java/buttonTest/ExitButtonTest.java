package buttonTest;

import element.position.Position;
import element.position.PositionInterface;
import game.Game;
import game.GameInterface;
import menu.ButtonInterface;
import menu.button.ExitButton;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ExitButtonTest {
    private ButtonInterface exitButton;
    private GameInterface game;
    private PositionInterface position;

    @BeforeEach
    public void helper() {
        game = new Game();
        position = new Position(3, 5);
        exitButton = new ExitButton(game, position);
    }

    @Test
    public void constructorTest() {
        ButtonInterface exitButtonTemp = new ExitButton(game, position);
        assertTrue(exitButtonTemp != null);
        assertTrue(exitButton != null);
    }

    @Test
    public void executeTest() {
        //set game state to the value of 3
        assertEquals(game.getState(), 0);
        exitButton.execute();
        assertEquals(game.getState(), 3);
    }

}
