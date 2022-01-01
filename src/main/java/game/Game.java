package game;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import maze.Maze;
import menu.Menu;

import java.awt.*;
import java.io.IOException;

public class Game implements GameInterface {

    private Screen screen;
    private Maze maze;
    private Menu menu;
    private static boolean initialized = false;
    private static int state = 0;
    private int screenH;
    private int screenW;
    private int dimension;

    public Game(){
        setDimension();
        maze = new Maze(dimension);
        try {
            loadInitialScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setInitialize(boolean value){initialized = value;}

    public static void setState(int newState) {
        state = newState;
    }

    public static void getTerminal(int newState) {
        state = newState;
    }

    public int getscreenH() {return screenH;}

    public int getscreenW() {return screenW;}

    private void loadInitialScreen() throws IOException {
        TerminalSize terminalSize = new TerminalSize(screenW, screenH);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        Terminal terminal = terminalFactory.createTerminal();
        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
    }

    private void setDimension() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        System.out.printf(screenSize.toString());
        this.screenH = (int) screenSize.getHeight()/20;
        this.screenW = (int) screenSize.getWidth()/9;
        //this.dimension = (int) (screenH* 0.7); //Insert Smart forumla later
        this.dimension= 5;
    }

    private void draw() throws IOException {
        screen.clear();
        maze.draw(screen.newTextGraphics());
        screen.refresh();
    }

    private void processKey(com.googlecode.lanterna.input.KeyStroke key) {
        System.out.println(key);
        switch (key.getKeyType()) {
            case ArrowUp -> maze.moveHero(maze.moveUp());
            case ArrowDown -> maze.moveHero(maze.moveDown());
            case ArrowLeft -> maze.moveHero(maze.moveLeft());
            case ArrowRight -> maze.moveHero(maze.moveRight());
        }
    }
    private void initialize(){
        maze = new Maze(dimension);
        Game.setInitialize(true);
    }
    private void readKey() throws IOException {
        com.googlecode.lanterna.input.KeyStroke key = screen.readInput();
        processKey(key);
        if (key.getKeyType() == KeyType.Character && key.getCharacter() == ('q'))
            quit(0);
        if (key.getKeyType() == KeyType.EOF)
            quit(0);
        if (key.getKeyType() == KeyType.Escape){
            menu = new Menu(screen,2);
        }
    }
    private void newgame(){
        initialized = false;
        state = 1;
    }
    private void restart(){
        initialized = false;
        state = 1;
    }
    void quit(int status) throws IOException {
        screen.stopScreen();
        System.exit(status);
    }
    public void run() {
        try {
            while(true) {
                switch (state){
                    case 0: // load initial menu
                        menu = new Menu(screen,1);
                        break;
                    case 1: // load game
                        if(!initialized) initialize();
                        draw();
                        readKey();
                        break;
                    case 2: // load instructions menu
                        menu = new Menu(screen,3);
                        break;
                    case 3: // Exit
                        quit(0);
                        break;
                    case 4: // restart
                        restart();
                        break;
                    case 5:
                        newgame();
                        menu = new Menu(screen,1);
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
