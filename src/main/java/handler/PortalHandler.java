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
        PositionInterface entryPosition;
        PositionInterface endPosition;
        do {
            entryPosition = getEntryPosition();
            endPosition = getEndPosition();
        } while (checkCoordinates(entryPosition) && checkCoordinates(endPosition));
        generatePortals(entryPosition, endPosition);
        System.out.println(portalA.getPosition());
        System.out.println(portalB.getPosition());
    }

    private void generatePortals(PositionInterface entryPosition, PositionInterface endPosition) {
        portalA = new Portal(entryPosition, "BLUE", SGR.BOLD, "p");
        portalB = new Portal(endPosition, "BLUE", SGR.BOLD, "p");
    }

    private PositionInterface getEntryPosition() {
        return new Position(generateNumber(xIncr + maze.getDim() - 1, xIncr + 1), generateNumber(yIncr + maze.getDim() - 1, yIncr + 1));
    }

    private PositionInterface getEndPosition() {
        return new Position(generateNumber(xIncr + maze.getDim() - 1, xIncr + 1), generateNumber(yIncr + maze.getDim() - 1, yIncr + 1));
    }

    private int generateNumber(int max, int min) {
        int range = (max - min) + 1;
        return (int) (Math.random() * range) + min;
    }

    private boolean checkCoordinates(PositionInterface position) {
        if (!(position.equals(maze.getEnding())) && !(position.equals(maze.getBegin()))) return true;
        return false;
    }

    public Portal getPortalB() {
        return portalB;
    }

    public Portal getPortalA() {
        return portalA;
    }

}
