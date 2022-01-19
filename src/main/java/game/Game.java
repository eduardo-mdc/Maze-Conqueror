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
import handler.BombsHandler;
import handler.LevelHandler;
import handler.PointsHandler;
import handler.ShopHandler;
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
    private int counter;
    private int maxHP = 5;


    private int currentHP;
    private PointsHandler pointsHandler;
    private BombsHandler bombsHandler;
    private LevelHandler levelHandler;
    private ShopHandler shopHandler;
    private int heroHp;
    private boolean isUnlocked = false;
    private boolean invensible = false;
    private int decrease;
    private int bombs;

    //TODO refactor error catching in game constructor

    /**
     * Constructor for the game Class.
     **/

    public int getMaxHP() {
        return maxHP;
    }
    public Game() {
        setDimension(52, 50, 40);
        initialized = false;
        counter = 0;
        state = 0;
        bombs = 5;
        heroHp = maxHP;
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

    public int getCurrentHP() {
        return currentHP;
    }
    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }
    public int getCurrentBombs(){
        return bombs;
    }
    public void setCurrentBombs(int newAmount){
        this.bombs = newAmount;
    }
    private void restartHeroHp(){
        heroHp = maxHP;
    }
    /**
     * public static Class<GameInterface> getGame() {
     * return GameInterface.class;
     * }
     */

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

    public ShopHandler getShopHandler(){return this.shopHandler;};

    public int getHeroHp(){
        return heroHp;
    }

    public void incrementHeroHp(int increment){
        if (maze.getActualHeroHp() < maxHP){
            int newHP = maze.getActualHeroHp() + increment;
            maze.setHeroHp(newHP);
        }
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

    @Override
    public PointsHandler getPointsHandler() {
        return pointsHandler;
    }

    @Override
    public BombsHandler getBombsHandler() {
        return bombsHandler;
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
        levelHandler.draw(textGraphics);
        pointsHandler.draw(textGraphics);
        screen.refresh();
    }


    @Override
    public void initialize() {
        restartHeroHp();
        generateNewMaze();
        setInitialize(true);
        pointsHandler = new PointsHandler();
        levelHandler = new LevelHandler();
        bombsHandler = new BombsHandler(maze);
        bombs = bombsHandler.getMaxbomb();
        shopHandler = new ShopHandler(this);
        decrease = (int) (levelHandler.getLevel() * 0.3);
    }

    /**
     * Reads the user's input and runs code accordingly.
     */
    private void readKey(KeyStroke key) throws IOException {
        if (key != null) {
            if (key.getKeyType() == KeyType.EOF)
                quit(0);
            if (this.getState() == 1) {
                if (key.getKeyType() == KeyType.Escape) {
                    menu = new PauseMenu(this, screen);
                    this.setState(6);
                }
            }
            if (this.getState() == 6) {
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

    @Override
    public void loadGameOverMenu() throws IOException {
        menu = new GameOverMenu(this, screen);
        this.setState(6);
    }

    @Override
    public void loadVictoryMenu() throws IOException {
        pointsHandler.incrementPoints(1000);
        menu = new VictoryMenu(this, screen);
        this.setState(6);
    }

    @Override
    public void drawMenu() throws IOException {
        screen.clear();
        menu.draw();
        screen.refresh();
    }

    @Override
    public void runGame() throws IOException {
        if (!initialized) initialize();
        if (levelHandler.getLevel() == 10 && !isUnlocked){
            isUnlocked = true;
            unlockShop();
        }
        KeyStroke key = screen.pollInput();
        readKey(key);
        maze.nextFrame(key);
        if (counter >= 15) {
            pointsHandler.setPoints(pointsHandler.getPoints() - decrease);
            counter = 0;
        }
        counter++;
        draw();
    }

    @Override
    public void unlockShop() {
        shopHandler.addItem("?","SOMETHING",1, 10000);
    }
    @Override
    public void runMenu() throws IOException {
        readKey(screen.pollInput());
        drawMenu();
    }

    @Override
    public void incrementBombs() {
        if (bombs < bombsHandler.getMaxbomb()) bombsHandler.setBomb(bombs +1);
    }

    public boolean isInvincible(){
        return invensible;
    }

    @Override
    public void turnInvincible() {
        invensible = true;
    }

    @Override
    public void loadInstructionsMenu() throws IOException {
        menu = new InstructionsMenu(this, screen);
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
                    case 8 -> loadShop();
                    case 9 -> nextMap();
                }
                Thread.sleep((int) (1000 / fps));
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void winGame() {
        if(invensible) {invensible = false;}
        setState(7);
    }

    @Override
    public LevelHandler getLevelHandler() {
        return levelHandler;
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
    public MazeInterface getMaze(){
        return maze;
    }
    public void generateNewMaze(){
        maze = new Maze(this, dimension);
    }

    public void loadShop() throws IOException {
        menu = new ShopMenu(this, screen);
        this.setState(6);
    }

    public void nextMap(){

        this.heroHp = maze.getActualHeroHp();
        levelHandler.nextLevel();
        if(levelHandler.getLevel() %10== 0)shopHandler.generalReStock(2,2);
        if(levelHandler.getLevel() %20== 0)shopHandler.generalReStock(2,-1);
        decrease = (int) (levelHandler.getLevel() * 0.3);
        generateNewMaze();
        state = 1 ;
    }

    @Override
    public void quit(int status) throws IOException {
        screen.stopScreen();
        System.exit(status);
    }
}
