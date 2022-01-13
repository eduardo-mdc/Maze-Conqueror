package menu;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import element.position.Position;

public class Button implements Action{
    private int width;
    private int height;
    private String text;
    private boolean selected;

    private Position position;
    private final String color = "WHITE";

    private String currentColor;
    private String backColor;
    private String selectedColor;

    public Button(Position position) {
        this.position = position;
        backColor = "BLACK";
        selectedColor = "YELLOW";
        currentColor = color;
        text = "";
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

    public String getText(){
        return text;
    }

    public void setText(String newText){
        text = newText;
    }

    public void setSelected(boolean value){
        selected = value;
        if(selected) setCurrentColor(selectedColor);
        else setCurrentColor(getColor());
    }

    public boolean isSelected(){
        return selected;
    }

    public void draw(TextGraphics screen) {
        screen.setForegroundColor(TextColor.Factory.fromString(getCurrentColor()));
        screen.putString(new TerminalPosition(getPosition().getX(), getPosition().getY()), getText());
    }

    public void execute() {}
}

