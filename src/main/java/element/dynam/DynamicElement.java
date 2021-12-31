package element.dynam;

import com.googlecode.lanterna.graphics.TextGraphics;
import element.Element;
import element.position.PositionInterface;

public abstract class DynamicElement extends Element implements DynamicElementInterface {
    private PositionInterface position;

    protected DynamicElement(int x, int y) {
        super(x, y);
    }

    public PositionInterface getPosition() {
        return position;
    }

    public void setPosition(PositionInterface position) {
        this.position = position;
    }

    public abstract void draw(TextGraphics screen);
}
