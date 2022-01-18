package handler;

import com.googlecode.lanterna.SGR;
import element.Static.Portal;
import element.position.Position;
import element.position.PositionInterface;
import maze.Maze;
import maze.MazeInterface;

public class PortalHandler extends RandomPosition{

    int xIncr;
    int yIncr;
    private Portal portalA;
    private Portal portalB;

    public PortalHandler(MazeInterface maze) {
        super(maze);
        xIncr = maze.getxIncr();
        yIncr = maze.getyIncr();
        portalA = new Portal(getRandomPosition(maze.getEmptyTiles().size()-1),"BLUE", SGR.BOLD,"p");
        portalB = new Portal(getRandomPosition(maze.getEmptyTiles().size()-1),"BLUE", SGR.BOLD,"p");
    }

    public Portal getPortalB() {
        return portalB;
    }

    public Portal getPortalA() {
        return portalA;
    }

    public Portal getOtherPortal(Portal portalToCheck){
        if(portalToCheck.equals(portalA)) return portalB;
        return portalA;
    }

}
