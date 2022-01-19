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
        loadWalls();
        text = "TO WIN YOU MUST REACH@THE TROPHY AT THE END";
        splitText("@",xIncr,yIncr);

        texts = Arrays.asList(
                new TextMenuElement(new Position(xIncr,yIncr-10),"HERO ASPIRES TO BE THE BEST TREASURE HUNTER "),
                new TextMenuElement(new Position(xIncr,yIncr-8),"IN THE WORLD!!"),
                new TextMenuElement(new Position(xIncr,yIncr-6),"YOUR JOB IS TO HELP HIM COLLECT"),
                new TextMenuElement(new Position(xIncr,yIncr-4),"ALL THE TROPHIES POSSIBLE"),
                new TextMenuElement(new Position(xIncr,yIncr-1),"CONTROLS:"),
                new TextMenuElement(new Position(xIncr,yIncr+1),"ARROWS:"),
                new TextMenuElement(new Position(xIncr+10,yIncr+1),"MOVE HERO"),
                new TextMenuElement(new Position(xIncr,yIncr+3),"ENTER:"),
                new TextMenuElement(new Position(xIncr+10,yIncr+3),"DROP BOMB"),
                new TextMenuElement(new Position(xIncr,yIncr+5),"ESC:"),
                new TextMenuElement(new Position(xIncr+10,yIncr+5),"PAUSE MENU"),
                new TextMenuElement(new Position(xIncr,yIncr+8),"GAME MECHANICS"),
                new TextMenuElement(new Position(xIncr,yIncr+10),"EVERY TIME HERO DISCOVERS A NEW TILE HE GETS "),
                new TextMenuElement(new Position(xIncr,yIncr+12),"POINTS. COINS CAN ALSO BE FOUND AND GIVE"),
                new TextMenuElement(new Position(xIncr,yIncr+14),"HERO EXTRA AMOUNTS OF POINTS."),
                new TextMenuElement(new Position(xIncr,yIncr+16),"AS HERO MOVES HE MARKS THE FLOOR AFTER SOME"),
                new TextMenuElement(new Position(xIncr,yIncr+18),"TIME THIS PATH BECOMES HARMFUL."),
                new TextMenuElement(new Position(xIncr,yIncr+20),"TAKING DAMAGE OR WASTING TOO MUCH TIME CAN"),
                new TextMenuElement(new Position(xIncr,yIncr+22),"MAKING HIM LOSE POINTS."),
                new TextMenuElement(new Position(xIncr,yIncr+24),"THE MAZES ALSO FEATURE PORTALS THAT CAN LEAD"),
                new TextMenuElement(new Position(xIncr,yIncr+26),"TO STRATEGIC MOVES TO SAVE TIME AND POINTS"),
                new TextMenuElement(new Position(xIncr,yIncr+28),"EVERYTIME HERO GETS A TROPHY HE GETS AN"),
                new TextMenuElement(new Position(xIncr,yIncr+30),"OPPORTUNITY TO GO BACK HOME OR TO TRADE POINTS"),
                new TextMenuElement(new Position(xIncr,yIncr+32),"IN THE SHOP FOR ITEMS TO AID HIS ADVENTURE.")
                );

        btn = Arrays.asList(
                new MainMenuButton(game,new Position(xIncr+36,yIncr+35))
        );
    }
}
