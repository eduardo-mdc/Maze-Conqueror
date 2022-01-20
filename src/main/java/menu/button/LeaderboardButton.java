package menu.button;

import element.position.Position;
import element.position.PositionInterface;
import game.Game;
import game.GameInterface;
import menu.Button;


public class LeaderboardButton extends Button {
    private GameInterface game;

    public LeaderboardButton(GameInterface game, PositionInterface position) {
        super(position);
        this.game = game;
        setText("LEADERBOARD");
    }

    @Override
    public void execute() {
        game.setState(10);
    }
}
