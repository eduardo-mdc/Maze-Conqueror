package menu.submenu;


import com.googlecode.lanterna.screen.Screen;
import element.position.Position;
import game.Game;
import menu.Menu;
import menu.button.*;

import java.io.IOException;
import java.util.Arrays;

public class GameOverMenu extends Menu {
    private final int xIncr;
    private final int yIncr;

    public GameOverMenu(Game game, Screen screen) throws IOException {
        super(game, screen);
        xIncr = 20;
        yIncr = 5;
        text = "GAME OVER@";
        splitText("@", xIncr, yIncr);
        setButtonList(Arrays.asList(
                new MainMenuButton(game, new Position(xIncr, yIncr + 5)),
                new ExitButton(game, new Position(xIncr, yIncr + 10))
        ));
    }
}
