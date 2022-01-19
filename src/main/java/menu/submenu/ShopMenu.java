package menu.submenu;


import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import element.Element;
import element.position.Position;
import game.Game;
import handler.ShopHandler;
import menu.Button;
import menu.Menu;
import menu.button.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShopMenu extends Menu {
    private final int xIncr = 10;
    private final int yIncr = 20;

    private Game game;

    public ShopMenu(Game game, Screen screen) throws IOException {
        super(game,screen);
        ShopHandler shopHandler = game.getShopHandler();
        this.game = game;

        String hearts ="";
        for (int i = 0; i< shopHandler.getHp();i++) hearts+="*";

        TextMenuElement text = new TextMenuElement(new Position(xIncr+4,yIncr-12),"WELCOME TO THE SHOP!");
        TextMenuElement wallet = new TextMenuElement(new Position(xIncr-3,yIncr-7),"HEALTH: " + hearts + " b BOMBS: " + shopHandler.getBombs() + " SCORE: " + shopHandler.getPoints());
        TextMenuElement name = new TextMenuElement(new Position(xIncr-3,yIncr-3),"NAME");
        TextMenuElement amount = new TextMenuElement(new Position(xIncr+8,yIncr-3),"AMOUNT");
        TextMenuElement price = new TextMenuElement(new Position(xIncr+17,yIncr-3),"PRICE");
        texts.add(text);
        texts.add(name);
        texts.add(amount);
        texts.add(price);
        texts.add(wallet);

        for (int i = 0; i < shopHandler.getTotalItems();i++){
            texts.add(new TextMenuElement(new Position(xIncr-3,yIncr + i*5+1),shopHandler.getName(i)));
            texts.add(new TextMenuElement(new Position(xIncr+ 10,yIncr+ i*5+1),shopHandler.getAmount(i).toString()));
            texts.add(new TextMenuElement(new Position(xIncr+ 17,yIncr + i*5+1),shopHandler.getPrice(i).toString() + "c"));
            btn.add(new BuyButton(game,new Position(xIncr+27,yIncr + i*5+1),i));
        }

        btn.add(new CloseShopButton(game,new Position(xIncr+30,yIncr+ 25)));

    }


}

