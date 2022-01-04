package element;

import com.googlecode.lanterna.graphics.TextGraphics;
import element.position.PositionInterface;

import java.util.Objects;

public abstract class Element implements ElementInterface {
    private PositionInterface position;

    protected Element(PositionInterface position) {
        this.position = position;
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
    public abstract void draw(TextGraphics screen);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Element element = (Element) o;
        return Objects.equals(position, element.position);
    }
}
