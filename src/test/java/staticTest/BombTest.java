package staticTest;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.graphics.TextGraphics;
import element.Static.Bomb;
import element.Static.StaticElement;
import element.position.PositionInterface;
import game.Game;
import game.GameInterface;
import maze.Maze;
import maze.MazeInterface;
import net.jqwik.api.*;
import net.jqwik.api.constraints.NotEmpty;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class BombTest {
    private Bomb bomb;
    private PositionInterface position;
    private MazeInterface maze;
    private GameInterface game;

    @BeforeEach
    public void helper() {
        position = mock(PositionInterface.class);
        bomb = new Bomb(position, "BLACK", SGR.BOLD, "b");
        game = new Game();
        maze = new Maze(game, 10);
        game.initialize();
    }

    @Provide
    Arbitrary<String> lengthOne() {
        return Arbitraries.strings().ofMaxLength(1);
    }

    @Property
    public void constructorTest(@ForAll("lengthOne") String character) {
        Bomb bombTemp = new Bomb(position, "RED", SGR.BOLD, character);
        assertTrue(bombTemp != null);
    }

    @Test
    public void getTimerTest() {
        //Timer default value is 90
        assertEquals(90, bomb.getTimer());
    }

    @Test
    public void bombTickTest() {
        int timer = 0;
        while (bomb.getTimer() != 60) {
            timer = bomb.getTimer();
            bomb.bombTick();
            assertEquals(timer - 1, bomb.getTimer());
        }
        bomb.bombTick();
        assertEquals(5, bomb.getInterval());
        while (bomb.getTimer() != 25) {
            timer = bomb.getTimer();
            bomb.bombTick();
            assertEquals(timer - 1, bomb.getTimer());
        }
        bomb.bombTick();
        assertEquals(2, bomb.getInterval());
    }

    @Test
    public void getIntervalTest() {
        //timer deafult value is 10
        assertEquals(10, bomb.getInterval());
    }

    @Test
    public void explodeTest() {
        int arrayTilesSize = maze.getEmptyTiles().size();
        bomb.explode(maze);
        int newArrayTilesSize = maze.getEmptyTiles().size();
        assertTrue(arrayTilesSize == newArrayTilesSize);
    }

    @Test
    public void verifyDrawTest() {
        Bomb bombTemp = mock(Bomb.class);
        TextGraphics graphics = mock(TextGraphics.class);
        bombTemp.draw(graphics);
        verify(bombTemp, times(1)).draw(graphics);
    }


}
