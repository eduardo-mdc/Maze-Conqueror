package element.Static;

import com.googlecode.lanterna.SGR;
import element.position.Position;
import element.position.PositionInterface;
import maze.MazeInterface;

import java.util.List;

/**
 *Class responsible for creating the bomb element. Extension of the static element class.
 *@author Eduardo Correia
 *@author Jose Carvalho
 *@author Alberto Serra
 */
public class Bomb extends StaticElement {
    private int timer;
    private final int radius;
    private String colour1;
    private final String colour2;
    private MazeInterface maze;
    private int interval;
    private boolean flag;

    /**
     * Constructor for the bomb class
     * @param position Position to generate the bomb on
     * @param color color of the bomb
     * @param format SGR format
     * @param character character to represent the bomb
     * @param radius radius of the explosion
     */
    public Bomb(PositionInterface position, String color, SGR format, String character,int radius) {
        super(position, color, format, character);
        this.colour1 = this.getColor();
        timer = 90;
        interval = 10;
        colour2 = "RED";
        flag = true;
        this.radius = radius;
    }

    /**
     * Gets the interval at which the bomb flashes
     * @return integer corresponding to the interval
     */
    public int getInterval() {
        return interval;
    }

    /**
     * Gets the radius the of the bomb
     * @return returns integer value corresponding to radius of the bomb
     */
    public int getRadius() {
        return radius;
    }

    /**
     * Ticks the bomb's timer by 1, also checks to see if a flashing interval has been reached and alternates colour accordingly.
     */
    public void bombTick() {
        if (timer == 60) interval = 5;
        if (timer == 25) interval = 2;
        if (timer % interval == 0) alternateColour();
        timer--;
    }

    /**
     * Alternates the bomb's colour between colour 1 and colour 2
     */
    private void alternateColour() {
        if (this.getColor().equals(colour1)) {
            this.setColor(colour2);
            return;
        }
        this.setColor(colour1);
    }

    /**
     * Gets the current bomb timer
     * @return integer corresponding to the bomb timer
     */
    public int getTimer() {
        return timer;
    }

    /**
     * Function used to destroy tiles in a radius around the bomb.
     * @param maze maze class in which to explode the bomb
     */
    public void explode(MazeInterface maze) {
        this.maze = maze;
        destroy(maze.getStaticElems(), this.getPosition(), radius);
    }

    /**
     * Recursive function that destroys tiles in a cross shaped pattern until the radius variable reaches 0
     * @param list list which contains the tiles to be destroyed
     * @param position position to destroy
     * @param radius radius variable, ends recursive loop when 0
     */
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
