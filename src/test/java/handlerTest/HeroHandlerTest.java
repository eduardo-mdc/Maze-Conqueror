package handlerTest;

import com.googlecode.lanterna.SGR;
import element.dynam.Hero;
import element.position.Position;
import element.position.PositionInterface;
import game.Game;
import game.GameInterface;
import handler.HeroHandler;
import maze.Maze;
import maze.MazeInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HeroHandlerTest {

    private HeroHandler handler;
    private GameInterface game;
    private MazeInterface maze;
    private Hero hero;
    private PositionInterface position;

    @BeforeEach
    public void helper() {
        game = new Game();
        position = new Position(3, 5);
        maze = new Maze(game, 15);
        hero = new Hero(position, "GREEN", SGR.BORDERED, "@");
        handler = new HeroHandler(hero, maze);
    }

    @Test
    public void constructorTest() throws IOException {
        HeroHandler handlerTemp = new HeroHandler(hero, new Maze(new Game(), 15));
        assertTrue(handlerTemp != null);
        assertTrue(handler != null);
    }

    @Test
    public void checkTileTest() {
        PositionInterface ending = maze.getEnding();
        assertEquals(maze.getGame().getState(), 0);
        handler.checkTile(ending);
        assertEquals(maze.getGame().getState(), 7);
    }

    @Test
    public void takeDamageTest() {
        int hp = hero.getHealth();
        assertEquals(hp, 5);

    }
}
