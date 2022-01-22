package menu.button;

import element.position.PositionInterface;
import game.GameInterface;
import menu.Button;

public class BuyButton extends Button {
    private GameInterface game;

    private int type;
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
