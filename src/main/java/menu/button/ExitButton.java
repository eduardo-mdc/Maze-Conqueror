package menu.button;

import element.position.PositionInterface;
import game.GameInterface;
import menu.Button;

/**
 * Class used to create the exit button. This button is used to exit the application.
 */
public class ExitButton extends Button {
    protected GameInterface game;

    /**
     * Constructor for this button, receives a game to interact with and a position to create the button
     * @param game game to interact with
     * @param position position to create the button
     */
    public ExitButton(GameInterface game, PositionInterface position) {
        super(position);
        this.game = game;
        setText("EXIT");
    }

    @Override
    public void execute() {
        game.setState(3);
    }
}
