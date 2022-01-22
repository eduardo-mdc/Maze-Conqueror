package menu.button;

import element.position.PositionInterface;
import game.GameInterface;
import menu.Button;

public class StartButton extends Button {
    private GameInterface game;

    public StartButton(GameInterface game, PositionInterface position) {
        super(position);
        this.game = game;
        setText("START");
    }

    @Override
    public void execute() {
        game.setState(1);
    }
}
