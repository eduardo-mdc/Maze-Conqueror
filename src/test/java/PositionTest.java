import element.position.Position;
import element.position.PositionInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PositionTest {
    private PositionInterface currentPosition;
    private PositionInterface exceptedPosition;


    @BeforeEach
    public void helper() {
        currentPosition = new Position(3, 5);
        exceptedPosition = new Position(6, 8);
    }

    @Test
    public void setXTest() {
        currentPosition.setX(6);
        assertEquals(currentPosition.getX(), exceptedPosition.getX());
    }

    @Test
    public void setYTest() {
        currentPosition.setY(8);
        assertEquals(currentPosition.getY(), exceptedPosition.getY());
    }

    @Test
    public void getXTest() {
        int x = currentPosition.getX();
        assertEquals(3, x);
    }

    @Test
    public void getYTest() {
        int y = currentPosition.getY();
        assertEquals(5, y);
    }

}