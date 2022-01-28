package handler;

import com.googlecode.lanterna.SGR;
import element.Static.Coin;
import element.position.Position;
import element.position.RandomPosition;
import maze.MazeInterface;

/**
 * Class used to handle the coin's behaviour in the game.
 *  @author Eduardo Correia
 *  @author Alberto Serra
 *  @author José Carvalho
 */
public class CoinsHandler extends RandomPosition {
    private MazeInterface maze;


    /**
     * Constructor for the coin handler class
     * @param maze maze class to interact with
     */
    public CoinsHandler(MazeInterface maze) {
        super(maze);
        this.maze = maze;
    }

    /**
     * Generates a new coin
     */
    public void generateCoin() {
        maze.getCoins().add(new Coin(getRandomPosition(maze.getEmptyTiles().size() - 1), "YELLOW", SGR.BOLD, "a"));
    }

    /**
     * Changes game values when the user catches a coin.
     * @param index coin which got collected
     */
    public void obtainCoin(int index) {
        Position position = (Position) maze.getCoins().get(index).getPosition();
        maze.getGame().getPointsHandler().incrementPoints(100 + 100 * (int) (0.1 * maze.getLevelhandler().getLevel()));
        maze.getCoins().remove(index);
        maze.getEmptyTiles().add(position);
    }
}
