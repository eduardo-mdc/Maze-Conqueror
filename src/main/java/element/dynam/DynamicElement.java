package element.dynam;

import com.googlecode.lanterna.graphics.TextGraphics;
import element.Element;

public abstract class DynamicElement extends Element implements DynamicElementInterface {

    protected DynamicElement(int x, int y) {
        super(x, y);
    }

    public abstract void draw(TextGraphics screen);
}
