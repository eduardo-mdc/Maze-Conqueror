package maze;

import element.position.PositionInterface;

public class Node{
    private final PositionInterface position;

    /**
     * Constructor for the node class. Receives a position object as an argument and stores its value.
     * @param position Position object to store in node.
     */
    public Node(PositionInterface position) {
        this.position = position;
    }

    /**
     * Gets the position object stored in the node.
     * @return Stored position object.
     */
    public PositionInterface getPosition() {
        return position;
    }

    /**
     * Gets the X value from the stored position.
     * @return Integer corresponding to the x value of the stored position object
     */
    public int getX() {
        return position.getX();
    }

    /**
     * Gets the Y value from the stored position.
     * @return Integer corresponding to the y value of the stored position object
     */
    public int getY() {
        return position.getY();
    }
}