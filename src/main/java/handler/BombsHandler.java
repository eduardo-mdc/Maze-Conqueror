
package handler;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import element.Static.Bomb;
import element.position.PositionInterface;
import maze.MazeInterface;

import java.util.LinkedList;
import java.util.List;

/**
 * Class used to handle the bomb's behaviour in the game.
 */
public class BombsHandler {

    private Integer bomb;
    private Integer maxbomb;
    private final String color;
    private MazeInterface maze;
    private int radius;

    /**
     * Constructor for the bomb handler class
     * @param maze maze class to interact with
     */
    public BombsHandler(MazeInterface maze) {
        this.maze = maze;
        bomb = maze.getGame().getCurrentBombs();
        maxbomb = 5;
        color = "WHITE";
        this.radius = 3;
    }

    /**
     * Gets the number of bombs available
     * @return number of bombs
     */
    public Integer getBombs() {
        return bomb;
    }

    /**
     * Sets the number of bombs to the amount given
     * @param bomb new bomb amount
     */
    public void setBomb(Integer bomb) {
        if (bomb < 0)
            this.bomb = 0;
        else {
            this.bomb = bomb;
            maze.getGame().setCurrentBombs(bomb);
        }
    }

    /**
     * Adds the given increment to the current amount of bombs
     * @param increment increase/decrease to bomb amount.
     */
    public void incrementBombs(Integer increment) {
        setBomb(bomb + increment);
    }

    /**
     * Draws amount of bombs in the screen
     * @param screen lanterna screen to draw on.
     */
    public void draw(TextGraphics screen) {
        screen.setForegroundColor(TextColor.Factory.fromString(color));
        screen.putString(new TerminalPosition(35, 2), ("b " + bomb.toString()));
    }

    /**
     * Tries to generate bomb at given position and decreases number of bombs available.
     * @param position position to generate bomb at
     */
    public void generateBomb(PositionInterface position) {
        boolean flag = false;
        for (PositionInterface pos : maze.getEmptyTiles())
            if (pos.equals(position)) flag = true;
        if (flag && getBombs() > 0) {
            this.incrementBombs(-1);
            maze.getBombs().add(new Bomb(position, "BLACK", SGR.BOLD, "b", radius));
        }
    }

    /**
     * Gets the maximum number of bombs
     * @return maximum number of bombs
     */
    public Integer getMaxbomb() {
        return maxbomb;
    }

    /**
     * Resets the number of bombs the player has.
     */
    public void resetBombs() {
        setBomb(maxbomb);
    }

    /**
     * Ticks all bomb's timer by one tick. If the timer reaches 0, explodes the bomb in question.
     */
    public void tickAllBombs() {
        List<Bomb> toExplode = new LinkedList<>();
        for (Bomb bomb : maze.getBombs()) {
            bomb.bombTick();
            if (bomb.getTimer() == 0) toExplode.add(bomb);
        }
        for (Bomb bomb : toExplode) {
            bomb.explode(maze);
            maze.getBombs().remove();
        }
    }

    /**
     * Increases the bomb's radius
     */
    public void increaseRadius() {
        System.out.println("Radius Upgrade!");
        this.radius *= 2;
    }

    /**
     * Returns the current radius for the bomb's explosion.
     * @return radius for the bomb's explosion
     */
    public int getRadius() {
        return radius;
    }
}