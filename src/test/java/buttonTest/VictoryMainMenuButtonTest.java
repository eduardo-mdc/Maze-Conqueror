package buttonTest;

import element.position.Position;
import element.position.PositionInterface;
import game.Game;
import game.GameInterface;
import menu.ButtonInterface;
import menu.button.VictoryMainMenuButton;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VictoryMainMenuButtonTest {
    private ButtonInterface victoryButton;
    private GameInterface game;
    private PositionInterface position;

    @BeforeEach
    public void helper() {
        game = new Game();
        position = new Position(3, 5);
        game.initialize();
        victoryButton = new VictoryMainMenuButton(game, position);
    }

    @Test
    public void constructorTest() {
        ButtonInterface victoryButtonTemp = new VictoryMainMenuButton(game, position);
        assertTrue(victoryButtonTemp != null);
        assertTrue(victoryButton != null);
    }

    @Test
    public void setTextTest() {
        assertEquals(victoryButton.getText(), "MAIN MENU");
    }

    @Test
    public void executeTest() {
        //set game state to the value of 2
        assertEquals(game.getState(), 0);
        victoryButton.execute();
        assertEquals(game.getState(), 0);
    }
}
