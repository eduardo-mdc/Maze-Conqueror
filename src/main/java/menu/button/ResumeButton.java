package menu.button;

import element.position.PositionInterface;
import game.GameInterface;
import menu.Button;

/**
 * Class used to create the Resume button. This button is used to resume the game.
 */
public class ResumeButton extends Button {
    private GameInterface game;

    /**
     * Constructor for this button, receives a game to interact with and a position to create the button
     * @param game game to interact with
     * @param position position to create the button
     */
    public ResumeButton(GameInterface game, PositionInterface position) {
        super(position);
        this.game = game;
        setText("RESUME");
    }

    @Override
    public void execute() {
        game.setState(1);
    }
}
