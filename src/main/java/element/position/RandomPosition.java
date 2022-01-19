package element.position;


import maze.MazeInterface;

public abstract class RandomPosition {
    int xIncr;
    int yIncr;
    private MazeInterface maze;

    public RandomPosition(MazeInterface maze){
        this.maze = maze;
        xIncr = maze.getxIncr();
        yIncr = maze.getyIncr();
    }
    private int generateNumber(int min, int max){
        int range = (max-min) + 1;
        return (int)(Math.random()*range) + min;
    }

    public PositionInterface getRandomPosition(int max){
        int index = generateNumber(0,max);
        PositionInterface position = new Position(maze.getEmptyTiles().get(index));
        maze.getEmptyTiles().remove(index);
        return position;
    }
}
