package element.dynam;

import com.googlecode.lanterna.SGR;
import element.Element;
import element.position.PositionInterface;

public abstract class DynamicElement extends Element {

    protected DynamicElement(PositionInterface position, String color, SGR format, String character) {
        super(position, color, format, character);
    }

}
