package handlerTest;

import game.Game;
import game.GameInterface;
import handler.ShopHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShopHandlerTest {

    private ShopHandler handler;
    private GameInterface game;


    @BeforeEach
    public void helper() {
        game = new Game();
        game.initialize();
        handler = game.getShopHandler();
    }

    @Test
    public void constructorTest() {
        assertTrue(handler != null);
    }

    @Test
    public void addItem() {
        assertEquals(handler.getTotalItems(), 2);
    }

    @Test
    public void getNameTest() {
        assertEquals(handler.getName(0), "* HEALTH");
        assertEquals(handler.getName(1), "b BOMBS");
    }

    @Test
    public void getAmount() {
        assertEquals(handler.getAmount(0), 20);
        assertEquals(handler.getAmount(1), 10);
    }

    @Test
    public void getPrice() {
        assertEquals(handler.getPrice(0), 1000);
        assertEquals(handler.getPrice(1), 1500);
    }

    @Test
    public void increaseStockTest() {
        int amountID0 = handler.getAmount(0);
        int amountID1 = handler.getAmount(1);
        assertEquals(amountID0, 20);
        assertEquals(amountID1, 10);
        handler.increaseStock(0, 30);
        handler.increaseStock(1, 25);
        assertEquals(handler.getAmount(0), 30);
        assertEquals(handler.getAmount(1), 25);
    }

    @Test
    public void gettersTest() {
        assertEquals(handler.getHp(), 5);
        assertEquals(handler.getBombs(), 5);
        assertEquals(handler.getPoints(), 1000);
    }

    @Test
    public void sellTest() {
        handler.sell(0);
        assertEquals(game.getMaze().getActualHeroHp(), 5);
        assertEquals(game.getCurrentBombs(), 5);
        assertEquals(game.getPointsHandler().getPoints(), 1000);
    }
}
