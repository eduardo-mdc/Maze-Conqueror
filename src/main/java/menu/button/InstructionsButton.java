package menu.button;

import element.position.Position;
import game.Game;
import menu.Button;
import menu.ButtonInterface;

public class InstructionsButton extends Button {
    private Game game;
    public InstructionsButton(Game game,Position position) {
        super(position);
        this.game = game;
        setText("INSTRUCTIONS");
    }

    @Override
    public void execute() {
        game.setState(2);
    }
}
