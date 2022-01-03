package element.Static;

import com.googlecode.lanterna.graphics.TextGraphics;
import element.Element;
import element.position.PositionInterface;

public abstract class StaticElement extends Element {

    public StaticElement(PositionInterface position) {
        super(position);
    }

    public abstract void draw(TextGraphics screen);
}
