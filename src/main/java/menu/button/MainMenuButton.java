package menu.button;

import element.position.PositionInterface;
import game.GameInterface;
import menu.Button;

/**
 * Class used to create the Main Menu button. This button is used to open the Main menu.
 */
public class MainMenuButton extends Button {
    protected GameInterface game;

    /**
     * Constructor for this button, receives a game to interact with and a position to create the button
     * @param game game to interact with
     * @param position position to create the button
     */
    public MainMenuButton(GameInterface game, PositionInterface position) {
        super(position);
        this.game = game;
        setText("MAIN MENU");
    }

    @Override
    public void execute() {
        game.restartGame();
        game.setState(0);
    }
}
