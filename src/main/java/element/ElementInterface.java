package element;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.graphics.TextGraphics;
import element.position.PositionInterface;
/**
 * ElementInterface contains the functions set and get the basic components of the element.
 *
 * @author Eduardo Correia
 * @author Alberto Serra
 * @author José Carvalho
 */
public interface ElementInterface {
    /**
     * Returns the color of the element.
     * @return
     */
    String getColor();
    /**
     * Returns the format of the element.
     * @return
     */
    SGR getFormat();
    /**
     * Returns the Character of the element.
     * @return
     */
    String getCharacter();
    /**
     * Returns the position of the element.
     * @return
     */
    PositionInterface getPosition();
    /**
     * Sets the position of the element.
     * @param position Position (x,y) to set the element on.
     */
    void setPosition(PositionInterface position);
    /**
     *  Draws the element in a given screen.
     * @param screen Screen to draw the element on.
     */
    void draw(TextGraphics screen);
}
