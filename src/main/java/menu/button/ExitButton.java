package menu.button;

import element.position.Position;
import element.position.PositionInterface;
import game.Game;
import game.GameInterface;
import menu.Button;
import menu.ButtonInterface;

public class ExitButton extends Button {
    private GameInterface game;

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
