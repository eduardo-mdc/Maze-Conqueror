package maze;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.graphics.TextGraphics;
import element.stat.Wall;

import java.util.Arrays;
import java.util.List;

public class Maze {
    private int[][] maze;
    private int dim;
    private List<Wall> walls;

    public Maze(int dim){
        this.dim = dim;
        do {
            MazeGenerator gen = new MazeGenerator(dim-2);
            gen.generateMaze();
            maze = gen.getIntMaze();
        }while (maze[dim-3][dim-3] == 0);
        maze = load_walls(maze,dim);
    }
    static private int[][] load_walls(int[][] map , int dim){
        int[][] maze = new int [dim][dim];
        for(int i = 1 ; i < dim-1; i++ ){
            for (int j = 1; j < dim-1;j++) {
                if (map[i-1][j-1] != 0 )maze[i][j] = map[i-1][j-1];
            }
        }
        return maze;
    }

    public void draw(TextGraphics screen) {
        screen.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        screen.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(dim  , dim), ' ');
        for (Wall wall : walls)
            wall.draw(screen);
    }

    public String stringMaze() {
        StringBuilder sb = new StringBuilder();
        for (int[] row : maze) {
            sb.append(Arrays.toString(row) + "\n");
        }
        return sb.toString();
    }



}
