package game;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import maze.Maze;
import menu.Instructions;
import menu.Menu;
import java.io.IOException;

public class Game implements GameInterface {

    private Screen screen;
    private Maze maze;
    private Menu menu;
    private Instructions intructions;
    private static int state = 0;
    private int screenH;
    private int screenW;
    private int dimension;

    public Game(){
        getDimension();
        maze = new Maze(dimension);
        try {
            TerminalSize terminalSize = new TerminalSize(screenW, screenH);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
            Terminal terminal = terminalFactory.createTerminal();
            screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null);
            screen.startScreen();
            screen.doResizeIfNecessary();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getDimension() {
       /* Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.screenH= (int) screenSize.getHeight();
        this.screenW= (int) screenSize.getWidth()/2;*/
        this.screenH = 200;
        this.screenW = 200;
        this.dimension = 50; //Insert Smart forumla later
    }

    public static void setState(int newState) {
        state = newState;
    }

    public static void getTerminal(int newState) {
        state = newState;
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

    public void run() {
        try {
            while(true) {
                switch (state){
                    case 0: //Initial State
                        menu = new Menu(screen);
                        break;
                    case 1: //Game Started
                        maze = new Maze(dimension);
                        draw();
                        com.googlecode.lanterna.input.KeyStroke key = screen.readInput();
                        processKey(key);
                        if (key.getKeyType() == KeyType.Character && key.getCharacter() == ('q'))
                            quit(0);
                        if (key.getKeyType() == KeyType.EOF)
                            break;
                        break;
                    case 2: // Instructions
                        intructions = new Instructions(screen);
                        break;
                    case 3: // Exit
                        quit(0);
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    void quit(int status) throws IOException {
        screen.stopScreen();
        System.exit(status);
    }
}
