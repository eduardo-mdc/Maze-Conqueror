package element;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import element.position.PositionInterface;

import java.util.Objects;
/**
 * The Element class is the base class for the objects present in the maze. All elements extend from this class.
 *
 * @author Eduardo Correia
 * @author Alberto Serra
 * @author José Carvalho
 */
public abstract class Element implements ElementInterface {
    private PositionInterface position;
    private String color;
    private SGR format;
    private String character;

    /**
     * Constructor for the Element class. Receives a position, color, format, and character to represent the object.
     * @param position sets the position of the element on the lanterna screen.
     * @param color sets the color of the element on the lanterna screen.
     * @param format sets the format of the element on the lanterna screen.
     * @param character sets the character of the element on the lanterna screen.
     */
    public Element(PositionInterface position, String color, SGR format, String character) {
        this.position = position;
        this.color = color;
        this.format = format;
        this.character = character;
    }

    /**
     * Returns the color of the element.
     * @return string value of the element's color.
     */
    public String getColor() {
        return color;
    }

    /**
     * Returns the format of the element.
     * @return string value of the element's format.
     */
    public SGR getFormat() {
        return format;
    }

    /**
     * Returns the Character of the element.
     * @return string value of the element's character.
     */
    public String getCharacter() {
        return character;
    }

    /**
     * Returns the position of the element.
     * @return position object corresponding to the element's location on the screen.
     */
    public PositionInterface getPosition() {
        return position;
    }

    /**
     * Sets the position of the element.
     * @param position Position (x,y) to set the element on.
     */
    public void setPosition(PositionInterface position) {
        this.position = position;
    }

    /**
     *  Draws the element in a given screen.
     * @param screen Screen to draw the element on.
     */
    public void draw(TextGraphics screen) {
        screen.setForegroundColor(TextColor.Factory.fromString(color));
        screen.enableModifiers(format);
        screen.putString(new TerminalPosition(getPosition().getX(), getPosition().getY()), character);
    }

    /**
     * Verifies equality to another object.
     * @param o object to compare to.
     * @return boolean representing the equality of the objects.
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Element element = (Element) o;
        return position.equals(element.position) && color.equals(element.color) && format == element.format && character.equals(element.character);
    }

}
