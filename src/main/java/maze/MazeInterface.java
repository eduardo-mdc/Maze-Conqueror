package maze;

import com.googlecode.lanterna.graphics.TextGraphics;
import element.position.PositionInterface;

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
     * Draws the maze objects on the lanterna screen.
     *
     * @param screen lanterna screen to draw to.
     */
    void draw(TextGraphics screen);
}