package menu.button;

import element.position.PositionInterface;
import game.GameInterface;
import menu.Button;

public class InstructionsButton extends Button {
    private GameInterface game;

    public InstructionsButton(GameInterface game, PositionInterface position) {
        super(position);
        this.game = game;
        setText("INSTRUCTIONS");

    }

    @Override
    public void execute() {
        game.setState(2);
    }
}
