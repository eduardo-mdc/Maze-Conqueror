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

public class Game implements GameInterface {

    private Screen screen;
    private Maze maze;
    private Menu menu;
    private boolean initialized = false;
    private int state;
    private int screenH;
    private int screenW;
    private int dimension;

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

    @Override
    public void setInitialize(boolean value) {
        initialized = value;
    }

    @Override
    public void setState(int newState) {
        state = newState;
    }

    @Override
    public void getTerminal(int newState) {
        state = newState;
    }

    @Override
    public int getscreenH() {
        return screenH;
    }

    @Override
    public int getscreenW() {
        return screenW;
    }

    private void loadFonts(DefaultTerminalFactory factory) throws IOException, FontFormatException, URISyntaxException {
        URL resource = getClass().getClassLoader().getResource("fount.ttf");
        File fontFile = new File(resource.toURI());
        Font font =  Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        Font loadedFont = font.deriveFont(Font.PLAIN, 25);
        AWTTerminalFontConfiguration fontConfig = AWTTerminalFontConfiguration.newInstance(loadedFont);
        factory.setTerminalEmulatorFontConfiguration(fontConfig);
        factory.setForceAWTOverSwing(true);

    }

    private void loadInitialScreen() throws IOException, URISyntaxException, FontFormatException {


        TerminalSize terminalSize = new TerminalSize(screenW, screenH);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);

       // loadFonts(terminalFactory);

        Terminal terminal = terminalFactory.createTerminal();

        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        screen.newTextGraphics().setBackgroundColor(TextColor.Factory.fromString("BLACK"));
    }

    private void setDimension() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        System.out.printf(screenSize.toString());
        this.screenH = (int) screenSize.getHeight() / 20;
        this.screenW = (int) screenSize.getWidth() / 9;
        this.dimension = (int) (screenH* 0.7); //Insert Smart formula later
       // this.dimension = 25;
    }

    private void draw() throws IOException {
        screen.clear();
        maze.draw(screen.newTextGraphics());
        screen.refresh();
    }

    private void initialize() {
        maze = new Maze(this, dimension);
        setInitialize(true);
    }

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

    public void newGame() {
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
                        newGame();
                        break;
                    case 5:
                        newGame();
                        menu = new Menu(this, screen, 1);
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
