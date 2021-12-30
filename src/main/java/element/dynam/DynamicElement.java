package element.dynam;

import com.googlecode.lanterna.graphics.TextGraphics;
import element.Element;
import element.position.Position;

public abstract class DynamicElement extends Element implements DynamicElementInterface {
    private Position position;
    protected DynamicElement(int x, int y) {
        super(x, y);
    }
    public Position getPosition() {
        return position;
    }
    public void setPosition(Position position) {
        this.position = position;
    }
    public abstract void draw(TextGraphics screen);
}
