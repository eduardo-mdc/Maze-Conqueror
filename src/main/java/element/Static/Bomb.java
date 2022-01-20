package element.Static;

import com.googlecode.lanterna.SGR;
import element.position.Position;
import element.position.PositionInterface;
import maze.MazeInterface;

import java.util.List;

public class Bomb extends StaticElement {
    private int timer;
    private final int radius;
    private String colour1;
    private final String colour2;
    private MazeInterface maze;
    private int interval;
    private boolean flag;

    public Bomb(PositionInterface position, String color, SGR format, String character) {
        super(position, color, format, character);
        this.colour1 = this.getColor();
        timer = 90;
        radius = 3;
        interval = 10;
        colour2 = "RED";
        flag = true;
    }

    public int getInterval() {
        return interval;
    }

    public void bombTick() {
        if (timer == 60) interval = 5;
        if (timer == 25) interval = 2;
        if (timer % interval == 0) alternateColour();
        timer--;
    }

    private void alternateColour() {
        if (this.getColor().equals(colour1)) {
            this.setColor(colour2);
            return;
        }
        this.setColor(colour1);
    }

    public int getTimer() {
        return timer;
    }

    public void explode(MazeInterface maze) {
        this.maze = maze;
        destroy(maze.getStaticElems(), this.getPosition(), radius);
    }

    public void destroy(List<StaticElement> list, PositionInterface position, int radius) {
        if (radius > 0) {
            if (position.equals(maze.getHero().getPosition()) && flag) {
                maze.getHeroHandler().takeDamage();
                flag = false;
            }
            int index = list.indexOf(new Wall(position, "#FFFFFF", SGR.BOLD, "#", false));
            if (index != -1) {
                list.remove(index);
                maze.getEmptyTiles().add((Position) position);
            }
            destroy(list, new Position(position, 0, 1), radius - 1);
            destroy(list, new Position(position, 0, -1), radius - 1);
            destroy(list, new Position(position, 1, 0), radius - 1);
            destroy(list, new Position(position, -1, 0), radius - 1);
        }
    }
}
