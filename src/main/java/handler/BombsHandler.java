package handler;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import element.Static.Bomb;
import element.position.Position;
import maze.Maze;
import maze.MazeInterface;

public class BombsHandler {
    private Integer bomb;
    private final String color = "WHITE";
    private MazeInterface maze;


    public BombsHandler(MazeInterface maze){
        this.maze = maze;
        bomb = 5;
    }

    public Integer getBombs() {
        return bomb;
    }

    public void setBomb(Integer bomb) {
        if(bomb < 0) this.bomb = 0;
        else this.bomb = bomb;
    }

    public void incrementBombs(Integer increment){
        setBomb(bomb + increment);
    }

    public void draw(TextGraphics screen){
        screen.setForegroundColor(TextColor.Factory.fromString(color));
        screen.putString(new TerminalPosition(25, 2), ("b " + bomb.toString()));
    }

    public void generateBomb(Position position) {
        boolean flag = false;
        for (Position pos : maze.getEmptyTiles())
            if (pos.equals(position)) flag = true;
        if (flag)maze.getBombs().add(new Bomb(position, "RED", SGR.BOLD, "b"));
    }

}
