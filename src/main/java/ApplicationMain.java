import game.Game;


public class ApplicationMain {
    /**
     * ApplicationMain class used to lauch the game.
     *
     * @author Eduardo Correia
     * @author Alberto Serra
     * @author José Carvalho
     */

    /**
     *Starts the game.
     * @param args String which contains the arguments to run the program.
     *
     */
    public static void main(String[] args) {
        Game game = new Game();
        game.run();
    }
}
