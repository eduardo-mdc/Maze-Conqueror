package menu.button;

import element.position.PositionInterface;
import game.GameInterface;
import menu.Button;

/**
 * Class used to create the leaderboard button. This button is used to open the leaderboard menu.
 */
public class LeaderboardButton extends Button {
    private GameInterface game;

    /**
     * Constructor for this button, receives a game to interact with and a position to create the button
     * @param game game to interact with
     * @param position position to create the button
     */
    public LeaderboardButton(GameInterface game, PositionInterface position) {
        super(position);
        this.game = game;
        setText("LEADERBOARD");
    }

    @Override
    public void execute() {
        game.setState(10);
    }
}
