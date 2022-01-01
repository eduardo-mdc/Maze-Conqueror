package element.dynam;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import element.position.Position;
import element.position.PositionInterface;

public class Hero extends DynamicElement {

    public Hero(PositionInterface position) {
        super(position);
    }

    public void draw(TextGraphics screen) {
        screen.setForegroundColor(TextColor.Factory.fromString("#FFFF33"));
        screen.enableModifiers(SGR.BOLD);
        screen.putString(new TerminalPosition(getPosition().getX(), getPosition().getY()), "X");
    }

    public PositionInterface moveUp() {
        return new Position(getPosition().getX(), getPosition().getY() - 1);
    }

    public PositionInterface moveDown() {
        return new Position(getPosition().getX(), getPosition().getY() + 1);
    }

    public PositionInterface moveLeft() {
        return new Position(getPosition().getX() - 1, getPosition().getY());
    }

    public PositionInterface moveRight() {
        return new Position(getPosition().getX() + 1, getPosition().getY());
    }
}
