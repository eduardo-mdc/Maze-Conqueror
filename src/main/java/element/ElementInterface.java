package element;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.graphics.TextGraphics;
import element.position.PositionInterface;

/**
 * The Element interface is the base interface for the objects present in the maze.
 *
 * @author Eduardo Correia
 * @author Alberto Serra
 * @author José Carvalho
 */
public interface ElementInterface {

    String getColor();

    SGR getFormat();

    String getCharacter();

    PositionInterface getPosition();

    void setPosition(PositionInterface position);

    void draw(TextGraphics screen);
}
