package menu;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import element.position.Position;
import game.Game;
import menu.Action;
import menu.GenericMenuElement;
import menu.button.ButtonExecute;

public class Button extends GenericMenuElement {
    private int width;
    private int height;
    private String text;
    private boolean selected;

    private String backColor;
    private String selectedColor;

    public Button(Position position) {
        super(position);
        backColor = "BLACK";
        selectedColor = "YELLOW";
    }

    public String getText(){
        return text;
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
}

