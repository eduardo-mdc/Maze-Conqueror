package menu.button;

import element.position.Position;
import game.Game;
import menu.Action;
import menu.Button;

public class ResumeButton extends Button implements Action {
    private Game game;
    public ResumeButton(Game game,Position position) {
        super(position);
        this.game = game;
        setText("RESUME");
    }

    @Override
    public void execute() {
        game.setState(1);
    }
}