package menu.submenu;

import com.googlecode.lanterna.screen.Screen;
import element.position.Position;
import game.GameInterface;
import menu.Menu;
import menu.button.MainMenuButton;

import java.util.Arrays;

/**
 * Extension of the Menu Class. This class is used to instantiate and create the various elements present on the Leaderboard menu.
 */
public class LeaderboardMenu extends Menu {
    private final int xIncr;
    private final int yIncr;
    private String[] finalText;

    /**
     * Constructor for the Leaderboard Class. Receives a game, and a lanterna screen to create objects on.
     * @param game currently instantiated game class.
     * @param screen lanterna screen to draw objects on.
     */
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
            getTextList().add(new TextMenuElement(new Position(xIncr + 12, yIncr + 3 + i * 2), value.toString()));
        }

        setButtonList(Arrays.asList(
                new MainMenuButton(game, new Position(xIncr + 35, yIncr + 35))
        ));
    }

    /**
     * Function that returns the number of elements that should be represented on the leaderboard.
     * @return number of elements that should be shown.
     */
    public int maxOccur() {
        if (finalText.length < 2) {
            return 0;
        }
        return Math.min(finalText.length, 10);
    }
}
