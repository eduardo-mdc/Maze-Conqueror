package menu.submenu;

import com.googlecode.lanterna.screen.Screen;
import element.position.Position;
import game.Game;
import game.GameInterface;
import menu.Menu;
import menu.button.MainMenuButton;

import java.io.IOException;
import java.util.Arrays;

public class LeaderboardMenu extends Menu {
    private final int xIncr = 3;
    private final int yIncr = 13;

    public LeaderboardMenu(Game game, Screen screen) throws IOException {
        super(game,screen);
        loadWalls();
        text = "LEADERBOARD@";
        splitText("@", xIncr, yIncr-2);


        texts = Arrays.asList(
                new TextMenuElement(new Position(xIncr,yIncr),"HERO ASPIRES TO BE THE BEST TREASURE HUNTER ")
        );

        btn = Arrays.asList(
                new MainMenuButton(game,new Position(xIncr+36,yIncr+35))
        );
    }
}
