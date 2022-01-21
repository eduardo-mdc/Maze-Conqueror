package mazeTest;

import element.position.Position;
import element.position.PositionInterface;
import game.Game;
import game.GameInterface;
import maze.Maze;
import maze.MazeInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MazeTest {

    private GameInterface game;
    private MazeInterface maze;

    @BeforeEach
    public void helper() {
        game = new Game();
        maze = new Maze(game, 10);
        game.initialize();
        maze.createElements();
    }


    @Test
    public void constructorTest() {
        MazeInterface mazeTemp = new Maze(game, 10);
        assertTrue(mazeTemp != null);
        assertTrue(maze != null);
    }

    @Test
    public void getxIncrTest() {
        //the value can change, just ensure its not negative.
        assertTrue(maze.getxIncr() >= 0);

    }

    @Test
    public void getyIncrTest() {
        //the value can change, just ensure its not negative.
        assertTrue(maze.getyIncr() >= 0);
    }

    @Test
    public void getEndingTest() {
        PositionInterface ending = new Position(maze.getDim() - 2 + maze.getxIncr(), maze.getDim() - 2 + maze.getyIncr());
        assertEquals(maze.getEnding(), ending);
    }

    @Test
    public void getBeginTest() {
        PositionInterface begin = new Position(1 + maze.getxIncr(), 1 + maze.getyIncr());
        assertEquals(maze.getBegin(), begin);
    }


    @Test
    public void getStaticElemsTest() {
        assertTrue(maze.getStaticElems() != null);
        assertTrue(maze.getStaticElems().size() > 0);

    }

    @Test
    public void getPathTest() {
        assertTrue(maze.getPath() != null);

    }


    @Test
    public void getGameTest() {
        assertEquals(maze.getGame(), game);
    }

    @Test
    public void getDIMTest() {
        assertEquals(10, maze.getDim());
    }

    @Test
    public void getCoinsTest() {
        assertTrue(maze.getCoins() != null);
        assertTrue(maze.getCoins().size() > 0);
    }

    @Test
    public void getHandlersTest() {
        assertTrue(maze.getCoinsHandler() != null);
        assertTrue(maze.getGame().getLevelHandler() != null);
        assertTrue(maze.getPortalHandler() != null);
        assertTrue(maze.getHeroHandler() != null);
    }


}
