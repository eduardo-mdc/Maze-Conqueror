package menu.submenu;


import com.googlecode.lanterna.screen.Screen;
import element.position.Position;
import game.GameInterface;
import menu.Menu;
import menu.button.*;

import java.util.Arrays;

/**
 * Extension of the Menu Class. This class is used to instantiate and create the various elements present on the Game Over menu.
 */
public class GameOverMenu extends Menu {
    private final int xIncr;
    private final int yIncr;

    /**
     * Constructor for the GameOverMenu Class. Receives a game, and a lanterna screen to create objects on.
     * @param game currently instantiated game class.
     * @param screen lanterna screen to draw objects on.
     */
    public GameOverMenu(GameInterface game, Screen screen) {
        super(game, screen);
        xIncr = 20;
        yIncr = 5;
        setText("GAME OVER@");
        splitText("@", xIncr, yIncr);
        setButtonList(Arrays.asList(
                new MainMenuButton(game, new Position(xIncr, yIncr + 5)),
                new ExitButton(game, new Position(xIncr, yIncr + 10))
        ));
    }
}
