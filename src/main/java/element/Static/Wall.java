package element.Static;

import com.googlecode.lanterna.SGR;
import element.position.PositionInterface;

public class Wall extends StaticElement {


    public Wall(PositionInterface position, String color, SGR format, String character) {
        super(position, color, format, character);
    }

}
