package element.position;


import maze.MazeInterface;

/**
 * Abstract Class which contains functions that give random free positions on the maze.
 */
public abstract class RandomPosition {
    int xIncr;
    int yIncr;
    private MazeInterface maze;

    /**
     * Constructor for the RandomPosition Class, receives the maze class as an argument.
     * @param maze previously created maze class.
     */
    public RandomPosition(MazeInterface maze){
        this.maze = maze;
        xIncr = maze.getxIncr();
        yIncr = maze.getyIncr();
    }

    /**
     * Generates a random number between given values
     * @param min mininum value
     * @param max maximum value
     * @return random value between minimum and maximum
     */
    private int generateNumber(int min, int max){
        int range = (max-min) + 1;
        return (int)(Math.random()*range) + min;
    }

    /**
     * function that returns a random free position on the maze.
     * @param max maximum value for randomly generating an integer, this value is the max index of the empty tile list in maze
     * @return returns a random empty position.
     */
    public PositionInterface getRandomPosition(int max){
        int index = generateNumber(0,max);
        PositionInterface position = new Position(maze.getEmptyTiles().get(index));
        maze.getEmptyTiles().remove(index);
        return position;
    }
}
