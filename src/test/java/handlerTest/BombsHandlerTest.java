package handlerTest;

import com.googlecode.lanterna.graphics.TextGraphics;
import game.Game;
import handler.BombsHandler;
import maze.Maze;
import maze.MazeInterface;
import net.jqwik.api.*;
import net.jqwik.api.constraints.Positive;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class BombsHandlerTest {
    private BombsHandler handler;
    private MazeInterface maze;

    @BeforeEach
    public void helper() {
        maze = new Maze(new Game(), 10);
        handler = new BombsHandler(maze);
        maze.getGame().initialize();
    }

    @Test
    public void constructorTest() throws IOException {
        BombsHandler handlerTemp = new BombsHandler(maze);
        assertTrue(handlerTemp != null);
        assertTrue(handler != null);
    }

    @Property
    public void getBombsTest(@ForAll("6 to 10") @Positive int x) {
        MazeInterface mazeTemp = new Maze(new Game(), 10);
        BombsHandler handlerTemp = new BombsHandler(mazeTemp);
        assertEquals(handlerTemp.getBombs(), 5);
        handlerTemp.setBomb(x);
        assertEquals(handlerTemp.getBombs(), x);
    }

    @Provide("6 to 10")
    Arbitrary<Integer> numbers() {
        return Arbitraries.integers().between(6, 10);
    }

    @Test
    public void setBombsTest() {
        handler.setBomb(-8);
        assertEquals(handler.getBombs(), 0);
        handler.setBomb(10);
        assertEquals(handler.getBombs(), 10);
    }

    @Test
    public void incrementBombsTest() {
        assertEquals(handler.getBombs(), 5);
        handler.incrementBombs(5);
        assertEquals(handler.getBombs(), 10);
    }

    @Test
    public void verifyDrawTest() {
        BombsHandler handlerTemp = mock(BombsHandler.class);
        TextGraphics graphics = mock(TextGraphics.class);
        handlerTemp.draw(graphics);
        verify(handlerTemp, times(1)).draw(graphics);
    }

    @Test
    public void generateBombTest() {
        int bombsArraySize = maze.getBombs().size();
        handler.generateBomb(maze.getEmptyTiles().get(0));
        int newBombsArraySize = maze.getBombs().size();
        assertTrue(newBombsArraySize > bombsArraySize);
    }

    @Test
    public void increaseRadiusTest() {
        int currentRadius = handler.getRadius();
        handler.increaseRadius();
        assertEquals(currentRadius * 2, handler.getRadius());

    }
}
