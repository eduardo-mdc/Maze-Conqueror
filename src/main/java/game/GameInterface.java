package game;

import handler.BombsHandler;
import handler.LevelHandler;
import handler.PointsHandler;
import handler.ShopHandler;
import maze.MazeInterface;
import menu.Menu;

import java.io.IOException;
import java.util.logging.Level;

/**
 * Main Game interface which manages the state of the program.
 *
 * @author Eduardo Correia
 * @author Alberto Serra
 * @author José Carvalho
 */
public interface GameInterface {

    void restartHeroHp();

    /**
     * Return the application menu object.
     *
     * @return menu object.
     */
    Menu getMenu();

    void incrementHeroHp(int increment);

    /**
     * Changes the value of the variable initialize to control the state of the game.
     *
     * @param value boolean value to change to.
     */
    void setInitialize(boolean value);


    /**
     * Return the value of state.
     *
     * @return int state variable value.
     */
    int getState();

    /**
     * Return the value of initialized.
     *
     * @return value of the initialized variable.
     */
    boolean getInitialized();

    /**
     * Returns the game shop handler, responsible for the shop behavior.
     *
     * @return the game shop handler.
     */
    ShopHandler getShopHandler();

    /**
     * Changes the state of the state machine.
     * <p>
     * (1) Initial menu.
     * (2) Load the game.
     * (3) Exit.
     * (4) Restart the game.
     * (5) Cleans old game and goes to main menu.
     *
     * @param newState value of the new state.
     */
    void setState(int newState);

    int getCurrentBombs();

    Leaderboard getLeaderboard();

    int getMaxHP();

    void setCurrentBombs(int newAmount);

    /**
     * Returns the height of the screen.
     *
     * @return value of the screen height.
     */
    int getScreenH();

    void setCurrentHP(int currentHP);

    int getCurrentHP();

    /**
     * Returns the width of the screen.
     *
     * @return value of the screen width.
     */
    int getScreenW();

    /**
     * Returns the game Points Handler.
     *
     * @return the points handler object.
     */
    PointsHandler getPointsHandler();


    /**
     * Returns the game Bombs Handler.
     *
     * @return the bombs handler object.
     */
    BombsHandler getBombsHandler();

    int getHeroHp();

    MazeInterface getMaze();

    /**
     * Sets the dimension for the lanterna screen based on the user's physical screen resolution.
     *
     * @param screenH
     * @param screenW
     * @param dimension
     */
    void setDimension(int screenH, int screenW, int dimension);

    /**
     * Creates a new game re/initializing the variables to run the game.
     */
    void restartGame();

    void setHeroID(Integer value);

    Integer getHeroID();

    /**
     * Quits the game. Receives an integer to quit check if the game was exited successfully,
     *
     * @param status integer corresponding to the type of exit.
     * @throws IOException
     */
    void quit(int status) throws IOException;

    /**
     * Generates the maze and the element handlers for the game to use.
     */
    void initialize();

    /**
     * Loads the game initial menu.
     *
     * @throws IOException
     */
    void loadInitialMenu() throws IOException;

    /**
     * Loads the game over menu.
     *
     * @throws IOException
     */
    void loadGameOverMenu() throws IOException;

    /**
     * Loads the game victory menu.
     *
     * @throws IOException
     */
    void loadVictoryMenu() throws IOException;

    /**
     * Loads the game. Game is available to play after execution.
     *
     * @throws IOException
     */
    void runGame() throws IOException;

    /**
     * Draws the game current Menu with lanterna framework.
     *
     * @throws IOException
     */
    void drawMenu() throws IOException;

    /**
     * Loads the game instructions menu. Gives information to the user about the objective of the game.
     *
     * @throws IOException
     */
    void loadInstructionsMenu() throws IOException;

    /**
     * Main game loop. Constantly checks the state of the game and runs code accordingly.
     */
    void run();

    /**
     * Sets the game to the winning state.
     */
    void winGame();

    LevelHandler getLevelHandler();

    /**
     * Sets the game to the end losing state.
     */
    void gameOver();


    /**
     * Run the menu, reading the keys input and drawing the corresponding menu.
     *
     * @throws IOException
     */
    void runMenu() throws IOException;

    boolean isInvincible();

    void incrementBombs();

    void turnInvincible();

    void unlockShop();

}
