package menu.submenu;


import com.googlecode.lanterna.screen.Screen;
import element.position.Position;
import game.Game;
import menu.Menu;
import menu.button.*;

import java.io.IOException;
import java.util.Arrays;

public class VictoryMenu extends Menu {
    private final int xIncr = 20;
    private final int yIncr = 5;

    public VictoryMenu(Game game, Screen screen) throws IOException {
        super(game,screen);
        text = "VICTORY@SCORE " + game.getPointsHandler().getPoints().toString() + "@";
        splitText("@",xIncr,yIncr);
        btn = Arrays.asList(
                new MainMenuButton(game,new Position(xIncr,yIncr+5)),
                new ExitButton(game,new Position(xIncr,yIncr+10))
        );
    }
}
