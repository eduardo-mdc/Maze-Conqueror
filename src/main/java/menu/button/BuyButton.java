package menu.button;

import element.position.PositionInterface;
import game.GameInterface;
import menu.Button;

/**
 * Class used to create the buy button. This button is used in the shop to buy an item.
 */
public class BuyButton extends Button {
    private GameInterface game;

    private int type;

    /**
     * Constructor for this button, receives a game to interact with, a position to create the button and a type to indicate which item was bought
     * @param game game to interact with
     * @param position position to create the button
     * @param type type to indicate which item was bought
     */
    public BuyButton(GameInterface game, PositionInterface position, int type) {
        super(position);
        this.type = type;
        this.game = game;
        setText("BUY");
    }

    @Override
    public void execute() {
        game.getShopHandler().sell(type);
        game.setState(8);
    }
}
