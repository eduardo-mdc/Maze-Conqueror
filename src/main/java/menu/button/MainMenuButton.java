package menu.button;

import element.position.PositionInterface;
import game.GameInterface;
import menu.Button;

public class MainMenuButton extends Button {
    private GameInterface game;

    public MainMenuButton(GameInterface game, PositionInterface position) {
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
