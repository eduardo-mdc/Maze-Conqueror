package menu;

import element.Static.StaticElement;
import element.position.Position;
import game.Game;
import menu.button.ExitButton;
import menu.button.InstructionsButton;
import menu.button.StartButton;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Menu {
    private  List<Button> btn = new ArrayList<>();

    public Menu(Game game) throws IOException {
        btn = Arrays.asList(
                new StartButton(game,new Position(1,2),3,4),
                new InstructionsButton(game,new Position(1,2),3,4),
                new ExitButton(game,new Position(1,2),3,4)
        );
    }
}
