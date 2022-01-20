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

public class InstructionsMenu extends Menu {
    private final int xIncr = 3;
    private final int yIncr = 13;

    public InstructionsMenu(Game game, Screen screen) throws IOException {
        super(game,screen);

        texts .add(new TextMenuElement(new Position(xIncr,yIncr-10),"HERO ASPIRES TO BE THE BEST TREASURE HUNTER "));
        texts .add( new TextMenuElement(new Position(xIncr,yIncr-8),"IN THE WORLD!"));
        texts .add(   new TextMenuElement(new Position(xIncr,yIncr-6),"YOUR JOB IS FINISHING MAZES AND COLLECTING"));
        texts .add(new TextMenuElement(new Position(xIncr,yIncr-4),"THE MOST AMOUNT OF TROPHIES AS POSSIBLE"));
        texts .add(new TextMenuElement(new Position(xIncr,yIncr-1),"CONTROLS:"));
        texts .add(new TextMenuElement(new Position(xIncr,yIncr+1),"ARROWS:"));
        texts .add(new TextMenuElement(new Position(xIncr+10,yIncr+1),"MOVE HERO"));
        texts .add(new TextMenuElement(new Position(xIncr,yIncr+1),"ARROWS:"));
        texts .add(new TextMenuElement(new Position(xIncr,yIncr+3),"B:"));
        texts .add(new TextMenuElement(new Position(xIncr+10,yIncr+3),"DROP BOMB"));
        texts .add(new TextMenuElement(new Position(xIncr,yIncr+5),"ESC:"));
        texts .add(new TextMenuElement(new Position(xIncr+10,yIncr+5),"PAUSE MENU"));
        texts .add(new TextMenuElement(new Position(xIncr,yIncr+8),"GAME MECHANICS"));
        texts .add(new TextMenuElement(new Position(xIncr,yIncr+10),"EVERY TIME HERO DISCOVERS A NEW TILE HE GETS "));
        texts .add(new TextMenuElement(new Position(xIncr,yIncr+12),"POINTS. COINS CAN ALSO BE FOUND AND GIVE"));
        texts .add(new TextMenuElement(new Position(xIncr,yIncr+14),"HERO EXTRA POINTS."));
        texts .add(new TextMenuElement(new Position(xIncr,yIncr+16),"AS HERO MOVES HE TRAILS HIS PATH AND AFTER "));
        texts .add(new TextMenuElement(new Position(xIncr,yIncr+18),"SOME TIME IT BECOMES HARMFUL."));
        texts .add(new TextMenuElement(new Position(xIncr,yIncr+20),"TAKING DAMAGE OR BEING WASTEFUL WITH TIME "));
        texts .add(new TextMenuElement(new Position(xIncr,yIncr+22),"MAKES HIM LOSE POINTS."));
        texts .add(new TextMenuElement(new Position(xIncr,yIncr+24),"THE MAZE HAS RANDOM PORTALS THAT TELEPORT"));
        texts .add(new TextMenuElement(new Position(xIncr,yIncr+26),"HIM TO OTHER PORTALS"));
        texts .add(new TextMenuElement(new Position(xIncr,yIncr+28),"WHENEVER HERO FINISHES A MAZE HE GETS AN"));
        texts .add(new TextMenuElement(new Position(xIncr,yIncr+30),"OPPORTUNITY TO FINISH OR TO CONTINUE"));
        texts .add(new TextMenuElement(new Position(xIncr,yIncr+32),"RESTOCK RESOURCES AFTER OBTAINING A TROPHY."));

        btn = Arrays.asList(
                new MainMenuButton(game,new Position(xIncr+36,yIncr+35))
        );
    }
}
