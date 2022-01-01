package element.dynam;

import com.googlecode.lanterna.graphics.TextGraphics;
import element.Element;
import element.position.PositionInterface;

public abstract class DynamicElement extends Element {

    protected DynamicElement(PositionInterface position) {
        super(position);
    }

    public abstract void draw(TextGraphics screen);
}
