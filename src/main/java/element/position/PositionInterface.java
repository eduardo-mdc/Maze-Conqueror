package element.position;

/**
 * The position interface is responsible for handling the object's location on the lanterna screen.
 *
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

    /**
     * Sums the values of the arguments x and y to the current position.
     *
     * @param x
     * @param y
     */
    void changePos(int x, int y);

    /**
     * Checks whether the given object is equal to current position
     * @param o object to compare to
     * @return boolean corresponding to the veracity of the equality.
     */
    boolean equals(Object o);
}
