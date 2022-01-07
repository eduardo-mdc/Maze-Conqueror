package mazeTest;

import com.googlecode.lanterna.graphics.TextGraphics;
import element.Static.Heart;
import element.Static.StaticElement;
import game.GameInterface;
import maze.Maze;
import maze.MazeInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class MazeTest {

    private MazeInterface maze;
    private GameInterface game;
    private int dim;


    @BeforeEach
    public void helper() {
        dim = 50;
        game = mock(GameInterface.class);
        maze = new Maze(game, dim);
    }

    @Test
    public void constructorTest() {
        assertTrue(maze != null);
    }

    @Test
    public void getDimTest() {
        MazeInterface tempMaze = new Maze(game, 80);
        assertEquals(maze.getDim(), 50);
        assertEquals(tempMaze.getDim(), 80);
    }

    @Test
    public void verifyDrawTest() {
        TextGraphics graphics = mock(TextGraphics.class);
        MazeInterface tempMaze = mock(MazeInterface.class);
        tempMaze.draw(graphics);
        verify(tempMaze, times(1)).draw(graphics);
    }

    @Test
    public void createHpBarTest() {
        List<Heart> hpList = maze.getHpList();
        List<StaticElement> staticElems = maze.getStaticElems();
        int hpBarSize = hpList.size();
        assertEquals(hpBarSize, 5);
        assertFalse(hpList.isEmpty());
        assertFalse(staticElems.isEmpty());
    }

    @Test
    public void createWallsTest() {

    }

    @Test
    public void createTrophyTest() {
        TextGraphics graphics = mock(TextGraphics.class);
        MazeInterface tempMaze = mock(MazeInterface.class);
        tempMaze.draw(graphics);
        verify(tempMaze, times(1)).draw(graphics);
    }


}
