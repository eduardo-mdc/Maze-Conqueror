package menu.submenu;

import com.googlecode.lanterna.screen.Screen;
import element.position.Position;
import game.GameInterface;
import menu.Menu;
import menu.button.MainMenuButton;

import java.util.Arrays;


public class LeaderboardMenu extends Menu {
    private final int xIncr;
    private final int yIncr;
    private String[] finalText;

    public LeaderboardMenu(GameInterface game, Screen screen) {
        super(game, screen);
        xIncr = 3;
        yIncr = 13;
        loadWalls();
        setText("LEADERBOARD@");
        splitText("@", xIncr + 15, yIncr - 4);

        String notText = game.getLeaderboard().toString();
        finalText = notText.split("\n");

        for (int i = 0; i < maxOccur(); i++) {
            Integer value = i + 1;
            getTextList().add(new TextMenuElement(new Position(xIncr + 15, yIncr + 3 + i * 2), finalText[i]));
            getTextList().add(new TextMenuElement(new Position(xIncr + 13, yIncr + 3 + i * 2), value.toString()));
        }

        setButtonList(Arrays.asList(
                new MainMenuButton(game, new Position(xIncr + 35, yIncr + 35))
        ));
    }

    private int maxOccur() {
        if (finalText.length < 2) {
            return 0;
        }
        return Math.min(finalText.length, 10);
    }
}
