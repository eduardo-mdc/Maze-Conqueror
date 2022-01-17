package handler;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class BombsHandler {
    private Integer bomb;
    private final String color = "WHITE";


    public BombsHandler(){
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

}
