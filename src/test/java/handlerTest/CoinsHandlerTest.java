package handlerTest;

import game.Game;
import game.GameInterface;
import handler.CoinsHandler;
import maze.Maze;
import maze.MazeInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CoinsHandlerTest {

    private CoinsHandler handler;
    private MazeInterface maze;
    private GameInterface game;

    @BeforeEach
    public void helper() {
        game = new Game();
        maze = new Maze(game, 10);
        handler = new CoinsHandler(maze);
        game.initialize();
    }

    @Test
    public void constructorTest() {
        CoinsHandler handlerTemp = new CoinsHandler(maze);
        assertTrue(handlerTemp != null);
        assertTrue(handler != null);
    }

    @Test
    public void obtainCoinTest() {
        int emptyTilesSize = maze.getEmptyTiles().size();
        int coinsSize = maze.getCoins().size();
        int points = game.getPointsHandler().getPoints();
        handler.obtainCoin(0);
        assertEquals(maze.getEmptyTiles().size(), emptyTilesSize + 1);
        assertEquals(maze.getCoins().size(), coinsSize - 1);
        assertTrue(game.getPointsHandler().getPoints() > points);

    }
}
