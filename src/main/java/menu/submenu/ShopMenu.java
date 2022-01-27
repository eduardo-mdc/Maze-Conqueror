package menu.submenu;

import com.googlecode.lanterna.screen.Screen;
import element.position.Position;
import game.Game;
import game.GameInterface;
import handler.ShopHandler;
import menu.Menu;
import menu.button.*;

/**
 * Extension of the Menu Class. This class is used to instantiate and create the various elements present on the Shop menu.
 */
public class ShopMenu extends Menu {
    private final int xIncr;
    private final int yIncr;
    private ShopHandler shopHandler;
    private TextMenuElement text;
    private TextMenuElement wallet;
    private TextMenuElement name;
    private TextMenuElement amount;
    private TextMenuElement price;

    private GameInterface game;

    public ShopMenu(GameInterface game, Screen screen) {
        super(game, screen);
        shopHandler = game.getShopHandler();
        this.game = game;
        xIncr = 10;
        yIncr = 20;
        String hearts = "";
        for (int i = 0; i < shopHandler.getHp(); i++) hearts += "*";
        text = new TextMenuElement(new Position(xIncr + 4, yIncr - 12), "WELCOME TO THE SHOP!");
        wallet = new TextMenuElement(new Position(xIncr - 5, yIncr - 7), "HEALTH: " + hearts + "   b BOMBS: " + shopHandler.getBombs() + " SCORE: " + shopHandler.getPoints());
        name = new TextMenuElement(new Position(xIncr - 3, yIncr - 3), "NAME");
        amount = new TextMenuElement(new Position(xIncr + 10, yIncr - 3), "AMOUNT");
        price = new TextMenuElement(new Position(xIncr + 19, yIncr - 3), "PRICE");
        addToTextList();
        addObjects();
        getButtonsList().add(new CloseShopButton(game, new Position(xIncr + 30, yIncr + 25)));
    }

    public void addToTextList() {
        getTextList().add(text);
        getTextList().add(name);
        getTextList().add(amount);
        getTextList().add(price);
        getTextList().add(wallet);
    }

    public void addObjects() {
        for (int i = 0; i < shopHandler.getTotalItems(); i++) {
            getTextList().add(new TextMenuElement(new Position(xIncr - 5, yIncr + i * 5 + 1), shopHandler.getName(i)));
            getTextList().add(new TextMenuElement(new Position(xIncr + 12, yIncr + i * 5 + 1), shopHandler.getAmount(i).toString()));
            getTextList().add(new TextMenuElement(new Position(xIncr + 19, yIncr + i * 5 + 1), shopHandler.getPrice(i).toString() + "c"));
            getButtonsList().add(new BuyButton(game, new Position(xIncr + 27, yIncr + i * 5 + 1), i));
        }
    }
}
