package menu.button;

import element.position.PositionInterface;
import game.GameInterface;
import menu.Button;
import menu.submenu.VictoryMenu;

/**
 * Class used to create the Victory Main Menu button. This button is used to go to the main menu after the game has been completed. This also writes to the leaderboard.
 */
public class VictoryMainMenuButton extends MainMenuButton {
    /**
     * Constructor for this button, receives a game to interact with and a position to create the button
     * @param game game to interact with
     * @param position position to create the button
     */
    public VictoryMainMenuButton(GameInterface game, PositionInterface position) {
        super(game,position);
    }

    @Override
    public void execute() {
        game.getLeaderboard().put(game.getPointsHandler().getPoints());
        game.getLeaderboard().write();
        game.restartGame();
        game.setState(0);
    }
}
