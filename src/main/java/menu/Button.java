package menu;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import element.position.Position;
import element.position.PositionInterface;

public abstract class Button extends GenericMenuElement implements ButtonInterface {

    private boolean selected;
    private String currentColor;
    private String selectedColor;

    public Button(PositionInterface position) {
        super(position);
        selectedColor = "YELLOW";
        currentColor = getColor();
    }

    @Override
    public String getCurrentColor() {
        return currentColor;
    }

    @Override
    public void setCurrentColor(String newColor) {
        currentColor = newColor;
    }

    @Override
    public void setSelected(boolean value) {
        selected = value;
        if (selected) setCurrentColor(selectedColor);
        else setCurrentColor(getColor());
    }

    @Override
    public void draw(TextGraphics screen) {
        screen.setBackgroundColor(TextColor.Factory.fromString(getBackColor()));
        screen.setForegroundColor(TextColor.Factory.fromString(getCurrentColor()));
        screen.putString(new TerminalPosition(getPosition().getX(), getPosition().getY()), getText());
    }

    //strategy pattern
    @Override
    public abstract void execute();
}

