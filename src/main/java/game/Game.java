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
import maze.MazeInterface;
import menu.MenuInterface;
import menu.Menu;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Main Game class which manages the state of the program.
 *
 * @author Eduardo Correia
 * @author Alberto Serra
 * @author José Carvalho
 */
public class Game implements GameInterface {

    private Screen screen;
    private MazeInterface maze;
    private MenuInterface menu;
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
        setDimension(53, 50, 40);
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


    @Override
    public void setInitialize(boolean value) {
        initialized = value;
    }

    @Override
    public int getState() {
        return state;
    }

    @Override
    public boolean getInitialized() {
        return initialized;
    }


    @Override
    public void setState(int newState) {
        state = newState;
    }

    @Override
    public int getScreenH() {
        return screenH;
    }


    @Override
    public int getScreenW() {
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


    @Override
    public void setDimension(int screenH, int screenW, int dimension) {
        this.screenH = screenH;
        this.screenW = screenW;
        this.dimension = dimension;
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

    @Override
    public void restartGame() {
        initialized = false;
        state = 1;
    }

    @Override
    public void quit(int status) throws IOException {
        screen.stopScreen();
        System.exit(status);
    }


    @Override
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
