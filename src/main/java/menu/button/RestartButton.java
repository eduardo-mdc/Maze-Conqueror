package menu.button;

import element.position.PositionInterface;
import game.GameInterface;
import menu.Button;

public class RestartButton extends Button {
    private GameInterface game;

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
