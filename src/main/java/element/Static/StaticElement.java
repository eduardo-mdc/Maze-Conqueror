package element.Static;

import com.googlecode.lanterna.SGR;
import element.Element;
import element.position.PositionInterface;

/**
 * Extension Class for the static objects, i.e, objects that after generated, don't change positions.
 */
public abstract class StaticElement extends Element {
    /**
     * Constructor for the StaticElement class. Receives a position, color, format, and character to represent the object.
     * @param position sets the position of the element on the lanterna screen.
     * @param color sets the color of the element on the lanterna screen.
     * @param format sets the format of the element on the lanterna screen.
     * @param character sets the character of the element on the lanterna screen.
     */
    protected StaticElement(PositionInterface position, String color, SGR format, String character) {
        super(position, color, format, character);
    }
}
