package game;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import maze.Maze;
import menu.Menu;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
/**
 * Main Game class which manages the state of the program.
 *
 * @author Eduardo Correia
 * @author Alberto Serra
 * @author José Carvalho
 */
public class Game implements GameInterface {

    private Screen screen;
    private Maze maze;
    private Menu menu;
    private boolean initialized = false;
    private int state;
    private int screenH;
    private int screenW;
    private int dimension;

    //TODO refactor error catching in game constructor

    /**
     * Constructor for the game Class.
     */
    public Game() {
        setDimension();
        maze = new Maze(this, dimension);
        state = 0;
        try {
            loadInitialScreen();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (FontFormatException e) {
            e.printStackTrace();
        }
    }

    /**
     * Changes the value of the variable initialize to control the state of the game.
     * @param value boolean value to change to.
     */
    public void setInitialize(boolean value) {
        initialized = value;
    }

    /**
     * Changes the state of the state machine
     *
     * (1) Initial menu.
     * (2) Load the game.
     * (3) Exit.
     * (4) Restart the game.
     * (5) Cleans old game and goes to main menu.
     *
     * @param newState value of the new state.
     *
     */
    public void setState(int newState) {
        state = newState;
    }
    /**
     * Returns the height of the screen.
     * @return value of the screen height.
     */
    public int getscreenH() {
        return screenH;
    }

    /**
     * Returns the width of the screen.
     * @return value of the screen width.
     */
    public int getscreenW() {
        return screenW;
    }

    private void loadInitialScreen() throws IOException, URISyntaxException, FontFormatException {
        File fontFile = new File("src/main/resources/square.ttf");
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);
        Font loadedFont = font.deriveFont(Font.PLAIN, 10);
        AWTTerminalFontConfiguration fontConfig = AWTTerminalFontConfiguration.newInstance(loadedFont);

        TerminalSize terminalSize = new TerminalSize(screenW, screenH);

        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory();
        terminalFactory.setTerminalEmulatorFontConfiguration(fontConfig);
        terminalFactory.setForceAWTOverSwing(true);
        terminalFactory.setInitialTerminalSize(terminalSize);
        Terminal terminal = terminalFactory.createTerminal();

        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        screen.newTextGraphics().setBackgroundColor(TextColor.Factory.fromString("BLACK"));
    }

    /**
     * Sets the dimension for the lanterna screen based on the user's physical screen resolution.
     */
    private void setDimension() {
        this.screenH = 53;
        this.screenW = 50;
        this.dimension = 40;
    }

    /**
     * Draws the game on the lanterna screen.
     */
    private void draw() throws IOException {
        screen.clear();
        maze.draw(screen.newTextGraphics());
        screen.refresh();
    }

    /**
     * Generates the maze for the game to use.
     */
    private void initialize() {
        maze = new Maze(this, dimension);
        setInitialize(true);
    }

    //TODO change readkey() into a tread so it doesn't interrupt operation.
    /**
     * Reads the user's input and runs code accordingly.
     */
    private void readKey() throws IOException {
        com.googlecode.lanterna.input.KeyStroke key = screen.readInput();
        if (key.getKeyType() == KeyType.Character && key.getCharacter() == ('q'))
            quit(0);
        if (key.getKeyType() == KeyType.EOF)
            quit(0);
        if (key.getKeyType() == KeyType.Escape) {
            menu = new Menu(this, screen, 2);
        }
        maze.processKey(key);
    }

    /**
     * Initializes a new game, used when there was a previous game running.
     */
    public void restartGame() {
        initialized = false;
        state = 1;
    }

    /**
     * Quits the game. Receives an integer to quit check if the game was exited successfully,
     * @param status integer corresponding to the type of exit.
     */
    public void quit(int status) throws IOException {
        screen.stopScreen();
        System.exit(status);
    }

    /**
     *  Main game loop. Constantly checks the state of the game and runs code accordingly.
     */
    public void run() {
        try {
            while (true) {
                switch (state) {
                    case 0: // load initial menu
                        menu = new Menu(this, screen, 1);
                        break;
                    case 1: // load game
                        if (!initialized) initialize();
                        draw();
                        readKey();
                        break;
                    case 2: // load instructions menu
                        menu = new Menu(this, screen, 3);
                        break;
                    case 3: // Exit
                        quit(0);
                        break;
                    case 4: // restart
                        restartGame();
                        break;
                    case 5:
                        restartGame();
                        menu = new Menu(this, screen, 1);
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
