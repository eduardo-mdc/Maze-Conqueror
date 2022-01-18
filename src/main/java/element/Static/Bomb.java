package element.Static;

import com.googlecode.lanterna.SGR;
import element.position.Position;
import element.position.PositionInterface;
import maze.MazeInterface;

import java.util.List;

public class Bomb extends StaticElement{
    private int timer;
    private final int radius = 2;
    public Bomb(PositionInterface position, String color, SGR format, String character) {
        super(position, color, format, character);
        timer = 90;
    }
    public void bombTick(){
        timer--;
    }
    public int getTimer(){
        return timer;
    }
    public void explode(MazeInterface maze){
        destroy(maze.getStaticElems(),this.getPosition(),radius);
    }
    private void destroy(List<StaticElement> list, PositionInterface position, int radius){
        if(radius > 0){
            for(StaticElement wall : list){
                if (wall.getClass() == Wall.class && wall.getPosition().equals(position)){
                    if(!((Wall) wall).isOuterWall()){
                        list.remove(wall);
                        break;
                    }
                }
            }
            destroy(list,new Position(position,0,1),radius-1);
            destroy(list,new Position(position,0,-1),radius-1);
            destroy(list,new Position(position,1,0),radius-1);
            destroy(list,new Position(position,-1,0),radius-1);
        }
    }
}
