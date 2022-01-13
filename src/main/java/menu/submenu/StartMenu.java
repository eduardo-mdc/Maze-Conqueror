package menu.submenu;


import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import element.position.Position;
import game.Game;
import menu.Button;
import menu.Menu;
import menu.button.ExitButton;
import menu.button.InstructionsButton;
import menu.button.StartButton;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StartMenu extends Menu {
    private Game game;
    private Screen screen;

    private  List<Button> btn;
    private final int xIncr = 10;
    private final int yIncr = 5;

    public StartMenu(Game game, Screen screen) throws IOException {
        super(game,screen);
        btn = new ArrayList<>();
        btn = Arrays.asList(
                new StartButton(game,new Position(xIncr,yIncr)),
                new InstructionsButton(game,new Position(xIncr,yIncr+10)),
                new ExitButton(game,new Position(xIncr,yIncr+20))
        );
    }
}
