package element;

import com.googlecode.lanterna.graphics.TextGraphics;
import element.position.Position;
import element.position.PositionInterface;

public interface ElementInterface {
    
    PositionInterface getPosition();

    void setPosition(Position position);

    void draw(TextGraphics screen);
}
