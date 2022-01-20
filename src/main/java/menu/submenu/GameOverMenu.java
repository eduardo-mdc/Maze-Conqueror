package menu.submenu;


import com.googlecode.lanterna.screen.Screen;
import element.position.Position;
import game.GameInterface;
import menu.Menu;
import menu.button.*;

import java.util.Arrays;

public class GameOverMenu extends Menu {
    private final int xIncr;
    private final int yIncr;

    public GameOverMenu(GameInterface game, Screen screen){
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
