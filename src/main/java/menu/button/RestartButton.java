package menu.button;

import element.position.PositionInterface;
import game.GameInterface;
import menu.Button;

/**
 * Class used to create the Main Menu button. This button is used to restart the game.
 */
public class RestartButton extends Button {
    private GameInterface game;

    /**
     * Constructor for this button, receives a game to interact with and a position to create the button
     * @param game game to interact with
     * @param position position to create the button
     */
    public RestartButton(GameInterface game, PositionInterface position) {
        super(position);
        this.game = game;
        setText("RESTART");
    }

    @Override
    public void execute() {
        game.setState(4);
    }
}
