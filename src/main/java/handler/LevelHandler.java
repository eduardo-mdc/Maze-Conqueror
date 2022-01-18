package handler;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class LevelHandler {
    private Integer level;
    private final String color = "WHITE";

    public LevelHandler(){this.level = 1;}

    public Integer getLevel() {return level;}

    public void nextLevel(){this.level ++;}

    public void draw(TextGraphics screen) {
        screen.setForegroundColor(TextColor.Factory.fromString(color));
        screen.putString(new TerminalPosition(25, 2), ("LEVEL " + level.toString()));
    }
}
