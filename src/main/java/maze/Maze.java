package maze;

import java.util.Arrays;

public class Maze{

    private int[][] maze;

    public Maze(int dim) {
        MazeGenerator gen = new MazeGenerator(dim);
        gen.generateMaze();
        maze = gen.getIntMaze();
    }

    public String stringMaze() {
        StringBuilder sb = new StringBuilder();
        for (int[] row : maze) {
            sb.append(Arrays.toString(row) + "\n");
        }
        return sb.toString();
    }


}





