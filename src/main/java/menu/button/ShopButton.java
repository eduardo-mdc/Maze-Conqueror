package menu.button;

import element.position.PositionInterface;
import game.GameInterface;
import menu.Button;

public class ShopButton extends Button {
    private GameInterface game;

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
