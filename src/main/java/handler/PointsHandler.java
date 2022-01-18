package handler;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class PointsHandler {
    private Integer points;
    private final String color = "WHITE";

    public PointsHandler() {
        points = 1000;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        if (points < 0) this.points = 0;
        else this.points = points;
    }

    public void incrementPoints(Integer increment) {
        setPoints(points + increment);
    }

    public void draw(TextGraphics screen) {
        screen.setForegroundColor(TextColor.Factory.fromString(color));
        screen.putString(new TerminalPosition(5, 2), ("SCORE " + points.toString()));
    }

}
