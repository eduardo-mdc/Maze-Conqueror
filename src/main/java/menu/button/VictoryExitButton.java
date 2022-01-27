package menu.button;

import element.position.PositionInterface;
import game.GameInterface;

public class VictoryExitButton extends ExitButton{
    public VictoryExitButton(GameInterface game, PositionInterface position){
        super(game, position);
    }

    @Override
    public void execute() {
        game.getLeaderboard().put(game.getPointsHandler().getPoints());
        game.getLeaderboard().write();
        game.setState(3);
    }
}
