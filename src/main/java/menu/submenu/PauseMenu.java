package menu.submenu;


import com.googlecode.lanterna.screen.Screen;
import element.position.Position;
import game.GameInterface;
import menu.Menu;
import menu.button.*;

import java.util.Arrays;

/**
 * Extension of the Menu Class. This class is used to instantiate and create the various elements present on the Pause menu.
 */
public class PauseMenu extends Menu {
    private final int xIncr;
    private final int yIncr;

    public PauseMenu(GameInterface game, Screen screen) {
        super(game, screen);
        xIncr = 10;
        yIncr = 20;
        setButtonList(Arrays.asList(
                new ResumeButton(game, new Position(xIncr, yIncr)),
                new RestartButton(game, new Position(xIncr, yIncr + 5)),
                new MainMenuButton(game, new Position(xIncr, yIncr + 10))
        ));
    }
}
