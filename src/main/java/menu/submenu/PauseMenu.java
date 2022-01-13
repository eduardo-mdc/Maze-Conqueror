package menu.submenu;


import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import element.position.Position;
import game.Game;
import menu.Button;
import menu.Menu;
import menu.button.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PauseMenu extends Menu {
    private final int xIncr = 10;
    private final int yIncr = 20;

    public PauseMenu(Game game, Screen screen) throws IOException {
        super(game,screen);
        btn = Arrays.asList(
                new ResumeButton(game,new Position(xIncr,yIncr)),
                new RestartButton(game,new Position(xIncr,yIncr+5)),
                new MainMenuButton(game,new Position(xIncr,yIncr+10))
        );
    }
}
