package menu.submenu;


import com.googlecode.lanterna.screen.Screen;
import element.position.Position;
import game.GameInterface;
import menu.Menu;
import menu.button.*;

import java.io.IOException;
import java.util.Arrays;

public class VictoryMenu extends Menu {
    private final int xIncr;
    private final int yIncr;

    public VictoryMenu(GameInterface game, Screen screen) throws IOException {
        super(game, screen);
        xIncr = 20;
        yIncr = 5;
        setText("VICTORY!!@@@@SCORE " + game.getPointsHandler().getPoints().toString() + "@");
        splitText("@", xIncr, yIncr);
        setButtonList(Arrays.asList(
                new ShopButton(game, new Position(xIncr, yIncr + 15)),
                new VictoryMainMenuButton(game, new Position(xIncr, yIncr + 20)),
                new ExitButton(game, new Position(xIncr, yIncr + 25)))
        );
        getTextList().add(new TextMenuElement(new Position(3, 48), "YOUR HERO ID IS : HERO" + game.getHeroID()));
    }
}
