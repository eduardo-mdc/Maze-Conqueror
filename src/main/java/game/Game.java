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

import java.awt.*;
import java.io.IOException;

public class Game implements GameInterface {

    private Screen screen;
    private Maze maze;
    private Menu menu;
    private Instructions intructions;
    private static boolean initialized = false;
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

    static public void setInitialize(boolean value){
        initialized = value;
    }

    private void getDimension() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        System.out.printf(screenSize.toString());
        this.screenH = (int) screenSize.getHeight()/20;
        this.screenW = (int) screenSize.getWidth()/9;
        this.dimension = (int) (screenH* 0.7); //Insert Smart forumla later
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
                        if(!initialized) maze = new Maze(dimension);
                        draw();
                        com.googlecode.lanterna.input.KeyStroke key = screen.readInput();
                        processKey(key);
                        if (key.getKeyType() == KeyType.Character && key.getCharacter() == ('q'))
                            quit(0);
                        if (key.getKeyType() == KeyType.EOF)
                            quit(0);
                        if (key.getKeyType() == KeyType.Escape){
                            menu = new Menu(screen);
                            //TODO continuar isto
                        }
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
