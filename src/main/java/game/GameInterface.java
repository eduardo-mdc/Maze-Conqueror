package game;
import java.io.IOException;

/**
 *  Game class which manages the state of the elements that make up the game.
 *
 * @author Eduardo Correia
 * @author Alberto Serra
 * @author José Carvalho
 */

public interface GameInterface {
    /**
     * Changes the value of the variable initialize to control the state of the game.
     * @param value (true/false)
     */
    void setInitialize(boolean value);
    /**
     * Changes the state of the state machine
     *
     * (1) Initial menu.
     * (2) Load the game.
     * (3) Exit.
     * (4) Restart the game.
     * (5) Cleans old game and goes to main menu.
     *
     * @param newState State to change in to.
     *
     */
    void setState(int newState);
    /**
     * Returns the terminal in use.
     * @param newState
     */
    void getTerminal(int newState);
    /**
     * Returns the height of the screen.
     * @return value of the screen height
     */
    int getscreenH();
    /**
     * Returns the width of the screen.
     * @return value of the screen width.
     */
    int getscreenW();
    /**
     *
     * @param status Controls the type of exit: if it's a controlled one or an error.
     * @throws IOException
     */
    void quit(int status) throws IOException;
    /**
     *  Main function.
     *  Functions as a state machine for the entire game never stops to run handling all the stages that the games goes through.
     */
    void run();
    /**
     * Creates a new game re/initializing the variables to run the game.
     */
    void newGame();
}
