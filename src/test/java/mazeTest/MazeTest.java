package mazeTest;

import com.googlecode.lanterna.graphics.TextGraphics;
import element.ElementInterface;
import element.Static.Heart;
import element.Static.StaticElement;
import element.Static.Trophy;
import element.Static.Wall;
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
    private List<StaticElement> staticElems;
    private int dim;


    @BeforeEach
    public void helper() {
        dim = 50;
        game = mock(GameInterface.class);
        maze = new Maze(game, dim);
        staticElems = maze.getStaticElems();
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
        int hpBarSize = hpList.size();
        assertEquals(hpBarSize, 5);
        assertFalse(hpList.isEmpty());
        assertFalse(staticElems.isEmpty());
    }

    @Test
    public void createWallsTest() {
        int wallCounter = 0;
        int dimTotal = maze.getDim() * maze.getDim();
        for (ElementInterface e : staticElems)
            if (e instanceof Wall)
                wallCounter += 1;
        assertTrue(wallCounter < dimTotal);
        assertFalse(wallCounter >= dimTotal);
    }

    @Test
    public void createTrophyTest() {
        int trophy = 0;
        for (ElementInterface e : staticElems)
            if (e instanceof Trophy)
                trophy += 1;
        assertEquals(1, trophy);
    }
}
