package menu.button;

import element.position.PositionInterface;
import game.GameInterface;
import menu.Button;
import menu.submenu.VictoryMenu;

public class VictoryMainMenuButton extends MainMenuButton {

    public VictoryMainMenuButton(GameInterface game, PositionInterface position) {
        super(game,position);
    }

    @Override
    public void execute() {
        game.getLeaderboard().put(game.getPointsHandler().getPoints());
        game.getLeaderboard().write();
        game.restartGame();
        game.setState(0);
    }
}
