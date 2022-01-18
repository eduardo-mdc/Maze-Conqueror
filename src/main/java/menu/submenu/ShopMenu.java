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


    public ShopMenu(Game game, Screen screen) throws IOException {
        super(game,screen);
        TextMenuElement text = new TextMenuElement(new Position(xIncr,yIncr-10),"WELCOME@TO@THE@SHOP!");
        ShopHandler shopHandler = game.getShopHandler();
        splitText("@",xIncr,yIncr);

        texts.add(text);

        for (int i = 0; i < shopHandler.getTotalItems();i++){
            texts.add(new TextMenuElement(new Position(xIncr,yIncr + i*5),shopHandler.getName(i)));
            texts.add(new TextMenuElement(new Position(xIncr+ 5,yIncr+ i*5),shopHandler.getAmount(i).toString()));
            texts.add(new TextMenuElement(new Position(xIncr+ 10,yIncr + i*5),shopHandler.getPrice(i).toString()));
            btn.add(new BuyButton(game,new Position(xIncr+15,yIncr + i*5),1));
        }
        btn.add(new CloseShopButton(game,new Position(xIncr+15,yIncr+ 25)));

    }
}

