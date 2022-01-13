package menu;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import element.position.Position;

public class GenericMenuElement {
    private Position position;
    private String color;
    private String text;
    private String backColor;


    public GenericMenuElement(Position position){
        this.position = position;
        this.setBackColor("BLACK");
        this.setText("");
        this.setColor("WHITE");
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

    public void setColor(String newColor){
        color = newColor;
    }

    public String getText(){
        return text;
    }

    public void setText(String newText){
        text = newText;
    }

    public String getBackColor() {
        return backColor;
    }

    public void setBackColor(String backColor) {
        this.backColor = backColor;
    }

    public void draw(TextGraphics screen) {
        screen.setBackgroundColor(TextColor.Factory.fromString(getBackColor()));
        screen.setForegroundColor(TextColor.Factory.fromString(getColor()));
        screen.putString(new TerminalPosition(getPosition().getX(), getPosition().getY()), getText());
    }

}
