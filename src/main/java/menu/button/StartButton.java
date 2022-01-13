package menu.button;

import element.position.Position;
import game.Game;
import menu.Action;
import menu.Button;

public class StartButton extends Button implements Action {
    private Game game;
    public StartButton(Game game,Position position) {
        super(position);
        this.game = game;
        setText("START");
    }

    @Override
    public void execute() {
        game.setState(1);
    }
}