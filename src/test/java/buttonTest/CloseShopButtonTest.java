package buttonTest;

import element.position.Position;
import element.position.PositionInterface;
import game.Game;
import game.GameInterface;
import menu.ButtonInterface;
import menu.button.CloseShopButton;
import menu.button.VictoryMainMenuButton;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CloseShopButtonTest {
    private ButtonInterface closeButton;
    private GameInterface game;
    private PositionInterface position;

    @BeforeEach
    public void helper() {
        game = new Game();
        position = new Position(3, 5);
        closeButton = new CloseShopButton(game, position);
    }

    @Test
    public void constructorTest() {
        ButtonInterface closeButtonTemp = new  CloseShopButton(game, position);
        assertTrue(closeButtonTemp != null);
        assertTrue(closeButton != null);
    }

    @Test
    public void setTextTest() {
        assertEquals(closeButton.getText(), "CLOSE");
    }

    @Test
    public void executeTest() {
        //set game state to the value of 9
        assertEquals(game.getState(), 0);
        closeButton.execute();
        assertEquals(game.getState(), 9);
    }
}
