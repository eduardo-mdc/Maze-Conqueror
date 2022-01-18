package element.Static;

import com.googlecode.lanterna.SGR;
import element.position.Position;
import element.position.PositionInterface;
import maze.MazeInterface;

import java.util.List;

public class Bomb extends StaticElement{
    private int timer;
    private final int radius = 3;
    private String colour1;
    private final String colour2 = "RED";
    public Bomb(PositionInterface position, String color, SGR format, String character) {
        super(position, color, format, character);
        this.colour1 = this.getColor();
        timer = 90;
    }
    public void bombTick(){
        if (timer%10 == 0) alternateColour();
        timer--;
    }
    private void alternateColour(){
        if (this.getColor().equals(colour1)){
            this.setColor(colour2);
            return;
        }
        this.setColor(colour1);
    }
    public int getTimer(){
        return timer;
    }
    public void explode(MazeInterface maze){
        destroy(maze.getStaticElems(),this.getPosition(),radius);
    }
    private void destroy(List<StaticElement> list, PositionInterface position, int radius){
        if(radius > 0){
            for(StaticElement element : list){
                if (element.getClass() == Wall.class && element.getPosition().equals(position)){
                    if(!((Wall) element).isOuterWall()){
                        list.remove(element);
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
