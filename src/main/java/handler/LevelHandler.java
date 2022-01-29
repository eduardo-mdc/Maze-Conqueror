package handler;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

/**
 * Class used to handle the level's behaviour in the game.
 *  @author Eduardo Correia
 *  @author Alberto Serra
 *  @author José Carvalho
 */
public class LevelHandler {
    private Integer level;
    private final String color = "WHITE";
    /**
     * Constructor for the level handler class
     */
    public LevelHandler() {
        this.level = 1;
    }
    /**
     * Gets the level
     * @return level integer
     */
    public Integer getLevel() {
        return level;
    }
    /**
     * Increments the level
     */
    public void nextLevel() {
        this.level++;
    }
    /**
     * Draws the current level in the screen
     * @param screen lanterna screen to draw on.
     */
    public void draw(TextGraphics screen) {
        screen.setForegroundColor(TextColor.Factory.fromString(color));
        screen.putString(new TerminalPosition(25, 2), ("LEVEL " + level.toString()));
    }
}