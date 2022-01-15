package buttonTest;

import element.position.PositionInterface;
import game.GameInterface;
import menu.ButtonInterface;
import menu.button.ExitButton;
import org.junit.jupiter.api.BeforeEach;

public class ExitButtonTest {
    private ButtonInterface exitButton;
    private GameInterface game;
    private PositionInterface position;

    @BeforeEach
    public void helper(){
        exitButton = new ExitButton(game, position);


    }

}
