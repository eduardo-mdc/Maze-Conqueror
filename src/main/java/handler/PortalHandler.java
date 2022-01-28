package handler;

import com.googlecode.lanterna.SGR;
import element.Static.Portal;
import element.position.RandomPosition;
import maze.MazeInterface;
/**
 * Class used to handle the portal's behaviour in the game.
 *  @author Eduardo Correia
 *  @author Alberto Serra
 *  @author José Carvalho
 */
public class PortalHandler extends RandomPosition {

    private Portal portalA;
    private Portal portalB;
    /**
     * Constructor for the portal handler class
     * @param maze maze class to interact with
     */
    public PortalHandler(MazeInterface maze) {
        super(maze);
        portalA = new Portal(getRandomPosition(maze.getEmptyTiles().size() - 1), "BLUE", SGR.BOLD, "p");
        portalB = new Portal(getRandomPosition(maze.getEmptyTiles().size() - 1), "BLUE", SGR.BOLD, "p");
    }
    /**
     * Gets the portal B
     * @return portal B
     */
    public Portal getPortalB() {
        return portalB;
    }
    /**
     * Gets the portal A
     * @return portal A
     */
    public Portal getPortalA() {
        return portalA;
    }
    /**
     * Gets the other portal
     * @return if B return A , if A return B
     */
    public Portal getOtherPortal(Portal portalToCheck) {
        if (portalToCheck.equals(portalA)) return portalB;
        return portalA;
    }
}
