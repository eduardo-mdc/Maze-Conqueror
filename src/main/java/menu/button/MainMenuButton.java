package menu.button;

import element.position.Position;
import game.Game;
import menu.Button;

public class MainMenuButton extends Button{
    private Game game;
    public MainMenuButton(Game game,Position position) {
        super(position);
        this.game = game;
        setText("MAIN MENU");
    }

    @Override
    public void execute() {
        game.restartGame();
        game.setState(0);
    }
}
