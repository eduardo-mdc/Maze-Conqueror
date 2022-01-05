package element.Static;

import com.googlecode.lanterna.SGR;
import element.Element;
import element.position.PositionInterface;

public abstract class StaticElement extends Element {

    protected StaticElement(PositionInterface position, String color, SGR format, String character) {
        super(position, color, format, character);
    }
}
