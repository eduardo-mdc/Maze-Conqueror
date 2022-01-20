
import element.position.Position;
import element.position.PositionInterface;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PositionTest {
    private PositionInterface currentPosition;
    private PositionInterface exceptedPosition;


    @BeforeEach
    public void helper() {
        currentPosition = new Position(3, 5);
        exceptedPosition = new Position(6, 8);
    }

    @Property
    public void constructor1Test(@ForAll int x, @ForAll int y) {
        PositionInterface position = new Position(x, y);
        assertTrue(position != null);
    }

    @Test
    public void constructor2Test(@ForAll int x, @ForAll int y) {
        PositionInterface position = new Position(currentPosition, x, y);
        assertTrue(position != null);
    }

    @Test
    public void changePosTest() {
        PositionInterface tempPos = new Position(13, 17);
        currentPosition.changePos(10, 12);
        assertEquals(tempPos.getX(), currentPosition.getX());
        assertEquals(tempPos.getY(), currentPosition.getY());

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

    @Test
    public void toStringTest() {
        String positionString = "(" + currentPosition.getX() + "," + currentPosition.getY() + ")";
        assertEquals(currentPosition.toString(), positionString);
    }
}