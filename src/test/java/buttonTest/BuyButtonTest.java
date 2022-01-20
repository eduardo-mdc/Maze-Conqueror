package buttonTest;

import element.position.Position;
import element.position.PositionInterface;
import game.Game;
import game.GameInterface;
import menu.ButtonInterface;
import menu.button.BuyButton;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BuyButtonTest {
    private ButtonInterface buyButton;
    private GameInterface game;
    private PositionInterface position;

    @BeforeEach
    public void helper() {
        game = new Game();
        position = new Position(3, 5);
        game.initialize();
        buyButton = new BuyButton(game, position, 1);
    }

    @Test
    public void constructorTest() {
        ButtonInterface buyButtonTemp = new BuyButton(game, position, 1);
        assertTrue(buyButtonTemp != null);
        assertTrue(buyButton != null);
    }

    @Test
    public void setTextTest() {
        assertEquals(buyButton.getText(), "BUY");
    }

    @Test
    public void executeTest() {
        //set game state to the value of 2
        assertEquals(game.getState(), 0);
        buyButton.execute();
        assertEquals(game.getState(), 8);
    }
}
