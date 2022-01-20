package menu.submenu;

import com.googlecode.lanterna.screen.Screen;
import element.position.Position;
import game.Game;
import game.GameInterface;
import menu.Menu;
import menu.button.MainMenuButton;

import java.io.IOException;
import java.util.Arrays;

import java.net.DatagramSocket;
import java.net.InetAddress;

public class LeaderboardMenu extends Menu {
    private final int xIncr = 3;
    private final int yIncr = 13;
    private String[] finalText;
    public LeaderboardMenu(Game game, Screen screen) throws IOException {
        super(game,screen);
        loadWalls();
        text = "LEADERBOARD@";
        splitText("@", xIncr+15, yIncr-4);

        String notText = game.getLeaderboard().toString();
        finalText = notText.split("\n");

        for (int i = 0 ; i < maxOccur() ;i++){
            Integer value = i+1;
            texts.add(new TextMenuElement(new Position(xIncr+15,yIncr+3+i*2),finalText[i]));
            texts.add(new TextMenuElement(new Position(xIncr+13,yIncr+3+i*2), value.toString()));
        }

        btn = Arrays.asList(
                new MainMenuButton(game,new Position(xIncr+35,yIncr+35))
        );
    }
    private int maxOccur(){
        if (finalText.length < 2){
            return 0;
        }
        return Math.min(finalText.length, 10);
    }
}
