package element.dynam;

import com.googlecode.lanterna.SGR;
import element.position.Position;
import element.position.PositionInterface;

public class Hero extends DynamicElement {
    private int health;
    private int maxhealth;

    public Hero(PositionInterface position, String color, SGR format, String character) {
        super(position, color, format, character);
    }

    public int getHealth() {
        return this.health;
    }

    public boolean isDead() {
        if (health == 0) {
            return true;
        }
        return false;
    }

    public void heroTakesDamage() {
        this.health--;
    }

    public void heroHeals() {
        this.health++;
    }

    public void setHealth(int newHealth) {
        this.health = newHealth;
    }

    public PositionInterface moveUp() {
        return new Position(getPosition().getX(), getPosition().getY() - 1);
    }

    public PositionInterface moveDown() {
        return new Position(getPosition().getX(), getPosition().getY() + 1);
    }

    public PositionInterface moveLeft() {
        return new Position(getPosition().getX() - 1, getPosition().getY());
    }

    public PositionInterface moveRight() {
        return new Position(getPosition().getX() + 1, getPosition().getY());
    }
}
