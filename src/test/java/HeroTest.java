import com.googlecode.lanterna.graphics.TextGraphics;
import element.dynam.DynamicElement;
import element.dynam.Hero;
import element.position.PositionInterface;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class HeroTest {
    Hero hero;
    PositionInterface position;

    @BeforeEach
    public void helper() {
        position = Mockito.mock(PositionInterface.class);
        hero = new Hero(position);
    }

    @Test
    public void moveUpTest() {
        Mockito.when(position.getX()).thenReturn(5);
        Mockito.when(position.getY()).thenReturn(7);
        PositionInterface positionUp = hero.moveUp();
        Assertions.assertEquals(positionUp.getX(), 5);
        Assertions.assertEquals(positionUp.getY(), 6);
    }

    @Test
    public void moveDownTest() {
        Mockito.when(position.getX()).thenReturn(5);
        Mockito.when(position.getY()).thenReturn(7);
        PositionInterface positionDown = hero.moveDown();
        Assertions.assertEquals(positionDown.getX(), 5);
        Assertions.assertEquals(positionDown.getY(), 8);
    }

    @Test
    public void moveLeftTest() {
        Mockito.when(position.getX()).thenReturn(5);
        Mockito.when(position.getY()).thenReturn(7);
        PositionInterface positionLeft = hero.moveLeft();
        Assertions.assertEquals(positionLeft.getX(), 4);
        Assertions.assertEquals(positionLeft.getY(), 7);

    }

    @Test
    public void moveRightTest() {
        Mockito.when(position.getX()).thenReturn(5);
        Mockito.when(position.getY()).thenReturn(7);
        PositionInterface positionRight = hero.moveRight();
        Assertions.assertEquals(positionRight.getX(), 6);
        Assertions.assertEquals(positionRight.getY(), 7);
    }

    @Test
    public void draw() {
        TextGraphics graphics = Mockito.mock(TextGraphics.class);
        hero.draw(graphics);
        Assertions.assertTrue(hero.getPosition() != null);
    }
}