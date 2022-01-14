package menu.button;

import element.position.Position;
import game.Game;
import menu.Button;
import menu.ButtonInterface;

public class ExitButton extends Button {
    private Game game;

    public ExitButton(Game game, Position position) {
        super(position);
        this.game = game;
        setText("EXIT");
    }

    @Override
    public void execute() {
        game.setState(3);
    }
}
