package menu.submenu;


import com.googlecode.lanterna.screen.Screen;
import element.position.Position;
import game.Game;
import menu.Menu;
import menu.button.*;

import java.io.IOException;
import java.util.Arrays;

public class InstructionsMenu extends Menu {
    private final int xIncr;
    private final int yIncr;

    public InstructionsMenu(Game game, Screen screen) throws IOException {
        super(game, screen);
        xIncr = 3;
        yIncr = 13;
        getTextList().add(new TextMenuElement(new Position(xIncr, yIncr - 10), "HERO ASPIRES TO BE THE BEST TREASURE HUNTER "));
        getTextList().add(new TextMenuElement(new Position(xIncr, yIncr - 8), "IN THE WORLD!"));
        getTextList().add(new TextMenuElement(new Position(xIncr, yIncr - 6), "YOUR JOB IS FINISHING MAZES AND COLLECTING"));
        getTextList().add(new TextMenuElement(new Position(xIncr, yIncr - 4), "THE MOST AMOUNT OF TROPHIES AS POSSIBLE"));
        getTextList().add(new TextMenuElement(new Position(xIncr, yIncr - 1), "CONTROLS:"));
        getTextList().add(new TextMenuElement(new Position(xIncr, yIncr + 1), "ARROWS:"));
        getTextList().add(new TextMenuElement(new Position(xIncr + 10, yIncr + 1), "MOVE HERO"));
        getTextList().add(new TextMenuElement(new Position(xIncr, yIncr + 1), "ARROWS:"));
        getTextList().add(new TextMenuElement(new Position(xIncr, yIncr + 3), "B:"));
        getTextList().add(new TextMenuElement(new Position(xIncr + 10, yIncr + 3), "DROP BOMB"));
        getTextList().add(new TextMenuElement(new Position(xIncr, yIncr + 5), "ESC:"));
        getTextList().add(new TextMenuElement(new Position(xIncr + 10, yIncr + 5), "PAUSE MENU"));
        getTextList().add(new TextMenuElement(new Position(xIncr, yIncr + 8), "GAME MECHANICS"));
        getTextList().add(new TextMenuElement(new Position(xIncr, yIncr + 10), "EVERY TIME HERO DISCOVERS A NEW TILE HE GETS "));
        getTextList().add(new TextMenuElement(new Position(xIncr, yIncr + 12), "POINTS. COINS CAN ALSO BE FOUND AND GIVE"));
        getTextList().add(new TextMenuElement(new Position(xIncr, yIncr + 14), "HERO EXTRA POINTS."));
        getTextList().add(new TextMenuElement(new Position(xIncr, yIncr + 16), "AS HERO MOVES HE TRAILS HIS PATH AND AFTER "));
        getTextList().add(new TextMenuElement(new Position(xIncr, yIncr + 18), "SOME TIME IT BECOMES HARMFUL."));
        getTextList().add(new TextMenuElement(new Position(xIncr, yIncr + 20), "TAKING DAMAGE OR BEING WASTEFUL WITH TIME "));
        getTextList().add(new TextMenuElement(new Position(xIncr, yIncr + 22), "MAKES HIM LOSE POINTS."));
        getTextList().add(new TextMenuElement(new Position(xIncr, yIncr + 24), "THE MAZE HAS RANDOM PORTALS THAT TELEPORT"));
        getTextList().add(new TextMenuElement(new Position(xIncr, yIncr + 26), "HIM TO OTHER PORTALS"));
        getTextList().add(new TextMenuElement(new Position(xIncr, yIncr + 28), "WHENEVER HERO FINISHES A MAZE HE GETS AN"));
        getTextList().add(new TextMenuElement(new Position(xIncr, yIncr + 30), "OPPORTUNITY TO FINISH OR TO CONTINUE"));
        getTextList().add(new TextMenuElement(new Position(xIncr, yIncr + 32), "RESTOCK RESOURCES AFTER OBTAINING A TROPHY."));
        setButtonList(Arrays.asList(
                new MainMenuButton(game, new Position(xIncr + 36, yIncr + 35))
        ));
    }
}
