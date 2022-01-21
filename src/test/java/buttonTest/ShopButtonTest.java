package buttonTest;

import element.position.Position;
import element.position.PositionInterface;
import game.Game;
import game.GameInterface;
import menu.ButtonInterface;
import menu.button.ShopButton;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShopButtonTest {
    private ButtonInterface shopButton;
    private GameInterface game;
    private PositionInterface position;

    @BeforeEach
    public void helper() {
        game = new Game();
        position = new Position(3, 5);
        game.initialize();
        shopButton = new ShopButton(game, position);
    }

    @Test
    public void constructorTest() {
        ButtonInterface shopButtonTemp = new ShopButton(game, position);
        assertTrue(shopButtonTemp != null);
        assertTrue(shopButton != null);
    }

    @Test
    public void executeTest() {
        //set game state to the value of 8
        assertEquals(game.getState(), 0);
        shopButton.execute();
        assertEquals(game.getState(), 8);
    }

    @Test
    public void setTextTest() {
        assertEquals(shopButton.getText(), "CONTINUE");
    }
}
