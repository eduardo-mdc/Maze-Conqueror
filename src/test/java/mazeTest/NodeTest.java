package mazeTest;

import element.position.PositionInterface;
import maze.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class NodeTest {
    Node node;
    PositionInterface position;

    @BeforeEach
    public void helper() {
        position = mock(PositionInterface.class);
        node = new Node(position);
    }

    @Test
    public void getPositionTest() {
        Node newNode = new Node(position);
        assertEquals(newNode.getPosition(), node.getPosition());
    }

    @Test
    public void getXTest() {
        when(position.getX()).thenReturn(5);
        int x = node.getX();
        assertEquals(5, x);
    }

    @Test
    public void getYTest() {
        when(position.getY()).thenReturn(6);
        int y = node.getY();
        assertEquals(6, y);
    }

    @Test
    public void constructorTest() {
        Node newNode = new Node(position);
        assertTrue(newNode != null);
    }
}
