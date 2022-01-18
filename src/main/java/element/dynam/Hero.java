package element.dynam;

import com.googlecode.lanterna.SGR;
import element.position.Position;
import element.position.PositionInterface;

/**
 * Hero object which the player controls. This object is responsible with interacting with the various elements of the maze.
 */
public class Hero extends DynamicElement {
    private int health;
    private int maxhealth  = 5;

    /**
     * Constructor for the Hero class. Receives a position, color, format, and character to represent the object.
     *
     * @param position  sets the position of the element on the lanterna screen.
     * @param color     sets the color of the element on the lanterna screen.
     * @param format    sets the format of the element on the lanterna screen.
     * @param character sets the character of the element on the lanterna screen.
     */
    public Hero(PositionInterface position, String color, SGR format, String character, int hp) {
        super(position, color, format, character);
        health =  hp;
    }

    /**
     * Gets the hero's health value.
     *
     * @return integer value corresponding to the hero's health.
     */
    public int getHealth() {
        return this.health;
    }

    /**
     * Checks whether the hero's health has reached 0.
     *
     * @return boolean value corresponding to the hero's death state.
     */
    public boolean isDead() {
        if (health == 0) {
            return true;
        }
        return false;
    }

    /**
     * Reduce the hero's health by one.
     */
    public void heroTakesDamage() {
        this.health--;
    }

    /**
     * Increase the hero's health by one.
     */
    public void heroHeals() {
        this.health++;
    }

    /**
     * Set the hero's health to a certain value.
     *
     * @param newHealth new hero's health value.
     */
    public void setHealth(int newHealth) {
        this.health = newHealth;
    }

    /**
     * Gets the position directly above from the hero's current position.
     *
     * @return position directly above the hero's position.
     */
    public PositionInterface moveUp() {
        return new Position(getPosition().getX(), getPosition().getY() - 1);
    }

    /**
     * Gets the position directly below from the hero's current position.
     *
     * @return position directly below the hero's position.
     */
    public PositionInterface moveDown() {
        return new Position(getPosition().getX(), getPosition().getY() + 1);
    }

    /**
     * Gets the position directly left from the hero's current position.
     *
     * @return position directly left the hero's position.
     */
    public PositionInterface moveLeft() {
        return new Position(getPosition().getX() - 1, getPosition().getY());
    }

    /**
     * Gets the position directly right from the hero's current position.
     *
     * @return position directly right the hero's position.
     */
    public PositionInterface moveRight() {
        return new Position(getPosition().getX() + 1, getPosition().getY());
    }
}
