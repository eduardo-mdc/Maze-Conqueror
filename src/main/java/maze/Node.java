package maze;

import element.position.PositionInterface;

public class Node {
    private final PositionInterface position;

    public Node(PositionInterface position) {
        this.position = position;
    }

    public PositionInterface getPosition() {
        return position;
    }

    public int getX() {
        return position.getX();
    }

    public int getY() {
        return position.getY();
    }
}