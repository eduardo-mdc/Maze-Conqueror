package menu;

import com.googlecode.lanterna.graphics.TextGraphics;
import element.position.PositionInterface;

public interface GenericMenuElementInterface {
    /**
     * Return the generic menu element position interface.
     *
     * @return the menu element position interface.
     */
    PositionInterface getPosition();

    /**
     * Sets the generic menu element position.
     *
     * @param position
     */
    void setPosition(PositionInterface position);

    /**
     * Returns the current color of the generic menu element.
     *
     * @return - current menu color.
     */
    String getColor();

    /**
     * Sets the generic menu element color.
     *
     * @param newColor
     */
    void setColor(String newColor);

    /**
     * Returns the generic menu element text.
     *
     * @return menu element text.
     */
    String getText();

    /**
     * Sets the current generic menu element text.
     *
     * @param newText
     */
    void setText(String newText);

    /**
     * Returns the generic menu element background color.
     *
     * @return menu element background color.
     */
    String getBackColor();

    /**
     * Sets the generic menu element background color.
     *
     * @param backColor
     */
    void setBackColor(String backColor);

    /**
     * Draws the current generic menu element with the lanterna gui.
     *
     * @param screen
     */
    void draw(TextGraphics screen);
}
