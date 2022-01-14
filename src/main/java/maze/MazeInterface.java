package maze;

import com.googlecode.lanterna.graphics.TextGraphics;
import element.Static.StaticElement;
import element.position.Position;
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

    /**
     * Generates de Maze with a certain dimension passed as an argument.
     *
     * @param dim
     * @return the generated Maze.
     */
    MazeGenerator getMazeGenerator(int dim);

    /**
     * Returns the shortest path between two positions in the Maze, considering his walls.
     *
     * @param incrementedStart
     * @param incrementedEnd
     * @return the shortest path between two positions.
     */
    int shortestPath(PositionInterface incrementedStart, PositionInterface incrementedEnd);

    /**
     * Return an array to verify if some position is already visited or not.
     *
     * @param start
     * @return an array of visited positions with tghe certain dim.
     */
    boolean[][] getIsVisitedArray(PositionInterface start);

    /**
     * Checks the movement of the cell to the right and adds a new cell to the queue.
     *
     * @param queue
     * @param cell
     * @param isVisited
     */
    void cellMoveRight(Queue<VisitedCell> queue, VisitedCell cell, boolean[][] isVisited);

    /**
     * Checks the movement of the cell to the left and adds a new cell to the queue.
     *
     * @param queue
     * @param cell
     * @param isVisited
     */
    void cellMoveLeft(Queue<VisitedCell> queue, VisitedCell cell, boolean[][] isVisited);

    /**
     * Checks the down movement of the cell and adds a new cell to the queue.
     *
     * @param queue
     * @param cell
     * @param isVisited
     */
    void cellMoveDown(Queue<VisitedCell> queue, VisitedCell cell, boolean[][] isVisited);

    /**
     * Checks the up movement of the cell and adds a new cell to the queue.
     *
     * @param queue
     * @param cell
     * @param isVisited
     */
    void cellMoveUp(Queue<VisitedCell> queue, VisitedCell cell, boolean[][] isVisited);

    /**
     * Returns the found distance between positions.
     *
     * @param cell
     * @return the found distance.
     */
    int distFound(VisitedCell cell);

    /**
     * Returns the ending Position.
     *
     * @return the ending position.
     */
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
    List<StaticElement> getPath();

    /**
     * Returns the only instance of game executing in the game.
     *
     * @return the game instance.
     */
    GameInterface getGame();
}