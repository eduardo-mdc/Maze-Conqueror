package element.Static;

import com.googlecode.lanterna.SGR;
import element.position.PositionInterface;

/**
 *Class to contain and represent the heart objects which corresponds to the hp of the player.
 *@author Eduardo Correia
 *@author Jose Carvalho
 *@author Alberto Serra
 */
public class HpBar extends StaticElement {
    /**
     * Constructor for the HpBar class. Receives a position, color, format, and character to represent the object.
     * @param position sets the position of the element on the lanterna screen.
     * @param color sets the color of the element on the lanterna screen.
     * @param format sets the format of the element on the lanterna screen.
     * @param character sets the character of the element on the lanterna screen.
     */
    public HpBar(PositionInterface position, String color, SGR format, String character) {
        super(position, color, format, character);
    }
}
