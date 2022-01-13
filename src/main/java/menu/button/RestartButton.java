package menu.button;

import element.position.Position;
import game.Game;
import menu.Action;
import menu.Button;

public class RestartButton extends Button implements Action {
    private Game game;
    public RestartButton(Game game,Position position) {
        super(position);
        this.game = game;
        setText("RESTART");
    }

    @Override
    public void execute() {
        game.setState(4);
    }
}
