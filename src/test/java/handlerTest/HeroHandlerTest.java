package handlerTest;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import element.Static.Portal;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

public class HeroHandlerTest {

    private HeroHandler handler;
    private GameInterface game;
    private MazeInterface maze;
    private Hero hero;
    private PositionInterface position;
    private Portal portal;

    @BeforeEach
    public void helper() {
        game = new Game();
        position = new Position(3, 5);
        maze = new Maze(game, 15);
        hero = new Hero(position, "GREEN", SGR.BORDERED, "@", 5);
        handler = new HeroHandler(hero, maze);
        portal = mock(Portal.class);
        game.initialize();
    }

    @Test
    public void constructorTest() {
        HeroHandler handlerTemp = new HeroHandler(hero, new Maze(new Game(), 5));
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
        handler.takeDamage();
        assertEquals(hero.getHealth(), hp - 1);
    }

    @Test
    public void checkKeyTest() {
        PositionInterface currentPos = hero.getPosition();
        handler.checkKey(new KeyStroke(KeyType.ArrowUp));
        assertEquals(currentPos.getX(), hero.getPosition().getX());
        assertEquals(currentPos.getY(), hero.getPosition().getY() + 1);
        handler.checkKey(new KeyStroke(KeyType.ArrowDown));
        assertEquals(currentPos.getX(), hero.getPosition().getX());
        assertEquals(currentPos.getY(), hero.getPosition().getY());
        handler.checkKey(new KeyStroke(KeyType.ArrowLeft));
        assertEquals(currentPos.getX(), hero.getPosition().getX() + 1);
        assertEquals(currentPos.getY(), hero.getPosition().getY());
        handler.checkKey(new KeyStroke(KeyType.ArrowRight));
        assertEquals(currentPos.getX(), hero.getPosition().getX());
        assertEquals(currentPos.getY(), hero.getPosition().getY());
    }

    @Test
    public void moveHeroTest() {
        int size = maze.getPath().size();
        handler.moveHero(new Position(6, 7));
        assertEquals(hero.getPosition().getX(), 6);
        assertEquals(hero.getPosition().getY(), 7);
    }

    @Test
    public void teleportHeroTest() {
        int size = maze.getPath().size();
        handler.teleportHero(portal);
        assertTrue(size < maze.getPath().size());
    }
}
