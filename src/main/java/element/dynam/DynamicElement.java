package element.dynam;

import com.googlecode.lanterna.SGR;
import element.Element;
import element.position.PositionInterface;

/**
 *  Class to contain and represent the dynamic elements of the game.
 * @author Eduardo Correia
 * @author Alberto Serra
 * @author José Carvalho
 */

public abstract class DynamicElement extends Element {
    /**
     * Constructor of the class DynamicElement
     * @param position Position (x,y) to the element.
     * @param color Color of the element.
     * @param format format SGR.
     * @param character Character to Represent the element.
     */
    protected DynamicElement(PositionInterface position, String color, SGR format, String character) {
        super(position, color, format, character);
    }

}
