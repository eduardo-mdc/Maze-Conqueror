package menu;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import element.position.Position;

public class Button extends GenericMenuElement implements Action{

    private boolean selected;

    private String currentColor;
    private String selectedColor;

    public Button(Position position) {
        super(position);
        selectedColor = "YELLOW";
        currentColor = getColor();
    }

    public String getCurrentColor() {
        return currentColor;
    }
    public void setCurrentColor(String newColor){
        currentColor = newColor;
    }

    public void setSelected(boolean value){
        selected = value;
        if(selected) setCurrentColor(selectedColor);
        else setCurrentColor(getColor());
    }

    @Override
    public void draw(TextGraphics screen) {
        screen.setBackgroundColor(TextColor.Factory.fromString(getBackColor()));
        screen.setForegroundColor(TextColor.Factory.fromString(getCurrentColor()));
        screen.putString(new TerminalPosition(getPosition().getX(), getPosition().getY()), getText());
    }

    public void execute() {}
}

