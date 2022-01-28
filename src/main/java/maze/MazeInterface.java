package maze;

import com.googlecode.lanterna.graphics.TextGraphics;
import element.Static.Bomb;
import element.Static.StaticElement;
import element.dynam.Hero;
import element.position.PositionInterface;
import game.GameInterface;
import handler.*;

import java.util.List;
import java.util.Queue;

/**
 * Maze interface which contains the elements that make up the game, this includes, but is not limited to, static elements such as hero, path, walls, other special
 * game objects and the actual maze in matrix form, generated from the MazeGenerator class. This interface is also responsible for managing the directional inputs received by the
 * player and verifying the state of the game.
 *
 * @author Eduardo Correia
 * @author Alberto Serra
 * @author José Carvalho
 */
public interface MazeInterface {

    /**
     * Function to encapsulate the raw integer maze matrix in the value 0 (which corresponds to a Wall).
     *
     * @param map raw integer maze generated by the maze generator.
     * @param dim integer dimension for the output maze.
     * @return returns a new raw integer maze in which the outer layers have the value of 0.
     */
    int[][] load_walls(int[][] map, int dim);

    /**
     * Function to create the elements that exist within the maze.
     */
    void createElements();

    /**
     * Returns the dimension value.
     *
     * @return dimension integer.
     */
    int getDim();

    /**
     * Receives a key input from the player, check if it's an arrow key and run the appropriate code.
     *
     * @param key key input from the player.
     */
    void nextFrame(com.googlecode.lanterna.input.KeyStroke key);

    /**
     * Gets the level handler object
     *
     * @return returns the level handler object
     */
    LevelHandler getLevelhandler();

    /**
     * Creates red path objects and inserts them into the static element list
     */
    void createRedPath();

    /**
     * Creates portal objects and inserts them into the static element list
     */
    void createPortals();

    /**
     * Creates coins objects and inserts them into the coins element list
     */
    void createCoins();

    /**
     * Creates hearts objects corresponding to the current hp of the Hero object.
     */
    void loadHearts();

    /**
     * Draws the maze objects on the lanterna screen.
     *
     * @param screen lanterna screen to draw to.
     */
    void draw(TextGraphics screen);

    /**
     * Returns the xIncr variable of the maze.
     *
     * @return xIncr variable of the maze.
     */
    int getxIncr();

    /**
     * Returns the yIncr variable of the maze.
     *
     * @return yIncr variable of the maze.
     */
    int getyIncr();

    /**
     * Returns the inital (beginning) position of the maze.
     *
     * @return beginning position
     */
    PositionInterface getBegin();

    /**
     * Generates maze with given dimension
     *
     * @param dim dimension to create a maze with
     */
    void getMaze(int dim);

    /**
     * Returns the final (ending) position of the maze.
     *
     * @return ending position.
     */
    PositionInterface getEnding();

    /**
     * Returns the Maze static elements list.
     *
     * @return maze static elements.
     */
    List<StaticElement> getStaticElems();

    /**
     * Gets the path queue.
     *
     * @return returns the path queue.
     */
    Queue<StaticElement> getPath();

    /**
     * Gets the game object.
     *
     * @return returns the game object.
     */
    GameInterface getGame();

    /**
     * Gets the int value of the hero's current hp
     *
     * @return value of the hero's hp
     */
    int getActualHeroHp();

    /**
     * Creates a Trophy at the ending position of the maze.
     */
    void createTrophy();

    /**
     * Creates walls objects corresponding to where the value 0 exists in the raw integer maze.
     */
    void createWalls();

    /**
     * Sets the hero's hp to the given value
     *
     * @param newHP new hero health
     */
    void setHeroHp(int newHP);

    /**
     * Gets the list with the empty tiles in the maze.
     *
     * @return returns the empty tiles list.
     */
    List<PositionInterface> getEmptyTiles();

    /**
     * Gets the portal handler object.
     *
     * @return returns portal handler object.
     */
    PortalHandler getPortalHandler();

    /**
     * Gets the coins list.
     *
     * @return returns the coins list.
     */
    List<StaticElement> getCoins();

    /**
     * Gets the coin handler object
     *
     * @return returns the coin handler object.
     */
    CoinsHandler getCoinsHandler();

    /**
     * Gets the bomb queue;
     *
     * @return returns the bomb queue;
     */
    Queue<Bomb> getBombs();

    /**
     * Gets the bomb handler object.
     *
     * @return returns the bomb handler object.
     */
    BombsHandler getBombsHandler();

    /**
     * Gets the hero handler object
     *
     * @return returns the hero handler object.
     */
    HeroHandler getHeroHandler();

    /**
     * Gets the hero object.
     *
     * @return returns the hero object.
     */
    Hero getHero();

    /**
     * Transforms the raw integer maze to string form.
     *
     * @return raw integer maze in string form.
     */
    String toString();
}