package element.stat;

import com.googlecode.lanterna.graphics.TextGraphics;
import element.Element;

public abstract class StaticElement extends Element implements StaticElementInterface {

    public StaticElement(int x, int y) {
        super(x, y);
    }

    public abstract void draw(TextGraphics screen);
}
