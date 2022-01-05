package element.Static;

import com.googlecode.lanterna.SGR;
import element.position.PositionInterface;
/**
 *Class to create heart objects to represent the life of the player.
 *@author Eduardo Correia
 *@author Jose Carvalho
 *@author Alberto Serra
 */
public class Heart extends StaticElement {
    /**
     * Constructor for the heart class. Receives a position, color, format, and character to represent the object.
     * @param position sets the position of the element on the lanterna screen.
     * @param color sets the color of the element on the lanterna screen.
     * @param format sets the format of the element on the lanterna screen.
     * @param character sets the character of the element on the lanterna screen.
     */
    public Heart(PositionInterface position, String color, SGR format, String character) {
        super(position, color, format, character);
    }
}
