package element.Static;

import com.googlecode.lanterna.SGR;
import element.position.PositionInterface;
/**
 * Class to create the walls present in the game, these are immovable objects that the player cannot move through.
 */
public class Point extends StaticElement {
    /**
     * Constructor for the Point class. Receives a position, color, format, and character to represent the object.
     * @param position sets the position of the element on the lanterna screen.
     * @param color sets the color of the element on the lanterna screen.
     * @param format sets the format of the element on the lanterna screen.
     * @param character sets the character of the element on the lanterna screen.
     */
    public Point(PositionInterface position, String color, SGR format, String character) {
        super(position, color, format, character);
    }

}
