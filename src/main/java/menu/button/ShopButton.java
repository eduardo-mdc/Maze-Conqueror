package menu.button;

import element.position.PositionInterface;
import game.GameInterface;
import menu.Button;
/**
 * Class used to create the Shop button. This button is used to open the shop.
 */
public class ShopButton extends Button {
    private GameInterface game;
    /**
     * Constructor for this button, receives a game to interact with and a position to create the button
     * @param game game to interact with
     * @param position position to create the button
     */
    public ShopButton(GameInterface game, PositionInterface position) {
        super(position);
        this.game = game;
        setText("CONTINUE");
    }

    @Override
    public void execute() {
        game.getShopHandler().value();
        game.setState(8);
    }
}
