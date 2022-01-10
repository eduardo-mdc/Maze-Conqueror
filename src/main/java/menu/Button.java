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

    private final Position position;
    private final ButtonExecute action;
    private final int width;
    private final int height;
    private final String text;

    private final String textColor;
    private final String backColor;

    public Button(Position position, int width, int height, String text, ButtonExecute action, String textColor, String backColor) {
        super(position,textColor);
        this.position = position;
        this.action = action;
        this.width = width;
        this.height = height;
        this.text = text;
        this.textColor = textColor;
        this.backColor = backColor;
    }

    public void draw(TextGraphics screen) {
        screen.setForegroundColor(TextColor.Factory.fromString(textColor));
        screen.putString(new TerminalPosition(getPosition().getX(), getPosition().getY()), text);
    }
}

