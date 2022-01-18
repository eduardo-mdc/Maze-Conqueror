package handler;

import com.googlecode.lanterna.SGR;
import element.Static.Portal;
import element.position.Position;
import element.position.PositionInterface;
import maze.Maze;
import maze.MazeInterface;

public class PortalHandler {
    private MazeInterface maze;
    int xIncr;
    int yIncr;
    private Portal portalA;
    private Portal portalB;

    public PortalHandler(MazeInterface maze) {
        this.maze = maze;
        xIncr = maze.getxIncr();
        yIncr = maze.getyIncr();

        portalA = new Portal(getPortalPosition(),"BLUE", SGR.BOLD,"p");
        portalB = new Portal(getPortalPosition(),"BLUE", SGR.BOLD,"p");
        System.out.println(portalA.getPosition());
        System.out.println(portalB.getPosition());
    }

    private int generateNumber(int min, int max){
        int range = (max-min) + 1;
        return (int)(Math.random()*range) + min;
    }

    private Position getPortalPosition(){
        int index = generateNumber(0,maze.getEmptyTiles().size());
        Position position = new Position(maze.getEmptyTiles().get(index));
        maze.getEmptyTiles().remove(index);
        return position;
    }

    public Portal getPortalB() {
        return portalB;
    }

    public Portal getPortalA() {
        return portalA;
    }

}
