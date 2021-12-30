package maze;

import java.util.Arrays;

public class Maze {
    private int[][] maze;
    public Maze(int dim){
        MazeGenerator gen = new MazeGenerator(dim-1);
        gen.generateMaze();
        maze = load_walls(gen.getIntMaze(),dim);

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
    public String stringMaze() {
        StringBuilder sb = new StringBuilder();
        for (int[] row : maze) {
            sb.append(Arrays.toString(row) + "\n");
        }
        return sb.toString();
    }
}
