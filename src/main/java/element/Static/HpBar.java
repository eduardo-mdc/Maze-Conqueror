package element.Static;

import com.googlecode.lanterna.SGR;
import element.position.PositionInterface;

public class HpBar extends StaticElement {

    public HpBar(PositionInterface position, String color, SGR format, String character) {
        super(position, color, format, character);
    }
}
