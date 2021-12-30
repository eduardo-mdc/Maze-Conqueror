package maze;

public class Maze {
    public Maze(int dim){
        MazeGenerator gen = new MazeGenerator(dim);
        gen.generateMaze();
    }
}
