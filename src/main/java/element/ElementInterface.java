package element;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.graphics.TextGraphics;
import element.position.PositionInterface;

public interface ElementInterface {

    String getColor();

    SGR getFormat();

    String getCharacter();

    PositionInterface getPosition();

    void setPosition(PositionInterface position);

    void draw(TextGraphics screen);
}
