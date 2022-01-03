import com.googlecode.lanterna.graphics.TextGraphics;
import element.dynam.Hero;
import element.position.PositionInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;


public class HeroTest {
    private Hero hero;
    private PositionInterface position;

    @BeforeEach
    public void helper() {
        position = mock(PositionInterface.class);
        hero = new Hero(position);
    }

    @Test
    public void takesDamageTest() {
        int hp = hero.getHealth();
        hero.heroTakesDamage();
        assertTrue(hero.getHealth() == hp - 1);
    }

    @Test
    public void healTest() {
        int hp = hero.getHealth();
        hero.heroHeals();
        assertTrue(hero.getHealth() == hp + 1);
    }

    @Test
    public void moveUpTest() {
        when(position.getX()).thenReturn(5);
        when(position.getY()).thenReturn(7);
        PositionInterface positionUp = hero.moveUp();
        assertEquals(positionUp.getX(), 5);
        assertEquals(positionUp.getY(), 6);
    }

    @Test
    public void moveDownTest() {
        when(position.getX()).thenReturn(5);
        when(position.getY()).thenReturn(7);
        PositionInterface positionDown = hero.moveDown();
        assertEquals(positionDown.getX(), 5);
        assertEquals(positionDown.getY(), 8);
    }

    @Test
    public void moveLeftTest() {
        when(position.getX()).thenReturn(5);
        when(position.getY()).thenReturn(7);
        PositionInterface positionLeft = hero.moveLeft();
        assertEquals(positionLeft.getX(), 4);
        assertEquals(positionLeft.getY(), 7);

    }

    @Test
    public void moveRightTest() {
        when(position.getX()).thenReturn(5);
        when(position.getY()).thenReturn(7);
        PositionInterface positionRight = hero.moveRight();
        assertEquals(positionRight.getX(), 6);
        assertEquals(positionRight.getY(), 7);
    }

    @Test
    public void drawTest() {
        Hero tempHero = mock(Hero.class);
        TextGraphics graphics = mock(TextGraphics.class);
        tempHero.draw(graphics);
        verify(tempHero, times(1)).draw(graphics);
    }
}