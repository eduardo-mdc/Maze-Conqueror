package game;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import handler.PointsHandler;
import maze.Maze;
import maze.MazeInterface;
import menu.Menu;
import menu.submenu.*;

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
    private Menu menu;
    final private double fps = 30.0;
    private boolean initialized;
    private int state;
    private int screenH;
    private int screenW;
    private int dimension;
    private int counter = 0;



    private PointsHandler pointsHandler;

    //TODO refactor error catching in game constructor

    /**
     * Constructor for the game Class.
     */
    public Game() {
        setDimension(53, 50, 40);
        maze = new Maze(this, dimension);
        initialized = false;
        counter = 0;
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
    public Menu getMenu() {
        return menu;
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
        File fontFile = new File("src/main/resources/ldts1.ttf");
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);
        Font loadedFont = font.deriveFont(Font.PLAIN, 15);
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
        TextGraphics textGraphics = screen.newTextGraphics();
        maze.draw(textGraphics);
        pointsHandler.draw(textGraphics);
        screen.refresh();
    }

    /**
     * Generates the maze for the game to use.
     */
    private void initialize() {
        maze = new Maze(this, dimension);
        setInitialize(true);
        pointsHandler = new PointsHandler(maze);
    }


    /**
     * Reads the user's input and runs code accordingly.
     */
    private void readKey(KeyStroke key) throws IOException {
        if(key != null){
            if ((key.getKeyType() == KeyType.Character && key.getCharacter() == ('q')) || (key.getKeyType() == KeyType.EOF)) quit(0);
            if(this.getState() == 1){
                if (key.getKeyType() == KeyType.Escape){
                    menu = new PauseMenu(this, screen);
                    this.setState(6);
                }
            }
            if(this.getState() == 6){
                switch (key.getKeyType()) {
                    case ArrowUp -> menu.iterateSelection(-1);
                    case ArrowDown -> menu.iterateSelection(1);
                    case Enter -> menu.select();
                }
            }
        }
    }


    @Override
    public void loadInitialMenu() throws IOException {
        menu = new StartMenu(this, screen);
        this.setState(6);
    }

    public void loadGameOverMenu() throws IOException{
        menu = new GameOverMenu(this,screen);
        this.setState(6);
    }

    public void loadVictoryMenu() throws IOException{
        menu = new VictoryMenu(this,screen);
        this.setState(6);
    }

    @Override
    public void runGame() throws IOException {
        if (!initialized) initialize();
        KeyStroke key = screen.pollInput();
        readKey(key);
        maze.nextFrame(key);
        if(counter >= 15){
            pointsHandler.setPoints(pointsHandler.getPoints()-1);
            counter = 0;
        }
        counter++;
        draw();
    }

    public void runMenu() throws IOException {
        readKey(screen.pollInput());
        drawMenu();
    }

    public PointsHandler getPointsHandler() {
        return pointsHandler;
    }

    public void drawMenu() throws IOException{
        screen.clear();
        menu.draw();
        screen.refresh();
    }

    @Override
    public void loadInstructionsMenu() throws IOException {
        menu = new InstructionsMenu(this,screen);
        this.setState(6);
    }


    @Override
    public void run() {
        try {
            while (true) {
                switch (state) {
                    case 0 -> loadInitialMenu();
                    case 1 -> runGame();
                    case 2 -> loadInstructionsMenu();
                    case 3 -> quit(0);
                    case 4 -> restartGame();
                    case 5 -> loadGameOverMenu();
                    case 6 -> runMenu();
                    case 7 -> loadVictoryMenu();
                }
                Thread.sleep((int) (1000/fps));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getCurrentState() {
        return state;
    }


    @Override
    public void winGame() {
        setState(7);
    }

    @Override
    public void gameOver() {
        setState(5);
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



}
