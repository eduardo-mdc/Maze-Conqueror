package element;

import com.googlecode.lanterna.graphics.TextGraphics;
import element.position.PositionInterface;

public interface ElementInterface {
    
    PositionInterface getPosition();

    void setPosition(PositionInterface position);

    void draw(TextGraphics screen);
}
