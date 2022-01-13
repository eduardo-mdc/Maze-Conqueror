package handler;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import game.Game;
import game.GameInterface;
import maze.Maze;
import maze.MazeInterface;

public class PointsHandler {
    private MazeInterface maze;
    private Integer points;
    private GameInterface game;
    private final String color = "WHITE";


    public PointsHandler(MazeInterface maze){
        this.maze = maze;
        this.game = maze.getGame();
        points = 1000;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public void draw(TextGraphics screen){
        screen.setForegroundColor(TextColor.Factory.fromString(color));
        screen.putString(new TerminalPosition(1, 5), ("SCORE " + points.toString()));
    }


}
