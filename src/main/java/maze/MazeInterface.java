package maze;

import com.googlecode.lanterna.graphics.TextGraphics;
import element.Static.StaticElement;
import element.position.PositionInterface;
import game.GameInterface;

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
     * Draws the maze objects on the lanterna screen.
     *
     * @param screen lanterna screen to draw to.
     */
    void draw(TextGraphics screen);


    PositionInterface getEnding();

    /**
     * Returns the Maze static elements list.
     *
     * @return maze static elements.
     */
    List<StaticElement> getStaticElems();

    /**
     * Return the path queue casted to a list.
     *
     * @return the path converted to list.
     */
    Queue<StaticElement> getPath();

    /**
     * Returns the only instance of game executing in the game.
     *
     * @return the game instance.
     */
    GameInterface getGame();
}