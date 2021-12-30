import maze.*;
import menu.*;
import game.*;
import element.*;

public class ApplicationMain {
    public static void main(String[] args) {
        Game game = new Game();
        Maze maze = new Maze(5);
        System.out.println(maze.stringMaze());
    }
}
