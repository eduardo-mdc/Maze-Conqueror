import game.Game;
import game.GameInterface;

/**
 * ApplicationMain class used to launch the game.
 *
 * @author Eduardo Correia
 * @author Alberto Serra
 * @author José Carvalho
 */
public class ApplicationMain {

    /**
     * Starts the game.
     *
     * @param args String which contains the arguments to run the program.
     */
    public static void main(String[] args) {
        GameInterface game = new Game();
        game.run();
    }
}
