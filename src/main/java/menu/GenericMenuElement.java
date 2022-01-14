package menu;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import element.position.PositionInterface;
import menu.submenu.GenericMenuElementInterface;

public class GenericMenuElement implements GenericMenuElementInterface {
    private PositionInterface position;
    private String color;
    private String text;
    private String backColor;


    public GenericMenuElement(PositionInterface position) {
        this.position = position;
        this.setBackColor("BLACK");
        this.setText("");
        this.setColor("WHITE");
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
    public String getColor() {
        return color;
    }

    @Override
    public void setColor(String newColor) {
        color = newColor;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public void setText(String newText) {
        text = newText;
    }

    @Override
    public String getBackColor() {
        return backColor;
    }

    @Override
    public void setBackColor(String backColor) {
        this.backColor = backColor;
    }

    @Override
    public void draw(TextGraphics screen) {
        screen.setBackgroundColor(TextColor.Factory.fromString(getBackColor()));
        screen.setForegroundColor(TextColor.Factory.fromString(getColor()));
        screen.putString(new TerminalPosition(getPosition().getX(), getPosition().getY()), getText());
    }

}
