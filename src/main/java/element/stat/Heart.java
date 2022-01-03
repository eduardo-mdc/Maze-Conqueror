package element.stat;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import element.position.PositionInterface;

public class Heart extends StaticElement {

    public Heart(PositionInterface position) {
        super(position);
    }

    public void draw(TextGraphics screen) {
        screen.setForegroundColor(TextColor.Factory.fromString("#FF0000"));
        screen.enableModifiers(SGR.BOLD);
        screen.putString(new TerminalPosition(getPosition().getX(), getPosition().getY()), "X");
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || this.getClass() != o.getClass()) return false;
        return (this == o ||
                this.getPosition().equals(((Wall) o).getPosition()));

    }
}
