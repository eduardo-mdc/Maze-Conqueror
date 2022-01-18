package handler;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import element.Static.Bomb;
import element.position.Position;
import maze.Maze;
import maze.MazeInterface;

import java.util.LinkedList;
import java.util.List;

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
        if (flag && getBombs()>0){
            this.incrementBombs(-1);
            maze.getBombs().add(new Bomb(position, "RED", SGR.BOLD, "b"));
        }
    }

    public void tickAllBombs() {
        List<Bomb> toExplode = new LinkedList<>();
        for (Bomb bomb : maze.getBombs()){
            bomb.bombTick();
            if(bomb.getTimer() == 0) toExplode.add(bomb);
        }
        for(Bomb bomb : toExplode){
            bomb.explode(maze);
            maze.getBombs().remove();
        }
    }
}
