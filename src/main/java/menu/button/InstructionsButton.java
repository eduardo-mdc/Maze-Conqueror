package menu.button;

import element.position.Position;
import game.Game;
import menu.Action;
import menu.Button;

public class InstructionsButton extends Button implements Action {
    private Game game;
    public InstructionsButton(Game game,Position position) {
        super(position);
        this.game = game;
    }

    @Override
    public void execute() {
        game.setState(2);
    }
}
