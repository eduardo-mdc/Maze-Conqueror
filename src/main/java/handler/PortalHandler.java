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
        Position entryPosition;
        Position endPosition;

        do {
            entryPosition = new Position(generateNumber(xIncr+maze.getDim()-1,xIncr+1),generateNumber(yIncr+maze.getDim()-1,yIncr+1));
            endPosition = new Position(generateNumber(xIncr+maze.getDim()-1,xIncr+1),generateNumber(yIncr+maze.getDim()-1,yIncr+1));
        }while (checkCoordinates(entryPosition) && checkCoordinates(endPosition));
        portalA = new Portal(entryPosition,"BLUE", SGR.BOLD,"#");
        portalB = new Portal(endPosition,"BLUE", SGR.BOLD,"#");
        System.out.println(portalA.getPosition());
        System.out.println(portalB.getPosition());

    }

    private int generateNumber(int max, int min){
        int range = (max-min) + 1;
        return (int)(Math.random()*range) + min;
    }

    private boolean checkCoordinates(Position position){
        if(!(position.equals(maze.getEnding())) && !(position.equals(maze.getBegin()))) return true;
        return false;
    }

    public Portal getPortalB() {
        return portalB;
    }

    public Portal getPortalA() {
        return portalA;
    }

}
