package menu.button;

import element.position.PositionInterface;
import game.GameInterface;
import menu.Button;

public class VictoryMainMenuButton extends Button {
    private GameInterface game;

    public VictoryMainMenuButton(GameInterface game, PositionInterface position) {
        super(position);
        this.game = game;
        setText("MAIN MENU");
    }

    @Override
    public void execute() {
        game.getLeaderboard().put(game.getPointsHandler().getPoints());
        game.getLeaderboard().write();
        game.restartGame();
        game.setState(0);
    }
}
