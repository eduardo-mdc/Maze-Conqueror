package element.position;
/**
 * PositionInterface contains the functions to position the game elements relative to which other.
 *
 * @author Eduardo Correia
 * @author Alberto Serra
 * @author José Carvalho
 */

public interface PositionInterface {
    /**
     *  Returns the X position
     * @return
     */
    int getX();

    /**
     *  Sets the X position
     * @param x x value to set
     */
    void setX(int x);

    /**
     * Returns the Y position
     * @return
     */
    int getY();

    /**
     * Sets the Y position
     * @param y y value to set
     */
    void setY(int y);
}
