package buttonTest;

import element.position.Position;
import element.position.PositionInterface;
import game.Game;
import game.GameInterface;
import menu.ButtonInterface;
import menu.button.ExitButton;
import menu.button.InstructionsButton;
import menu.button.MainMenuButton;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class InstructionsButtonTest {
    private ButtonInterface instructionsButton;
    private GameInterface game;
    private PositionInterface position;

    @BeforeEach
    public void helper() {
        game = new Game();
        position = new Position(3, 5);
        instructionsButton = new InstructionsButton(game, position);
    }

    @Test
    public void constructorTest() {
        ButtonInterface instructionsButtonTemp = new  InstructionsButton(game, position);
        assertTrue(instructionsButtonTemp != null);
        assertTrue(instructionsButton != null);
    }

    @Test
    public void executeTest() {
        //set game state to the value of 2
        assertEquals(game.getState(), 0);
        instructionsButton.execute();
        assertEquals(game.getState(), 2);
    }

}
