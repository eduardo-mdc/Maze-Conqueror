package element.position;

/**
 * The position interface is responsible for handling the object's location on the lanterna screen.
 * @author Eduardo Correia
 * @author Alberto Serra
 * @author José Carvalho
 */
public interface PositionInterface {
    /**
     * Returns the X coordinate.
     *
     * @return Integer corresponding to the X value.
     */
    int getX();

    /**
     * Sets the X coordinate.
     *
     * @param x Integer to change the x value to.
     */
    void setX(int x);

    /**
     * Returns the Y coordinate.
     *
     * @return Integer corresponding to the Y value.
     */
    int getY();

    /**
     * Sets the Y coordinate.
     *
     * @param y Integer to change the x value to.
     */
    void setY(int y);
}
