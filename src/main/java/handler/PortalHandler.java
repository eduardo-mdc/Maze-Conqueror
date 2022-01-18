package handler;

import com.googlecode.lanterna.SGR;
import element.Static.Portal;
import element.position.Position;
import maze.Maze;

public class PortalHandler {
    Maze maze;
    int xIncr;
    int yIncr;


    Portal portalA;
    Portal portalB;

    public PortalHandler(Maze maze){
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
