package buttonTest;

import element.position.Position;
import element.position.PositionInterface;
import game.Game;
import game.GameInterface;
import menu.ButtonInterface;
import menu.button.InstructionsButton;
import menu.button.LeaderboardButton;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LeaderboardButtonTest {
    private ButtonInterface leaderboardButton;
    private GameInterface game;
    private PositionInterface position;

    @BeforeEach
    public void helper() {
        game = new Game();
        position = new Position(3, 5);
        leaderboardButton = new LeaderboardButton(game, position);
    }

    @Test
    public void constructorTest() {
        ButtonInterface leaderboardButtonTemp = new InstructionsButton(game, position);
        assertTrue(leaderboardButtonTemp != null);
        assertTrue(leaderboardButton != null);
    }

    @Test
    public void setTextTest() {
        assertEquals(leaderboardButton.getText(), "LEADERBOARD");
    }

    @Test
    public void executeTest() {
        //set game state to the value of 2
        assertEquals(game.getState(), 0);
        leaderboardButton.execute();
        assertEquals(game.getState(), 10);
    }
}
