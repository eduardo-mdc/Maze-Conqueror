package menu.button;

import element.position.PositionInterface;
import game.GameInterface;
/**
 * Class used to create the Victory Exit button. This button is used to exit after the game has been completed. This also writes to the leaderboard.
 */
public class VictoryExitButton extends ExitButton{
    /**
     * Constructor for this button, receives a game to interact with and a position to create the button
     * @param game game to interact with
     * @param position position to create the button
     */
    public VictoryExitButton(GameInterface game, PositionInterface position){
        super(game, position);
    }

    @Override
    public void execute() {
        game.getLeaderboard().put(game.getPointsHandler().getPoints());
        game.getLeaderboard().write();
        game.setState(3);
    }
}
