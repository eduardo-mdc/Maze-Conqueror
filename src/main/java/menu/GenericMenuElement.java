package menu;

import element.position.Position;

public class GenericMenuElement {
    private Position position;
    private String color;

    public GenericMenuElement(Position position, String color) {
        this.position = position;
        this.color = color;
    }

    public Position getPosition() {
        return position;
    }
    public void setPosition(Position position) {
        this.position = position;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
}
