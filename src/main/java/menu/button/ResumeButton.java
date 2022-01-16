package menu.button;

import element.position.Position;
import element.position.PositionInterface;
import game.Game;
import game.GameInterface;
import menu.Button;

public class ResumeButton extends Button {
    private GameInterface game;

    public ResumeButton(GameInterface game, PositionInterface position) {
        super(position);
        this.game = game;
        setText("RESUME");
    }

    @Override
    public void execute() {
        game.setState(1);
    }
}
