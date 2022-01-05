package element.Static;

import com.googlecode.lanterna.SGR;
import element.position.PositionInterface;

/**
 * Class which is responsible for pathing the trajectory of the player.
 * @author Eduardo Correia
 * @author Jose Carvalho
 * @author Alberto Serra
 */
public class Path extends StaticElement {
    /**
     * Constructor for the Path class. Receives a position, color, format, and character to represent the object.
     * @param position sets the position of the element on the lanterna screen.
     * @param color sets the color of the element on the lanterna screen.
     * @param format sets the format of the element on the lanterna screen.
     * @param character sets the character of the element on the lanterna screen.
     */
    public Path(PositionInterface position, String color, SGR format, String character) {
        super(position, color, format, character);
    }

}
