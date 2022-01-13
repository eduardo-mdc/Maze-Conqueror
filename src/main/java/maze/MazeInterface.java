package maze;

import com.googlecode.lanterna.graphics.TextGraphics;
import element.Static.Heart;
import element.Static.StaticElement;
import element.position.PositionInterface;

import java.util.List;

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
     * Return the list of the elements that belong to the Static Element class.
     *
     * @return the list of the maze Static elements.
     */
    List<StaticElement> getStaticElems();

    /**
     * Return the list of Heart objects in the maze.
     *
     * @return the list containing the Hearts objects.
     */
    List<Heart> getHpList();

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
     * Checks the tile that the player is attempting to move to and runs code accordingly.
     *
     * @param position position to which the player is attempting to move to.
     */
    void checkTile(PositionInterface position);

    /**
     * Moves the Hero to a certain position.
     *
     * @param position
     */
    void moveHero(PositionInterface position);

    /**
     * Sets the game state to won.
     */
    void winGame();

    /**
     * Sets the game state to lost.
     */
    void gameOver();

    /**
     * Receives a key input from the player, check if it's an arrow key and run the appropriate code.
     *
     * @param key key input from the player.
     */
    void nextFrame(com.googlecode.lanterna.input.KeyStroke key);

    /**
     * Creates a Trophy at the ending position of the maze.
     */
    void createTrophy();

    /**
     * Creates walls objects corresponding to where the value 0 exists in the raw integer maze.
     */
    void createWalls();

    /**
     * Creates an Hpbar object at the upper-left corner of the terminal. //todo not right
     *
     * @param xs - xSize
     * @param ys - ySize
     */
    void createHpBar(int xs, int ys);

    /**
     * Draws the maze objects on the lanterna screen.
     *
     * @param screen lanterna screen to draw to.
     */
    void draw(TextGraphics screen);
}