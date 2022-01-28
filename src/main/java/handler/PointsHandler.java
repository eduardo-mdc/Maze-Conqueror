package handler;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

/**
 * Class used to handle the point's behaviour in the game.
 *  @author Eduardo Correia
 *  @author Alberto Serra
 *  @author José Carvalho
 */
public class PointsHandler {
    private Integer points;
    private final String color;
    /**
     * Constructor for the point handler class
     */
    public PointsHandler() {
        points = 1000;
        color = "WHITE";
    }
    /**
     * Gets the number of points
     * @return number of points
     */
    public Integer getPoints() {
        return points;
    }
    /**
     * Sets the number of points to the amount given
     * @param points new points amount
     */
    public void setPoints(Integer points) {
        if (points < 0) this.points = 0;
        else this.points = points;
    }
    /**
     * Adds the given increment to the current amount of points
     * @param increment increase/decrease to point amount.
     */
    public void incrementPoints(Integer increment) {
        setPoints(points + increment);
    }
    /**
     * Draws amount of points in the screen
     * @param screen lanterna screen to draw on.
     */
    public void draw(TextGraphics screen) {
        screen.setForegroundColor(TextColor.Factory.fromString(color));
        screen.putString(new TerminalPosition(5, 2), ("SCORE " + points.toString()));
    }

}
