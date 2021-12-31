package element.dynam;

import com.googlecode.lanterna.graphics.TextGraphics;
import element.Element;
import element.position.PositionInterface;

public abstract class DynamicElement extends Element {

    protected DynamicElement(int x, int y) {
        super(x, y);
    }

    public abstract void draw(TextGraphics screen);
}
