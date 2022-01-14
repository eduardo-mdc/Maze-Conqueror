package mazeTest;

import maze.VisitedCell;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class VisitedCellTest {
    VisitedCell cell;

    @BeforeEach
    public void helper() {
        cell = new VisitedCell(3, 5, 8);
    }

    @Test
    public void constructorTest() {
        VisitedCell tempCell = new VisitedCell(1, 2, 3);
        assertTrue(tempCell != null);
        assertTrue(cell != null);
    }

    @Test
    public void getColTest() {
        assertEquals(5, cell.getCol());
    }

    @Test
    public void getRowTest() {
        assertEquals(3, cell.getRow());
    }

    @Test
    public void getDisTest() {
        assertEquals(8, cell.getDist());
    }
}
