package element.dynam;

import com.googlecode.lanterna.graphics.TextGraphics;
import element.ElementInterface;
import element.position.PositionInterface;

public interface DynamicElementInterface extends ElementInterface {

    PositionInterface getPosition();

    void setPosition(PositionInterface position);

    void draw(TextGraphics screen);
}
