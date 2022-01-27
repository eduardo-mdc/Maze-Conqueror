package menu.button;

import element.position.PositionInterface;
import game.GameInterface;
import menu.Button;

public class ExitButton extends Button {
    protected GameInterface game;

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
