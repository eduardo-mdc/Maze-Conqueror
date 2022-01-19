package menu.button;

import element.position.PositionInterface;
import game.GameInterface;
import menu.Button;

public class CloseShopButton extends Button {
    private GameInterface game;

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