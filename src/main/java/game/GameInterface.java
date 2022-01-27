package game;

import com.googlecode.lanterna.input.KeyStroke;
import handler.BombsHandler;
import handler.LevelHandler;
import handler.PointsHandler;
import handler.ShopHandler;
import maze.MazeInterface;
import menu.Menu;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;

/**
 * Main Game interface which manages the state of the program.
 *
 * @author Eduardo Correia
 * @author Alberto Serra
 * @author José Carvalho
 */
public interface GameInterface {

    /**
     * Restarts the hero's health.
     */
    void restartHeroHp();
    /**
     * Return the application menu object.
     *
     * @return menu object.
     */
    Menu getMenu();
    /**
     * Increases/Decreases the hero hp by the amount given
     * @param increment value to add to hero health.
     */
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
     * Gets the integer value of the decrease variable
     * @return integer corresponding to the decrease variable
     */
    int getDecrease();
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
    /**
     * Gets the value for the current amount of bombs available for use to the player.
     * @return integer value of the amount of bombs
     */
    int getCurrentBombs();
    /**
     * Gets the initialized leaderboard class.
     * @return leaderboard object.
     */
    Leaderboard getLeaderboard();
    /**
     * Gets the maximum amount of health.
     * @return value of maximum allowed health.
     */
    int getMaxHP();
    /**
     * Sets the current amount of bombs to the given amount.
     * @param newAmount new amount of bombs.
     */
    void setCurrentBombs(int newAmount);
    /**
     * Returns the height of the screen.
     *
     * @return value of the screen height.
     */
    int getScreenH();
    /**
     * Sets the hero's current health to the given value
     * @param currentHP value to set as new hero health.
     */
    void setCurrentHP(int currentHP);
    /**
     * Gets the current health value of the player.
     * @return integer corresponding to the health of the player.
     */
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
    /**
     Gets the current health value of the player.
     * @return integer corresponding to the health of the player.
     */
    int getHeroHp();

    /**
     * Gets the maze object.
     * @return the maze object.
     */
    MazeInterface getMaze();
    /**
     * Creates and initializes the lanterna screen for use.
     */
    void loadInitialScreen() throws IOException, URISyntaxException, FontFormatException;
    /**
     * Sets the dimension for the lanterna screen based on given values. Also sets the dimension for the maze.
     *
     * @param screenH terminal height
     * @param screenW terminal width
     * @param dimension maze dimension
     */
    void setDimension(int screenH, int screenW, int dimension);
    /**
     * Creates a new game resetting the variables used to run the game.
     */
    void restartGame();
    /**
     * Generates a new maze for use.
     */
    void generateNewMaze();
    /**
     * Loads the shop menu for buying items.
     */
    void loadShop() throws IOException;
    /**
     * Creates a new map after completing a maze.
     */
    void nextMap();
    /**
     * Sets the player's id to the given value. This id is used in the leaderboard.
     * @param value
     */
    void setHeroID(Integer value);
    /**
     * Gets the hero's ID for use in the leaderboard.
     * @return
     */
    Integer getHeroID();
    /**
     * Quits the game. Receives an integer to quit check if the game was exited successfully,
     *
     * @param status integer corresponding to the type of exit.
     */
    void quit(int status) throws IOException;
    /**
     * Draws all the game objects on the lanterna screen.
     */
    void draw() throws IOException;
    /**
     * Generates the maze and the element handlers for the game to use.
     */
    void initialize();
    /**
     * Reads the user's input and runs code accordingly.
     */
    void readKey(KeyStroke key) throws IOException;
    /**
     * Loads the game initial menu.
     */
    void loadInitialMenu() throws IOException;
    /**
     * Loads the game over menu.
     */
    void loadGameOverMenu() throws IOException;
    /**
     * Loads the game victory menu.
     */
    void loadVictoryMenu() throws IOException;
    /**
     * Loads the game. Game is available to play after execution.
     */
    void runGame() throws IOException;
    /**
     * Draws the game current Menu with lanterna framework.
     */
    void drawMenu() throws IOException;
    /**
     * Loads the game instruction menu. Gives information to the user about the objective of the game.
     */
    void loadInstructionsMenu() throws IOException;
    /**
     * Main game loop. Constantly checks the state of the game and runs code accordingly.
     */
    void run();
    /**
     * Loads the leaderboard menu.
     */
    void loadLeaderboardMenu() throws IOException;
    /**
     * Sets the game to the winning state.
     */
    void winGame();
    /**
     * Gets the level handler object.
     * @return returns the level handler object.
     */
    LevelHandler getLevelHandler();
    /**
     * Sets the game to the end losing state.
     */
    void gameOver();
    /**
     * Run the menu, reading the keys input and drawing the corresponding menu.
     */
    void runMenu() throws IOException;
    /**
     * Checks whether the player is impervious to damage.
     * @return boolean value of the assertion.
     */
    boolean isInvincible();
    /**
     * Increments the amount of bombs available to the player by one.
     */
    void incrementBombs();
    /**
     * makes the player become impervious to damage.
     */
    void turnInvincible();
    /**
     * Unlocks certain items for sale at the shop.
     */
    void unlockShop();
    /**
     * Increases the bombs radius
     */
    void increaseRadius();
}
