package element;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import element.position.PositionInterface;

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
     *
     * @param position  sets the position of the element on the lanterna screen.
     * @param color     sets the color of the element on the lanterna screen.
     * @param format    sets the format of the element on the lanterna screen.
     * @param character sets the character of the element on the lanterna screen.
     */
    public Element(PositionInterface position, String color, SGR format, String character) {
        this.position = position;
        this.color = color;
        this.format = format;
        this.character = character;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public SGR getFormat() {
        return format;
    }

    @Override
    public String getCharacter() {
        return character;
    }

    @Override
    public PositionInterface getPosition() {
        return position;
    }

    @Override
    public void setPosition(PositionInterface position) {
        this.position = position;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }


    @Override
    public void draw(TextGraphics screen) {
        screen.setForegroundColor(TextColor.Factory.fromString(color));
        screen.enableModifiers(format);
        screen.putString(new TerminalPosition(getPosition().getX(), getPosition().getY()), character);
    }

    /**
     * Verifies equality to another object.
     *
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
