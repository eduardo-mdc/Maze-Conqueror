package handler;

import com.googlecode.lanterna.SGR;
import element.Static.Coin;
import element.Static.StaticElement;
import element.position.Position;
import maze.MazeInterface;

public class CoinsHandler extends RandomPosition{
    private MazeInterface maze;
    public CoinsHandler(MazeInterface maze) {
        super(maze);
        this.maze = maze;
    }

    public void generateCoin(){
        maze.getCoins().add(new Coin(getRandomPosition(maze.getEmptyTiles().size()-1),"YELLOW",SGR.BOLD,"a"));
    }

    public void obtainCoin(int index){
        Position position = (Position) maze.getCoins().get(index).getPosition();
        maze.getGame().getPointsHandler().incrementPoints(100);
        maze.getCoins().remove(index);
        maze.getEmptyTiles().add(position);
    }


}
