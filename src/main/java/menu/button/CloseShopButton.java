package menu.button;

import element.position.PositionInterface;
import game.GameInterface;
import menu.Button;

/**
 * Class used to create the close shop button. This button is used in the shop to close the shop and continue the game.
 */
public class CloseShopButton extends Button {
    private GameInterface game;

    /**
     * Constructor for this button, receives a game to interact with and a position to create the button
     * @param game game to interact with
     * @param position position to create the button
     */
    public CloseShopButton(GameInterface game, PositionInterface position) {
        super(position);
        this.game = game;
        setText("CLOSE");
    }

    @Override
    public void execute() {
        game.setState(9);
    }
}