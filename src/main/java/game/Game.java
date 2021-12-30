package game;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import maze.Maze;

import java.io.IOException;

public class Game implements GameInterface{

    private Screen screen;
    private Maze maze;

    public Game(){
        maze = new Maze(5);
        try {
            TerminalSize terminalSize = new TerminalSize(720, 680);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
            Terminal terminal = terminalFactory.createTerminal();
            screen = new TerminalScreen(terminal);

            screen.setCursorPosition(null);
            screen.startScreen();
            screen.doResizeIfNecessary();
        } catch (IOException e){
            e.printStackTrace();
        }
    }


    private void draw() throws IOException{
        screen.clear();
        maze.draw(screen.newTextGraphics());
        screen.refresh();
    }

    /*private void processKey(com.googlecode.lanterna.input.KeyStroke key){
        System.out.println(key);
        switch (key.getKeyType()) {
            case ArrowUp    -> arena.moveHero(arena.moveUp());
            case ArrowDown  -> arena.moveHero(arena.moveDown());
            case ArrowLeft  -> arena.moveHero(arena.moveLeft());
            case ArrowRight -> arena.moveHero(arena.moveRight());
        }
    }

     */

  /*  public void run() {
        try {
            while(true) {
                draw();
                com.googlecode.lanterna.input.KeyStroke key = screen.readInput();
                processKey(key);
                if(arena.verifyMonsterCollisions()){
                    screen.close();
                    break;
                }

                if (key.getKeyType() == KeyType.Character && key.getCharacter() == ('q'))
                    screen.close();
                if (key.getKeyType() == KeyType.EOF)
                    break;

                arena.moveMonsters();
                if(arena.verifyMonsterCollisions()){
                    screen.close();
                    break;
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }

    }
   */
}
