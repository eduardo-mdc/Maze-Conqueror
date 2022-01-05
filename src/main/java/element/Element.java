package element;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import element.position.PositionInterface;

import java.util.Objects;

public abstract class Element implements ElementInterface {
    private PositionInterface position;
    private String color;
    private SGR format;
    private String character;

    public Element(PositionInterface position, String color, SGR format, String character) {
        this.position = position;
        this.color = color;
        this.format = format;
        this.character = character;
    }

    public String getColor() {
        return color;
    }

    public SGR getFormat() {
        return format;
    }

    public String getCharacter() {
        return character;
    }

    @Override
    public PositionInterface getPosition() {
        return position;
    }

    @Override
    public void setPosition(PositionInterface position) {
        this.position = position;
    }

    @Override
    public void draw(TextGraphics screen) {
        screen.setForegroundColor(TextColor.Factory.fromString(color));
        screen.enableModifiers(format);
        screen.putString(new TerminalPosition(getPosition().getX(), getPosition().getY()), character);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Element element = (Element) o;
        return Objects.equals(position, element.position);
    }
}
