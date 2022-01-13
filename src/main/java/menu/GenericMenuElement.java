package menu;

import element.position.Position;

public class GenericMenuElement {

    private Position position;
    private final String color = "WHITE";
    private String currentColor;

    public GenericMenuElement(Position position) {
        this.position = position;
        currentColor = color;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getCurrentColor() {
        return currentColor;
    }

    public String getColor() {
        return color;
    }

    public void setCurrentColor(String newColor){
        currentColor = newColor;
    }


}
