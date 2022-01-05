package element.dynam;

import com.googlecode.lanterna.SGR;
import element.Element;
import element.position.PositionInterface;

/**
 *  Class to contain and represent the dynamic elements of the game.
 *  @author Eduardo Correia
 *  @author Alberto Serra
 *  @author José Carvalho
 */

public abstract class DynamicElement extends Element {
    /**
     * Constructor for the DynamicElement class. Receives a position, color, format, and character to represent the object.
     * @param position sets the position of the element on the lanterna screen.
     * @param color sets the color of the element on the lanterna screen.
     * @param format sets the format of the element on the lanterna screen.
     * @param character sets the character of the element on the lanterna screen.
     */
    protected DynamicElement(PositionInterface position, String color, SGR format, String character) {
        super(position, color, format, character);
    }

}
