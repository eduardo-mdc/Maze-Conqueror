package buttonTest;

import element.position.Position;
import element.position.PositionInterface;
import game.Game;
import game.GameInterface;
import menu.ButtonInterface;
import menu.button.ResumeButton;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class ResumeButtonTest {
    private ButtonInterface resumeButton;
    private GameInterface game;
    private PositionInterface position;

    @BeforeEach
    public void helper() {
        game = new Game();
        position = new Position(3, 5);
        resumeButton = new ResumeButton(game, position);
    }

    @Test
    public void constructorTest() {
        ButtonInterface resumeButtonTemp = new ResumeButton(game, position);
        assertTrue(resumeButtonTemp != null);
        assertTrue(resumeButton != null);
    }

    @Test
    public void executeTest() {
        //set game state to the value of 1
        assertEquals(game.getState(), 0);
        resumeButton.execute();
        assertEquals(game.getState(), 1);
    }
}