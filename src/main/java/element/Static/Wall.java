package element.Static;

import com.googlecode.lanterna.SGR;
import element.Element;
import element.position.PositionInterface;
/**
 * Class to create the walls present in the game, these are immovable objects that the player cannot move through.
 */
public class Wall extends StaticElement {


    private boolean outerWall;
    /**
     * Constructor for the Wall class. Receives a position, color, format, and character to represent the object.
     * @param position sets the position of the element on the lanterna screen.
     * @param color sets the color of the element on the lanterna screen.
     * @param format sets the format of the element on the lanterna screen.
     * @param character sets the character of the element on the lanterna screen.
     */
    public Wall(PositionInterface position, String color, SGR format, String character) {
        super(position, color, format, character);
        outerWall = false;
    }

    public Wall(PositionInterface position, String color, SGR format, String character,boolean outerWall) {
        super(position, color, format, character);
        this.outerWall = outerWall;
    }

    public boolean isOuterWall() {
        return outerWall;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wall element = (Wall) o;
        return getPosition().equals(element.getPosition()) && getColor().equals(element.getColor()) && getFormat() == element.getFormat() && getCharacter().equals(element.getCharacter()) && isOuterWall() == element.isOuterWall();
    }




}
