package game;
import java.io.IOException;



public interface GameInterface {

    void setInitialize(boolean value);

    void setState(int newState);

    int getscreenH();

    int getscreenW();

    void quit(int status) throws IOException;

    void run();
    /**
     * Creates a new game re/initializing the variables to run the game.
     */
    void restartGame();
}
