package element;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.graphics.TextGraphics;
import element.position.PositionInterface;

public interface ElementInterface {
    /**
     * Returns the color of the element
     * @return
     */
    String getColor();
    /**
     * Returns the format of the element
     * @return
     */
    SGR getFormat();
    /**
     * Returns the Character of the element
     * @return
     */
    String getCharacter();
    /**
     * Returns the position of the element
     * @return
     */
    PositionInterface getPosition();

    /**
     * Sets the position of the element
     * @param position Position (x,y) to set the element on
     */
    void setPosition(PositionInterface position);

    /**
     *  Draws the element in a given sreen
     * @param screen Screen to draw de element
     */
    void draw(TextGraphics screen);
}
