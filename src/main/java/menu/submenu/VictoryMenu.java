package menu.submenu;


import com.googlecode.lanterna.screen.Screen;
import element.position.Position;
import game.GameInterface;
import menu.Menu;
import menu.button.*;

import java.io.IOException;
import java.util.Arrays;
/**
 * Extension of the Menu Class. This class is used to instantiate and create the various elements present on the Victory menu.
 */
public class VictoryMenu extends Menu {
    private final int xIncr;
    private final int yIncr;


    /**
     * Constructor for the VictoryMenu Class. Receives a game, and a lanterna screen to create objects on.
     * @param game currently instantiated game class.
     * @param screen lanterna screen to draw objects on.
     */
    public VictoryMenu(GameInterface game, Screen screen) throws IOException {
        super(game, screen);
        xIncr = 20;
        yIncr = 5;
        setText("VICTORY!!@@@@SCORE " + game.getPointsHandler().getPoints().toString() + "@");
        splitText("@", xIncr, yIncr);
        setButtonList(Arrays.asList(
                new ShopButton(game, new Position(xIncr, yIncr + 15)),
                new VictoryMainMenuButton(game, new Position(xIncr, yIncr + 20)),
                new VictoryExitButton(game, new Position(xIncr, yIncr + 25)))
        );
        getTextList().add(new TextMenuElement(new Position(3, 48), "YOUR HERO ID IS : HERO" + game.getHeroID()));
    }
}
