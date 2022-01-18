package handler;

import element.position.Position;
import maze.MazeInterface;

public abstract class RandomPosition {
    private MazeInterface maze;
    RandomPosition(MazeInterface maze){
        this.maze = maze;
    }
    private int generateNumber(int min, int max){
        int range = (max-min) + 1;
        return (int)(Math.random()*range) + min;
    }

    public Position getRandomPosition(int max){
        int index = generateNumber(0,max);
        Position position = new Position(maze.getEmptyTiles().get(index));
        maze.getEmptyTiles().remove(index);
        return position;
    }
}
