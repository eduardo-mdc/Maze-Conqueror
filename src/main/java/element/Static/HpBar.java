package element.Static;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import element.position.PositionInterface;

public class HpBar extends StaticElement {

    public HpBar(PositionInterface position) {
        super(position);
    }

    public void draw(TextGraphics screen) {
       screen.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        screen.enableModifiers(SGR.BOLD);
        screen.putString(new TerminalPosition(getPosition().getX(), getPosition().getY()), ".");
    }

}
