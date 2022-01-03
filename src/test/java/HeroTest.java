import com.googlecode.lanterna.graphics.TextGraphics;
import element.dynam.Hero;
import element.position.PositionInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class HeroTest {
    Hero hero;
    PositionInterface position;

    @BeforeEach
    public void helper() {
        position = Mockito.mock(PositionInterface.class);
        hero = new Hero(position);
    }

    @Test
    public void takesDamageTest() {
        int hp = hero.getHealth();
        hero.heroTakesDamage();
        assertTrue( hero.getHealth() == hp-1);
    }

    @Test
    public void healTest() {
        int hp = hero.getHealth();
        hero.heroHeals();
        assertTrue( hero.getHealth() == hp+1);
    }

    @Test
    public void moveUpTest() {
        Mockito.when(position.getX()).thenReturn(5);
        Mockito.when(position.getY()).thenReturn(7);
        PositionInterface positionUp = hero.moveUp();
        assertEquals(positionUp.getX(), 5);
        assertEquals(positionUp.getY(), 6);
    }

    @Test
    public void moveDownTest() {
        Mockito.when(position.getX()).thenReturn(5);
        Mockito.when(position.getY()).thenReturn(7);
        PositionInterface positionDown = hero.moveDown();
        assertEquals(positionDown.getX(), 5);
        assertEquals(positionDown.getY(), 8);
    }

    @Test
    public void moveLeftTest() {
        Mockito.when(position.getX()).thenReturn(5);
        Mockito.when(position.getY()).thenReturn(7);
        PositionInterface positionLeft = hero.moveLeft();
        assertEquals(positionLeft.getX(), 4);
        assertEquals(positionLeft.getY(), 7);

    }

    @Test
    public void moveRightTest() {
        Mockito.when(position.getX()).thenReturn(5);
        Mockito.when(position.getY()).thenReturn(7);
        PositionInterface positionRight = hero.moveRight();
        assertEquals(positionRight.getX(), 6);
        assertEquals(positionRight.getY(), 7);
    }

    @Test
    public void draw() {
        TextGraphics graphics = Mockito.mock(TextGraphics.class);
        hero.draw(graphics);
        assertTrue(hero.getPosition() != null);
    }
}