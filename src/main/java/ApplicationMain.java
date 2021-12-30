import maze.*;
import menu.*;
import game.*;
import element.*;

public class ApplicationMain {
    public static void main(String[] args) {
        MazeGenerator maze = new MazeGenerator(10);
        maze.generateMaze();
        System.out.println(maze.getRawMaze());
    }
}
